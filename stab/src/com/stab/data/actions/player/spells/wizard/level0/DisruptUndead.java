package com.stab.data.actions.player.spells.wizard.level0;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class DisruptUndead extends SpellOnTarget{
	
	public static final String ID="DISRUPTUNDEAD";
	
	
	

	@Override
	public boolean execute(Info yo, Info target) {
		
		BaseInfo caster = (BaseInfo)yo;
		BaseInfo atacado = (BaseInfo)target;
		int cl = getCasterLevel(caster);
		int dañobase=Roll.d6();
		
		
		MagicAttack ataque = new MagicAttack(caster);
		atacado.apply(ataque);
	
		caster.playAnimationOn(ShootProyectileAnimation.ID, atacado.getToken(), "PARTICLE#magicmissile");
		
		if(atacado.getTrait(UndeadTraits.ID) != null){
			
			if(ataque.hits()) {
					Damage d= new Damage(dañobase, Damage.HOLY_DAMAGE,yo);
					atacado.apply(d);
					return true;
					}
				}
		return false;
	}
	
	public DisruptUndead() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
     setTargetClass(PhysicalToken.class);
     setResource("actions/disruptundead");
     setName("DisruptUndead");
     this.setEffectType(DAMAGE);
 	 setRange(CLOSE);
	
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 3;
	}
}
