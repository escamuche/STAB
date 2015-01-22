package com.stab.data.info.props;

import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.ListensTo;
import com.stab.model.info.applicable.base.Damage;

public class BreakableColumn extends Column {
	
	public static final String ID="BREAKABLE_COLUMN";
	
	@Override
	public void init() {
		super.init();
		setInvulnerable(false);
		setSelectable(Token.SELECTABLE);
		setMaxHp(80);
		setDestroyedResource("props/1x1BrokenColumn");
		//TODO: añadir damage reduction o algo, o por material
	}
	
	String[] debris={"decor/2x2Debris"};
	
	@Override
	protected void onDeath() {
		
		
		
		super.onDeath();
	}
	

}
