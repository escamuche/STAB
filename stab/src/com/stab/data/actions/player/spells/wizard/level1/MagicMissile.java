package com.stab.data.actions.player.spells.wizard.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
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
		int cl = caster.getValue(StabConstants.CASTERLEVEL);
		int dañobase1=Roll.d4()+1;
		int dañobase2=Roll.d4()+1;
		int dañobase3=Roll.d4()+1;
		int dañobase4=Roll.d4()+1;
		int dañobase5=Roll.d4()+1;
		
		setRangeMedium(cl);
		caster.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		if(cl<3){
		Damage d= new Damage(dañobase1, Damage.FORCE_DAMAGE,yo);
		atacado.apply(d);
		return true;	
		}
		if(cl>=3 && cl<5){
			Damage d= new Damage(dañobase1+dañobase2, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=5 && cl<7){
			Damage d= new Damage(dañobase1+dañobase2+dañobase3, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=7 && cl<9){
			Damage d= new Damage(dañobase1+dañobase2+dañobase3+dañobase4, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		if(cl>=9){
			Damage d= new Damage(dañobase1+dañobase2+dañobase3+dañobase4+dañobase5, Damage.FORCE_DAMAGE,yo);
			atacado.apply(d);
			return true;	
			}
		return false;
		}
	
	public MagicMissile() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(PhysicalToken.class);
		setResource("actions/magicmissile");
		setName("MagicMissile");
		this.setEffectType(DAMAGE);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 15;
	}
	

}