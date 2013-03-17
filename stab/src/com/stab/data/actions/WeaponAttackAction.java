package com.stab.data.actions;

import com.stab.data.StabConstants;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

public class WeaponAttackAction extends TargetAction{
	
	public static final String ID="MELEE_STRIKE_ACTION";

	
	
	

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
		atacante.apply(ad); //Esto calcula todos los bonos, da�o etc
		
		Attack ataque = ad.getAttack();  //Esto nos da el ataque, ya preparado
		atacado.check(ataque);
		
		//Aqui viene la animacion ((Sale del AD, pero por ahora esta fija) (y falta comprobar si hit, parry, etc)
		yo.playAnimationOn(ad.getAnimationType(), target.getToken(), ad.getAnimationIcon());
		
		sleep(500);
		
		if (ataque.hits()) {
			ataque.apply();
			/*
			for (Applicable d:ad.getEffects(ataque.isCritical())){
				atacado.apply(d);
				
				//System.out.println(d.getFinalAmount()+" de da�o (tipo "+d.getType()+")");
			}
			/**/
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