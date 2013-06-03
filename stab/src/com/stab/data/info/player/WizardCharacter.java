package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.WizardActionSet;
import com.stab.data.info.BonusAttributeMP;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.feat.general.CombatCasting_Feat;
import com.stab.data.info.feat.general.ImprovedInitiative_Feat;
import com.stab.data.info.feat.itemcreation.ScribeScroll_Feat;
import com.stab.model.info.trait.Modifier;


public class WizardCharacter extends PathfinderCharacter{

	
public static final String ID="WIZARD_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WizardActionSet());
		setResource("tokenWizard");
		setText("Wizard1");
		
		this.setMaxEp(10);
		this.setMaxHp(600);
		this.healFully();
		this.fillEnergy();
		
		this.setAttribute(StabConstants.STRENGHT, 10);
		this.setAttribute(StabConstants.DEXTERITY, 13);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.INTELIGENCE, 17);
		this.setAttribute(StabConstants.WISDOM, 12);
		this.setAttribute(StabConstants.CHARISMA, 8);
		
		this.setAttribute(StabConstants.WILLSAVE, 2);
		
		this.setAttribute(StabConstants.BLUFF, 7);
		this.setAttribute(StabConstants.INTIMIDATE, 7);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 5);
		this.setAttribute(StabConstants.PERCEPTION, 1);
		this.setAttribute(StabConstants.SENSEMOTIVE, 1);
		this.setAttribute(StabConstants.SPELLCRAFT, 5);
		
		this.setAttribute(StabConstants.WIZARDCASTER, 1);
		
		this.addTrait(new BonusAttributeMP(StabConstants.MAXMP, StabConstants.INTELIGENCE, getValue(StabConstants.WIZARDCASTER)));
		
		this.addTrait(new Alertness_Feat());
		this.addTrait(new CombatCasting_Feat());
		this.addTrait(new ImprovedInitiative_Feat());
		this.addTrait(new ScribeScroll_Feat());
		
		this.equip(StabInit.getWeaponFactory().getWeapon("QUARTERSTAFF"), HumanoidGear.BOTHHANDS);
		
		this.equip(EquipmentFactory.TORCH);

		this.addTrait(new Modifier(StabConstants.APPRAISE,+3)); // Familiar--> cuervo
		
		
		/*Equipment brazalete = new Equipment();
		brazalete.setSlots(HumanoidGear.BRACERS);
		brazalete.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,+4));
		this.equip(brazalete, HumanoidGear.BRACERS);*/
		
		
		//Lo del familiar.... miedo me da
		
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