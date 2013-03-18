package com.stab.data.info.player;



import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.info.base.Character;
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
	}
	
	
	@Override
	public void rollInitiative() {
		setInitiative(Roll.d20()+getValue(StabConstants.INICIATIVEMOD));
	}
	
}
	
