package com.stab.pf.info.player;



import com.stab.common.utils.Roll;
import com.stab.model.basic.token.Token;
import com.stab.model.info.base.Character;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.trait.base.gear.Equipment;
import com.stab.model.info.trait.base.gear.Gear;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.debuff.condition.DyingCondition;
import com.stab.pf.info.equipment.EquipmentFactory;
import com.stab.pf.info.equipment.HumanoidGear;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.trait.BasicAttributes;

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
	    
	    
	    addToInventory(EquipmentFactory.TORCH);
	    addToInventory(WeaponFactory.DAGGER);
	    addToInventory(EquipmentFactory.POTION_CLW);
	    
	}
	
	
	public void addToInventory(String id){
		ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
	    i.setItem((Item)PfModule.getEquipment(id));
	    i.setInventory(quickInventory);
	}
	public void addToInventory(Item it){
		ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
	    i.setItem(it);
	    i.setInventory(quickInventory);
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
		Equipment e= PfModule.getWeaponFactory().getWeapon(s);
		if (e==null)
			e=PfModule.getArmorFactory().getArmor(s);
		if (e==null)
			e=PfModule.getEquipmentFactory().getItem(s); 
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
	
	
	@Override
		public void setMovePoints(int moves) {
			super.setMovePoints(moves);
			setCustomString(StabConstants.MOVEMENTS,moves);
		}
	
	public void refreshCA(){
			if (this.getToken()!=null)
				this.getToken().setCustomProperty(StabConstants.AC, getValue(StabConstants.AC));
	}
	
	public void setCustomString(String id){
		if (this.getToken()!=null){
			this.getToken().setCustomProperty(id, getValue(id));
			this.getToken().setVisible(getToken().isVisible());//�apa para forzar a que refresque las tokencards
		}
	}
	public void setCustomString(String id,Object val){
		if (this.getToken()!=null){
			this.getToken().setCustomProperty(id,val.toString());
			this.getToken().setVisible(getToken().isVisible());//�apa para forzar a que refresque las tokencards
		}
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
			
	
		}


	public Inventory getBasicInventory() {
		return quickInventory;
	}

	@Override
		public void purgeItems() {
			super.purgeItems();
			this.getBasicInventory().purge();
		}
	
}
	
