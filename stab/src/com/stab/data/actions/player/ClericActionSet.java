package com.stab.data.actions.player;


import com.stab.data.actions.player.abilities.ChannelPossitiveEnergyAction;
import com.stab.data.actions.player.abilities.NobilityDomain;
import com.stab.data.actions.player.spells.cleric.level1.Bane;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.Command;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.DivineFavor;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.EntropicShield;
import com.stab.data.actions.player.spells.cleric.level1.InflictLight;
import com.stab.data.actions.player.spells.cleric.level1.MagicStone;
import com.stab.data.actions.player.spells.cleric.level1.ShieldFaith;
import com.stab.data.actions.player.spells.lvl0.Resistance;
import com.stab.data.actions.player.spells.lvl0.Stabilize;
import com.stab.data.actions.player.spells.lvl0.Virtue;
import com.stab.data.actions.player.spells.lvl0.unfinished.Guidance;


public class ClericActionSet extends PathfinderActionSet {

	public ClericActionSet() {
		
		
		//this.addAction(Bleed.ID);
		this.addAction(Guidance.ID);
		this.addAction(Resistance.ID);
		this.addAction(Stabilize.ID);
		this.addAction(Virtue.ID);
		
		/*
		this.addAction(Bane.ID);
		this.addAction(Bless.ID);
		this.addAction(Command.ID);
		this.addAction(CureLight.ID);
		this.addAction(DivineFavor.ID);
		this.addAction(Doom.ID);
		this.addAction(EntropicShield.ID);
		this.addAction(InflictLight.ID);
		this.addAction(MagicStone.ID);
		this.addAction(ShieldFaith.ID);
		/**/
		this.addAction(ChannelPossitiveEnergyAction.ID);
		
		this.setAction(CureLight.ID, 1);
		this.setAction(Bless.ID, 2);
		this.setAction(ShieldFaith.ID, 3);
		this.setAction(Doom.ID, 4);
		this.setAction(NobilityDomain.ID,5);
		
	}
}
