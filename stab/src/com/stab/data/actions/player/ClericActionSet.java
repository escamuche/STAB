package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.cleric.level0.Guidance;
import com.stab.data.actions.player.spells.cleric.level0.ResistanceCleric;
import com.stab.data.actions.player.spells.cleric.level1.Bane;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.DivineFavor;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.MagicStone;
import com.stab.data.actions.player.spells.cleric.level1.ShieldFaith;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class ClericActionSet extends BasicActionSet {

	public ClericActionSet() {
		for (int f=0;f<10;f++)
			this.addAction(EmptyAction.ID);
		
		
		this.setAction(InteractAction.ID,18);
		this.setAction(DefendAction.ID,19);
		this.setAction(ClericBasicMelee.ID, 10);
		this.setAction(Bless.ID, 12);
		this.setAction(Doom.ID, 16);
		this.setAction(CureLight.ID, 11);
		this.setAction(ShieldFaith.ID, 13);
		this.setAction(MagicStone.ID, 14);
		this.setAction(RangedKill.ID, 17);
		this.setAction(DivineFavor.ID,15);
		
	}
}