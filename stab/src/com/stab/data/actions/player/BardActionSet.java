package com.stab.data.actions.player;

import com.stab.data.actions.player.spells.bard.level0.DancingLights_Bard;
import com.stab.data.actions.player.spells.bard.level0.Daze_Bard;
import com.stab.data.actions.player.spells.bard.level0.DetectMagic_Bard;
import com.stab.data.actions.player.spells.bard.level0.Flare_Bard;
import com.stab.data.actions.player.spells.bard.level0.GhostSound_Bard;
import com.stab.data.actions.player.spells.bard.level0.Light_Bard;
import com.stab.data.actions.player.spells.bard.level0.Lullaby;
import com.stab.data.actions.player.spells.bard.level0.MageHand_Bard;
import com.stab.data.actions.player.spells.bard.level0.Mending_Bard;
import com.stab.data.actions.player.spells.bard.level0.Message_Bard;
import com.stab.data.actions.player.spells.bard.level0.OpenClose_Bard;
import com.stab.data.actions.player.spells.bard.level0.Resistance_Bard;
import com.stab.data.actions.player.spells.bard.level1.Alarm_Bard;
import com.stab.data.actions.player.spells.bard.level1.AnimateRope_Bard;
import com.stab.data.actions.player.spells.bard.level1.CauseFear_Bard;
import com.stab.data.actions.player.spells.bard.level1.CharmPerson_Bard;
import com.stab.data.actions.player.spells.bard.level1.ComprehendLanguages_Bard;
import com.stab.data.actions.player.spells.bard.level1.CureLight_Bard;
import com.stab.data.actions.player.spells.bard.level1.DetectSecretDoors_Bard;
import com.stab.data.actions.player.spells.bard.level1.DisguiseSelf_Bard;
import com.stab.data.actions.player.spells.bard.level1.Erase_Bard;
import com.stab.data.actions.player.spells.bard.level1.ExpeditiousRetreat_Bard;
import com.stab.data.actions.player.spells.bard.level1.FeatherFall_Bard;
import com.stab.data.actions.player.spells.bard.level1.Grease_Bard;
import com.stab.data.actions.player.spells.bard.level1.HideousLaughter;
import com.stab.data.actions.player.spells.bard.level1.Hypnotism_Bard;
import com.stab.data.actions.player.spells.bard.level1.Identify_Bard;
import com.stab.data.actions.player.spells.bard.level1.LesserConfusion;
import com.stab.data.actions.player.spells.bard.level1.MagicAura_Bard;
import com.stab.data.actions.player.spells.bard.level1.RemoveFear_Bard;
import com.stab.data.actions.player.spells.bard.level1.SilentImage_Bard;
import com.stab.data.actions.player.spells.bard.level1.Sleep_Bard;
import com.stab.data.actions.player.spells.bard.level1.SummonMonster1_Bard;
import com.stab.data.actions.player.spells.bard.level1.UndetectableAlignment;
import com.stab.data.actions.player.spells.bard.level1.UnseenServant_Bard;
import com.stab.data.actions.player.spells.bard.level1.Ventriloquism_Bard;




public class BardActionSet extends PathfinderActionSet {

	public BardActionSet() {
		
		this.addAction(DancingLights_Bard.ID);
		this.addAction(Daze_Bard.ID);
		this.addAction(DetectMagic_Bard.ID);
		this.addAction(Flare_Bard.ID);
		this.addAction(GhostSound_Bard.ID);
		this.addAction(Light_Bard.ID);
		this.addAction(Lullaby.ID);
		this.addAction(MageHand_Bard.ID);
		this.addAction(Mending_Bard.ID);
		this.addAction(Message_Bard.ID);
		this.addAction(OpenClose_Bard.ID);
		this.addAction(Resistance_Bard.ID);
		
		this.addAction(Alarm_Bard.ID);
		this.addAction(AnimateRope_Bard.ID);
		this.addAction(CauseFear_Bard.ID);
		this.addAction(CharmPerson_Bard.ID);
		this.addAction(ComprehendLanguages_Bard.ID);
		this.addAction(CureLight_Bard.ID);
		this.addAction(DetectSecretDoors_Bard.ID);
		this.addAction(DisguiseSelf_Bard.ID);
		this.addAction(Erase_Bard.ID);
		this.addAction(ExpeditiousRetreat_Bard.ID);
		this.addAction(FeatherFall_Bard.ID);
		this.addAction(Grease_Bard.ID);
		this.addAction(HideousLaughter.ID);
		this.addAction(Hypnotism_Bard.ID);
		this.addAction(Identify_Bard.ID);
		this.addAction(LesserConfusion.ID);
		this.addAction(MagicAura_Bard.ID);
		this.addAction(RemoveFear_Bard.ID);
		this.addAction(SilentImage_Bard.ID);
		this.addAction(Sleep_Bard.ID);
		this.addAction(SummonMonster1_Bard.ID);
		this.addAction(UndetectableAlignment.ID);
		this.addAction(UnseenServant_Bard.ID);
		this.addAction(Ventriloquism_Bard.ID);
		
		this.setAction(Daze_Bard.ID, 1);
		this.setAction(Flare_Bard.ID, 2);
		this.setAction(OpenClose_Bard.ID, 3);
		this.setAction(Resistance_Bard.ID, 4);
		this.setAction(CharmPerson_Bard.ID, 5);
		this.setAction(CureLight_Bard.ID, 6);
	}	
}
