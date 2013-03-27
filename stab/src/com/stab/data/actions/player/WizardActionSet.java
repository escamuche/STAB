package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.wizard.level0.AcidSplash;
import com.stab.data.actions.player.spells.wizard.level0.Flare;
import com.stab.data.actions.player.spells.wizard.level0.OpenClose;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.Resistance;
import com.stab.data.actions.player.spells.wizard.level0.unfinished.DancingLights;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.unfinished.ReducePerson;

public class WizardActionSet extends PathfinderActionSet {

	public WizardActionSet() {
		
		
		
		this.addAction(AcidSplash.ID);
		this.addAction(Flare.ID);
		this.addAction(OpenClose.ID);
		this.addAction(RayFrost.ID);
		this.addAction(Resistance.ID);
		this.addAction(ChillTouch.ID);
		this.addAction(EnlargePerson.ID);
		this.addAction(ExpeditiousRetreat.ID);
		this.addAction(MageArmor.ID);
		this.addAction(MagicMissile.ID);
		this.addAction(RayEnfeeblement.ID);
		this.addAction(ReducePerson.ID);
		this.addAction(Shield.ID);
		this.addAction(ShockingGrasp.ID);
	//	this.setAction(TrueStrike.ID, 34);
		
		this.addAction(DancingLights.ID);
		
		//this.setAction(WizardBasicMelee.ID, 10);
				/**/this.setAction(MagicMissile.ID, 2);
				this.setAction(DancingLights.ID, 4);
				this.setAction(Shield.ID,1);
				this.setAction(Flare.ID,5);
				this.setAction(RayFrost.ID, 3);
				this.setAction(OpenClose.ID,6);
				this.setAction(Resistance.ID,7);/**/
		
	}
}