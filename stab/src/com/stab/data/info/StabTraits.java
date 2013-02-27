package com.stab.data.info;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Effect;
import com.stab.model.info.trait.Modifier;

/**
 * Repertorio de effectos y modificadores estaticos.
 * 
 * 
 * ESTONO FUNCIONA AUN, NO USAR, es solo una idea previa.
 *
 */
public class StabTraits {
	
	//Efectos varios
	public static Effect POWERATTACK; 
	public static Effect DEFENSE; 
	
	
	
	//Inicializacion
	static{
		
		POWERATTACK=Effect.createTurn("POWERATTACK",1,Modifier.createMod(StabConstants.DAMAGE, +2),Modifier.createMod(StabConstants.TOHIT, -1));
		POWERATTACK.setName("Power attack");
		//POWERATTACK.setResource();
		
		DEFENSE=Effect.createTurn("DEFENSE",1,Modifier.createMod(StabConstants.ARMOR, +2));
		
	}

}
