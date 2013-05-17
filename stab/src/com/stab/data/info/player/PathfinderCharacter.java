package com.stab.data.info.player;



import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.StabInit;
import com.stab.data.animation.HorizontalScreenShakeAnimation;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.Item;
import com.stab.model.basic.token.Token;
import com.stab.model.info.base.Character;
import com.stab.model.info.trait.base.Equipment;

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
			e=StabInit.getEquipmentFactory().getItem(s); 
		if (e==null)
			return false;
		return equip(e);
	}
	
	
	@Override
		public boolean equip(Equipment e, String slot) {
			boolean b=super.equip(e, slot);
			if (HumanoidGear.MAINHAND.equals(slot)||HumanoidGear.OFFHAND.equals(slot)||HumanoidGear.BOTHHANDS.equals(slot))
				refreshEquippedGear();
			return b;
		}
	
	
	@Override
		public void initToken(Token token) {
			super.initToken(token);
			refreshEquippedGear();
			
		}
	
	public void refreshEquippedGear(){
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
	public void receiveDamage(int amount, int type, boolean critical) {
		// TODO Auto-generated method stub
		super.receiveDamage(amount, type, critical);
		//playAnimation(HorizontalScreenShakeAnimation.ID);
	}
	
}
	
