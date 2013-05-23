package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.data.info.applicable.RolledDamage;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class BurningHands extends SpellOnTile implements AoE {

	public static final String ID="BURNINGHANDS";
	
	public BurningHands() {
	     
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(1);
	     setResource("actions/burninghands");
	     setName("BurningHands");
	     this.setEffectType(DAMAGE);
	     this.setSave(StabConstants.REFLEXSAVE);
	     this.setDescription("A cone of searing flame shoots from your fingertips. Any creature in the area of the flames takes 1d4 points of fire damage per caster level (maximum 5d4).");
		}


	@Override
	public boolean affect(Info instigator,Info receptor,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receptor;
		return false;
	}
	
	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		int level = getCasterLevel(caster);
		if(level<5){
			RolledDamage g = new RolledDamage(level,4,Damage.FIRE_DAMAGE,caster);
			target.apply(g);
		}
		else{
			RolledDamage g = new RolledDamage(5,4,Damage.FIRE_DAMAGE,caster);
			target.apply(g);
		}
		return super.fullEffect(caster, target, point);	
	}
	
	@Override
	protected boolean partialEffect(BaseInfo caster, BaseInfo target,
			Point point) {
		
		int level = getCasterLevel(caster);
		if(level<5){
			RolledDamage g = new RolledDamage(level,2,Damage.FIRE_DAMAGE,caster);
			target.apply(g);
		}
		else{
			RolledDamage g = new RolledDamage(5,2,Damage.FIRE_DAMAGE,caster);
			target.apply(g);
		}
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
		return 4;
	}


	@Override
	public int getRequiredLine() {
		return Action.LOS;
	}


	@Override
	public float getWidth(Info arg0) {
		return 0;
	}
}
