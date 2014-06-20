package com.stab.data.ui;

import com.stab.model.Player;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;

public class RolledSkillOptionButton extends RolledOptionButton {
	
	
	
	
	public static final String ID="ROLLEDSKILLOPTIONBUTTON_ENTITY";
	
	
	String skill;
	int dc;
	
	@Override
	public void init() {
		super.init();
		skill="";
		dc=10;
	}
	
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getSkill() {
		return skill;
	}
	public void setDC(int dc) {
		this.dc = dc;
	}
	public int getDC() {
		return dc;
	}
	
	public void setResults(String fail, String success){
		setResults(fail,fail, success,success);
	}
	public void setResults(String botch,String fail, String success,String critical){
		setResult(SkillRoll.BOTCH, botch);
		setResult(SkillRoll.FAIL, fail);
		setResult(SkillRoll.SUCCESS, success);
		setResult(SkillRoll.CRITICAL, critical);
	}
	
	
	@Override
	protected int makeRoll(Player actor) {
	
		BaseInfo roller=determineRoller(actor);
		if (roller==null)
			return SkillRoll.FAIL;
		SkillRoll sk= createRoll(roller);
		sk.check();
		return sk.getResult();
	}
	
	
	protected SkillRoll createRoll(BaseInfo actor) {
		//Sacado aqui aparte para permitir que una subclase devuelva otro skillRoll (ej: JumpSkillRoll)
		return new SkillRoll(actor, getSkill(), getDC());
	}


	protected BaseInfo determineRoller(Player actor) {
		// por ahora, el primer info que tenga el player
		try{
			return (BaseInfo)actor.getInfo().iterator().next();
		}catch(Exception e){}
		return null;
	}
	
	
}
