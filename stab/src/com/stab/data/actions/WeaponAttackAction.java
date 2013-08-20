package com.stab.data.actions;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.animation.BlockAnimation;
import com.stab.data.animation.GenericProyectileAnimation;
import com.stab.data.animation.GenericProyectileMissAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SidestepAnimation;
import com.stab.data.animation.StepBackAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.RangedWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.utils.PathfinderUtils;
import com.stab.model.action.Action;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

public class WeaponAttackAction extends Action implements TargetAction{
	
	public static final String ID="MELEE_STRIKE_ACTION";

	
	
	@Override
	public int getRange(Info i) {
		if (i instanceof BaseInfo){
			Weapon arma=null;
			arma=getWeapon((BaseInfo)i);
			if (arma instanceof RangedWeapon ){
				RangedWeapon r=(RangedWeapon)arma;
				return r.getMaxRange();
			}
			if (arma instanceof BasicWeapon){
				//Enun futuro, el reach de i
				return ADYACENT; 
			}
		}
		return super.getRange(i);
	}

	@Override
	public int affect(Info yo, Info target,Point point) {
		
		BaseInfo atacante = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;

		Weapon arma=null;
		
		arma=getWeapon(atacante);
		if (arma==null){
			System.out.println("No hay arma! "+atacante+" sobre "+atacado);
			return INVALID;
		}
		
		//TODO: ver como se rellena el slot!
		
		WeaponAttack ad=new WeaponAttack (atacante,arma,atacado);

		ad.check();
		 //Esto calcula todos los bonos, daño etc
		 //y comprueba si da o no, pero sin aplicar el resultado
		
		if (ad.hits())
			playHitAnimation(ad,atacante,target.getToken());
		else
			playMissAnimation(ad,atacante,target.getToken());
	
		
		if (ad.hits()) {
			ad.applyEffects();
			sleep(500);
			if (ad.isCritical())
				return CRITICAL;
			return OK;	
		}
		
		
		sleep(500);
		if (ad.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return BOTCH;
		}
		
		return FAIL;
		
	}
	
	
	private void playHitAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			origin.playSound("effects/SwipeTarget");
			sleep(500);
			origin.playSound("effects/MetalShieldBlock1");
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(ShootProyectileAnimation.ID,target,ad.getAnimationIcon()));
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(ThrustAnimation.ID,target,ad.getAnimationIcon());
			sleep(100);
			origin.playSound("effects/SwipeTarget");
			sleep(400);
			origin.playSound("effects/MetalShieldBlock1");
			return;
		}
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(GenericProyectileAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		sleep(origin.playAnimationOn(ad.getAnimationType(),target,ad.getAnimationIcon()));
	}

	private void playMissAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		if (ad.getResult()==WeaponAttack.BLOCK)
			playBlockAnimation(ad,origin,target);
		if (ad.getResult()==WeaponAttack.DODGE)
			playDodgeAnimation(ad,origin,target);
		
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			origin.playSound("effects/SwipeTarget");
			sleep(500);
			if (ad.getResult()==WeaponAttack.BLOCK)
				origin.playSound("effects/m1hSwordHitMetalShield1b");
			if (ad.getResult()==WeaponAttack.ARMOR)
				origin.playSound("effects/m1hSwordHitFlesh1b");
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			if (ad.getResult()==WeaponAttack.BLOCK)
				sleep(origin.playAnimationOn(ShootProyectileAnimation.ID,target,ad.getAnimationIcon()));
			else
				sleep(origin.playAnimationOn(MissProyectileAnimation.ID,target,ad.getAnimationIcon()));
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(ThrustAnimation.ID,target,ad.getAnimationIcon());
			sleep(100);
			origin.playSound("effects/SwipeTarget");
			sleep(400);
			if (ad.getResult()==WeaponAttack.BLOCK)
				origin.playSound("effects/m1hSwordHitMetalShield1b");
			if (ad.getResult()==WeaponAttack.ARMOR)
				origin.playSound("effects/m1hSwordHitFlesh1b");
			return;
		}
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(GenericProyectileMissAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		sleep(origin.playAnimationOn(ad.getMissAnimationType(),target,ad.getAnimationIcon()));
	}

	private void playBlockAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		String icon=null;
		if (target.getInfo() instanceof Creature){
			//icon=((BaseInfo)target.getInfo()).get 
			icon="effects/woodenshield";
			icon=PathfinderUtils.getShieldIcon((Creature)target.getInfo());
		}
		if (icon==null)
			return;
		if (icon.length()==0)
			return;
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(BlockAnimation.ID,origin.getToken(),icon);
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(BlockAnimation.ID,origin.getToken(),icon);
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(BlockAnimation.ID,origin.getToken(),icon);
			return;
		}
		
	}
	private void playDodgeAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(StepBackAnimation.ID,origin.getToken());
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(SidestepAnimation.ID,origin.getToken());
			return;
		}
	}
	protected Weapon getWeapon(BaseInfo atacante) {
		
		if (atacante instanceof Creature){
			Creature c=(Creature)atacante;
			Equipment e= c.getEquipment(HumanoidGear.MAINHAND);
			if (e instanceof Weapon)
				return (Weapon)e;
		}
		return null;
	}
	
	public WeaponAttackAction() {
     setRange(ADYACENT);
     
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
     setDescription("Ataca con el arma equipada en la mano principal (O en ambas manos). El daño depende del arma.");
	}

	@Override
	public String getResource(BaseInfo info) {
		Weapon arma=null;
		arma=getWeapon(info);
		if (arma==null){
		//	System.out.println("No hay arma! resource para "+info);
			return super.getResource(info);
		}
		return arma.getResource();
	}
	
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return i.getAttributeValue(StabConstants.DAMAGE);  //REvisar
	}
	
}