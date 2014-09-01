package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.common.utils.Roll;
import com.stab.data.actions.player.spells.Spell;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Attack;
import com.stab.model.info.applicable.base.WeaponAttack;

public class EntropicShield_Buff extends SpellEffect implements Attends<WeaponAttack> {

	public static final String ID="ENTROPICSHIELD_BUFF";
	
	public EntropicShield_Buff(Spell spell,BaseInfo caster) {
		super(spell,caster);
		setBuffDebuff(BUFF);
		setEvident(true);
		setEffectResource("SHADER#entropicshield#effects/globe$S");
		}

	@Override
	public void attend(WeaponAttack arg0) {
		
		int i = Roll.d100();
		if(i <= 20) 
			arg0.setResult(Attack.MISS);
		
	}

	@Override
	public boolean canAttend(Applicable arg0) {
		if (arg0 instanceof PathfinderAttack)
			return ((Attack)arg0).isRanged();
		return false;
	}

	

}
