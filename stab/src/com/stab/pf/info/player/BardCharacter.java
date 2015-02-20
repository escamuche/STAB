package com.stab.pf.info.player;

import com.stab.data.actions.general.DefendAction;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.BardActionSet;
import com.stab.pf.info.alignment.Chaotic;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.feat.general.SkillFocusPerformWind_Feat;
import com.stab.pf.info.player.abilities.BardicKnowledge;
import com.stab.pf.info.trait.BonusAttributeMP;


public class BardCharacter extends PathfinderCharacter{

	
public static final String ID="BARD_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new BardActionSet());
		setResource("tokenBard");
		setText("Bard1");
		
		this.setMaxHp(8);
		this.healFully();
		this.setMaxEp(10);
		this.fillEnergy();
		this.setAttribute(StabConstants.DEXTERITY, 14);
		this.setAttribute(StabConstants.CONSTITUTION, 12);
		this.setAttribute(StabConstants.CHARISMA, 17);
		this.setAttribute(StabConstants.INTELLIGENCE, 13);
		this.setAttribute(StabConstants.WISDOM, 8);
		this.setAttribute(StabConstants.REFLEXSAVE, 2);
		this.setAttribute(StabConstants.WILLSAVE, 2);
		this.setAttribute(StabConstants.BARDCASTER, 1);
		this.setAttribute(StabConstants.SPELLKNOWN1, 2);
		this.setAttribute(StabConstants.SPELLKNOWN0, 4);
		this.addTrait(new BonusAttributeMP(StabConstants.MAXMP, StabConstants.CHARISMA, getValue(StabConstants.BARDCASTER)));
		
		this.addTrait(new SkillFocusPerformWind_Feat());
		//this.addTrait(new WeaponFinesse_Feat());
		
		this.addTrait(new BardicKnowledge());
		
		this.setAttribute(StabConstants.BLUFF, 7);
		this.setAttribute(StabConstants.DIPLOMACY, 7);
		this.setAttribute(StabConstants.PERCEPTION, 5);
		this.setAttribute(StabConstants.PERFORMWIND, 9);
		this.setAttribute(StabConstants.SENSEMOTIVE, 3);
		this.setAttribute(StabConstants.SLEIGHTOFHAND, 6);
		this.setAttribute(StabConstants.STEALTH, 5);
		this.setAttribute(StabConstants.USEMAGICDEVICE, 7);
		
		this.equip(StabInit.getWeaponFactory().getWeapon("RAPIER"), HumanoidGear.BOTHHANDS);
		this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);
		
		this.addTrait(new Chaotic());
		
		/* habilidades especiales
		 * Bardic Performance			esto.... po que?
		 * Countersong					probablemente genere un aura que de un buff que attends MAgicEffect o algo asi
		 * Distraction					esto..... po cualo?
		 * Fascinate					esto..... po como
		 * Inspire Courage +1			una accion extendida (aun faltan) que cada turno ponga un buff(de 1 turno) a todos los aliados en rango
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
