package com.stab.data.info.traits;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.interfaces.Examinable;
import com.stab.model.info.trait.TargetedTrait;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.StabUtils;



public abstract class SkillCheckTrait extends TargetedTrait implements Examinable {
	
	
	
	String skill;
	int dc;
	
	
	
	public SkillCheckTrait() {
		skill=null;
		dc=0;
	}
	
	public void setSkill(String skill, int dc){
		this.skill=skill;
		this.dc=dc;
	}
	
	
	
	@Override
	public void examinedBy(Info instigator) {
		if (instigator instanceof BaseInfo){
			boolean b=true;
			if (skill!=null){
				SkillRoll r=StabUtils.getGameLogic().getSkillRoll((BaseInfo)instigator,skill,dc);
				r.check();
				b=r.success();
			}
			
			if (b){
				setActive(true);
					
				skillCheckPassed((BaseInfo)instigator,getTarget());
			}
			
		}
		
	}
	
	
	
	public void skillCheckPassed(BaseInfo instigator, Info owner){
		owner.playAnimation(VisualEffect.REVEAL_ANIMATION);
	}
	
}
