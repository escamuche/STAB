package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.actions.player.BarbarianActionSet;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.combat.Cleave_Feat;
import com.stab.data.info.feat.combat.PowerAttack_Feat;


public class BarbarianCharacter extends PathfinderCharacter{

	
public static final String ID="BARBARIAN_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new BarbarianActionSet());
		setResource("tokenBarbarian");
		setText("Barbarian1");
		
		this.setMaxHp(12);
		this.healFully();
		this.fillEnergy();

		this.setAttribute(StabConstants.BAB,1);
		this.setAttribute(StabConstants.STRENGHT, 17);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.DEXTERITY, 10);
		this.setAttribute(StabConstants.WISDOM, 12);
		this.setAttribute(StabConstants.CHARISMA, 8);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.addTrait(new PowerAttack_Feat());
		this.getActionSet().setAction(PowerAttack.ID, 17);
		
		this.addTrait(new Cleave_Feat());
		//this.getActionSet().setAction(Cleave.ID, 18);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("GREATSWORD"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("BREASTPLATE"), HumanoidGear.ARMOR);
		
		this.setAttribute(StabConstants.CLIMB, 5);
		this.setAttribute(StabConstants.KNOWLEDGENATURE, 4);
		this.setAttribute(StabConstants.PERCEPTION, 5);
		this.setAttribute(StabConstants.SURVIVAL, 5);
		this.setAttribute(StabConstants.SWIMSKILL, 5);
		
		/* habilidades especiales
		 * Rage
		 * Fast Movement
		 * 
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