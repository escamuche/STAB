package com.stab.data.info.buff.spells;

import com.stab.data.info.buff.Torchlight_Buff;
import com.stab.model.info.BaseInfo;

public class Light_Buff extends Torchlight_Buff{

	LightInUse inUseTrait = null;
	
	public LightInUse getInUseTrait() {
		return inUseTrait;
	}
	
	public void setInUseTrait(LightInUse inUseTrait) {
		this.inUseTrait = inUseTrait;
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		if(inUseTrait!=null)
			inUseTrait=null;
		super.removeFrom(baseInfo);
	}
	
	
}
