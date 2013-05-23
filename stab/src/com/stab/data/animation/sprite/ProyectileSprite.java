package com.stab.data.animation.sprite;

import com.tien.princess.engine.sprite.StateSprite;
import com.tien.princess.engine.sprite.common.states.BasicAnimState;
import com.tien.princess.engine.sprite.common.states.State;
import com.tien.princess.engine.sprite.common.updaters.misc.CheckSolid;
import com.tien.princess.engine.sprite.common.updaters.misc.Reach;
import com.tien.princess.engine.sprite.common.updaters.move.Move;

public class ProyectileSprite extends StateSprite {

	

	
	private static final String PRIME = "PRIME";
	private static final String FIRE = "FIRE";
	private static final String FADE = "FADE";
	private static final String TRAVEL = "TRAVEL";
	private static final String SOLID = "SOLID";
	private static final String REACH = "REACH";
	
	
	State travel;
	
	public ProyectileSprite(long timecap) {

		travel=new BasicAnimState(timecap);
		travel.addUpdater(new Move());
		setTravel(travel);
		BasicAnimState prime=new BasicAnimState(2);
		prime.setTimed(2, FIRE);
		prime.setId(PRIME);
		addState(prime);
		BasicAnimState fire=new BasicAnimState(2);
		fire.setTimed(2, TRAVEL);
		fire.setId(FIRE);
		addState(fire);
		BasicAnimState fade=new BasicAnimState(2);
		fade.setId(FADE);
		addState(fade);
		setState(PRIME);
	}
	
	public void setTravel(State st){
		st.setId(TRAVEL);
		this.addState(st.getId(), st);
		travel.setTimed(st.getTimed(), FADE);
		travel=st;
	}
	

	public void setOnReach(State st,int dist){
		st.setId(REACH);
		this.addState(st.getId(), st);
		travel.addUpdater(new Reach(st.getId(),dist));
	}
	public void setOnFire(State st){
		st.setId(FIRE);
		this.addState(st.getId(), st);
		st.setTimed(2, TRAVEL);
	}
	public void setOnSolid(State st){
		st.setId(SOLID);
		this.addState(st.getId(), st);
		travel.addUpdater(new CheckSolid(st.getId()));
	}
	public void setOnFade(State st){
		st.setId(FADE);
		this.addState(st.getId(), st);
	}
	
}
