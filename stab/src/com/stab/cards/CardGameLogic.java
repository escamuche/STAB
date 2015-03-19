package com.stab.cards;

import com.stab.adventure.GameLogic;
import com.stab.model.basic.token.interfaces.Mechanism;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.OpposedSkillRoll;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.base.Creature;
import com.stab.model.info.interfaces.ActiveTurnBased;
import com.stab.pf.StabConstants;

public class CardGameLogic extends GameLogic {

	
	@Override
	public SkillRoll getSkillRoll(BaseInfo info, String skill, int dc) {
		return new TableSkillRoll(info, skill, dc);
	}
	
	@Override
	public OpposedSkillRoll getOpposedSkillRoll(BaseInfo info, String skill,
			BaseInfo target, String skill2) {
		return null;//Ya veremos
	}
	
	@Override
	public int getInitiativeFor(ActiveTurnBased t) {
		//Iniciativa agi+int. o 20 fija para objetos y efectos
		if (t instanceof Creature){
			int ini=((Creature)t).getValue(CardConstants.AGI);
			ini+=((Creature)t).getValue(CardConstants.INT);
			return ini;
		}
		return 20;
	}
	
	@Override
	public void hide(Info i, int check) {
		//Nada, puesto que ya viene hecho en setHideCheck.
	}
	
	@Override
	public boolean detectAttempt(Info origin, Info target) {
		if (!(origin instanceof BaseInfo))
			return true; //Es algun tipo de efecto especial
		if (!target.canBeDetected())
			return false;
		
		BaseInfo i=(BaseInfo)origin;
		SkillRoll sk=getSkillRoll(i, CardConstants.PERCEPTION, target.getHideCheck());
		sk.check();
		return sk.success();
	}
	
	@Override
	public int tinkerAttempt(Info instigator, Mechanism target) {
		int dc=1;
			if (!(instigator instanceof BaseInfo))
				return Applicable.OK; //Es algun tipo de efecto especial
			
			BaseInfo i=(BaseInfo)instigator;
			if (target instanceof Mechanism){
				dc=((Mechanism)target).getDifficultyCheck();
			}
			SkillRoll d= getSkillRoll(i,StabConstants.DISABLEDEVICES,dc);
			d.check();
			return d.getResult();
	}
	
	
	
}
