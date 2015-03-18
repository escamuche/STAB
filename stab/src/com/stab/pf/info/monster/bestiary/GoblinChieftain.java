package com.stab.pf.info.monster.bestiary;

import com.stab.model.ai.actions.orders.Commander;
import com.stab.model.ai.actions.orders.base.FocusOnTargetOrderAction;
import com.stab.model.ai.traits.Agressor;
import com.stab.model.ai.traits.DefaultCommanderAI;
import com.stab.model.ai.traits.DistanceMapAI;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.ai.FlankAI;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;

public class GoblinChieftain extends Goblin implements Commander{

	public static final String ID="GOBLIN_CHIEFTAIN_INFO";
	
	
	public GoblinChieftain() {
	
		
		setResource("goblinChief");
		setText("Goblin Chieftain");
		setDescription("This goblin seems to be taller and stronger than the rest");
		
		this.setAttribute(StabConstants.HITDICENUMBER, 2);
		this.setAttribute(StabConstants.STRENGHT,14);
		this.setAttribute(StabConstants.DEXTERITY,15);
		this.setAttribute(StabConstants.INTELLIGENCE,14);
		this.setAttribute(StabConstants.CONSTITUTION,14);
		
		this.equip(PfModule.getWeaponFactory().getWeapon(WeaponFactory.SHORTSWORD), HumanoidGear.MAINHAND);
		this.equip(PfModule.getArmorFactory().getArmor(ArmorFactory.CHAINSHIRT), HumanoidGear.ARMOR);
		this.equip(PfModule.getArmorFactory().getArmor(ArmorFactory.LIGHTSTEELSHIELD), HumanoidGear.OFFHAND);
		
		
		this.addTrait(new Agressor());
		this.addTrait(new FlankAI(1.0f));
		this.addTrait(new DistanceMapAI());
		this.addTrait(new DefaultCommanderAI());
		
		this.getActionSet().addAction(FocusOnTargetOrderAction.ID);
	
		getAIParams().setLog(true);
		
		
	//	((BaseSpeech)getSpeech()).loadFrom(Resources.INSTANCE.getStream("/txt/speech/goblin.txt"));
		
	}


	@Override
	public int getOrderCooldown() {
	 return 2;
	}
}

