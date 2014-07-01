package com.stab.data.actions.player.spells;

import java.awt.Point;
import java.util.EnumSet;

import org.newdawn.slick.Color;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.general.WeaponAttackAction;
import com.stab.data.info.applicable.BreakSpellResistance;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.applicable.SpellCasting;
import com.stab.data.info.buff.SpellCasting_Condition;
import com.stab.data.info.equipment.SpellActionEffect;
import com.stab.data.info.equipment.SpellWeapon;
import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.request.basic.ActionRequest;
import com.stab.util.StabUtils;

public abstract class SpellAction extends Action implements SpellProperties{

	
	
	
	Spell spell;
	
	public SpellAction() {
		spell=new Spell();
		
	}

	
	public final int execute(Info origin,Info target,Point point,ActionRequest ar){
	
		if (!attemptCast(origin,target,point))
			return FAIL;
		return castSpell(origin,target,point,ar);
	}
	
	public int castSpell(Info origin,Info target,Point point,ActionRequest ar){
		return super.execute(origin, target, point,ar);
	}
	
	protected void beginCasting(Info origin){
		if (origin instanceof BaseInfo){
			SpellCasting_Condition c= new SpellCasting_Condition(this);
			((BaseInfo)origin).addTrait(c);
			origin.waitAnimation(200);
			sleep(200);
		}
	}
	protected void endCasting(Info origin){
		if (origin instanceof BaseInfo){
			((BaseInfo)origin).removeTrait(SpellCasting_Condition.ID);
			origin.waitAnimation(50);
			sleep(50);
		}
	}
	
