package com.stab.data.info.buff;

import com.stab.data.StabConstants;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.BuffEffect;

public class PowerAttack_Buff extends BuffEffect {

	public static final String ID="POWER_ATTACK_BUFF";
	
	public PowerAttack_Buff(int bab) {
		//setUnique(true);//no hace falta, por defecto los buffs son unicos
		
		this.setAnimIcon("actions/ability_backstab");					//Icono para la animacion
		this.setSound("HolyCast");										//Sonido para la animacion
		this.setResource("actions/ability_backstab");                   //El icono para la barra o para pintar los buffs en algun sitio
		this.setName("Power attack");
		
		//Usar uno de estos 3
		this.setPermanent();	//Efecto permanente
		//this.setTimed(x);    //Efecto que dura x rounds
		//this.setCharges(x);   //Efecto permanente hasta que se agoten x cargas (el efecto se las descuenta como corresponda)
		
		//setEvery(2); 		   //Es posible indicar que solo se ejecuta cada x turnos
		
		
		//Modificadores que aporta
		
		int v = (bab/4)+1;
		Modifier daño = new Modifier(StabConstants.DAMAGE, v*2);
		Modifier hit = new Modifier(StabConstants.TOHIT, v);
		addTrait(daño);
		addTrait(hit);
		
		
	}
}
