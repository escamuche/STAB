package com.stab.pf.info.ai;

import java.awt.Point;
import java.awt.Rectangle;

import com.stab.model.action.Action;
import com.stab.model.ai.HeatMap;
import com.stab.model.ai.traits.HeatMapAITrait;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.pf.utils.PathfinderUtils;

public class FlankAI extends HeatMapAITrait{

	
	float value=1.0f;
	
	
	public FlankAI(float val) {
		value=val;
	}
	
	
	@Override
	public void heat(HeatMap map, BaseInfo actor, Info target) {
		if (!(target instanceof BaseInfo))
			return;
		if (!actor.isEnemy(target))
			return;
		//Empezamos calentando las casillas desde las que alcanzo a este objetivo
		Rectangle r=target.getBounds();
		int i=PathfinderUtils.getReach(actor);
		Rectangle r2=target.getBounds();
		r2.grow(i, i);
		MapLogic ml=map.getMapLogic();
		for (Point p:ml.getPointsInRect(r2))
			if (map.getHeat(p)>=0)
			if (!r.contains(p)){
				if (ml.isLOS(target.getToken(), p)){
					map.heat(p, 1);
					//Comprobamos si desde aqui flanquearia a ese objetivo.
					if (PathfinderUtils.willIFlankAt((BaseInfo)target, actor, p, actor.getAIParams().getTargets())){
						map.heat(p, 10);
						//System.out.println("Flankeo!" +p);
					}
				}
			}else
				map.setHeat(p, 0);
		
		
	}
	
	@Override
	public int valorateTile(Action action, BaseInfo actor, Point p, int v) {
		int vf=0;
		vf=getHeat(p);
		vf=(int)(vf*value);
	//	System.out.println("Flank tile value: "+p+" : "+vf);
		return v+vf;
	}
	

}
