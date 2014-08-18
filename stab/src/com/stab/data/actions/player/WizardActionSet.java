package com.stab.data.actions.player;


import com.stab.data.StabConstants;
import com.stab.data.actions.monster.AcidFlask;
import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.lvl0.AcidSplash;
import com.stab.data.actions.player.spells.lvl0.Daze;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.data.actions.player.spells.lvl0.DisruptUndead;
import com.stab.data.actions.player.spells.lvl0.Flare;
import com.stab.data.actions.player.spells.lvl0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.OpenClose;
import com.stab.data.actions.player.spells.wizard.level0.TouchFatigue;
import com.stab.data.actions.player.spells.wizard.level0.unfinished.DancingLights;
import com.stab.data.actions.player.spells.wizard.level1.BurningHands;
import com.stab.data.actions.player.spells.wizard.level1.CharmPerson;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.wizard.level1.HoldPortal;
import com.stab.data.actions.player.spells.wizard.level1.Identify;
import com.stab.data.actions.player.spells.wizard.level1.Jump;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;

public class WizardActionSet extends PathfinderActionSet {

	public WizardActionSet() {
		
		this.addAction(AcidSplash.ID);
	//	this.addAction(Bleed_Wizard.ID);
		this.addAction(Daze.ID);
		this.addAction(DisruptUndead.ID);
		this.addAction(Flare.ID);
	//	this.addAction(Light_Wizard.ID);
	//	this.addAction(MageHand.ID);
		this.addAction(OpenClose.ID);
		this.addAction(RayFrost.ID);
	//	this.addAction(Resistance_Wizard.ID);
		this.addAction(TouchFatigue.ID);
		
		this.addAction(BurningHands.ID);
		this.addAction(CharmPerson.ID);
		this.addAction(ChillTouch.ID);
		this.addAction(EnlargePerson.ID);
		this.addAction(ExpeditiousRetreat.ID);
		this.addAction(HoldPortal.ID);
		this.addAction(Identify.ID);
		this.addAction(Jump.ID);
		this.addAction(MageArmor.ID);
	//	this.addAction(MagicMissile.ID);
		this.addAction(RayEnfeeblement.ID);
		this.addAction(Shield.ID);
		this.addAction(ShockingGrasp.ID);
		this.addAction(TrueStrike.ID);
		
		this.addAction(DancingLights.ID);
		
				this.setAction(Shield.ID,1);
				this.setAction(Daze.ID, 2);
				this.setAction(DisruptUndead.ID, 3);
				this.setAction(BurningHands.ID, 4);
				this.setAction(RayFrost.ID,5);
				this.setAction(TouchFatigue.ID,6);
				
				
				this.setAction(Daze.ID, 2);
				
				
				this.addAction(AcidFlask.ID);
				this.setAction(AcidFlask.ID,6);
				
				
		SpellAction mm= SpellUtils.asCaster(MagicMissile.ID, StabConstants.WIZARDCASTER);
		this.addAction(mm);
		this.setAction(mm, 2);
		
		this.setAction(DetectMagic.ID,1);
		
	}
}