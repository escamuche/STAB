package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.RangerActionSet;
import com.stab.data.info.alignment.Lawful;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.combat.PointBlankShot_Feat;
import com.stab.data.info.feat.general.SkillFocusPerception_Feat;


public class RangerCharacter extends PathfinderCharacter{

	
public static final String ID="RANGER_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new RangerActionSet());
		setResource("tokenRanger");
		setText("Ranger1");
		
		this.setMaxHp(10);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 14);
		this.setAttribute(StabConstants.DEXTERITY, 17);
		this.setAttribute(StabConstants.CONSTITUTION, 12);
		this.setAttribute(StabConstants.INTELIGENCE, 10);
		this.setAttribute(StabConstants.WISDOM, 13);
		this.setAttribute(StabConstants.CHARISMA, 8);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		
		this.setAttribute(StabConstants.CLIMB, 6);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 1);
		this.setAttribute(StabConstants.KNOWLEDGENATURE, 4);
		this.setAttribute(StabConstants.PERCEPTION, 7);
		this.setAttribute(StabConstants.STEALTH, 7);
		this.setAttribute(StabConstants.SURVIVAL, 4);
		
		this.addTrait(new SkillFocusPerception_Feat());
		this.addTrait(new PointBlankShot_Feat());
		
		
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);
		this.equip(StabInit.getWeaponFactory().getWeapon("LONGBOW"), HumanoidGear.MAINHAND);
		
		this.addTrait(new Lawful());
		
		/* Habilidades especiales
		 * Favored Enemy 1				Esto, tal cual es un attends<attackDAta>. Ojo hacer un trait con parametro, para que acepte la clase
		 * Track						deja que me piense lo de las huellas, que suena interesante 
		 * Will Empathy					primero ai animal
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
