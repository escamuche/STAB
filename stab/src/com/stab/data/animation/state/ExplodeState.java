package com.stab.data.animation.state;

import com.stab.data.StabInit;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.states.StateSet;
import com.tien.princess.engine.sprite.common.updaters.sound.PlaySound;
import com.tien.princess.engine.sprite.common.updaters.spawn.SpawnUpdater;

public class ExplodeState extends State {

	String spark;
	boolean reverseAngle;
	String sound;
	
	public ExplodeState(String spark){
		this(spark,false,null);
	}
	public ExplodeState(String spark,boolean reverseAngle) {
		this(spark,reverseAngle,null);
	}
	public ExplodeState(String spark,String sound) {
		this(spark,false,sound);
	}
	public ExplodeState(String spark,boolean reverseAngle,String sound) {
		this.setId("EXPLODE");
		this.spark=spark;
		setTimed(2, StateSet.DESTROYED);
		this.reverseAngle=reverseAngle;
		this.sound=sound;
		if (sound!=null)
			addUpdater(new PlaySound(sound));
		SpawnUpdater sp=new SpawnUpdater();
		sp.setEvery(-1);
		sp.setType(spark);
		sp.setFactory(StabInit.getSpriteFactory());
		sp.setReverseAngle(reverseAngle);
		addUpdater(sp);
	
	}
	
	
	
	

}
