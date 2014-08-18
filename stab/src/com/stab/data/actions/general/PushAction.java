package com.stab.data.actions.general;

import java.awt.Point;

import com.stab.common.utils.PathUtils;
import com.stab.data.info.other.PushActivity;
import com.stab.data.info.other.Pushable;
import com.stab.model.action.Action;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.base.activity.Activity;
import com.stab.model.request.basic.ActionRequest;

public class PushAction extends Action {
	
	public static final String ID="PUSH";
	
	
	public PushAction() {
		setTargetMode(TARGET);
		this.setName("Push");
		this.setForEveryone(true);
		this.setRange(ADYACENT);
		setUsableByAI(false);
		setAPCost(1);
	}
	
	
	@Override
	public void execute(ActionRequest ar) {
		// TODO Auto-generated method stub
		super.execute(ar);
	}
	
	@Override
	public Class getActivityClass() {
		return PushActivity.class;
	}
	
	@Override
	public Activity createActivity(ActionRequest ar) {
		int dc=0;
		BaseInfo target=(BaseInfo)getTarget(ar);
		Pushable p=(Pushable)target.getTrait(Pushable.class);
		PushActivity pa= new PushActivity(p.getDc(),getTarget(ar));
		return pa;
	}

	@Override
	public int affect(Info instigator, Info target, Point point,
			ActionRequest ar) {
		Point p=instigator.getPos();
		Point t=target.getPos();
		char c=PathUtils.getDirection2(p, t);
		double[] dir=PathUtils.getDirStep(c);
		Point tp=new Point((int)(t.x+dir[0]),(int)(t.y+dir[1]));
		
		MapLogic ml=getMapLogic(instigator);
		if (!ml.isWalkable(instigator.getToken(),tp.x,tp.y)){
			sleep(instigator.playAnimationOn(WalkToAction.BUMP_ANIMATION_ID, tp));
			return FAIL;
		}else{
			target.playAnimationOn(WalkToAction.ANIMATION_ID, tp);
			instigator.playAnimationOn(WalkToAction.ANIMATION_ID, t);
			sleep(300);
			target.setPos(tp);
			instigator.setPos(t);
		}
		//System.out.println("Successfully push");
		return OK;
	}

}
