package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.Collection;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.AdvancedRollApplicable;
import com.stab.model.info.trait.Modifier;

public abstract class SkillRoll extends AdvancedRollApplicable {

	String skill;
	ArrayList<Modifier> modifiers;

	
	public SkillRoll(BaseInfo instigator, String skill,int target) {
		super(instigator);
		this.skill=skill;
		modifiers=new ArrayList<Modifier>();
		setTargetNumber(target);
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
		list.addAll(getModifiers(getSkill()));
		setFinalModifier(Modifier.getValue(list)+getModifier());
	}
	
	

	public void addModifier(Modifier m){
		modifiers.add(m);
	}

	
	public Collection<Modifier>getModifiers(String attr){
		/*ArrayList<Modifier> list=new ArrayList<Modifier>(); 
		for (Modifier m:modifiers)
				if (attr.equals(m.getAttribute()))
					list.add(m);
		return list;/**/
		return Modifier.getModifiers(attr,modifiers);
	}
	
	
	
	
	
}