	public boolean attemptCast(Info origin,Info target,Point point){
		beginCasting(origin);
		SpellCasting sc= new SpellCasting(origin,getSpell());
		sc.check();
		endCasting(origin);
		if (sc.failed()){
			switch(sc.getResult()){
				case SpellCasting.ARMORFAIL: 
				case SpellCasting.INDUCEDFAIL:
				case SpellCasting.CONCENTRATIONFAIL:
				case SpellCasting.SPELLCHECKFAIL:
				case SpellCasting.GENERICFAIL:
						origin.showFloatingText("FAILED", Color.red);
			}
			return false;
		}
		return true;
	}
	
	
	public Spell getSpell() {
		return spell;
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
			case SELECTED:
						return LOS;
			case SIGHT:
						return IN_SIGHT;
		}
		return super.getLosType();
	}
	
	
	@Override
	public EnumSet<EffectDescriptor> getDescriptors() {
		return spell.getDescriptors();
	}

	
	
	public void setDescriptors(EffectDescriptor arg0) {
		spell.setDescriptors(arg0);
	}

	public void setDescriptors(EffectDescriptor arg0, EffectDescriptor... arg1) {
		spell.setDescriptors(arg0, arg1);
	}

	@Override
	public int affect(Info origin,Info t,Point point, ActionRequest ar) {
		//Este comportamiento estandar es para baseinfos. si es otra cosa, este metodo estara sobreescrito
		if (!(origin instanceof BaseInfo))
			return FAIL;
		if (!(t instanceof BaseInfo))
			return FAIL;
		BaseInfo caster=(BaseInfo)origin;
		BaseInfo target=(BaseInfo)t;
		
		
		if (caster==target && isWeaponChargeSpell()){
			SpellWeapon w=getWeapon(caster,target,point,ar);
			if (w!=null)
				((Creature)caster).equip(w);
			return OK;
		}
		
		
		if (isHarmfulFor(caster,target)){
			
			SpellWeapon w=getWeapon(caster,target,point,ar);
			if (w!=null){
				((Creature)caster).equip(w);
				WeaponAttackAction a=(WeaponAttackAction)StabUtils.getGameLogic().getAttackAction(w);
				int r=a.affect(caster, target, point, ar);
				return r;
			}
			//Si no se usa un ataque, castear normalmente
			SpellActionEffect ae= new SpellActionEffect(caster,target,point,this.getLocator(),ar);
			target.apply(ae);
		
		
			return ae.getResult();
		}
		//Si no es harmful, considerar que afecta siempre
		//TODO: mirarse lo de resistencia magica para efectos beneficiosos, tecnicamente se aplica
		SpellActionEffect ae= new SpellActionEffect(caster,target,point,this.getId(),ar);
		target.apply(ae);
		
		
		return ae.getResult();

		
	}

	public int spellAffect(BaseInfo caster, BaseInfo target, Point point, boolean critical,ActionRequest ar){
		
		if (this.isHarmfulFor(caster, target)) //solo si es dañino (si, ya se que en las reglas no es asi, pero por simplificar)
		//primero, spell resistance
		if (spell.isAffectedBySR())
			if (target.getValue(StabConstants.SPELLRESISTANCE)>0){
				//Tirada de spell resistance
				 BreakSpellResistance bsr= new BreakSpellResistance(caster, spell.getCasterClass(), target);
				 bsr.check();
				 if (bsr.failed()){
					
					 spellResisted(caster,target,point, ar);
					 return SpellActionEffect.RESISTED;
				 }
			}
		
		//segundo, resolver tirada de salvacion (solo si es dañino)
		if (this.isHarmfulFor(caster, target))
		if (spell.getSave()!=null){
			SavingThrowEffect st=new SavingThrowEffect(caster, spell.getSave(), target);
			st.setTargetNumber(spell.getDC(caster));
			
			st.check();
			
			if (st.isEvaded()){
				
				evadedEffect(caster, target,point,ar);
				return SpellActionEffect.EVADED;
			}
			if (st.success()){
				
				return partialEffect(caster, target,point,ar);
				
			}
			if (st.failed()){
			
				return fullEffect(caster, target,point,ar);
			}
			//No hay mas casos.
			return INVALID; //por si algo falla horriblemente
		}
	
		return fullEffect(caster,target,point,ar);
	}
	
	
	protected int fullEffect(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar) {
		playFullEffectAnimation(caster, target,point, ar);
		fullEffect(caster,target,point);
		return Applicable.OK;
	}
	protected int partialEffect(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar) {
		playPartialEffectAnimation(caster, target,point,ar);
		partialEffect(caster,target,point);
		return Applicable.OK;
	}
	
	protected boolean fullEffect(BaseInfo caster, BaseInfo target,Point point) {
		
		return true;
	}
	protected boolean partialEffect(BaseInfo caster, BaseInfo target,Point point) {
		
		return true;
	}
	protected boolean evadedEffect(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar) {
		playEvadedAnimation(caster, target,point,ar);
	
		return true;
	}
	protected boolean spellResisted(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar) {
		 playSRFailAnimation(caster, target,point,ar);
	
		return true;
	}
	
	//No olvidarse de playExecuteActionAnimation!

	protected void playSRFailAnimation(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar){ 
		target.showFloatingText("RESIST", Color.pink);
	};
	protected void playFullEffectAnimation(BaseInfo caster, BaseInfo target,Point point, ActionRequest ar){};
	protected void playPartialEffectAnimation(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar){
		target.showFloatingText("SAVE", Color.green);
	};
	protected void playEvadedAnimation(BaseInfo caster, BaseInfo target,Point point,ActionRequest ar){
		target.showFloatingText("EVADED", Color.pink);
	};
	 
	
	//Corresponde a las subclases determinar las cargas!
	public SpellWeapon getWeapon(BaseInfo caster,BaseInfo target,Point point,ActionRequest ar){
		SpellWeapon w= spell.getWeapon();
		if (w==null)
			return null;
		w.addEffect(caster,target,point,this.getLocator(),ar);
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

	public void setSomatic(boolean somatic) {
		spell.setSomatic(somatic);
	}

	public void setVerbal(boolean verbal) {
		spell.setVerbal(verbal);
	}


	
	public boolean isSomatic() {
		return spell.isSomatic();
	}

	public boolean isVerbal() {
		return spell.isVerbal();
	}
	
	public boolean isSubjectToArcaneArmorFailure() {
		return spell.isSubjectToArcaneArmorFailure();
	}
	
}
