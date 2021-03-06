package com.stab.pf;

import java.util.HashSet;

import com.stab.adventure.GameLogic;
import com.stab.common.utils.Roll;
import com.stab.model.action.Action;
import com.stab.model.basic.token.interfaces.Mechanism;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.OpposedSkillRoll;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.interfaces.ActiveTurnBased;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.info.applicable.DetectRoll;
import com.stab.pf.info.applicable.SpotRoll;
import com.stab.pf.info.trait.InanimateObjectTraits;
import com.stab.pf.utils.PathfinderUtils;

public class PathfinderGameLogic extends GameLogic {

	
	HashSet<String> noUntrained;
	
	
	public PathfinderGameLogic() {
		noUntrained=new HashSet<String> ();
		noUntrained.add(StabConstants.CRAFTALCHEMY);
		noUntrained.add(StabConstants.CRAFTARMOR);
		//TODO: a�adir el resto!
	}
	
	@Override
	public void hide(Info i, int check) {
		super.hide(i, check);
		if (i instanceof BaseInfo){
			((BaseInfo)i).setAttribute(StabConstants.PERCEPTION_DC,check);
		}
	}
	
	public boolean detectAttempt(Info instigator, Info target) {
		if (!(instigator instanceof BaseInfo))
			return true; //Es algun tipo de efecto especial
		if (!target.canBeDetected())
			return false;
		
		BaseInfo i=(BaseInfo)instigator;
		
		if (target instanceof BaseInfo){
			
			BaseInfo t= (BaseInfo)target;
			DetectRoll d= new DetectRoll(i,t);
			d.check();
			return d.success();
			
		}else{
			//Dificultad fija? detectar siempre?
			
			int dc=target.getHideCheck();
			
			SpotRoll s= new SpotRoll(i,dc);
			s.check();
			
			return s.success();
		}
	}
	
	@Override
	public int tinkerAttempt(Info instigator, Mechanism target){
		int dc=10;	
		if (!(instigator instanceof BaseInfo))
			return Applicable.OK; //Es algun tipo de efecto especial
		
		BaseInfo i=(BaseInfo)instigator;
		if (target instanceof Mechanism){
			dc=((Mechanism)target).getDifficultyCheck();
		}
		SkillRoll d= getSkillRoll(i,StabConstants.DISABLEDEVICES,dc);
		d.check();
		System.out.println("disable device roll "+d.getRollResult()+" "+d.getFinalModifier()+" vs "+d.getFinalTargetNumber());
		if (!d.isBotch() && d.failed())
		if (d.getFinalTargetNumber()-5>d.getRollResult()){
			return SkillRoll.BOTCH;
		}
		
		return d.getResult();
			
	}
	
	@Override
	public Action getAttackAction(Weapon weapon) {
		return super.getAttackAction(weapon);
	}
	
	
	public SkillRoll getSkillRoll(BaseInfo info, String skill, int dc){
		SkillRoll s=super.getSkillRoll(info, skill, dc);
		if (noUntrained.contains(skill))
			if (!PathfinderUtils.hasRanks(info, skill))
				s.automaticFail();
		return s;
	}
	
	@Override
	public OpposedSkillRoll getOpposedSkillRoll(BaseInfo info, String skill,
			BaseInfo target, String skill2) {
		OpposedSkillRoll s=super.getOpposedSkillRoll(info, skill, target, skill2);
		if (noUntrained.contains(skill2))
			if (!PathfinderUtils.hasRanks(target, skill2))
				s.automaticSuccess();
	
		if (noUntrained.contains(skill))
			if (!PathfinderUtils.hasRanks(info, skill))
				s.automaticFail();
	
		return s;
	}
	
	
	//En un futuro meter aqui comprobaciones automaticas (ej: no le quedan acciones posibles, ni free actions)
	public boolean shouldEndTurn(Action action,ActionRequest ar,boolean success){
		Info actor=action.getInfo(ar);
		
	
		if (actor instanceof BaseInfo){
			BaseInfo i=(BaseInfo)actor;
			if (i.getActionPoints()==0)
				return true;
			return false;
		}
			
		return true;
	}
	
	
	@Override
	public Info initializeInfo(Info i) {
	
		if (i instanceof Obstacle)
			((Obstacle)i).addTrait(new InanimateObjectTraits());
		
		return i;
	}
	
	@Override
	public int getInitiativeFor(ActiveTurnBased t) {
		if (t instanceof BaseInfo){
			BaseInfo i=(BaseInfo)t;
			return Roll.d20()+i.getValue(StabConstants.INICIATIVEMOD);
		}
		return 20;
	}
	
}
