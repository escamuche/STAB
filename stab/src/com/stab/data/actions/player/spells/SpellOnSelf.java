package com.stab.data.actions.player.spells;

import com.stab.data.StabConstants;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public abstract class SpellOnSelf extends SelfAction  implements SpellData {

	
	Spell spell;
	
	public SpellOnSelf() {
		spell=new Spell();
	}

	public void setLevel(int level) {
		spell.setLevel(level);
	}

	public int getLevel() {
		return spell.getLevel();
	}

	public String getAttribute() {
		return spell.getAttribute();
	}

	public int getDC(BaseInfo caster) {
		return spell.getDC(caster);
	}

	public void setCasterClass(String casterClass) {
		spell.setCasterClass(casterClass);
	}

	public String getCasterClass() {
		return spell.getCasterClass();
	}

	public int getRange(BaseInfo caster) {
		return spell.getRange(caster);
	}

	public int getCasterLevel(BaseInfo caster) {
		return spell.getCasterLevel(caster);
	}

	public String getSave() {
		return spell.getSave();
	}

	public void setSave(String save) {
		spell.setSave(save);
	}

	public int getMedium() {
		return spell.getMedium();
	}

	public boolean canCast(BaseInfo caster) {
		return spell.canCast(caster);
	}

	public int hashCode() {
		return spell.hashCode();
	}

	public void setMedium(int medium) {
		spell.setMedium(medium);
	}

	public void setAffectedBySR(boolean affectedBySR) {
		spell.setAffectedBySR(affectedBySR);
	}

	public boolean isAffectedBySR() {
		return spell.isAffectedBySR();
	}

	public boolean isHarmfulFor(Info target) {
		return spell.isHarmfulFor(target);
	}
	
	public void setRange(int range){
		spell.setRange(range);
	}
	
	
}
