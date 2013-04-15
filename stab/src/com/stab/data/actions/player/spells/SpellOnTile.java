package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.action.TileAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public abstract class SpellOnTile extends TileAction implements SpellProperties {

	
	Spell spell;
	
	public SpellOnTile() {
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

	public boolean isHarmfulFor(Info instigator,Info target) {
		if (target instanceof BaseInfo){
			int i=this.getEffectType((BaseInfo)target);
			if ((i & OFFENSIVE) ==OFFENSIVE )
				return true;
		}
		
		return false;
	}
	
	@Override
	public SavingThrowEffect getSavingThrow(BaseInfo caster,BaseInfo target) {
		return spell.getSavingThrow(caster,target);
	}
	
	public void setRange(int range){
		spell.setRange(range);
	}
	
	@Override
	public int getLosType() {
		switch(spell.getMedium()){
			case SELF:
			case POINT:
						return IN_RANGE;
			case TOUCH:
			case MISSILE:
			case RAY:
			case TARGET:
						return LOS;
			case SIGHT:
						return IN_SIGHT;
		}
		return super.getLosType();
	}
	
	@Override
	public boolean affect(Info instigator, Info target,Point point) {
		// TODO Auto-generated method stub
		return true;
	}
	
}
