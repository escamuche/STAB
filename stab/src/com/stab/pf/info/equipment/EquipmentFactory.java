package com.stab.pf.info.equipment;

import com.stab.model.info.trait.base.gear.Item;
import com.stab.model.info.trait.base.gear.ItemFactory;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.SpellUtils;
import com.stab.pf.actions.player.spells.cleric.level1.CureLight;
import com.stab.pf.info.buff.Torchlight_Buff;
import com.stab.pf.info.equipment.traits.FlamingWeapon;

public class EquipmentFactory extends ItemFactory{

	
	
	public static final String TORCH="TORCH";
	
	public static final String POTION_CLW="POTION_CLW";
	
	public static final String ARROW="ARROW";
	public static final String FLAMEARROW="FLAMEARROW";
	
	
	public  void init(){
		
		
		Item e= new Item();
		e.setName("Torch");
		e.setSlots(HumanoidGear.OFFHAND);
		e.addTrait(new Torchlight_Buff());
		e.setWorldResource("../effects/torch");
		e.setDropSound("effects/dropWood");
		register(TORCH,e);
		
		
		Potion p= new Potion();
		p.setName("Potion of CureLight Wounds");
		p.setWorldResource("../effects/potion2");
		p.setInventoryAction(SpellUtils.asItem(CureLight.ID, StabConstants.CLERICCASTER, 1, 1));
		register(POTION_CLW,p);
		
		
		Arrow a= new Arrow("Arrows",null,null,null,null,null,"effects/arrow");
		//a.setWorldResource("../effects/droparrows");
		register(ARROW,a);
		
		
		a= new Arrow("Fire Arrows",1,1,null,0,1,"effects/arrow");//"PARTICLE#effects/flamingStrike#arrow");
		a.addTrait(new FlamingWeapon());
		//a.setWorldResource("PARTICLE#effects/flamingStrike#../effects/droparrows");
		//a.setResource();
		register(FLAMEARROW,a);
		
	}
	
}
