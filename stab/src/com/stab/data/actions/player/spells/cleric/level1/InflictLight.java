package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;
import com.stab.util.Roll;

public class InflictLight extends SpellOnTarget{
	
	public static final String ID="INFLICTLIGHT";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;
		int dañobase=Roll.d8()+1;
		
		MagicAttack ataque = new MagicAttack(caster);
		FortitudeAttack save = new FortitudeAttack(atacado);
		atacado.apply(ataque);
		atacado.apply(save);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		if(atacado.hasTrait(UndeadTraits.ID) == false) {
			if(ataque.hits()) {
					if(save.hits()){
						Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,yo);
						atacado.apply(d);
						this.setEffectType(DAMAGE);
						return true;
						}
						else {
							Damage d= new Damage(dañobase/2, Damage.UNHOLY_DAMAGE,yo);
							atacado.apply(d);
							return false;
							}	
					}
						
				else {
					Heal d= new Heal(dañobase,yo);
					atacado.apply(d);
					this.setEffectType(HEAL);
					return true;
				}
		}
		return false;

	}
	
	public InflictLight() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.CLERICCASTER);
	 setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/inflictlightwounds");
     setName("Inflict Light Wounds");
     
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}