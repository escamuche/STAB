package com.stab.data.actions.player;


import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.lvl0.AcidSplash;
import com.stab.data.actions.player.spells.lvl0.Daze;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.data.actions.player.spells.lvl0.DisruptUndead;
import com.stab.data.actions.player.spells.lvl0.Flare;
import com.stab.data.actions.player.spells.lvl0.RayFrost;
import com.stab.data.actions.player.spells.lvl0.Resistance;
import com.stab.data.actions.player.spells.lvl0.TouchFatigue;
import com.stab.data.actions.player.spells.lvl1.BurningHands;
import com.stab.data.actions.player.spells.lvl1.DivineFavor;
import com.stab.data.actions.player.spells.lvl1.MageArmor;
import com.stab.data.actions.player.spells.lvl1.RayEnfeeblement;
import com.stab.data.actions.player.spells.lvl1.Shield;
import com.stab.data.actions.player.spells.lvl1.SummonMonsterI;
import com.stab.data.actions.player.spells.lvl1.TrueStrike;
import com.stab.data.actions.player.spells.lvl1.unfinished.ChillTouch;
import com.stab.data.actions.player.spells.lvl1.unfinished.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.lvl1.unfinished.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.CharmPerson;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.HoldPortal;
import com.stab.data.actions.player.spells.wizard.level1.Identify;
import com.stab.data.actions.player.spells.wizard.level1.Jump;

public class WizardActionSet extends PathfinderActionSet {

	public WizardActionSet() {
		
		
		//No tardando mucho esto vendra directamente de una spell list en la clase wizard. por ahora, sigue puesto a pi�on
		
		this.addAction(AcidSplash.ID);
	//	this.addAction(Bleed_Wizard.ID);
		this.addAction(Daze.ID);
		this.addAction(DisruptUndead.ID);
		this.addAction(Flare.ID);
	//	this.addAction(Light_Wizard.ID);
	//	this.addAction(MageHand.ID);
	//	this.addAction(OpenClose.ID);
		this.addAction(RayFrost.ID);
		this.addAction(Resistance.ID);
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
		
	//	this.addAction(DancingLights.ID);
	//	
		this.setAction(Shield.ID,1);
		this.setAction(SummonMonsterI.ID, 2);
		this.setAction(DisruptUndead.ID, 3);
		this.setAction(BurningHands.ID, 4);
		this.setAction(RayFrost.ID,5);
		this.setAction(TouchFatigue.ID,6);
				
				
		//this.setAction(Resistance.ID, 2);
				
				
			//	this.addAction(AcidFlask.ID);
			//	this.setAction(AcidFlask.ID,6);
				
				
		//SpellAction mm= SpellUtils.asCaster(MagicMissile.ID, StabConstants.WIZARDCASTER);
		//this.addAction(mm);
		//this.setAction(mm, 2);
		
		this.setAction(DetectMagic.ID,1);
		
		this.setAction(SpellUtils.asWizard(DivineFavor.ID), 2);
	}
}