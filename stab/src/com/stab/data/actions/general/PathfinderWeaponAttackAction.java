package com.stab.data.actions.general;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import com.stab.annotations.Instanced;
import com.stab.common.utils.Roll;
import com.stab.data.animation.BlockAnimation;
import com.stab.data.animation.FlashAnimation;
import com.stab.data.animation.GenericProyectileAnimation;
import com.stab.data.animation.GenericProyectileMissAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SidestepAnimation;
import com.stab.data.animation.StepBackAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.model.action.Action;
import com.stab.model.action.base.WeaponAttackAction;
import com.stab.model.ai.packages.DefaultAIPackage;
import com.stab.model.animation.BaseSpeech;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.gear.Ammo;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.info.applicable.PathfinderAttack;
import com.stab.pf.info.applicable.SneakAttack;
import com.stab.pf.info.equipment.BasicWeapon;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.RangedWeapon;
import com.stab.pf.utils.PathfinderUtils;

@Instanced
public class PathfinderWeaponAttackAction extends WeaponAttackAction  {
	
	public static final String ID=WeaponAttackAction.ID;
	private static final String DONTSNEAK = "DONTSNEAK";

	@Override
	protected void fixID() {
		// TODO Auto-generated method stub
		super.fixID();
	}
	
	public Weapon getWeapon(BaseInfo i) {
		Weapon w=super.getWeapon(i);
		if (w!=null)
			return w;
		if (i instanceof Creature)
			return PathfinderUtils.getWeapon((Creature)i);
		return null;
	}
	
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
	public int affect(Info yo, Info target,Point point, ActionRequest ar) {
		
		BaseInfo atacante = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;

		Weapon arma=null;
		
		arma=getWeapon(atacante);
		if (arma==null){
			System.out.println("No hay arma! "+atacante+" sobre "+atacado);
			return INVALID;
		}
		
		
		
		PathfinderAttack ad=new PathfinderAttack (atacante,arma,atacado);
	
		//bonos adicionales por posicion: flanking y altura
		MapLogic ml=atacante.getMapLogic();
		int ha=ml.getElevation(atacante.getBounds());
		int hd=ml.getElevation(atacado.getBounds());
		if (ha>hd){
			ad.addModifier(+1); //+1 de altura
			System.out.println("+1 de altura!");
		}
		boolean trySneak=false;
		ArrayList<Info> infos= new ArrayList<Info>();
		//atacante.getAIParams().getTargets();
		infos.addAll(atacante.getScene().getElements(Creature.class));
		Collection<Creature> flankers=PathfinderUtils.getFlankersFor(atacado,atacante, infos);
		if (!flankers.isEmpty()){
			Creature flanker=flankers.iterator().next();
			ad.addModifier(+2);
			atacante.playAnimation(FlashAnimation.ID);
			flanker.playAnimation(FlashAnimation.ID);
			atacante.waitAnimation(100);
			sleep(100);
			trySneak=true;
			
		}
		
		//Preparamos los bonos del atacante (esto nos hace falta para saber si es ranged o no, etc)
		ad.ready();
		
		//TODO: atacado unaware , no puede ver al atacante, etc (bono a dar, do sneak
		
		
		//Linea del ataque para cover y otros efectos
		for (Point p:ml.getPointsInLine2(yo.getPos(), point, (int)point.distance(yo.getPos()))){
			for (Token t: ml.getTokensAt(p.x, p.y)){
				Info i=t.getInfo();
				if (i!=yo && i!=target){
					if (i instanceof Attends)
						if (((Attends)i).canAttend(ad))
							((Attends)i).attend(ad);
				}
			}
		}
		//TODO: visibilidad, concealment, etc
		
		

	
		
		
		ad.check();
		 //Esto calcula todos los bonos, daño etc
		 //y comprueba si da o no, pero sin aplicar el resultado
		
		if (Roll.check(10)){
			atacante.doSpeech(BaseSpeech.BATTLECRY, atacante,atacado);
		}
		
		if (ad.getResult()==PathfinderAttack.COVER || ad.getResult()==PathfinderAttack.COVERMISS){
			trySneak=false;
			
			//Quizas un notify en el target antes de cambiarlo, por si algo actua cuando se nos falla un ataque? seguramente si
			if (target instanceof BaseInfo)
				((BaseInfo)target).notifyListen(ad);
			
			target = ad.getCover();
			ad.setTarget(ad.getCover());
			if (ad.getResult()==PathfinderAttack.COVER)
				ad.setResult(Attack.HIT);
			else
				ad.setResult(PathfinderAttack.ARMOR);
			System.out.println("El ataque se detuvo en cover "+ad.getCover()+" result "+(ad.hits()));
		}
		if (ad.hits()){
			 boolean isSneak=false;
			//Sneak attack. siempre se hace (inicialmente 0 dados)
			if (trySneak)
				if (ad.getBaseDamageType()!=0 && ad.getBaseDamage()>0)  //Filtrar sneak attacks para ataques que no hacen daño. ie: touch of fatigue
					if (ar.getExtraParam(DONTSNEAK)!=Boolean.TRUE){
					SneakAttack s= new SneakAttack(atacante,ad);
					atacado.apply(s);
					if (s.success()){
						//añadimos el daño de sneak al ataque
						RolledDamage rd=new RolledDamage(s.getNumber(),s.getDie(),ad.getBaseDamageType(),ad.getInstigator());
						ad.addOnDamage(rd);
						isSneak=true;
					}
				}
			
			playHitAnimation(ad,atacante,target.getToken());
			if (isSneak){
				atacado.showFloatingText("Sneak Attack", Color.red);
			}
			ad.applyEffects();
			ad.notifyListen();
			sleep(500);
			if (ad.isCritical()){
				if (Roll.check(40))
					atacante.doSpeech(BaseSpeech.CRIT, atacante, atacado);
					return CRITICAL;		
				}
			
			return OK;	
		}
		else{
			playMissAnimation(ad,atacante,target.getToken());
			ad.notifyListen();
		}
	
		
		
		
		sleep(500);
		if (ad.isBotch()) {
			if (Roll.check(40))
				atacante.doSpeech(BaseSpeech.BOTCH, atacante, atacado);
			
				
			System.out.println("Pero mira que eres torpe!");
		    return BOTCH;
		}
		
		if (Roll.check(10))
			atacante.doSpeech(BaseSpeech.ATTACKFAILED, atacante, atacado);
		
		return FAIL;
		
	}
	
	
	void playBlockAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
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
	void playDodgeAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(StepBackAnimation.ID,origin.getToken());
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(SidestepAnimation.ID,origin.getToken());
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			target.playAnimationOn(SidestepAnimation.ID,origin.getToken());
			return;
		}
	}
	
	void playArmorAnimation(WeaponAttack ad,BaseInfo origin, Token target) {
		
	}
	
	public PathfinderWeaponAttackAction() {
     setRange(ADYACENT);
     setTargetMode(Action.TARGET);
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
     setDescription("Ataca con el arma equipada en la mano principal (O en ambas manos). El daño depende del arma.");
     setLosType(IN_SIGHT);
	}

	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		int v=0;
		Weapon w=getWeapon(i);
		if (w==null)
			return DefaultAIPackage.DISCARD;
		v=w.getEffectValue(i,target);
		return v;
	}
	
