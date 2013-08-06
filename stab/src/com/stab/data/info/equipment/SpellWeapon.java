package com.stab.data.info.equipment;

import java.awt.Point;
import java.util.ArrayList;

import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.interfaces.ActionPerformedListener;
import com.stab.model.request.basic.ActionRequest;

public class SpellWeapon extends OverrideWeapon implements ActionPerformedListener {

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

	@Override
	public void actionPerformed(Info info, Action action, int result,
			ActionRequest request) {
	
		if (action instanceof SpellAction){
			
		//	this.getTarget().removeTrait(this);
		//	System.out.println("-----");
		}
		
	}

	
	
	
}
