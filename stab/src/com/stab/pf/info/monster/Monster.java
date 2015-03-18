package com.stab.pf.info.monster;

import com.stab.common.utils.Roll;
import com.stab.model.ai.AIPackage;
import com.stab.model.basic.token.Token;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.gear.Equipment;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.trait.BasicAttributes;

public class Monster extends Creature {

	
	public static final int DEFAULT_MONSTER_FACTION=1000;

	
	@Override
	public void init() {
		super.init();
		this.setActionSet(new MonsterActionSet());
		this.setFaction(DEFAULT_MONSTER_FACTION);
		this.addTrait(new BasicAttributes());
		this.setGear(new HumanoidGear());   //si, si, ya, ya. ya lo separaremos en varias clases por tipo de monstruo
		setOverlay("border");
		setAIState(AIPackage.IDLE);
		this.setBloodeffEct("PARTICLE#damage/redblood");
	}
	
	public void postInit(){
		rollHp();
	}
	
	
	
	

	public boolean equip(String s) {
		Equipment e= PfModule.getWeaponFactory().getWeapon(s);
		if (e==null)
			e=PfModule.getArmorFactory().getArmor(s);
		if (e==null)
			e=PfModule.getEquipmentFactory().getItem(s); 
		if (e==null)
			return false;
		return super.equip(e);
	}
	
	
	private void rollHp(){
		if (StabConstants.USEMAXHPFORMONSTERS){
			int hp=getValue(StabConstants.HITDICENUMBER)*getValue(StabConstants.HITDICETYPE);
			setMaxHp(hp);
			healFully();
		}else{
			int hp=Roll.roll(getValue(StabConstants.HITDICENUMBER),getValue(StabConstants.HITDICETYPE));
			setMaxHp(hp);
			healFully();
		}
		
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
	
	
	public boolean equip(Equipment e, String slot) {
		boolean b=super.equip(e, slot);
		if (HumanoidGear.MAINHAND.equals(slot)||HumanoidGear.OFFHAND.equals(slot)||HumanoidGear.BOTHHANDS.equals(slot)||HumanoidGear.ARMOR.equals(slot))
			refreshEquippedGear();
		return b;
	}

@Override
	public void unequip(String slot) {
		super.unequip(slot);
		if (HumanoidGear.MAINHAND.equals(slot)||HumanoidGear.OFFHAND.equals(slot)||HumanoidGear.BOTHHANDS.equals(slot)||HumanoidGear.ARMOR.equals(slot))
			refreshEquippedGear();
	}


@Override
	public void initToken(Token token) {
		super.initToken(token);
		refreshEquippedGear();
		
	}

public void refreshEquippedGear(){
	if (getGear() instanceof HumanoidGear)
	if (getToken()!=null){
		String s="";
		Equipment rh=getEquipment(HumanoidGear.MAINHAND);
		if (rh instanceof Item)
			s=((Item)rh).getBaseItem();
		if (s==null)
			s="";
		getToken().setCustomProperty(HumanoidGear.MAINHAND, s);
		s="";
		Equipment lh=getEquipment(HumanoidGear.OFFHAND);
		if (lh instanceof Item)
			s=((Item)lh).getBaseItem();
		if (s==null)
			s="";
		getToken().setCustomProperty(HumanoidGear.OFFHAND, s);
		s="";
		Equipment ar=getEquipment(HumanoidGear.ARMOR);
		if (ar instanceof Item)
			s=((Item)ar).getBaseItem();
		if (s==null)
			s="";
		getToken().setCustomProperty(HumanoidGear.ARMOR, s);
	}
}
}
