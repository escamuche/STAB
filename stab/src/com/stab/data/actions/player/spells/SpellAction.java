package com.stab.data.actions.player.spells;

import java.awt.Point;
import java.util.EnumSet;

import org.newdawn.slick.Color;

import com.stab.annotations.Instanced;
import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.info.applicable.BreakSpellResistance;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.equipment.SpellActionEffect;
import com.stab.data.info.equipment.SpellWeapon;
import com.stab.data.info.other.ConcentrationActivity;
import com.stab.model.action.Action;
import com.stab.model.action.base.WeaponAttackAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.activity.Activity;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.request.basic.ActionRequest;
import com.stab.util.StabUtils;


@Instanced
public abstract class SpellAction extends Action implements SpellProperties{

	
	
	Spell baseSpell;
	Spell spell;
	
	
	
	public SpellAction() {
		baseSpell=new Spell();
		spell=baseSpell;
		spell.setAction(this);
		setCasterClass(StabConstants.WIZARDCASTER);
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		getBaseSpell().setText(name);
	}

	@Override
	public void setDescription(String description) {
		super.setDescription(description);
		getBaseSpell().setDescription(description);
	}
	
	@Override
	public void setResource(String resource) {
		super.setResource(resource);
		getBaseSpell().setResource(resource);
	}
	
	
	public Spell getBaseSpell() {
		return baseSpell;
	}
	
	public Class getActivityClass(){
		return SpellCastingActivity.class;
	}
	
	@Override
	public Activity createActivity(ActionRequest ar) {
		SpellCastingActivity act=new SpellCastingActivity(this);
		
		return act;
	}
	
	
	@Override
	protected void fail(ActionRequest ar) {
		super.fail(ar);
		this.setSpell(getBaseSpell());
	}
	
	@Override
	protected void success(ActionRequest ar) {
		super.success(ar);
		this.setSpell(getBaseSpell());
		
	}
	
	/*
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
	/**/
	
	
	public void setSpell(Spell spell) {
		this.spell = spell;
	}
	
	public Spell getSpell() {
		return spell;
	}
	
	public void setLevel(int level) {
		getBaseSpell().setLevel(level);
	}

	public int getLevel() {
		return getSpell().getLevel();
	}

	public String getAttribute() {
		return getSpell().getAttribute();
	}

	public int getDC(BaseInfo caster) {
		return getSpell().getDC(caster);
	}

	public void setCasterClass(String casterClass) {
		getBaseSpell().setCasterClass(casterClass);
	}

	public String getCasterClass() {
		return getSpell().getCasterClass();
	}

	public int getRange(Info caster) {
		if (isDirected())
			return 1;
		if (caster instanceof BaseInfo)
			return getSpell().getRange((BaseInfo)caster);
		return super.getRange(caster);
	}

	public int getCasterLevel(BaseInfo caster) {
		return getSpell().getCasterLevel(caster);
	}

	public String getSave() {
		return getSpell().getSave();
	}

	public void setSave(String save) {
		getBaseSpell().setSave(save);
	}

	public int getMedium() {
		return getSpell().getMedium();
	}

	public boolean canCast(BaseInfo caster) {
		return getSpell().canCast(caster);
	}

	public int hashCode() {
		return getSpell().hashCode();
	}

	public void setMedium(int medium) {
		getBaseSpell().setMedium(medium);
	}

	public void setAffectedBySR(boolean affectedBySR) {
		getBaseSpell().setAffectedBySR(affectedBySR);
	}

	public boolean isAffectedBySR() {
		return getBaseSpell().isAffectedBySR();
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
		return getSpell().getSavingThrow(caster,target);
	}
	
	public void setRange(int range){
		getBaseSpell().setRange(range);
	}
	
	
	
	public void setWeapon(String weapon) {
		getBaseSpell().setWeapon(weapon);
	}

	public boolean isWeaponChargeSpell() {
		return getSpell().isWeaponChargeSpell();
	}

	public void setWeaponChargeSpell(boolean weaponChargeSpell) {
		getBaseSpell().setWeaponChargeSpell(weaponChargeSpell);
	}

