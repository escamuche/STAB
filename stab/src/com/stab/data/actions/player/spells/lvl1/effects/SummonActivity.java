package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.common.Constants;
import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.actions.player.spells.SpellCastingActivity;
import com.stab.model.basic.token.DecorToken;

public class SummonActivity extends SpellCastingActivity {

	public SummonActivity(SpellAction action) {
		super(action);
	}

	
	
	DecorToken pointEffect;
	
	@Override
	public void startActivity() {
		super.startActivity();
		
		pointEffect=createEffectToken("PARTICLE#spells/summoning", Constants.EFFECTS);
		pointEffect.setSize(1, 1);
		getTarget().getScene().add(pointEffect);
		pointEffect.setPos(getAction().getPoint(getActionRequest()));
		//System.out.println("Position: "+pointEffect.getBounds()+" on "+pointEffect.getScene()+ " "+pointEffect.isVisible());
	}
	
	@Override
	public void cancelActivity() {
		super.cancelActivity();
		pointEffect.destroy();
	}

	@Override
	protected void finishActivity() {
		super.finishActivity();
		pointEffect.destroy();
	}
}
