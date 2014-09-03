package com.stab.data.ui;

import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;

import org.newdawn.slick.Color;

import com.stab.client.slick.BasicActionsController;
import com.stab.common.Constants;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.pickup.Inventory;
import com.stab.model.info.base.pickup.ItemPickup;
import com.stab.model.info.interfaces.EquipmentListener;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.model.info.trait.base.gear.Equipment;
import com.stab.model.info.trait.base.gear.Gear;
import com.stab.model.info.trait.base.gear.Item;
import com.stab.model.info.trait.base.gear.OverrideWeapon;


public class PlayerInventoryPanel extends InventoryPanel implements EquipmentListener {

	BaseInfo info;
	Panel pact;
	Button drop;
	Button equip;
	Button use;
	
	Panel gear;
	Hashtable<String,Button> gearButtons;
	
	@Override
	public void init() {
		super.init();
		setSize(480,512);
		setPos(Constants.END,60);
		setMargins(6,5);
		setOpenAction(BasicActionsController.INVENTORY);
		createGear();
		pact= new Panel();
		pact.setSize(Constants.FILL,65);
		pact.setPos(Constants.BEGIN,512-65-4);
		pact.setMargins(8,5);
		pact.setGap(2, 5);
		pact.setLayout("default");
		pact.setBackground("ui/nanoborder$X");
		pact.setOrder(4);
		addChild(pact);
		createButtons();
	}
	protected void createGear() {
		gear= new Panel();
		gear.setOrder(2);
		getInnerPanel().setOrder(3);
		
		gear.setSize(Constants.FILL,256);
		gear.setPos(Constants.BEGIN,Constants.NEXT);
		gear.setMargins(8,5);
		gear.setGap(2, 5);
		gear.setLayout("default");
		gear.setBackground("ui/gear");
		gear.setOverlay("ui/nanoborder$B");
		addChild(gear);		
		gearButtons=new Hashtable<String, Button>();
		createGearButton(HumanoidGear.HEAD,210,17);
		createGearButton(HumanoidGear.CLOAK,263,25);
		createGearButton(HumanoidGear.NECK,157,25);
		createGearButton(HumanoidGear.BRACERS,105,68);
		createGearButton(HumanoidGear.AMMO,325,68);
		createGearButton(HumanoidGear.MAINHAND,271,117);
		createGearButton(HumanoidGear.OFFHAND,152,115);
		createGearButton(HumanoidGear.ARMOR,210,63);
		createGearButton(HumanoidGear.BELT,210,112);
		createGearButton(HumanoidGear.BOOTS,210,186);
		createGearButton(HumanoidGear.RIGHTRING,305,159);
		createGearButton(HumanoidGear.LEFTRING,120,157);
	}
	
	protected Button createGearButton(String slot,int x,int y){
		Button b= new Button();
		b.setSize(40, 40);
		b.setPos(x,y);
		b.addButtonListener(this);
		b.setAction("SLOT"+slot);
		b.setActOnScene(false);
		b.setText("");
		b.setDisabled(true);
		b.setMode(Label.BANNER);
		b.setTooltip(slot);
		b.setMargin(2);
		gear.addChild(b);
		gearButtons.put(slot,b);
		b.setBackground("tokens/blank");
		b.setOverlay("ui/nanoborder$B");
		map.put(slot, b);	

		map2.put(b, slot);
		return b;
	}
	
	public void createButtons(){
		drop= new Button();
		drop.setSize(145, 45);
		drop.setPos(Constants.NEXT,Constants.PREVIOUS);
		drop.addButtonListener(this);
		drop.setAction("DROP");
		drop.setActOnScene(false);
		drop.setText("DROP");
		drop.setDisabled(true);
		drop.setMode(Label.BANNER);
		pact.addChild(drop);
		
		equip= new Button();
		equip.setSize(145, 45);
		equip.setPos(Constants.NEXT,Constants.PREVIOUS);
		equip.addButtonListener(this);
		equip.setAction("EQUIP");
		equip.setActOnScene(false);
		equip.setText("EQUIP");
		equip.setDisabled(true);
		equip.setMode(Label.BANNER);
		pact.addChild(equip);
		
		use= new Button();
		use.setSize(145, 45);
		use.setPos(Constants.NEXT,Constants.PREVIOUS);
		use.addButtonListener(this);
		use.setAction("USE");
		use.setActOnScene(false);
		use.setText("USE");
		use.setDisabled(true);
		use.setMode(Label.BANNER);
		pact.addChild(use);
	}
	public void setInfo(BaseInfo info) {
		this.info = info;
		this.setPlayerRestricted(((PlayerOwned)info).getOwner());
		Inventory i=(Inventory)info.getTrait(Inventory.class);
		this.setInventory(i);
		refresh();
		refreshGear();
		((Creature)info).getGear().addListener(this);
	}
	
	public BaseInfo getInfo() {
		return info;
	}
	
