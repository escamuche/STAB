package com.stab.data.info.player;

import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.player.WarriorActionSet;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.Weapon;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.equipment.traits.FlamingWeapon;
import com.stab.data.info.feat.combat.Expertise_Feat;
import com.stab.data.info.feat.combat.PowerAttack_Feat;
import com.stab.model.info.trait.Modifier;


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
		
		Weapon w=StabInit.getWeaponFactory().getWeapon("LONGSWORD");
		w.addTrait(new FlamingWeapon());
	//	this.equip(w, HumanoidGear.MAINHAND);
		
		this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.SHORTSWORD));
		this.equip(EquipmentFactory.TORCH);
				
		
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
	
