package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.SorcererActionSet;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.feat.general.CombatCasting_Feat;
import com.stab.data.info.feat.general.EschewMaterials_Feat;
import com.stab.data.info.feat.general.IronWill_Feat;


public class SorcererCharacter extends PathfinderCharacter{

	
public static final String ID="SORCERER_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new SorcererActionSet());
		setResource("tokenSorcerer");
		setText("Sorcerer1");
		
		this.setMaxHp(6);
		this.healFully();
		this.setEp(10);
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 10);
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.INTELIGENCE, 12);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.CHARISMA, 17);
		
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.BLUFF, 7);
		this.setAttribute(StabConstants.INTIMIDATE, 7);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 5);
		this.setAttribute(StabConstants.PERCEPTION, 1);
		this.setAttribute(StabConstants.SENSEMOTIVE, 1);
		this.setAttribute(StabConstants.SPELLCRAFT, 5);
		
		this.setAttribute(StabConstants.CASTERLEVEL, 1);
		this.setAttribute(StabConstants.SPELLKNOWN0, 4);
		this.setAttribute(StabConstants.SPELLKNOWN1, 2);
		
		this.addTrait(new Alertness_Feat());
		this.addTrait(new CombatCasting_Feat());
		this.addTrait(new EschewMaterials_Feat());
		this.addTrait(new IronWill_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		
		/* habilidades especiales
		 * 							hay que ir pensando esa tabla de coste de pm por nivel...
		 * Bloodline power			traits.
		 */
		
	}
	
	
	@Override
	public void setResource(String resource) {
		super.setResource(resource);
	}
	

	
	@Override
	public String getDefaultActionID() {
		return DefendAction.ID;
	}
	
}
