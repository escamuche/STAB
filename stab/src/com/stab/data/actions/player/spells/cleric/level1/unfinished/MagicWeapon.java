package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.buff.Bless_Buff;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class MagicWeapon extends SpellOnTarget {
	
	public static final String ID="MAGICWEAPON_CLERIC";
	
	public MagicWeapon() {
		setLevel(1);
		setCasterClass(StabConstants.CLERICCASTER);
		 setRange(1);
     setResource("actions/ability_druid_naturalperfection");
     setName("MagicWeapon");
     this.setEffectType(BUFF);
	}

	@Override
	public boolean execute(Info yo, Info target) {
		
		/* Como le digo que me de el arma equipada del target?
		BaseInfo weapon = (BaseInfo)target;
		MagicWeapon_Buff buff = new MagicWeapon_Buff(weapon);
		weapon.addTrait(buff);
		/**/
		
		return true;
	}
}