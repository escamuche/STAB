package com.stab.base.info.other;

import java.awt.Color;

import com.stab.model.basic.Sprite;
import com.stab.model.basic.token.interfaces.Mechanism;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.applicable.base.Interaction;
import com.stab.model.info.base.EffectDecoration;
import com.stab.model.info.base.MechanismDecoration;
import com.stab.model.info.trait.base.KeyTrait;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.activity.Activity;
import com.stab.model.request.basic.ActionRequest;

public class Locked extends VisualEffect implements Attends<Interaction>,Mechanism {

	int dc;
	String key;
	
	public Locked(int dc) {
		this.dc=dc;
		this.setVisible(false);
		key=null;
	}
	
	
	public void setKey(String key) {
		this.key = key;
	}
	public String getKey() {
		return key;
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
	
		if (getKey()!=null){
			//Buscamos los traits de key en el instigator
			boolean found=false;
			if (app.getInstigator() instanceof BaseInfo)
			for (KeyTrait k:((BaseInfo)app.getInstigator()).getTraits(KeyTrait.class))
				if (k.opens(getKey()))
					found=true;
			
			if (found){
				this.getTarget().playAnimation(VisualEffect.FLOATING_TEXT_ANIMATION,"Unlocked",Color.green);
				((EffectDecoration)this.getEffectSprite()).setResource("animations/openLock&0");
				this.getEffectSprite().playAnimation(VisualEffect.ANIMATED_ICON_ANIMATION,1000,0,3,1000,true,false);
				this.getEffectSprite().playAnimation(VisualEffect.WAIT_ANIMATION,1000);
				try{Thread.sleep(1000);}catch(Exception e){}
				this.end();
				return;
			}
			
		}
		
		app.setResult(Interaction.NEUTRALIZED);
		this.getTarget().playAnimation(VisualEffect.FLOATING_TEXT_ANIMATION,"Locked",Color.orange);
	}
	
	
	@Override
	protected Sprite createEffectSprite() {
		MechanismDecoration e=new MechanismDecoration();
		e.setResource("locked");
		e.setHidden();
		e.setHideCheck(-1); //evita que se detecte por search
	//	e.setHideCheck(5);
	
		e.setText("Lock");
		e.setDescription("A locking mechanism. Will either need a key, or some tinkering to get it open");
		
		return e;
	}

	@Override
	public boolean isValidForTinkering(Info actor) {
		return true;
	}



	@Override
	public boolean infoTinkers(Info actor) {
		int i=actor.getGameLogic().tinkerAttempt(actor, this);
		
		if (i==Applicable.OK){
			actor.playAnimation(VisualEffect.SUCCESS_ANIMATION);
			//this.getEffectSprite().playAnimation(a)
			((EffectDecoration)this.getEffectSprite()).setResource("animations/openLock&0");
			this.getEffectSprite().playAnimation(VisualEffect.ANIMATED_ICON_ANIMATION,1000,0,3,1000,true,false);
			this.getEffectSprite().playAnimation(VisualEffect.WAIT_ANIMATION,1000);
			try{Thread.sleep(1000);}catch(Exception e){}
			this.end();
		}else{
			actor.playAnimation(VisualEffect.FAILURE_ANIMATION);
		}
		return false;
	}

	@Override
	public int getDifficultyCheck() {
		return dc;
	}
	
	
	@Override
	public Activity createActivity(ActionRequest ar) {
		PickLockActivity pa= new PickLockActivity();
		pa.setMaxProgress(2);
	
	
		return pa;
	}

}
