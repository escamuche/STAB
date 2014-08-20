package com.stab.data.info.spellcasting;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.base.EffectDecoration;
import com.stab.model.info.interfaces.Examinable;
import com.stab.model.info.interfaces.PlayerOwned;
import com.stab.util.StabUtils;

public class SpellDecoration extends EffectDecoration implements Examinable {

	
	SpellEffect spellEffect;
	boolean recognized;
	
	public SpellDecoration(SpellEffect e) {
		this.spellEffect=e;
		recognized=false;
		if (e.getCaster() instanceof PlayerOwned)
			recognized=true;
		setRecognized(recognized);
	}
	
	public SpellEffect getSpellEffect() {
		return spellEffect;
	}
	
	
	public boolean isRecognized() {
		return recognized;
	}
	public void setRecognized(boolean recognized) {
		this.recognized = recognized;
		if (!recognized){
			this.setText(SpellUtils.getGenericDescription(spellEffect.getSpell()));
			this.setDescription("An unrecognized spell");
		}else{
			this.setText(spellEffect.getSpell().getText());
			this.setDescription(spellEffect.getSpell().getDescription());
		}
	}
	
	@Override
	public void examinedBy(Info instigator) {
		super.examinedBy(instigator);
		if (recognized)
			return;
		if (instigator instanceof BaseInfo){
			SkillRoll sk=StabUtils.getGameLogic().getSkillRoll((BaseInfo)instigator, StabConstants.SPELLCRAFT, getSpellEffect().getSpell().getLevel()+10);
			sk.check();
			if (sk.success())
				setRecognized(true);
		}
	}
	
}
