package com.stab.data.actions.player.spells.cleric.level1;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.Roll;

public class CureLight extends SpellOnTarget{
	
	public static final String ID="CURELIGHT_CLERIC";


	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo atacado = (BaseInfo)target;
		BaseInfo caster = (BaseInfo)yo;
		
		int cl=caster.getValue(StabConstants.CASTERLEVEL);
		if(cl>5)
			cl=5;
		int dañobase=Roll.d8()+cl;
		
		this.setRangeTouch(caster);
		MagicAttack ataque = new MagicAttack(caster);
		FortitudeAttack save = new FortitudeAttack(atacado);
		
		atacado.apply(ataque);
		atacado.apply(save);
		
		if (atacado.hasTrait(UndeadTraits.ID) == false) {
			Heal heal = new Heal(dañobase, atacado);
			atacado.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#Healing");
			sleep(500);
			atacado.apply(heal);
			this.setEffectType(HEAL);
			return true;
			}
		
		else {
			
			if(ataque.hits()) {
				if(save.hits()){
					Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,yo);
					atacado.apply(d);
					return true;
					}
					else {
						Damage d= new Damage(dañobase/2, Damage.UNHOLY_DAMAGE,yo);
						atacado.apply(d);
						System.out.println(d.getFinalAmount()+" de daño");	
						this.setEffectType(DAMAGE);
						return false;
						}	
				}
			}
		return false;

		}
	
	public CureLight() {
   
     setTargetClass(PhysicalToken.class);
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Cure Light");
  
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}