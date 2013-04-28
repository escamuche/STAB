package com.stab.data.adventure.everflame;

import com.stab.data.StabInit;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.base.Decoration;

public class ClimbWaypoint extends Decoration {

	
	public static final String ID="CLIMB_WAYPOINT";
	
	@Override
	public void init() {
		super.init();
		setResource("waypoint");
		setSelectable(true);
		setDepth(10);
		//Añadir contextualAction
		ContextualOption op= new ContextualOption();
		op.setActionId(ClimbAction.ID);
		addExtra(op);
	}
	
	
	/*
	  
	  	n0.addOption("Punto de salvado C (las cuerdas)", "ROPECLIFFS.Start");
	  
		//Elementos necesarios
				StabInit.getActionLibrary().register(new ClimbAction());
				StabInit.setMapping(ClimbWaypoint.class);
	//Escena de las cuerdas
				DefaultTileMapScene ropes=new DefaultTileMapScene();
				ropes.createContents();
				ropes.createMap(16,14);
				ropes.loadTiled("cliff", 0, 0);
				ropes.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
				ropes.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				ropes.setTag("ROPECLIFFS");
				
				//Regla para hacer visibles las cuerdas si la usaron
				
				//Regla de todos los players llegan a la salida
				r2=new AllPlayersDeadRule();
				r2.addResponse(new DefeatResponse(0,"DEFEAT"));
				ropes.addRule(r2);
				this.addScene(ropes);
	  
	 */
	
}
