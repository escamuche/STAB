package com.stab.pf.info.spellcasting;

import java.util.EnumSet;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.actions.player.spells.SpellProperties;
import com.stab.pf.info.applicable.SavingThrowEffect;

public class SpellCasting extends Applicable implements SpellProperties {
	
	//Eventualmente podemos meter aqui algun calculo de coste (doble coste para escuelas negadas, etc)


	public static final int SUCCESS = 0;
	public static final int GENERICFAIL = 10;
	public static final int ARMORFAIL = 11;		      //fallo por armadura y hechizos arcanos
	public static final int CONCENTRATIONFAIL = 12;  //fallo por necesitar concentracion
	public static final int INDUCEDFAIL = 13;        //inmobilizado y somatico, silencio y verbal, sordera 20%, etc
	public static final int SPELLCHECKFAIL = 14;     //Para pergminos,  lanzar cosas por umd, etc 
	
	
	//Metemos aqui el counterspell?  como?
	
	
	Spell spell;
	
	
	public SpellCasting(Info instigator,Spell spell) {
		super(instigator);
		this.spell=spell.getCopy();
		setResult(SUCCESS);
	}
	
	@Override
	public void validate() {
		
	}
	
	@Override
	public boolean success() {
		return !failed();
	}
	
	public boolean failed() {
		if (getResult()==GENERICFAIL)
			return true;
		if (getResult()==ARMORFAIL)
			return true;
		if (getResult()==CONCENTRATIONFAIL)
			return true;
		if (getResult()==INDUCEDFAIL)
			return true;
		if (getResult()==SPELLCHECKFAIL)
			return true;
		return false;
	}
	
	
	public Spell getSpell() {
		return spell;
	}

	public boolean isSomatic() {
		//Meter posibles comprobaciones (still, silent, etc)
		return spell.isSomatic();
	}

	public boolean isVerbal() {
	//	Meter posibles comprobaciones (still, silent, etc)
		return spell.isVerbal();
	}

	public boolean isSubjectToArcaneArmorFailure() {
		return spell.isSubjectToArcaneArmorFailure();
	}
	
	
	
	
	
	
	
	
	//From spell (revisar todo esto)
	
	@Override
	public EnumSet<EffectDescriptor> getDescriptors() {
		return spell.getDescriptors();
	}

	@Override
	public int getLevel() {
		return spell.getLevel();
	}

	@Override
	public String getAttribute() {
		return spell.getAttribute();
	}

	@Override
	public int getDC(BaseInfo caster) {
		return spell.getDC(caster);
	}

	@Override
	public String getCasterClass() {
		return spell.getCasterClass();
	}

	@Override
	public int getRange(Info caster) {
		return spell.getRange(caster);
	}

	@Override
	public int getCasterLevel(BaseInfo caster) {
		return spell.getCasterLevel(caster);
	}

	@Override
	public String getSave() {
		return spell.getSave();
	}

	@Override
	public int getMedium() {
		return spell.getMedium();
	}

	@Override
	public boolean isWeaponChargeSpell() {
		return spell.isWeaponChargeSpell();
	}

	@Override
	public boolean canCast(BaseInfo caster) {
		return spell.canCast(caster);
	}

	@Override
	public boolean isAffectedBySR() {
		return spell.isAffectedBySR();
	}

	@Override
	public int getDuration() {
		return spell.getDuration();
	}
	
	@Override
	public SavingThrowEffect getSavingThrow(BaseInfo caster, BaseInfo target) {
		return spell.getSavingThrow(caster, target);
	}
}
