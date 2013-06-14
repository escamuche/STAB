package com.stab.data.animation.sprite;

import com.stab.data.animation.state.ExplodeState;
import com.tien.princess.engine.sprite.base.ProyectileSprite;
import com.tien.princess.engine.sprite.common.updaters.sound.LoopSound;
import com.tien.princess.engine.sprite.common.updaters.sound.PlaySound;

public class StabProyectile extends ProyectileSprite {

	
	public StabProyectile(float speed) {
		super(1000);
		setR(speed);
	}
	
	public void setExplosion(String s){
		ExplodeState x=new ExplodeState(s);
		setOnFade(x);
		setOnSolid(x);
		setOnReach(x,16);
	}
	public void setExplosion(String p,String s){
		ExplodeState x=new ExplodeState(p,s);
		setOnFade(x);
		setOnSolid(x);
		setOnReach(x,16);
	}
	
	public void setOnFade(String s){
		setOnFade(new ExplodeState(s));
	}
	public void setOnReach(String s,int dist){
		setOnReach(new ExplodeState(s),dist);
	}
	public void setOnFire(String s){
		setOnFire(new ExplodeState(s));
	}
	public void setOnFade(String p,String s){
		setOnFade(new ExplodeState(p,s));
	}
	public void setOnReach(String p,String s,int dist){
		setOnReach(new ExplodeState(p,s),dist);
	}
	public void setOnFire(String p,String s){
		setOnFire(new ExplodeState(p,s));
	}
	public void setOnSolid(String p,String s){
		setOnSolid(new ExplodeState(p,s));
	}
	public void setOnSolid(String s){
		setOnSolid(new ExplodeState(s));
	}

	public void setLoopSound(String s){
		this.getTravel().addUpdater(new LoopSound(s));
	}
	
	public void setPlaySound(String s){
		this.getTravel().addUpdater(new PlaySound(s));
	}
	
	
}
