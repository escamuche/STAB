package com.stab.data.actions.player.spells.bard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.Info;

public class HideousLaughter extends SpellOnTarget{

	public static final String ID="HIDEOUSLAUGHTER";
	
	public HideousLaughter() {
		
		 setLevel(1);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("Hideous Laughter");
	     this.setEffectType(SPECIAL);
	     this.setDescription("This spell afflicts the subject with uncontrollable laughter. It collapses into gales of manic laughter, falling prone. The subject can take no actions while laughing, but is not considered helpless. After the spell ends, it can act normally. On the creature's next turn, it may attempt a new saving throw to end the effect. This is a full round action that does not provoke attacks of opportunity. If this save is successful, the effect ends. If not, the creature continues laughing for the entire duration." +
	     		 "A creature with an Intelligence score of 2 or lower is not affected. A creature whose type is different from the caster's receives a +4 bonus on its saving throw, because humor doesn't “translate” well.");
		}


	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return false;
	}
}