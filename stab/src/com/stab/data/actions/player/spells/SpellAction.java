package com.stab.data.actions.player.spells;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.WeaponAttackAction;
import com.stab.data.info.applicable.BreakSpellResistance;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.equipment.SpellActionEffect;
import com.stab.data.info.equipment.SpellWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;

public abstract class SpellAction extends Action implements SpellProperties{

Spell spell;
	
	public SpellAction() {
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

	public int getRange(Info caster) {
		if (isDirected())
			return 1;
		if (caster instanceof BaseInfo)
			return spell.getRange((BaseInfo)caster);
		return super.getRange(caster);
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
			int i=this.getEffectType(instigator,(BaseInfo)target);
			if ((i & NEGATIVE) ==NEGATIVE )
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
	
	
	
	public void setWeapon(String weapon) {
		spell.setWeapon(weapon);
	}

	public boolean isWeaponChargeSpell() {
		return spell.isWeaponChargeSpell();
	}

	public void setWeaponChargeSpell(boolean weaponChargeSpell) {
		spell.setWeaponChargeSpell(weaponChargeSpell);
	}

	@Override
	public int getLosType() {
		switch(spell.getMedium()){
			case SpellProperties.SELF:
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
	public boolean affect(Info origin,Info t,Point point) {
		//Este comportamiento estandar es para baseinfos. si es otra cosa, este metodo estara sobreescrito
		if (!(origin instanceof BaseInfo))
			return false;
		if (!(t instanceof BaseInfo))
			return false;
		BaseInfo caster=(BaseInfo)origin;
		BaseInfo target=(BaseInfo)t;
		
		
		if (caster==target && isWeaponChargeSpell()){
			SpellWeapon w=getWeapon(caster,target,point);
			if (w!=null)
				((Creature)caster).equip(w);
			return true;
		}
		
		
		if (isHarmfulFor(caster,target)){
			
			SpellWeapon w=getWeapon(caster,target,point);
			if (w!=null){
				
				((Creature)caster).equip(w);
				WeaponAttackAction a=(WeaponAttackAction)getActionLibrary().getAction(WeaponAttackAction.ID);
				boolean b=a.affect(caster, target, point);
				return b;
			}
			//Si no se usa un ataque, castear normalmente
			return fullEffect(caster,target,point);
		}
		//Si no es harmful, considerar que afecta siempre
		//TODO: mirarse lo de resistencia magica para efectos beneficiosos, tecnicamente se aplica
		
		return fullEffect(caster,target,point);
		
	}

	public boolean spellAffect(BaseInfo caster, BaseInfo target, Point point, boolean critical){
		
		
		//primero, spell resistance
		if (spell.isAffectedBySR())
			if (target.getValue(StabConstants.SPELLRESISTANCE)>0){
				//Tirada de spell resistance
				 BreakSpellResistance bsr= new BreakSpellResistance(caster, spell.getCasterClass(), target);
				 bsr.check();
				 if (bsr.failed()){
					
					 return spellResisted(caster,target,point);
				 }
			}
		
		//segundo, resolver tirada de salvacion
		
		if (spell.getSave()!=null){
			SavingThrowEffect st=new SavingThrowEffect(caster, spell.getSave(), target);
			st.setTargetNumber(spell.getDC(caster));
			
			st.check();
			
			if (st.isEvaded()){
				
				return evadedEffect(caster, target,point);
			}
			if (st.success()){
				
				return partialEffect(caster, target,point);
			}
			if (st.failed()){
			
				return fullEffect(caster, target,point);
			}
			//No hay mas casos.
			return false; //por si algo falla horriblemente
		}
	
		return fullEffect(caster,target,point);
	}
	
	protected boolean fullEffect(BaseInfo caster, BaseInfo target,Point point) {
		playFullEffectAnimation(caster, target,point);
		return true;
	}
	protected boolean partialEffect(BaseInfo caster, BaseInfo target,Point point) {
		playPartialEffectAnimation(caster, target,point);
		return true;
	}
	protected boolean evadedEffect(BaseInfo caster, BaseInfo target,Point point) {
		playEvadedAnimation(caster, target,point);
		return true;
	}
	protected boolean spellResisted(BaseInfo caster, BaseInfo target,Point point) {
		 playSRFailAnimation(caster, target,point);
		return true;
	}
	
	//No olvidarse de playExecuteActionAnimation!

	protected void playSRFailAnimation(BaseInfo caster, BaseInfo target,Point point){};
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,Point point){};
	protected void playPartialEffectAnimation(BaseInfo caster, BaseInfo target,Point point){};
	protected void playEvadedAnimation(BaseInfo caster, BaseInfo target,Point point){};
	 
	
	//Corresponde a las subclases determinar las cargas!
	public SpellWeapon getWeapon(BaseInfo caster,BaseInfo target,Point point){
		SpellWeapon w= spell.getWeapon();
		if (w==null)
			return null;
		w.addEffect(caster,target,point,this.getId());
		Weapon old=(Weapon)((Creature)caster).getEquipment(w.getSlot());
		w.setOld(old);
		return w;
	}
	
	@Override
		public int getCost() {
			if(spell.getLevel()==0)
				return 0;
			return (spell.getLevel()*5)+5;
		}
}