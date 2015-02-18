package com.stab.data.info.props;

import com.stab.annotations.Injected;
import com.stab.model.Element;
import com.stab.model.info.Info;
import com.stab.model.info.base.FloorDecoration;

public class DormantInfo extends FloorDecoration{
	
	public static final String ID="DORMANT";
	
	
	
	@Injected
	String info;
	
	@Injected
	String spawnAnimation;
	
	@Override
	public void init() {
		super.init();
		info=null;
		spawnAnimation=null;
	}
	
	public void setSpawnAnimation(String spawnAnimation) {
		this.spawnAnimation = spawnAnimation;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}

	
	public void wakeup(){
		if (spawnAnimation!=null)
			this.playAnimation(spawnAnimation);
		if (info!=null){
			Element e=this.getScene().createElement(info);
			if (e instanceof Info){
				Info i=(Info)e;
				i.setPos(this.getPos());
				i.setSize(this.getSize());
				i.setAngle(this.getAngle());
				i.setFaction(this.getFaction());
			}
			if (e!=null)
				this.getScene().add(e);
		}
		destroy();
	}
	
}
