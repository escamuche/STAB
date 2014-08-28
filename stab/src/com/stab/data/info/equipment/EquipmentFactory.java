package com.stab.data.info.equipment;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.model.info.trait.base.gear.ItemFactory;

public class EquipmentFactory extends ItemFactory{

	
	
	public static final String TORCH="TORCH";
	
	public static final String POTION_CLW="POTION_CLW";
	
	
	public  void init(){
		
		
		Item e= new Item();
		e.setName("Torch");
		e.setSlots(HumanoidGear.OFFHAND);
		e.addTrait(new Torchlight_Buff());
		e.setWorldResource("../effects/torch");
		e.setDropSound("effects/dropWood");
		register(TORCH,e);
		
		
		Potion p= new Potion();
		p.setName("Pocion de Curacion");
		p.setWorldResource("../effects/potion2");
		p.setInventoryAction(SpellUtils.asItem(CureLight.ID, StabConstants.CLERICCASTER, 1, 1));
		register(POTION_CLW,p);
		
	}
	
}
