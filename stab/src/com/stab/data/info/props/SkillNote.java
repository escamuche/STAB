package com.stab.data.info.props;

import com.stab.model.Injected;
import com.stab.model.basic.token.Token;
import com.stab.model.extras.OnSelectText;
import com.stab.model.info.base.Note;

public class SkillNote extends Note {

	public static final String ID="SKILLNOTE";
	
	
	@Injected
	String skill;
	
	@Injected
	int dc;
	
	
	@Override
	public void init() {
		super.init();
		setSelectable(Token.NOT_SELECTABLE);
	}
	
	protected OnSelectText createExtra() {
		SkillExtraText textExtra=new SkillExtraText();
		return textExtra;		
	}
	
	
	public void setSkill(String skill) {
		this.skill = skill;
		((SkillExtraText)getTextExtra()).setSkill(skill);
	}
	
	public void setDc(int dc) {
		this.dc = dc;
		((SkillExtraText)getTextExtra()).setDc(dc);
	}
	
}
