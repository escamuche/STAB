package com.stab.pf.info.player;

import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.actions.WarriorActionSet;
import com.stab.pf.actions.feats.Expertise;
import com.stab.pf.actions.feats.PowerAttack;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.feat.combat.Expertise_Feat;
import com.stab.pf.info.feat.combat.PowerAttack_Feat;


public class WarriorCharacter extends PathfinderCharacter{

	
public static final String ID="WARRIOR_INFO";
	
	
	@Override
	public void init() {
		super.init();
		setActionSet(new WarriorActionSet());
		setResource("tokenWarrior");
		setText("Warrior1");
		
		this.setMaxHp(10);
		this.healFully();
		this.fillEnergy();
		this.setAttribute(StabConstants.TOHIT,1);
		this.setAttribute(StabConstants.TOHITRANGED,1);
		this.setAttribute(StabConstants.DEXTERITY, 12);
		this.setAttribute(StabConstants.STRENGHT, 16);
		this.setAttribute(StabConstants.CONSTITUTION, 14);
		this.setAttribute(StabConstants.CHARISMA, 8);
		this.setAttribute(StabConstants.FORTITUDESAVE, 2);
		
		this.addTrait(new Modifier(StabConstants.ARMORDEFENSE,StabConstants.ARMORMOD,4));
		this.addTrait(new Modifier(StabConstants.SHIELDDEFENSE,StabConstants.SHIELDMOD,2));
		
		this.addTrait(new Expertise_Feat());
		this.getActionSet().setAction(Expertise.ID, 17);
		
		this.addTrait(new PowerAttack_Feat());
		this.getActionSet().setAction(PowerAttack.ID, 16);
		
		
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.SHORTSWORD));
		
		//this.equip(EquipmentFactory.TORCH);
				
		//hay que ponerle algo de equipo
		
		//ehum.... warrior se jubila entonces. pobre. nunca fue el mismo despues de perder sus poderes destructores de dummys
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
	
