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
	
	
	
	
	
	
	
	@Override
	public void examinedBy(Info instigator) {
		super.examinedBy(instigator);
		if (this.isActive()){
		//	System.out.println("Ya esta activa ");
			return; 
		}
		if (instigator instanceof BaseInfo){
			SkillRoll r=StabUtils.getGameLogic().getSkillRoll((BaseInfo)instigator,skill,dc);
			r.check();
			if (r.success()){
				setActive(true);
					
				skillCheckPassed((BaseInfo)instigator,((Token)getOwnerElement()).getInfo());
			}
			
		}
		
	}
	
	
	
	public void skillCheckPassed(BaseInfo instigator, Info owner){
		owner.playAnimation(VisualEffect.REVEAL_ANIMATION);
	}
	
}
