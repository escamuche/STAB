package com.stab.data.actions.player.spells.lvl0.unfinished;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTile;
import com.stab.data.info.debuff.Lullaby_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class Lullaby extends SpellOnTile  {

	public static final String ID="LULLABY";
	
	public Lullaby() {
		setAoE(true);
		 setLevel(0);
		 setCasterClass(StabConstants.BARDCASTER);
	     setResource("actions/lullaby");
	     setName("Lullaby");
	     this.setEffectType(DEBUFF);
	     this.setRange(MEDIUM);
	     this.setDescription("Any creature within the area that fails a Will save becomes drowsy and inattentive, taking a -5 penalty on Perception checks and a -2 penalty on Will saves against  sleep effects while the lullaby is in effect. Lullaby lasts for as long as the caster concentrates, plus up to 1 round per caster level thereafter.");
	    this.setSave(StabConstants.WILLSAVE);
	}

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		
		Lullaby_Debuff debuff = new Lullaby_Debuff();
		int t = getCasterLevel(caster);
		debuff.setTime(t);
		target.addTrait(debuff);
		return super.fullEffect(caster, target, point);
	}


	@Override
	public boolean affectsSelf() {
		return true;
	}


	@Override
	public int getAreaType() {
		return BURST;
	}


	@Override
	public float getLength(Info arg0) {
		return 2;
	}


	@Override
	public int getRequiredLine() {
		return IN_SIGHT;
	}


	@Override
	public float getWidth(Info arg0) {
		return 0;
	}
}
