package com.stab.data.actions.player.spells.lvl0.effects;

import com.stab.data.actions.player.spells.Spell;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.data.info.spellcasting.SpellEffect;
import com.stab.model.extras.VisionMode;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DetectMagic_Buff extends SpellEffect {

	public static final String ID="DETECT_MAGIC_BUFF";
	
	VisionMode vis;
	
	public DetectMagic_Buff(Spell spell, Info caster) {
		super(spell, caster);
		vis=new VisionMode(DetectMagic.VISIONMODE);
		setAnimIcon("actions/spells/sheikah_eye");
		//this.setEvident(true);
		setBuffDebuff(BUFF);
	}

	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		baseInfo.addExtra(vis);
	}
	
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		baseInfo.removeExtra(vis);
	}
}
