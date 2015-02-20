package com.stab.data.info.props;

import java.awt.Color;

import com.stab.model.info.Info;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.pf.StabConstants;
import com.stab.pf.StabInit;
import com.stab.pf.info.equipment.EquipmentFactory;

public class TreasureChest extends Chest {

	public static final String ID="CHEST";
	
	
	int gold;
	
	@Override
	public void init() {
		super.init();
		setGold(100);
		addLoot((Item)StabInit.getEquipment(EquipmentFactory.POTION_CLW));
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getGold() {
		return gold;
	}
	
	
	
	@Override
	protected void openChest(Info actor) {
		super.openChest(actor);
		if (gold>0)
			if (actor instanceof PlayerOwned){
				actor.showFloatingText(gold+"g", Color.yellow);
				getParty().set(StabConstants.GOLD, getParty().getInteger(StabConstants.GOLD)+gold);
			}
		gold=0;
	}
	
}
