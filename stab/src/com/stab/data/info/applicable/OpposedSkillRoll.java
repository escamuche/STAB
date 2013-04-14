package com.stab.data.info.applicable;

import java.util.ArrayList;
import java.util.Collection;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;

public class OpposedSkillRoll extends SkillRoll {

	String targetSkill;
	ArrayList<Modifier> opposedModifiers;
	
	public OpposedSkillRoll(BaseInfo instigator, String skill, BaseInfo target,String opSkill) {
		super(instigator, skill, 0);
		setTarget(target);
		setTargetSkill(opSkill);
		opposedModifiers=new ArrayList<Modifier>();
	}
	
	
	public void setTargetSkill(String opposedSkill) {
		this.targetSkill = opposedSkill;
	}
	public String getTargetSkill() {
		return targetSkill;
	}
	
	protected void recalcTarget(){
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(getTarget().getModifiers(getTargetSkill()));
		list.addAll(getModifiers(getTargetSkill()));
		setFinalTargetNumber(Modifier.getValue(list)+getTargetNumber());
	}
	
	
	public void addTargetModifier(Modifier m){
		opposedModifiers.add(m);
	}

	
	public Collection<Modifier>getTargetModifiers(String attr){
		return Modifier.getModifiers(attr,opposedModifiers);
		/*ArrayList<Modifier> list=new ArrayList<Modifier>(); 
		for (Modifier m:opposedModifiers)
				if (attr==null || attr.equals(m.getAttribute()))
					list.add(m);
		return list;/**/
	}
}
