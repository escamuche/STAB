package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.cleric.level0.Guidance;
import com.stab.data.actions.player.spells.cleric.level0.ResistanceCleric;
import com.stab.data.actions.player.spells.cleric.level1.Bane;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.DivineFavor;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.InflictLight;
import com.stab.data.actions.player.spells.cleric.level1.MagicStone;
import com.stab.data.actions.player.spells.cleric.level1.ShieldFaith;


public class ClericActionSet extends PathfinderActionSet {

	public ClericActionSet() {
		
		
		this.addAction(Guidance.ID);
		this.addAction(ResistanceCleric.ID);
		this.addAction(Bane.ID);
		this.addAction(Bless.ID);
		this.addAction(CureLight.ID);
		this.addAction(DivineFavor.ID);
		this.addAction(Doom.ID);
		this.addAction(InflictLight.ID);
		this.addAction(MagicStone.ID);
		this.addAction(ShieldFaith.ID);
		
		
		/**/this.setAction(Bless.ID, 2);
		this.setAction(Doom.ID, 6);
		this.setAction(CureLight.ID, 1);
		this.setAction(ShieldFaith.ID, 3);
		this.setAction(MagicStone.ID, 4);
		this.setAction(DivineFavor.ID,5);/**/
		
	}
}
