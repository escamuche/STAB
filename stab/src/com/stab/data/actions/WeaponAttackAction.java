package com.stab.data.actions;

import com.stab.data.StabConstants;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.equipment.BasicWeapon;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.RangedWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

public class WeaponAttackAction extends TargetAction{
	
	public static final String ID="MELEE_STRIKE_ACTION";

	
	
	@Override
	public int getRange(BaseInfo i) {
	
		Weapon arma=null;
		arma=getWeapon(i);
		if (arma instanceof RangedWeapon ){
			RangedWeapon r=(RangedWeapon)arma;
			return r.getMaxRange();
		}
		if (arma instanceof BasicWeapon){
			//Enun futuro, el reach de i
			return 1; 
		}
		return super.getRange(i);
	}

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacante = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;

		Weapon arma=null;
		
		arma=getWeapon(atacante);
		if (arma==null){
			System.out.println("No hay arma!");
			return false;
		}
		
		//TODO: ver como se rellena el slot!
		
		AttackData ad=new AttackData(atacante,arma,atacado);
		atacante.apply(ad); //Esto calcula todos los bonos, daño etc
		
		Attack ataque = ad.getAttack();  //Esto nos da el ataque, ya preparado
		atacado.check(ataque);
		
		if (ataque.hits())
			playHitAnimation(ad,atacante,target.getToken());
		else
			playMissAnimation(ad,atacante,target.getToken());
	
	//Pensarse donde informar al arma.
		
		if (ataque.hits()) {
			ataque.apply();
			sleep(500);
			return true;	
		}
		
		
		sleep(500);
		if (ataque.isBotch()) {
			
			System.out.println("Pero mira que eres torpe!");
		    return false;
		}
		
		return false;
		
	}
	
	
	private void playHitAnimation(AttackData ad,BaseInfo origin, Token target) {
		
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			sleep(500);
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(ShootProyectileAnimation.ID,target,ad.getAnimationIcon()));
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(ThrustAnimation.ID,target,ad.getAnimationIcon());
			sleep(500);
			return;
		}
		sleep(origin.playAnimation(ad.getAnimationType(),target,ad.getAnimationIcon()));
	}

	private void playMissAnimation(AttackData ad,BaseInfo origin, Token target) {
		if (SwingAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(SwingAnimation.ID,target,ad.getAnimationIcon());
			sleep(500);
			return;
		}
		if (ShootProyectileAnimation.ID.equals(ad.getAnimationType())){
			sleep(origin.playAnimationOn(MissProyectileAnimation.ID,target,ad.getAnimationIcon()));
			return;
		}
		if (ThrustAnimation.ID.equals(ad.getAnimationType())){
			origin.playAnimationOn(ThrustAnimation.ID,target,ad.getAnimationIcon());
			sleep(500);
			return;
		}
		sleep(origin.playAnimation(ad.getAnimationType(),target,ad.getAnimationIcon()));
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
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_steelmelee");
     setName("Attack");
     this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return i.getAttributeValue(StabConstants.DAMAGE);  //REvisar
	}
	
}