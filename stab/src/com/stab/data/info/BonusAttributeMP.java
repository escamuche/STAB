package com.stab.data.info;

import com.stab.model.info.trait.AttributeBasedModifier;


public class BonusAttributeMP extends AttributeBasedModifier {
	
	int nivel;
	
	public BonusAttributeMP(String target, String from, int level){
		super(target,from,false);
		this.nivel=level;
	}

	@Override
	protected int getBonusFrom(int attribute) {
		int bono=0;
		if (attribute>=10)
			attribute= (attribute-10)/2;
		else
			return 0;
		while( attribute >=  nivel ){
			bono = bono+(5*nivel)+5;
			attribute = attribute -5;
		}
		return bono;
	}

}