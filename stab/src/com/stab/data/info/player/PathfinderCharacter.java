package com.stab.data.info.player;



import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.info.debuff.condition.DyingCondition;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.traits.BasicAttributes;
import com.stab.model.basic.token.Token;
import com.stab.model.info.base.Character;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.trait.base.gear.Equipment;
import com.stab.model.info.trait.base.gear.Gear;
import com.stab.model.info.trait.base.gear.Item;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
public static final String QUICK_INVENTORY="QUICK_INVENTORY";
	
	Inventory quickInventory;
	
	@Override
	public void init() {
		super.init();
		this.addTrait(new BasicAttributes());
		this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	    this.setBloodeffEct("PARTICLE#damage/redblood");
	    this.setGear(new HumanoidGear());
	    this.setOverlay("border");
	    
	    
	    quickInventory= new Inventory();
	    quickInventory.setId(QUICK_INVENTORY);
	    addTrait(quickInventory);
	    
	    ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
	    i.setItem((Item)StabInit.getEquipment(EquipmentFactory.TORCH));
	    i.setInventory(quickInventory);
	    
	    
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
	public void setMaxEp(int maxEp) {
		setAttribute(StabConstants.MAXMP,maxEp);
		super.setMaxEp(maxEp);
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
			e=StabInit.getEquipmentFactory().getItem(s); 
		if (e==null)
			return false;
		return equip(e);
	}
	
	
	@Override
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
	
	@Override
		public void setState(int state) {
			int old = getState();
			
			super.setState(state);
			if(state==DESTROYED_STATE && old!=DESTROYED_STATE){
				this.addTrait(new DyingCondition());
			}
		}
	
	
	
	//Gestion de equip unequip
	@Override
		public void equipmentChanged(Gear gear, String slot,
				Equipment oldEquipment, Equipment newEquipment,boolean childEvent) {
			super.equipmentChanged(gear, slot, oldEquipment, newEquipment,childEvent);
		
			if (oldEquipment!=null)
			if (gear instanceof HumanoidGear)
				if (HumanoidGear.BOTHHANDS.equals(oldEquipment.getSlot()))
					if (!HumanoidGear.BOTHHANDS.equals(slot))
						return; //no hacer el drop por los unequip de main hand y off hand de un arma both hands
			if (oldEquipment instanceof Item){
				 Inventory inv=getBasicInventory();
				 if (inv.get((Item)oldEquipment)!=null){
					 ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
					 i.setItem((Item)oldEquipment);
				 	 if (inv.canAdd(i))
						 i.setInventory(inv);
					 else
						 i.setInventory(null);
				 }
			}
		}


	protected Inventory getBasicInventory() {
		return quickInventory;
	}
	
}
	
