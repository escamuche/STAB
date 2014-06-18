package com.stab.data.info.other;

import com.stab.model.action.base.TinkerAction;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.Token;
import com.stab.model.basic.token.interfaces.Mechanism;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Interaction;
import com.stab.model.info.base.EffectDecoration;
import com.stab.model.info.trait.base.VisualEffect;

public class Locked extends VisualEffect implements Attends<Interaction>,Mechanism {

	int dc;
	
	public Locked(int dc) {
		this.dc=dc;
		this.setVisible(false);
	}

	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof Interaction)
			return true;
		return false;
	}

	@Override
	public void attend(Interaction app) {
		((Info)this.getEffectSprite()).revealFor(app.getInstigator());
		app.setResult(Interaction.NEUTRALIZED);
	}
	
	
	@Override
	protected Sprite createEffectSprite() {
		EffectDecoration e=new EffectDecoration();
		e.setResource("locked");
		e.setHidden();
		e.setHideCheck(-1); //evita que se detecte por search
	//	e.setHideCheck(5);
		e.setSelectable(Token.SELECTABLE_MENU);
		e.addTag(TinkerAction.TINKER_TAG);
		e.setText("Lock");
		e.setDescription("A locking mechanism. Will either need a key, or some tinkering to get it open");
		return e;
	}

	@Override
	public boolean isValidForTinkering(Info actor) {
		return true;
	}

	@Override
	public int getTimeToTinker(Info actor) {
		return 0;
	}

	@Override
	public boolean infoTinkers(Info actor) {
		int i=actor.getGameLogic().tinkerAttempt(actor, this);
		
		return false;
	}

	@Override
	public int getDifficultyCheck() {
		return dc;
	}
	
}
