package com.stab.data.actions.player.spells;

import com.stab.model.info.BaseInfo;

public interface Spell {
  
	
	public int getLevel();
	public String getAttribute();
	public int getDC(BaseInfo caster);
	public String getCasterClass();
	
}
