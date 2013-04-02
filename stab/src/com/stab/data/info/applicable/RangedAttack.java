package com.stab.data.info.applicable;

import java.util.ArrayList;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.Modifier;

public class RangedAttack  extends Attack {

	public RangedAttack(BaseInfo instigator) {
		super(instigator);
	}
	
	
	@Override
	public void setInstigator(Info instigator) {
		super.setInstigator(instigator);
		ArrayList<Modifier>list=new ArrayList<Modifier>();
		list.addAll(((BaseInfo)instigator).getModifiers(StabConstants.TOHITRANGED));
		list.addAll(getAttackData().getModifiers());
		setModifier(Modifier.getValue(list));
	}

}
