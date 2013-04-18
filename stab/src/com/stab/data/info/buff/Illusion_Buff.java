package com.stab.data.info.buff;

import com.stab.data.info.applicable.Attack;
import com.stab.data.info.applicable.magic.WillAttack;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.Affects;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.trait.base.Buff;

public class Illusion_Buff extends Buff implements Affects<Attack> {

	@Override
	public void affect(Attack arg0) {
		
		BaseInfo target=getTarget();
		WillAttack d = new WillAttack(target);
		target.apply(d);
		if(d.hits()){
			
		}
		else{
			
		}
			
		
	}

	@Override
	public boolean canAffect(Applicable arg0) {
		// TODO Auto-generated method stub
		return false;
	}

}
