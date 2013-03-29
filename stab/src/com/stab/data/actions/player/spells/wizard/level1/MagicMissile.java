package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class MagicMissile extends SpellOnTarget{
	
	public static final String ID="MagicMissile";

	
	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		int cl = getCasterLevel(caster);
		/*int da�obase1=Roll.d4()+1;
		int da�obase2=Roll.d4()+1;
		int da�obase3=Roll.d4()+1;
		int da�obase4=Roll.d4()+1;
		int da�obase5=Roll.d4()+1;/**/
		
		int number=cl+1/2;
		if (number>5) number=5;
		
		sleep(caster.playAnimationOn(MagicMissileAnimation.ID, atacado.getToken(), number));
		
		Damage d= new RolledDamage(number,4, Damage.FORCE_DAMAGE,yo);
		atacado.apply(d);
		/*
		if(cl<3){
		Damage d= new Damage(da�obase1, Damage.FORCE_DAMAGE,yo);
		atacado.apply(d);
		return true;	
		}
		if(cl>=3 && cl<5){
			Damage d= new Damage(da�obase1+da�obase2, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=5 && cl<7){
			Damage d= new Damage(da�obase1+da�obase2+da�obase3, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=7 && cl<9){
			Damage d= new Damage(da�obase1+da�obase2+da�obase3+da�obase4, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=9){
			Damage d= new Damage(da�obase1+da�obase2+da�obase3+da�obase4+da�obase5, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
			/**/
		return true;
		}
	
	public MagicMissile() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/magicmissile");
		setName("MagicMissile");
		this.setEffectType(DAMAGE);
		setRange(MEDIUM);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 15;
	}
	

}