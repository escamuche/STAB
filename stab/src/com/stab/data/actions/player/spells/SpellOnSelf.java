package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.BreakSpellResistance;
import com.stab.data.info.applicable.OpposedSkillRoll;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.applicable.WeaponAttack;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public abstract class SpellOnSelf extends SelfAction  implements SpellProperties {

	
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
	public boolean affect(Info origin,Info t,Point point) {
		//Este comportamiento estandar es para baseinfos. si es otra cosa, este metodo estara sobreescrito
		if (!(origin instanceof BaseInfo))
			return false;
		if (!(t instanceof BaseInfo))
			return false;
		BaseInfo caster=(BaseInfo)origin;
		BaseInfo target=(BaseInfo)t;
		
		if (isHarmfulFor(caster,target)){
			
			/* esto va fuera de aqui
			//Primro, resolver ataque
			WeaponAttack attack=null;
			switch(spell.getMedium()){
				case SpellProperties.TOUCH: attack=new WeaponAttack(caster,null,target); break;
				case SpellProperties.RAY: break;
				case SpellProperties.MISSILE: break;
			}
			if (attack!=null){
				
			}
			/**/
			
			//primero, spell resistance
			if (spell.isAffectedBySR())
				if (target.getValue(StabConstants.SPELLRESISTANCE)>0){
					//Tirada de spell resistance
					 BreakSpellResistance bsr= new BreakSpellResistance(caster, spell.getCasterClass(), target);
					 bsr.check();
					 if (bsr.failed()){
						 playSRFailAnimation(caster, target);
						 return spellResisted(caster,target);
					 }
				}
			
			//segundo, resolver tirada de salvacion
			
			if (spell.getSave()!=null){
				SavingThrowEffect st=new SavingThrowEffect(caster, spell.getSave(), target);
				st.setTargetNumber(spell.getDC(caster));
				
				st.check();
				
				if (st.isEvaded()){
					playEvadedAnimation(caster, target);
					return evadedEffect(caster, target);
				}
				if (st.success()){
					playPartialEffectAnimation(caster, target);
					return partialEffect(caster, target);
				}
				if (st.failed()){
					playFullEffectAnimation(caster, target);
					return fullEffect(caster, target);
				}
				//No hay mas casos.
				return false; //por si algo falla horriblemente
			}
			//Si no tiene save, fullEffect
			return fullEffect(caster,target);
		}
		//Si no es harmful, considerar que afecta siempre
		//TODO: mirarse lo de resistencia magica para efectos beneficiosos
		
		return fullEffect(caster,target);
		
	}
	
	protected boolean fullEffect(BaseInfo caster, BaseInfo target) {
		return true;
	}
	protected boolean partialEffect(BaseInfo caster, BaseInfo target) {
		return true;
	}
	protected boolean evadedEffect(BaseInfo caster, BaseInfo target) {
		return true;
	}
	
	protected boolean spellResisted(BaseInfo caster, BaseInfo target) {
		return true;
	}
	
	//No olvidarse de playExecuteActionAnimation!
	protected void playAttackHitAnimation(BaseInfo caster, BaseInfo target){};
	protected void playAttackMissAnimation(BaseInfo caster, BaseInfo target){};
	protected void playSRFailAnimation(BaseInfo caster, BaseInfo target){};
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target){};
	protected void playPartialEffectAnimation(BaseInfo caster, BaseInfo target){};
	protected void playEvadedAnimation(BaseInfo caster, BaseInfo target){};
	
}
