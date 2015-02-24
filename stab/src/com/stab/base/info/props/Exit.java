package com.stab.base.info.props;

import com.stab.annotations.Injected;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllPlayersAtZoneRule;
import com.stab.model.info.base.FloorDecoration;
import com.stab.model.info.base.Zone;

public class Exit extends Zone{

	public static final String ID="EXIT";
	
	@Injected
	String nextScene;
	
	
	public void setNextScene(String nextScene) {
		this.nextScene = nextScene;
	}
	
	@Override
	public void init() {
		super.init();
		this.setResource("decor/staircaseDown");
	}
	
	@Override
	public void enter() {
		super.enter();
		//Añadir regla
		AllPlayersAtZoneRule r=new AllPlayersAtZoneRule(this.getTag());
		r.addResponse(new VictoryResponse(0,nextScene));
		getScene().addRule(r);
		
		//Añadir decoracion
		FloorDecoration d=(FloorDecoration)getEntityManager().createElement(FloorDecoration.ID);
		d.setPos(getPos());
		d.setSize(getSize());
		d.setResource(this.getResource());
		getScene().add(d);
	}
	
}