	@Override
	public int getLosType() {
		switch(getSpell().getMedium()){
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
		return getSpell().getDescriptors();
	}

	
	
	public void setDescriptors(EffectDescriptor arg0) {
		getBaseSpell().setDescriptors(arg0);
	}

	public void setDescriptors(EffectDescriptor arg0, EffectDescriptor... arg1) {
		getBaseSpell().setDescriptors(arg0, arg1);
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
			SpellActionEffect ae= new SpellActionEffect(caster,target,point,this.getSpell(),ar);
			target.apply(ae);
		
		
			return ae.getResult();
		}
		//Si no es harmful, considerar que afecta siempre
		//TODO: mirarse lo de resistencia magica para efectos beneficiosos, tecnicamente se aplica
		SpellActionEffect ae= new SpellActionEffect(caster,target,point,this.getSpell(),ar);
		target.apply(ae);
		
		
		return ae.getResult();

		
	}

	public int spellAffect(BaseInfo caster, BaseInfo target, Point point, boolean critical,ActionRequest ar){
		
		if (this.isHarmfulFor(caster, target)) //solo si es dañino (si, ya se que en las reglas no es asi, pero por simplificar)
		//primero, spell resistance
		if (getSpell().isAffectedBySR())
			if (target.getValue(StabConstants.SPELLRESISTANCE)>0){
				//Tirada de spell resistance
				 BreakSpellResistance bsr= new BreakSpellResistance(caster, getSpell().getCasterClass(), target);
				 bsr.check();
				 if (bsr.failed()){
					
					 spellResisted(caster,target,point, ar);
					 return SpellActionEffect.RESISTED;
				 }
			}
		
		//segundo, resolver tirada de salvacion (solo si es dañino)
		if (this.isHarmfulFor(caster, target))
		if (getSpell().getSave()!=null){
			SavingThrowEffect st=new SavingThrowEffect(caster, getSpell().getSave(), target);
			st.setTargetNumber(getSpell().getDC(caster));
			st.setDescriptors(getSpell().getDescriptors());
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
		SpellWeapon w= getSpell().getWeapon();
		if (w==null)
			return null;
		w.addEffect(caster,target,point,this.getSpell(),ar);
		Weapon old=(Weapon)((Creature)caster).getEquipment(w.getSlot());
		w.setOld(old);
		return w;
	}
	
	@Override
	public int getCost() {
		return getSpell().getCost();
	}

	public void setSomatic(boolean somatic) {
		getBaseSpell().setSomatic(somatic);
	}

	public void setVerbal(boolean verbal) {
		getBaseSpell().setVerbal(verbal);
	}


	
	public boolean isSomatic() {
		return getSpell().isSomatic();
	}

	public boolean isVerbal() {
		return getSpell().isVerbal();
	}
	
	public boolean isSubjectToArcaneArmorFailure() {
		return getSpell().isSubjectToArcaneArmorFailure();
	}
	
	public void setCastingTime(int time){
		this.getBaseSpell().setCastingTime(time);
	}
	
	public int getCastingTime(){
		return getSpell().getCastingTime();
	}
	
	@Override
	public int getDuration() {
		return getSpell().getDuration();
	}
	
	public void setDuration(int n){
		getBaseSpell().setDuration(n);
	}
	
	public void setDismissable(boolean b){
		getBaseSpell().setDismissable(b);
	}
	
	public void setConcentration(int concentration) {
		getBaseSpell().setConcentration(concentration);
	}
	public int getConcentration() {
		return  getSpell().getConcentration();
	}
	
	
	@Override
	public int execute(Info origin, Info target, Point point, ActionRequest ar) {
		onExecute( origin,  target,  point,  ar);
		return super.execute(origin, target, point, ar);
	}
	
	protected void onExecute(Info origin, Info target, Point point, ActionRequest ar){
		ConcentrationActivity c= createConcentrationActivity();
		getSpell().setConcentrationActivity(c);
		if (c!=null && (origin instanceof BaseInfo))
			((BaseInfo)origin).addTrait(c);
	}
	
	public ConcentrationActivity createConcentrationActivity(){
		if (getConcentration()==SpellProperties.NONE)
			return null;
		ConcentrationActivity c= new ConcentrationActivity();
		c.setText("Concentrate on "+getSpell().getText());
		String s="Concentrate on the spell.#";
		if (getConcentration()==SpellProperties.CONCENTRATION_EXTENDS){
			s=s+"Spell will keep going while you concentrate, and then some time";
			c.setKeepEveryRound(true);
		}
		if (getConcentration()==SpellProperties.CONCENTRATION_REQUIRED){
			s=s+"If you don't concentrate every round, the spell will end";
			c.setKeepEveryRound(true);
		}
		c.setDescription(s);
		return c;
	}
}
