package com.stab.data.actions.player.spells.cleric.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.debuff.Bleed_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Bleed extends SpellOnTarget{
	
	public static final String ID="BLEED_CLERIC";

	public Bleed() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.CLERICCASTER);
		 setRange(5);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Bleed");
	     this.setEffectType(DEBUFF);
	     this.setSave(StabConstants.FORTITUDESAVE);
	     this.setDescription("You cause a living creature that is below 0 hit points but stabilized to resume dying. Upon casting this spell, you target a living creature that has -1 or fewer hit points. That creature begins dying, taking 1 point of damage per round. The creature can be stabilized later normally. This spell causes a creature that is dying to take 1 point of damage.");
		}

	@Override
	public boolean affect(Info instigator, Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		if(target.getHp()<=0) {
		Bleed_Debuff debuff = new Bleed_Debuff();
		target.addTrait(debuff);
		}
		
		return true;
	}
}
