package com.stab.pf.info.player;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.SorcererActionSet;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.alignment.Lawful;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.general.Alertness_Feat;
import com.stab.pf.info.feat.general.CombatCasting_Feat;
import com.stab.pf.info.feat.general.EschewMaterials_Feat;
import com.stab.pf.info.feat.general.IronWill_Feat;
import com.stab.pf.info.trait.BonusAttributeMP;


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
		this.setMaxEp(30);
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 10);
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.INTELLIGENCE, 12);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.CHARISMA, 17);
		
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.BLUFF, 7);
		this.setAttribute(StabConstants.INTIMIDATE, 7);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 5);
		this.setAttribute(StabConstants.PERCEPTION, 1);
		this.setAttribute(StabConstants.SENSEMOTIVE, 1);
		this.setAttribute(StabConstants.SPELLCRAFT, 5);
		
		this.setAttribute(StabConstants.SORCERERCASTER, 1);
		this.setAttribute(StabConstants.SPELLKNOWN0, 4);
		this.setAttribute(StabConstants.SPELLKNOWN1, 2);
		
		this.addTrait(new BonusAttributeMP(StabConstants.MAXMP, StabConstants.CHARISMA, getValue(StabConstants.SORCERERCASTER)));
		
		this.addTrait(new Alertness_Feat());
		this.addTrait(new CombatCasting_Feat());
		this.addTrait(new EschewMaterials_Feat());
		this.addTrait(new IronWill_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		
		this.addTrait(new Lawful());
		
		this.addTrait(new Modifier(StabConstants.FORTITUDESAVE,+2)); 
		
		//familiar--> rata 
		//Bloodline arcana
		
		
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
