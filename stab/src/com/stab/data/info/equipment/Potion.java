package com.stab.data.info.equipment;

import com.stab.data.animation.DrinkPotionAnimation;
import com.stab.model.info.Info;
import com.stab.model.info.trait.base.gear.Item;

public class Potion extends Item {

	
	
	public Potion() {
		setResource("items/inv_potion_a");
		setWorldResource("../effects/potion1");
		setAmount(1);
		setMaxAmount(1);
		//setDropSound("effects/dropPotion");
	}
	
	
	@Override
	public long playInventoryUseAnimation(Info user) {
		user.playSound("effects/potiondrink");
		return user.playAnimation(DrinkPotionAnimation.ID);
	}
	
}
