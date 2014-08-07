package com.stab.data.info.extra;

import com.stab.model.basic.token.Token;
import com.stab.model.extras.Extra;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.StabUtils;

public class SkillCheckExtra extends Extra {
	
	
	
	String skill;
	int dc;
	
	
	
	public SkillCheckExtra() {
		skill=null;
		dc=0;
	}
	
	public void setSkill(String skill, int dc){
		this.skill=skill;
		this.dc=dc;
	}
	
	
	
	@Override
	public void examinedBy(Info instigator) {
		super.examinedBy(instigator);
		if (this.isActive()){
		//	System.out.println("Ya esta activa ");
			return; 
		}
		if (instigator instanceof BaseInfo){
			boolean b=true;
			if (skill!=null){
				SkillRoll r=StabUtils.getGameLogic().getSkillRoll((BaseInfo)instigator,skill,dc);
				r.check();
				b=r.success();
			}
			
			if (b){
				setActive(true);
					
				skillCheckPassed((BaseInfo)instigator,((Token)getOwnerElement()).getInfo());
			}
			
		}
		
	}
	
	
	
	public void skillCheckPassed(BaseInfo instigator, Info owner){
		owner.playAnimation(VisualEffect.REVEAL_ANIMATION);
	}
	
}
