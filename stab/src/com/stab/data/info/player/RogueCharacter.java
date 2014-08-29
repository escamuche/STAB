package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.player.RogueActionSet;
import com.stab.data.info.alignment.Evil;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.player.abilities.SneakAttack_Ability;


public class RogueCharacter extends PathfinderCharacter{

	
public static final String ID="ROGUE_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new RogueActionSet());
		setResource("tokenRogue");
		setText("Rogue1");
		
		this.setMaxHp(8);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 14);
		this.setAttribute(StabConstants.DEXTERITY, 17);
		this.setAttribute(StabConstants.CONSTITUTION, 13);
		this.setAttribute(StabConstants.INTELLIGENCE, 10);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.CHARISMA, 12);
		
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		
		this.setAttribute(StabConstants.ACROBATICS, 7);
		this.setAttribute(StabConstants.CLIMB, 6);
		this.setAttribute(StabConstants.DISABLEDEVICES, 7);
		this.setAttribute(StabConstants.ESCAPEARTIST, 7);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 4);
		this.setAttribute(StabConstants.PERCEPTION, 3);
		this.setAttribute(StabConstants.STEALTH, 7);
		this.setAttribute(StabConstants.SLEIGHTOFHAND, 7);
		this.setAttribute(StabConstants.SWIMSKILL, 6);
		
		this.addTrait(new ImprovedInitiative_Feat());
		//this.addTrait(new WeaponFinesse_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SHORTSWORD"), HumanoidGear.MAINHAND);
		
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);

		this.addTrait(new Evil());
		
		this.addTrait(new SneakAttack_Ability(1));
		
		
		/* Habilidades especiales
		 * 
		*   tapfinding.  un trait que attends spotroll, y sume +1/2 level min 1  si el target es una trampa. y un modificador igual a disable device 
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