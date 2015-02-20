package com.stab.pf.actions.player.spells.lvl0;

import java.awt.Point;

import com.stab.data.animation.BasicSparkAnimation;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Interaction;
import com.stab.model.info.base.Door;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.ActionDummy;
import com.stab.pf.actions.player.spells.SpellOnTarget;

public class OpenClose extends SpellOnTarget{
	
	public static final String ID="OPENCLOSE";

@Override
protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
	Door Atacado = (Door)target;
	ActionDummy dummy= new ActionDummy();
	Interaction i=new Interaction(dummy);
	((BaseInfo)target).apply(i);
	return i.success();
	//return super.fullEffect(caster, target, point);
}

@Override
public boolean validateAffect(Info instigator, Info target) {
	
	if (target instanceof Door)
		return true;
	
	//TODO: meter chests, y esas cosas
	
	return false;
}
	
	public OpenClose() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetTokenClass(DoorToken.class);
		setResource("actions/openclose");
		setName("Open/Close");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		this.setDescription("You can open or close (your choice) a door, chest, box, window, bag, pouch, bottle, barrel, or other container. If anything resists this activity (such as a bar on a door or a lock on a chest), the spell fails. In addition, the spell can only open and close things weighing 30 pounds or less. Thus, doors, chests, and similar objects sized for enormous creatures may be beyond this spell's ability to affect.");
	}
	
	@Override
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,
			Point point, ActionRequest ar) {
		super.playFullEffectAnimation(caster, target, point, ar);
		target.playAnimation(BasicSparkAnimation.ID,"PARTICLE#spells/magicSparks");
		target.playSound("effects/LayOnhands_Low_Chest");
	}
	
}
