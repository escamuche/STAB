package com.stab.data.info.applicable;

import java.util.ArrayList;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.AdvancedRollApplicable;
import com.stab.model.info.trait.Modifier;

public abstract class SkillRoll extends AdvancedRollApplicable {

	String skill;
	ArrayList<Modifier> modifiers;
	
	public SkillRoll(Info instigator, String skill,int target) {
		super(instigator);
		this.skill=skill;
		modifiers=new ArrayList<Modifier>();
		setTargetNumber(target);
	}

	public void validate() {
		recalcMod();
		super.validate();
	}
	
	public String getSkill() {
		return skill;
	}
	
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	protected void recalcMod(){
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(((BaseInfo)instigator).getModifiers(getSkill()));
		list.addAll(getModifiers());
		setModifier(Modifier.getValue(list)+getModifier());
	}

	public void addModifier(Modifier m){
		modifiers.add(m);
	}

	
	public ArrayList<Modifier> getModifiers() {
		return modifiers;
	}
}
