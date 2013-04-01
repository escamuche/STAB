package com.stab.data.info.player;



import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Character;
import com.stab.model.info.trait.Trait;
import com.stab.model.info.trait.base.Equipment;
import com.stab.util.Roll;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
	
	
	@Override
	public void init() {
		super.init();
		this.addTrait(new BasicAttributes());
		this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	    this.setBloodeffEct("PARTICLE#redblood");
	    this.setGear(new HumanoidGear());
	    this.setOverlay("border");
	}
	
	
	@Override
	public void rollInitiative() {
		setInitiative(Roll.d20()+getValue(StabConstants.INICIATIVEMOD));
	}
	
	@Override
	public void setMaxHp(int maxHp) {
		setAttribute(StabConstants.MAXHP,maxHp);
		super.setMaxHp(maxHp);
	}
	
	@Override
	public int getMaxHp() {
		return getValue(StabConstants.MAXHP);
	}
	
	@Override
	public void setMaxEp(int maxHp) {
		setAttribute(StabConstants.MAXMP,maxHp);
		super.setMaxHp(maxHp);
	}
	
	@Override
	public int getMaxEp() {
		return getValue(StabConstants.MAXMP);
	}
	
	
	
	
	
	public boolean equip(String s) {
		Equipment e= StabInit.getWeaponFactory().getWeapon(s);
		if (e==null)
			e=StabInit.getArmorFactory().getArmor(s);
		if (e==null)
			e=StabInit.getEquipmentFactory().getEquipment(s); 
		if (e==null)
			return false;
		return super.equip(e);
	}
	
	
	
	@Override
	public void turnStarts() {
			super.turnStarts();
			refreshCA();
	}
	
	@Override
	
	public void turnEnds() {
		super.turnEnds();
		refreshCA();
	}
	
	
	public void refreshCA(){
			if (this.getToken()!=null)
				this.getToken().setCustomProperty(StabConstants.AC, getValue(StabConstants.AC));
	}
	
}
	
