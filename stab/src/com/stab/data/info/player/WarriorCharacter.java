package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.combat.Expertise_Feat;
import com.stab.model.info.trait.Modifier;


public class WarriorCharacter extends PathfinderCharacter{

	
public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		
		this.setMaxHp(13);
		this.healFully();
		this.fillEnergy();
		this.setAttribute(StabConstants.TOHIT,1);
		this.setAttribute(StabConstants.TOHITRANGED,1);
		this.setAttribute(StabConstants.DEXTERITY, 12);
		this.setAttribute(StabConstants.STRENGHT, 16);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.CHARISMA, 8);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"ARMADURA",4));
		this.addTrait(Modifier.createMod(StabConstants.ARMOR,"SHIELD",2));
		
		this.addTrait(new Expertise_Feat());
		this.getActionSet().setAction(Expertise.ID, 17);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGSWORD"), HumanoidGear.MAINHAND);
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
	
