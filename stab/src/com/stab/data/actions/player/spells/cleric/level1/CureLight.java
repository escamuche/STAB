package com.stab.data.actions.player.spells.cleric.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
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

public class CureLight extends SpellOnTarget{
	
	public static final String ID="CURELIGHT_CLERIC";


	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		int cl=getCasterLevel(caster);
		if(cl>5)
			cl=5;
		int dañobase=Roll.d8()+cl;
		
		MagicAttack ataque = new MagicAttack(caster);
		FortitudeAttack save = new FortitudeAttack(caster);
		
		target.apply(ataque);
		target.apply(save);
		
		if (target.hasTrait(UndeadTraits.ID) == false) {
			Heal heal = new Heal(dañobase, caster);
			target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#Healing");
			sleep(500);
			target.apply(heal);
			this.setEffectType(HEAL);
			return true;
			}
		
		else {
			
			if(ataque.hits()) {
				if(save.hits()){
					Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,caster);
					target.apply(d);
					return true;
					}
					else {
						Damage d= new Damage(dañobase/2, Damage.UNHOLY_DAMAGE,caster);
						target.apply(d);
						System.out.println(d.getFinalAmount()+" de daño");	
						this.setEffectType(DAMAGE);
						return false;
						}	
				}
			}
		return false;

		}
	
	public CureLight() {
   
     
     setResource("actions/curelightwounds");
     this.setCasterClass(StabConstants.CLERICCASTER);
     setName("Cure Light");
  	 this.setRange(TOUCH);
	
  
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
	

}