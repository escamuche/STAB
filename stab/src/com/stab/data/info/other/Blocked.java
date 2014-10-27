package com.stab.data.info.other;

import java.awt.Color;

import com.stab.model.basic.Sprite;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Interaction;
import com.stab.model.info.base.EffectDecoration;
import com.stab.model.info.trait.base.VisualEffect;

public class Blocked extends VisualEffect implements Attends<Interaction> {

  public static final String ID="BLOCKED";
	
	public Blocked() {
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
		this.getTarget().playAnimation(VisualEffect.FLOATING_TEXT_ANIMATION,"Blocked",Color.orange);
	}
	
	protected Sprite createEffectSprite() {
		EffectDecoration e=new EffectDecoration();
		e.setResource("blocked");
		e.setHidden();
		e.setHideCheck(-1); //evita que se detecte por search
	//	e.setHideCheck(5);
	
		e.setText("barriers");
		e.setDescription("An effective blockade, making it impossible to open");
		
		return e;
	}
}
