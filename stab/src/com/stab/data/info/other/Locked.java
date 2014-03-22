package com.stab.data.info.other;

import com.stab.model.basic.Sprite;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Interaction;
import com.stab.model.info.base.EffectDecoration;
import com.stab.model.info.trait.base.VisualEffect;

public class Locked extends VisualEffect implements Attends<Interaction>{

	int dc;
	
	public Locked(int dc) {
		this.dc=dc;
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
		return e;
	}
}