protected void playHitAnimation(WeaponAttack ad, BaseInfo origin, Token target) {
	//if (ad.getMissAnimationType()==null)  //TODO: check... es eso un error? deberia ser getAnimationType? o es miss por algo? no lo recuerdo
	//	return;
		
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			for (String s:ad.getAdditionalEffects())
				origin.playAnimationOn(SwingAnimation.ID,target,s);
			origin.playSound("effects/SwipeTarget");
			origin.waitAnimation(500);
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
			for (String s:ad.getAdditionalEffects())
				origin.playAnimationOn(ThrustAnimation.ID,target,s);
			origin.waitAnimation(100);
			sleep(100);
			origin.playSound("effects/SwipeTarget");
			origin.waitAnimation(400);
			sleep(400);
			origin.playSound("effects/MetalShieldBlock1");
			return;
		}
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationAt(GenericProyectileAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		if (ad.getAnimationType()!=null)
			sleep(origin.playAnimationOn(ad.getAnimationType(),target,ad.getAnimationIcon()));
	}

	protected void playMissAnimation(WeaponAttack ad, BaseInfo origin, Token target) {
		//if (ad.getMissAnimationType()==null)
		//	return;
		if (ad.getResult()==PathfinderAttack.BLOCK)
			playBlockAnimation(ad,origin,target);
		if (ad.getResult()==PathfinderAttack.DODGE)
			playDodgeAnimation(ad,origin,target);
		
		
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			for (String s:ad.getAdditionalEffects())
				origin.playAnimationOn(SwingAnimation.ID,target,s);
			origin.playSound("effects/SwipeTarget");
			origin.waitAnimation(500);
			sleep(500);
			if (ad.getResult()==PathfinderAttack.BLOCK)
				origin.playSound("effects/m1hSwordHitMetalShield1b");
			if (ad.getResult()==PathfinderAttack.ARMOR)
				origin.playSound("effects/m1hSwordHitFlesh1b");
			if (ad.getResult()==PathfinderAttack.ARMOR)
				playArmorAnimation(ad,origin,target);
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			if (ad.getResult()==PathfinderAttack.BLOCK || (ad.getResult()==PathfinderAttack.DODGE )|| (ad.getResult()==PathfinderAttack.ARMOR) )
				sleep(origin.playAnimationOn(ShootProyectileAnimation.ID,target,ad.getAnimationIcon()));
			else
				sleep(origin.playAnimationOn(MissProyectileAnimation.ID,target,ad.getAnimationIcon()));
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(ThrustAnimation.ID,target,ad.getAnimationIcon());
			for (String s:ad.getAdditionalEffects())
				origin.playAnimationOn(ThrustAnimation.ID,target,s);
			origin.waitAnimation(100);
			sleep(100);
			origin.playSound("effects/SwipeTarget");
			origin.waitAnimation(400);
			sleep(400);
			if (ad.getResult()==PathfinderAttack.BLOCK)
				origin.playSound("effects/m1hSwordHitMetalShield1b");
			if (ad.getResult()==PathfinderAttack.ARMOR)
				origin.playSound("effects/m1hSwordHitFlesh1b");
			if (ad.getResult()==PathfinderAttack.ARMOR)
				playArmorAnimation(ad,origin,target);
			return;
		}
		if (GenericProyectileAnimation.ID.equals(ad.getAnimationType())){
			if (ad.getResult()==PathfinderAttack.BLOCK || (ad.getResult()==PathfinderAttack.DODGE )|| (ad.getResult()==PathfinderAttack.ARMOR) )
				sleep(origin.playAnimationAt(GenericProyectileAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			else
			sleep(origin.playAnimationAt(GenericProyectileMissAnimation.ID,target.getPos(),ad.getAnimationIcon(),origin.getWidth()));
			return;
		}
		if (ad.getMissAnimationType()!=null)
			sleep(origin.playAnimationOn(ad.getMissAnimationType(),target,ad.getAnimationIcon()));
	}
	
	protected Ammo findAmmo(Info instigator) {
		if (instigator instanceof Creature)
			return (Ammo)((Creature)instigator).getEquipment(HumanoidGear.AMMO);
		return null;
	}

	
}