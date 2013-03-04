package com.stab.data.actions.monster;

import com.stab.data.actions.player.Kill;
import com.stab.model.info.BaseInfo;

public class ZombieClawAction extends Kill {
	
	public static final String ID="ZOMBIECLAW_ATTACK";
	
	protected String getSwingImage(BaseInfo atacante) {
		return "effects/zombieclaw";
	}

}
