package com.stab.data.actions.player;

import com.stab.data.actions.player.spells.sorcerer.level0.AcidSplash_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.Bleed_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.Daze_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.DisruptUndead_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.Flare_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.MageHand_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.OpenClose_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.RayFrost_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.Resistance_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level0.TouchFatigue_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.BurningHands_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.CharmPerson_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.ChillTouch_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.EnlargePerson_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.ExpeditiousRetreat_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.HoldPortal_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.Identify_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.Jump_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.MageArmor_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.MagicMissile_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.RayEnfeeblement_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.Shield_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.ShockingGrasp_Sorcerer;
import com.stab.data.actions.player.spells.sorcerer.level1.TrueStrike_Sorcerer;


public class SorcererActionSet extends PathfinderActionSet {

	public SorcererActionSet() {
		
		this.addAction(AcidSplash_Sorcerer.ID);
		this.addAction(Bleed_Sorcerer.ID);
		this.addAction(Daze_Sorcerer.ID);
		this.addAction(DisruptUndead_Sorcerer.ID);
		this.addAction(Flare_Sorcerer.ID);
		this.addAction(MageHand_Sorcerer.ID);
		this.addAction(OpenClose_Sorcerer.ID);
		this.addAction(RayFrost_Sorcerer.ID);
		this.addAction(Resistance_Sorcerer.ID);
		this.addAction(TouchFatigue_Sorcerer.ID);
		
		this.addAction(BurningHands_Sorcerer.ID);
		this.addAction(CharmPerson_Sorcerer.ID);
		this.addAction(ChillTouch_Sorcerer.ID);
		this.addAction(EnlargePerson_Sorcerer.ID);
		this.addAction(ExpeditiousRetreat_Sorcerer.ID);
		this.addAction(HoldPortal_Sorcerer.ID);
		this.addAction(Identify_Sorcerer.ID);
		this.addAction(Jump_Sorcerer.ID);
		this.addAction(MageArmor_Sorcerer.ID);
		this.addAction(MagicMissile_Sorcerer.ID);
		this.addAction(RayEnfeeblement_Sorcerer.ID);
		this.addAction(Shield_Sorcerer.ID);
		this.addAction(ShockingGrasp_Sorcerer.ID);
		this.addAction(TrueStrike_Sorcerer.ID);
		
		
				this.setAction(MagicMissile_Sorcerer.ID, 1);
				this.setAction(RayEnfeeblement_Sorcerer.ID, 2);
				this.setAction(Daze_Sorcerer.ID, 3);
				this.setAction(RayFrost_Sorcerer.ID, 4);
				this.setAction(TouchFatigue_Sorcerer.ID, 5);
				this.setAction(OpenClose_Sorcerer.ID, 6);
	
	}	
}