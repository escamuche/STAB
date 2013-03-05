package com.stab.data.info.player;



import com.stab.data.info.BasicAttributes;
import com.stab.model.info.base.Character;

public class PathfinderCharacter extends Character {
	
public static final String ID="PATH_INFO";
	
	
	@Override
	public void init() {
		super.init();
		this.addTrait(new BasicAttributes());
		this.setMaxMovePoints(6);
	    this.setMaxActionPoints(1);
	}
}
	
