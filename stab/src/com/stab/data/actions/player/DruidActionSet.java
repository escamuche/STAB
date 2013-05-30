package com.stab.data.actions.player;

import com.stab.data.actions.player.abilities.NobilityDomain;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.ShieldFaith;
import com.stab.data.actions.player.spells.druid.level0.CreateWater_Druid;
import com.stab.data.actions.player.spells.druid.level0.DetectMagic_Druid;
import com.stab.data.actions.player.spells.druid.level0.DetectPoison_Druid;
import com.stab.data.actions.player.spells.druid.level0.Flare_Druid;
import com.stab.data.actions.player.spells.druid.level0.Guidance_Druid;
import com.stab.data.actions.player.spells.druid.level0.Light_Druid;
import com.stab.data.actions.player.spells.druid.level0.Mending_Druid;
import com.stab.data.actions.player.spells.druid.level0.PurifyFood_Druid;
import com.stab.data.actions.player.spells.druid.level0.Resistance_Druid;
import com.stab.data.actions.player.spells.druid.level0.Stabilize_Druid;
import com.stab.data.actions.player.spells.druid.level0.Virtue_Druid;
import com.stab.data.actions.player.spells.druid.level1.CalmAnimals;
import com.stab.data.actions.player.spells.druid.level1.CharmAnimal;
import com.stab.data.actions.player.spells.druid.level1.CureLight_Druid;
import com.stab.data.actions.player.spells.druid.level1.DetectAnimals;
import com.stab.data.actions.player.spells.druid.level1.DetectSnares;
import com.stab.data.actions.player.spells.druid.level1.EndureElements_Druid;
import com.stab.data.actions.player.spells.druid.level1.Entangle;
import com.stab.data.actions.player.spells.druid.level1.FaerieFire;
import com.stab.data.actions.player.spells.druid.level1.Goodberry;
import com.stab.data.actions.player.spells.druid.level1.HideAnimals;
import com.stab.data.actions.player.spells.druid.level1.Jump_Druid;
import com.stab.data.actions.player.spells.druid.level1.Longstrider;
import com.stab.data.actions.player.spells.druid.level1.MagicFang;
import com.stab.data.actions.player.spells.druid.level1.MagicStone_Druid;
import com.stab.data.actions.player.spells.druid.level1.ObscuringMist_Druid;
import com.stab.data.actions.player.spells.druid.level1.PassTrace;
import com.stab.data.actions.player.spells.druid.level1.ProduceFlame;
import com.stab.data.actions.player.spells.druid.level1.Shillelagh;
import com.stab.data.actions.player.spells.druid.level1.SpeakAnimals;
import com.stab.data.actions.player.spells.druid.level1.SummonNature1;




public class DruidActionSet extends PathfinderActionSet {

	public DruidActionSet() {
		
		this.addAction(CreateWater_Druid.ID);
		this.addAction(DetectMagic_Druid.ID);
		this.addAction(DetectPoison_Druid.ID);
		this.addAction(Flare_Druid.ID);
		this.addAction(Guidance_Druid.ID);
		this.addAction(Light_Druid.ID);
		this.addAction(Mending_Druid.ID);
		this.addAction(PurifyFood_Druid.ID);
		this.addAction(Resistance_Druid.ID);
		this.addAction(Stabilize_Druid.ID);
		this.addAction(Virtue_Druid.ID);
		
		
		this.addAction(CalmAnimals.ID);
		this.addAction(CharmAnimal.ID);
		this.addAction(CureLight_Druid.ID);
		this.addAction(DetectAnimals.ID);
		this.addAction(DetectSnares.ID);
		this.addAction(EndureElements_Druid.ID);
		this.addAction(Entangle.ID);
		this.addAction(FaerieFire.ID);
		this.addAction(Goodberry.ID);
		this.addAction(HideAnimals.ID);
		this.addAction(Jump_Druid.ID);
		this.addAction(Longstrider.ID);
		this.addAction(MagicFang.ID);
		this.addAction(MagicStone_Druid.ID);
		this.addAction(ObscuringMist_Druid.ID);
		this.addAction(PassTrace.ID);
		this.addAction(ProduceFlame.ID);
		this.addAction(Shillelagh.ID);
		this.addAction(SpeakAnimals.ID);
		this.addAction(SummonNature1.ID);
		
		this.setAction(CureLight_Druid.ID, 1);
		this.setAction(MagicStone_Druid.ID, 2);
		this.setAction(Stabilize_Druid.ID, 3);
		this.setAction(Flare_Druid.ID, 4);
		this.setAction(Guidance_Druid.ID, 5);
		
	}	
}