	@Override
	public void setSelected(Object o) {
		super.setSelected(o);
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null){
				boolean b=getInventory().canRemove((ItemPickup)getSelected());
				
				drop.setDisabled(!b);
			}
		}else{
			if (o instanceof String){
				drop.setDisabled(!(getItem((String)o)!=null));
					
			}else
				drop.setDisabled(true);
		}
		
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null){
				boolean b=(getInventory().canRemove((ItemPickup)getSelected()));
				b=b& ((((ItemPickup)getSelected()).getItem().getSlot()!=null));
				equip.setDisabled(!b);
				equip.setText("EQUIP");
			}
		}else{
			if (o instanceof String){
				equip.setDisabled(false);
				equip.setText("UNEQUIP");	
			}else
				equip.setDisabled(true);
		}
		
		if (getSelected() instanceof ItemPickup){
			if (getInventory()!=null)
				use.setDisabled(!((ItemPickup)getSelected()).canBeUsedFromInventory(getInventory()));
		}else{
			use.setDisabled(true);
		}
	}
	
	protected Equipment getItem(String o) {
		if (!(getInfo() instanceof Creature))
			return null;
		Equipment e=((Creature)getInfo()).getGear().getEquipment(o);
		return e;
	}
	@Override
	public void buttonActivated(Player p, Button b) {
		if (b==drop){
			dropSelected();
			return;
		}
		if (b==equip){
			equipSelected();
			return;
		}
		if (b==use){
			useSelected();
		}
		super.buttonActivated(p, b);
	}
	

	protected void useSelected() {
		
		//TODO: en un futuro, retirar el interfaz Usable e incorporarlo a los items, que decidiran en base a si tienen un trait de usable o no
		if (getSelected() instanceof ItemPickup){
			((ItemPickup)getSelected()).use(getInventory(), getInfo());
		}
	}

	protected void equipSelected() {

		if (getSelected() instanceof ItemPickup){
			
			//Primero desequipar lo que este equipado en ese slot...
			Item newItem=((ItemPickup)getSelected()).getItem();
			if (newItem.getSlot()==null)
				return;
			//ahora viene la parte interesante... pueden ser varios slots si es bothhands
			Hashtable<Equipment,String> toremove=new Hashtable<Equipment,String>();
			if (HumanoidGear.BOTHHANDS.equals(newItem.getSlot())){
				Equipment e=getItem(HumanoidGear.MAINHAND);
				if (e!=null)
					toremove.put(e,HumanoidGear.MAINHAND);
				e=getItem(HumanoidGear.OFFHAND);
				if (e!=null)
					toremove.put(e,HumanoidGear.OFFHAND);
				e=getItem(HumanoidGear.BOTHHANDS);
				if (e!=null)
					toremove.put(e,HumanoidGear.BOTHHANDS);
			}else{
				Equipment e=getItem(newItem.getSlot());
				if (e!=null)
					toremove.put(e,newItem.getSlot());
			}
			for (Equipment e:toremove.keySet()){
				if (!canUnequip(e))
					return;
			}
			for (Equipment e:toremove.keySet()){
				
				((Creature)this.getInfo()).unequip(toremove.get(e));
				//crear un itempickup y decidir si podemos guardarlo o se arroja al suelo
				 ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
				 i.setItem((Item)e);
			 	 if (getInventory().canAdd(i))
					 i.setInventory(getInventory());
				 else
					 i.setInventory(null);
				
			}	
			
	
			
			boolean b=((Creature)this.getInfo()).equip(newItem);
			if (b){
				((ItemPickup)getSelected()).destroy();
				getInfo().playSound("effects/equip");
				//this.refresh();
			}
		}else
		if (getSelected() instanceof String){
			Equipment e=getItem((String)getSelected());
			if (e==null)
				return;
			String slot=e.getSlot();
			((Creature)this.getInfo()).unequip(slot);
			//crear un itempickup y decidir si podemos guardarlo o se arroja al suelo
			 ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
			 i.setItem((Item)e);
		 	 if (getInventory().canAdd(i))
				 i.setInventory(getInventory());
			 else
				 i.setInventory(null);
		}
	}
	
	public void dropSelected(){
		if (getSelected() instanceof String){
			Equipment e=getItem((String)getSelected());
			if (e==null)
				return;
			if (!canUnequip(e))
				return;
			String slot=e.getSlot();
			
			((Creature)this.getInfo()).unequip(slot);
			
			//crear un itempickup y decidir si podemos guardarlo o se arroja al suelo
			 ItemPickup i=(ItemPickup)getEntityManager().createElement(ItemPickup.ID);
			 i.setItem((Item)e);
		 	 i.setInventory(null);
		}else
			super.dropSelected();
	}
	
	
	public boolean canUnequip(Equipment e){
		if (e instanceof OverrideWeapon)
			return false;
		return true;
	}
	
	public void refreshGear(){
		for (String s:((Creature)getInfo()).getGear().getSlots()){
		//	System.out.println("SLOT "+s+" "+map.get(s));
			if (map.containsKey(s)){
				Button b=map.get(s);
				
				Equipment e=((Creature)getInfo()).getGear().getEquipment(s);
				if (e==null){
					b.setDisabled(true);
					b.setImage("tokens/blank");
				}else{
					b.setDisabled(false);
					b.setImage("FOUR#cyan#"+e.getResource()+"$S");
					b.setColor(Color.white);
					if (e instanceof Item)
					if (((Item)e).getMaxAmount()>0)
						b.setText(""+((Item)e).getAmount());
					else
						b.setText("");
				}
			}
		}
	}
	@Override
	public void equipmentChanged(Gear gear, String slot,
			Equipment oldEquipment, Equipment newEquipment, boolean childEvent) {
		refreshGear();
	}
	
	
	protected boolean shouldRemove(Collection list, Object o) {
		if (o instanceof String)
			return false;
		return super.shouldRemove(list, o);
	}
	
	
	
	
	
}
