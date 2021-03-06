package com.stab.pf.info.player;

import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.actions.MonkActionSet;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.alignment.Lawful;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.combat.CombatReflexes_Feat;
import com.stab.pf.info.feat.combat.Dodge_Feat;
import com.stab.pf.info.feat.combat.ImprovedUnarmedStrike_Feat;
import com.stab.pf.info.trait.PathfinderAttributeBonus;


public class MonkCharacter extends PathfinderCharacter{

	
public static final String ID="MONK_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new MonkActionSet());
		setResource("tokenMonk");
		setText("Monk1");
		
		this.setMaxHp(8);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 12);
		this.setAttribute(StabConstants.DEXTERITY, 16);
		this.setAttribute(StabConstants.CONSTITUTION, 10);
		this.setAttribute(StabConstants.INTELLIGENCE, 13);
		this.setAttribute(StabConstants.WISDOM, 15);
		this.setAttribute(StabConstants.CHARISMA, 8);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.ACROBATICS, 7);
		this.setAttribute(StabConstants.KNOWLEDGEHISTORY, 5);
		this.setAttribute(StabConstants.KNOWLEDGERELIGION, 5);
		this.setAttribute(StabConstants.SENSEMOTIVE, 6);
		this.setAttribute(StabConstants.PERCEPTION, 6);
		this.setAttribute(StabConstants.STEALTH, 7);
		
		this.addTrait(new CombatReflexes_Feat());
		this.addTrait(new Dodge_Feat());
		this.addTrait(new ImprovedUnarmedStrike_Feat());
		//this.addTrait(new StunningFist_Feat());
		//this.addTrait(new WeaponFinesse_Feat());
		
		this.equip(PfModule.getWeaponFactory().getWeapon("KAMA"), HumanoidGear.BOTHHANDS);
		
		this.addTrait(new PathfinderAttributeBonus(StabConstants.ARMOR,StabConstants.WISDOM));
		
		this.addTrait(new Lawful());
		
		/* Habilidades especiales			Esto... vendra en un dlc, no?
		 * Flurry of Blows
		 * Stunning Fist					Como el feat
		 * Unarmed Strike
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