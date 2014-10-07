package com.stab.data.adventure.everflame;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.animation.AlertAnimation;
import com.stab.data.animation.VerticalScreenShakeAnimation;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.action.ContextualAction;
import com.stab.model.action.base.WalkToAction;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.request.basic.ActionRequest;
import com.stab.util.StabUtils;

public class ClimbAction extends ContextualAction {
	
	public static final String ID="CLIMB_WAYPOINT_EVERFLAME_ACTION";

	public ClimbAction() {
		setRange(4);
		setName("Trepar");
		setResource("actions/tumble");
		setDescription("Intentar trepar hasta el punto indicado, con riesgo de tropezar y caer al vacío.");
		setTargetTokenClass(DecorToken.class);
		setLosType(IN_RANGE);
		setTargetInfoClass(ClimbWaypoint.class);
	}

	@Override
	public int execute(Info origin, Info target, Point point, ActionRequest ar) {
		// TODO Auto-generated method stub
		return super.execute(origin, target, point, ar);
	}
	
	@Override
	public int affect(Info instigator, Info target, Point point, ActionRequest ar) {

		BaseInfo character=(BaseInfo)instigator;
		ClimbWaypoint waypoint=(ClimbWaypoint)target;
		
		//Primero, triada de climb
		int dc=10;
		if (character.getParty().getBoolean("USARCUERDAS"))
			dc=dc-2;
		if (character.getParty().getBoolean("DESPACIO"))
			dc=dc-2;
		SkillRoll ck= StabUtils.getGameLogic().getSkillRoll(character,StabConstants.ACROBATICS,dc);
		ck.check();
		if (ck.success()){
			//Ir al waypoint, todo bien.
			//animacion de moverse
			sleep(character.playAnimationOn(WalkToAction.ANIMATION_ID, target.getPos()));
			character.setPos(target.getPos());
			return OK;
		}
		character.playAnimation(AlertAnimation.ID);
		sleep(300);
		//Ahora bien, si fallamos, tirada de salvacion
		SavingThrowEffect st= new SavingThrowEffect(null,StabConstants.REFLEXSAVE,character);
		st.setTargetNumber(10);
		st.check();
		if (st.success()){
			//no pasa nada, un sustito.
			//animacion de warning, return
			return OK;
		}
		//ahora viene la gracia.
		int rolled=st.getRollResult();
		//ver los distintos casos.
		int steps=1;
		// calcular los steps por los que caes dependiendo de lo que falles 1 o 2 (si fallas por mas de 5) era asi, no?
		if ((10-rolled)>5){
		 steps=2;
		}
		Point p= getFallPoint(target.getPos(),steps);
		
		sleep(character.playAnimationOn(WalkToAction.ANIMATION_ID, target.getPos()));
		character.setPos(target.getPos());
		sleep(character.playAnimation(VerticalScreenShakeAnimation.ID));
		
		
		Damage d= new RolledDamage(steps,6,Damage.IMPACT_DAMAGE,null);
		character.apply(d);
		
		return OK;
	}
	
	
	@Override
	public boolean shouldEndTurn(ActionRequest ar, boolean success) {
		return true;
	}
	
	
	
	
	
	private Point getFallPoint(Point to, int steps){
		//Buscamos el punto al que caemos cuando movemos y fallamos
		int y=to.y;
		int dest=y;
		switch(y){
			case 5:  if (steps==1)
							dest=7;
					 if (steps==2)
						 dest = 9;
					 break;
			case 7:  if (steps==1)
						dest=9;
					 if (steps==2)
						 dest=12;
					break;
		}
		
		return new Point(to.x,dest);
	}
	
	
	
	
	
	
}
