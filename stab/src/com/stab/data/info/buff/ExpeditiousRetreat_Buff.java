package com.stab.data.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.Buff;

public class ExpeditiousRetreat_Buff extends Buff {

	public static final String ID="EXPEDITIOUSRETREAT_BUFF";
	BaseInfo self = new BaseInfo();
	int mov = 0;
	
	public ExpeditiousRetreat_Buff(BaseInfo caster) {
	
		self = caster;
		this.setAnimIcon("expeditiousretreat");				
		this.setSound("HolyCast");
		this.setResource("expeditiousretreat");                  
		this.setName("Expeditious Retreat");
		
		this.setTime(10);
		 if(caster.hasTrait(ExpeditiousRetreat_Buff.ID))
		 	{ 
		 	
		 	}
		 	else {
		 		mov = caster.getActionPoints()+6;
		 		caster.setActionPoints(mov);
		 		}
		 }
	
	@Override
	public void end() {
		self.setActionPoints(mov-6);
		super.end();
	}
	
}
