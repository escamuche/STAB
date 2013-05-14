package com.stab.data.actions.player.spells.wizard.level0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DancingLights extends SpellOnTile implements AoE {

	public static final String ID="DANCINGLIGHTS";
	
	public DancingLights() {
	     
		 setLevel(0);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(CLOSE);
	     setResource("actions/ability_mage_arcanebarrage");
	     setName("DancingLights");
	     this.setEffectType(Action.SPECIAL);
		}


	@Override
	public boolean affect(Info instigator,Info receive,Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)receive;
		return false;
	}


	@Override
	public int getAreaType() {
		return AoE.CONE;
	}


	@Override
	public float getLength(Info caster) {
		return 3;
	}


	@Override
	public float getWidth(Info caster) {
		return 190;
	}


	@Override
	public int getRequiredLine() {
		return Action.IN_SIGHT;
	}


	@Override
	public boolean affectsSelf() {
		// TODO Auto-generated method stub
		return false;
	}
}
