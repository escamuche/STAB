package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.debuff.ChillTouch_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class ChillTouch extends SpellOnTarget{
	
	public static final String ID="CHILLTOUCH";
	
	
	

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int dañobase=Roll.d6();
		int cl =getCasterLevel(caster);
		
		
		MagicAttack ataque = new MagicAttack(caster);
		target.apply(ataque);
		
		caster.playAnimationOn(ShootProyectileAnimation.ID, target.getToken(), "PARTICLE#magicmissile");
		
		Damage d= new Damage(dañobase, Damage.UNHOLY_DAMAGE,caster);
		target.apply(d);
			
		if(ataque.hits()) {
			FortitudeAttack ataque2 = new FortitudeAttack(caster);
			target.apply(ataque2);
			if(ataque2.hits()){
				ChillTouch_Debuff chilltouch = new ChillTouch_Debuff();
				target.addTrait(chilltouch);
			}
		return true;
		}
		return false;
	}
	
	// falta el tema de panicked a undeads...
	
	public ChillTouch() {
     
	 setLevel(1);
	 setCasterClass(StabConstants.WIZARDCASTER);
     
     setResource("actions/chilltouch");
     setName("Chill Touch");
     this.setEffectType(DAMAGE);
     setRange(TOUCH);
	}

	
	@Override
	public int getEffectValue(BaseInfo i) {
		return 5;
	}
}
