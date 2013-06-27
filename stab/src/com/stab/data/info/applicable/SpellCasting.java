package com.stab.data.info.applicable;

import com.stab.data.actions.player.spells.Spell;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;

public class SpellCasting extends Applicable {
	
	


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
		this.spell=spell;
		setResult(SUCCESS);
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		
	}

}
