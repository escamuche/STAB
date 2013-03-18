package com.stab.data.actions.player;

import com.stab.data.actions.WeaponAttackAction;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.actions.player.spells.wizard.level0.AcidSplash;
import com.stab.data.info.feat.combat.Dodge_Feat;
import com.stab.data.info.feat.combat.Expertise_Feat;
import com.stab.data.info.feat.combat.PowerAttack_Feat;
import com.stab.data.info.feat.combat.WeaponFocus_Feat;
import com.stab.data.info.feat.general.Acrobatic_Feat;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.feat.general.AnimalAffinity_Feat;
import com.stab.data.info.feat.general.Athletic_Feat;
import com.stab.data.info.feat.general.Deceitful_Feat;
import com.stab.data.info.feat.general.DeftHands_Feat;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;
import com.stab.model.action.BasicActionSet;
import com.stab.model.action.base.EmptyAction;
import com.stab.model.action.base.InteractAction;


public class WarriorActionSet extends PathfinderActionSet {

	public WarriorActionSet() {
		for (int f=0;f<32;f++) {
			
			this.setAction(Dodge_Feat.ID, 20);
			this.setAction(Expertise_Feat.ID, 21);
			this.setAction(PowerAttack_Feat.ID, 22);
			this.setAction(WeaponFocus_Feat.ID, 23);
			this.setAction(Acrobatic_Feat.ID, 24);
			this.setAction(Alertness_Feat.ID, 25);
			this.setAction(AnimalAffinity_Feat.ID, 26);
			this.setAction(Athletic_Feat.ID, 27);
			this.setAction(Deceitful_Feat.ID, 28);
			this.setAction(DeftHands_Feat.ID, 29);
			this.setAction(ImprovedInitiative_Feat.ID, 30);
			this.setAction(SkillFocusPerception_Feat.ID, 31);
		
		
		}
	}	
}
