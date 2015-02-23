package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;

import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTile;

public class BurningHands extends SpellOnTile   {

	public static final String ID="BURNINGHANDS";
	
	public BurningHands() {
		setAoE(true);
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(10);
	     setResource("actions/burninghands");
	     setName("BurningHands");
	     this.setEffectType(DAMAGE);
	     this.setSave(StabConstants.REFLEXSAVE);
	     this.setDescription("A cone of searing flame shoots from your fingertips. Any creature in the area of the flames takes 1d4 points of fire damage per caster level (maximum 5d4).");
	     this.setLosType(IN_SIGHT);
	     setDescriptors(EffectDescriptor.EVOCATION,EffectDescriptor.FIRE);
	}


	@Override
	public void playExecuteActionAnimation(Info caster, Info target,
			Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		double a=getAngle(caster,target,pos);
		a=Math.toDegrees(a);
		caster.playSound("flames");
		caster.playAnimation(VisualEffect.SPARK_ANIMATION, "PARTICLE#spells/burninghands", 1200,a);
	}
	
	


	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int level = getCasterLevel(caster);
		if(level>5)
			level=5;
		RolledDamage g = new RolledDamage(level,4,0,Damage.FIRE_DAMAGE,caster);
		target.apply(g);
		return super.fullEffect(caster, target, point);	
	}
	
	@Override
	protected boolean partialEffect(BaseInfo caster, BaseInfo target,
			Point point) {
		int level = getCasterLevel(caster);
		if(level>5)
			level=5;
		
		RolledDamage g = new RolledDamage(level,2,0,Damage.FIRE_DAMAGE,caster);
		target.apply(g);
		return super.partialEffect(caster, target, point);
	}


	@Override
	public boolean affectsSelf() {
		return false;
	}


	@Override
	public int getAreaType() {
		return AoE.CONE;
	}


	@Override
	public float getLength(Info arg0) {
		return 3;
	}


	@Override
	public int getRequiredLine() {
		return Action.IN_SIGHT;
	}


	@Override
	public float getWidth(Info arg0) {
		return 90;
	}
	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		return Damage.FIRE_DAMAGE;
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		int level = getCasterLevel(i);
		if(level>5)
			level=5;
		return level*4;
	}
	
}
