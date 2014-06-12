package com.stab.data.info.applicable;

import com.stab.data.actions.player.spells.Spell;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;

public class SpellCasting extends Applicable {
	
	//Eventualmente podemos meter aqui algun calculo de coste (doble coste para escuelas negadas, etc)


	public static final int SUCCESS = 0;
	public static final int GENERICFAIL = 10;
	public static final int ARMORFAIL = 11;		      //fallo por armadura y hechizos arcanos
	public static final int CONCENTRATIONFAIL = 12;  //fallo por necesitar concentracion
	public static final int INDUCEDFAIL = 13;        //inmobilizado y somatico, silencio y verbal, sordera 20%, etc
	public static final int SPELLCHECKFAIL = 14;     //Para pergminos,  lanzar cosas por umd, etc 
	
	
	//Metemos aqui el counterspell?  como?
	
	
	Spell spell;
	
	int clModifier; //Aun no funciona / hay que plantearlo de otra manera
	
	public SpellCasting(Info instigator,Spell spell) {
		super(instigator);
		this.spell=spell;
		setResult(SUCCESS);
		clModifier=0;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
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
	
	
	public void setClModifier(int clModifier) {
		this.clModifier = clModifier;
	}
	
	public int getClModifier() {
		return clModifier;
	}
	
	public void modifyCl(int amount){
		clModifier+=amount;
	}
}
