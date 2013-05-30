package com.stab.data.info.equipment;

import java.awt.Point;
import java.util.ArrayList;

import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.info.BaseInfo;

public class SpellWeapon extends OverrideWeapon {

	SpellActionEffect ae;
	Weapon base;
	
	public SpellWeapon(Weapon base) {
		this.base=base;
	}

	public void addEffect(BaseInfo instigator, BaseInfo target, Point point,
			String action) {
		this.ae=new SpellActionEffect(instigator, target, point, action);
	}
	
	
	public void affect(WeaponAttack app) {
		super.affect(app);
		base.affect(app);
		app.addOnDamage(ae);
	
	}

	public String getBaseItem() {
		return base.getBaseItem();
	}

	public String getId() {
		return base.getId();
	}

	public String getName() {
		return base.getName();
	}

	public ArrayList<String> getSlots() {
		return base.getSlots();
	}

	public String getSlot() {
		return base.getSlot();
	}

	public boolean isValidSlot(String s) {
		return base.isValidSlot(s);
	}

	public boolean canEquip(BaseInfo i) {
		return base.canEquip(i);
	}

	public String getText() {
		return base.getText();
	}

	
	
	
}
