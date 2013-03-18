package com.stab.data.actions.player;


import com.stab.data.actions.WeaponAttackAction;
import com.stab.data.actions.player.spells.wizard.level0.AcidSplash;
import com.stab.data.actions.player.spells.wizard.level0.Flare;
import com.stab.data.actions.player.spells.wizard.level0.OpenClose;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.Resistance;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.ReducePerson;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class WizardActionSet extends PathfinderActionSet {

	public WizardActionSet() {
		for (int f=0;f<24;f++)
			this.addAction(EmptyAction.ID);
		
		//this.setAction(WizardBasicMelee.ID, 10);
		/*this.setAction(MagicMissile.ID, 12);
		this.setAction(AcidSplash.ID, 14);
		this.setAction(Shield.ID,11);
		this.setAction(Flare.ID,15);
		this.setAction(RayFrost.ID, 13);
		this.setAction(OpenClose.ID,16);
		this.setAction(Resistance.ID,17);*/
		
		this.setAction(AcidSplash.ID, 20);
		this.setAction(Flare.ID, 21);
		this.setAction(OpenClose.ID, 22);
		this.setAction(RayFrost.ID, 23);
		this.setAction(Resistance.ID, 24);
		this.setAction(ChillTouch.ID, 25);
		this.setAction(EnlargePerson.ID, 26);
		this.setAction(ExpeditiousRetreat.ID, 27);
		this.setAction(MageArmor.ID, 28);
		this.setAction(MagicMissile.ID, 29);
		this.setAction(RayEnfeeblement.ID, 30);
		this.setAction(ReducePerson.ID, 31);
		this.setAction(Shield.ID, 32);
		this.setAction(ShockingGrasp.ID, 33);
	//	this.setAction(TrueStrike.ID, 34);
		
	}
}