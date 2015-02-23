package com.stab.pf.info.player;

import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.DruidActionSet;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.alignment.Lawful;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.general.Toughness_Feat;
import com.stab.pf.info.player.abilities.NatureSense;
import com.stab.pf.info.trait.BonusAttributeMP;


public class DruidCharacter extends PathfinderCharacter{

	
public static final String ID="DRUID_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new DruidActionSet());
		setResource("tokenDruid");
		setText("Druid1");
		
		this.setMaxHp(8);
		this.setMaxEp(10);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 15);
		this.setAttribute(StabConstants.DEXTERITY, 10);
		this.setAttribute(StabConstants.CONSTITUTION, 16);
		this.setAttribute(StabConstants.INTELLIGENCE, 12);
		this.setAttribute(StabConstants.WISDOM, 15);
		this.setAttribute(StabConstants.CHARISMA, 6);
		
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		this.setAttribute(StabConstants.DRUIDCASTER, 2);
		
		this.setAttribute(StabConstants.CLIMB, 4);
		this.setAttribute(StabConstants.HANDLEANIMAL, 2);
		this.setAttribute(StabConstants.KNOWLEDGEGREOGRAPPHY, 5);
		this.setAttribute(StabConstants.KNOWLEDGENATURE, 3);
		this.setAttribute(StabConstants.PERCEPTION, 6);
		this.setAttribute(StabConstants.SURVIVAL, 8);
		
		this.addTrait(new BonusAttributeMP(StabConstants.MAXMP, StabConstants.WISDOM, getValue(StabConstants.DRUIDCASTER)));
		
		this.addTrait(new Toughness_Feat());
		
		this.addTrait(new NatureSense());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("SPEAR"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("HIDE"), HumanoidGear.ARMOR);
		
		this.addTrait(new Lawful());
		
		//Aqui ni comentar nada, no? :D
		/* ya va, ya va
		 * 
		 * Nature Bond
		 * Wild Empathy
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