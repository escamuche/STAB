package com.stab.data.actions.player.spells.cleric.level1.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

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

	
	
protected Weapon getWeapon(BaseInfo atacante) {
		
		if (atacante instanceof Creature){
			Creature c=(Creature)atacante;
			Equipment e= c.getEquipment(HumanoidGear.MAINHAND);
			if (e instanceof Weapon)
				return (Weapon)e;
		}
		return null;
	}
}