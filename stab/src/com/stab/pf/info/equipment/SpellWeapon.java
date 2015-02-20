package com.stab.pf.info.equipment;

import java.awt.Point;
import java.util.ArrayList;

import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.interfaces.ActionPerformedListener;
import com.stab.model.info.trait.base.gear.OverrideWeapon;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.actions.player.spells.SpellAction;
import com.stab.pf.info.spellcasting.SpellActionEffect;

public class SpellWeapon extends OverrideWeapon implements ActionPerformedListener {

	SpellActionEffect ae;
	Weapon base;
	
	public SpellWeapon(Weapon base) {
		this.base=base;
	}

	public void addEffect(BaseInfo instigator, BaseInfo target, Point point,
			Spell spell,ActionRequest ar) {
		this.ae=new SpellActionEffect(instigator, target, point, spell,ar);
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

	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		int v= base.getEffectValue(i,target);
		if (ae!=null)
				v=v+ae.getAction().getEffectValue(i,target); //Sumar el effectType del spell que descargamos.
		v=v*3; //PAra realzar la importancia de usar el spellweapon que tenemos cargado (al fin y al cabo, para algo lo hemos casteado!)
		return v;
	}
	
}
