package com.stab.data.info.other;

import com.stab.annotations.Injected;
import com.stab.model.basic.token.interfaces.Interactive;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.InfoModifier;

public class HasLockInfo extends InfoModifier{

	public static final String ID="HASLOCK"	;
	
	@Injected
	int dc;
	
	@Injected
	String key;
	
	@Override
	protected boolean shouldAffect(Info i) {
		if (i instanceof Interactive)
			if (i instanceof BaseInfo)
				return true;
		return false;
	}
	
	public void setDc(int dc) {
		this.dc = dc;
	}
	
	public int getDc() {
		return dc;
	}
	
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}
	
	@Override
	protected void affect(Info i) {
	//	System.out.println("AÑADIENDO CERROJO A "+i+"  DC: "+dc);
		Locked l= new Locked(dc);
		if (getKey()!=null)
			l.setKey(getKey());
		((BaseInfo)i).addTrait(l);
		
	}
	
}
