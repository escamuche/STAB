package com.stab.data.info.extra;

import com.stab.data.info.applicable.SkillRoll;
import com.stab.model.extras.OnSelectText;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class SkillExtraText extends OnSelectText{
	
	public static final String ID="SKILLONSELECT_TEXT";

	String skill;
	int dc;
	
	

	
	@Override
	public void init() {
		super.init();
		setActive(false);
	
	}
	
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getSkill() {
		return skill;
	}
	public void setDc(int dc) {
		this.dc = dc;
	}
	public int getDc() {
		return dc;
	}
	
	
	@Override
	public void examinedBy(Info instigator) {
		super.examinedBy(instigator);
		if (this.isActive()){
		//	System.out.println("Ya esta activa ");
			return; 
		}
		if (instigator instanceof BaseInfo){
			SkillRoll r=new SkillRoll((BaseInfo)instigator,skill,dc);
			r.check();
			if (r.success())
				setActive(true);
			
		}
		
	}
	
}
