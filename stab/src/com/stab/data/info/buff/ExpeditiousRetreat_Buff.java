package com.stab.data.info.buff;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Buff;

public class ExpeditiousRetreat_Buff extends Buff {

	public static final String ID="EXPEDITIOUSRETREAT_BUFF";
	BaseInfo self = new BaseInfo();
	Creature c = (Creature) self;
	int mov = 0;
	
	public ExpeditiousRetreat_Buff() {
	
		
		this.setAnimIcon("expeditiousretreat");				
		this.setSound("HolyCast");
		this.setResource("expeditiousretreat");                  
		this.setName("Expeditious Retreat");
		
		 if(self.hasTrait(ExpeditiousRetreat_Buff.ID))
		 	{ 
		 	
		 	}
		 	else {
		 		mov = c.getMovePoints()+6;
		 		c.setMovePoints(mov);
		 		}
		 }
	
	@Override
	public void end() {
		c.setMovePoints(mov-6);
		super.end();
	}
	
}
