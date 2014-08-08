package com.stab.data.actions.player.spells;

import com.stab.data.actions.HasDescriptor;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public interface SpellProperties extends HasDescriptor{
  
	//Medio de transmision
	public static final int SELF=0;  //Solo en el caster (rango 0)
	public static final int TOUCH=1; //Toque
	public static final int RAY=2;   //rayo (tirada de ranged touch)
	public static final int MISSILE=3;//proyectil (tirada de ranged touch) (distinto para los weapon focus)
	public static final int SELECTED=4; //normal, LoE
	public static final int SIGHT=5; //LoS
	public static final int POINT=6; //Basta con que este en rango, no se necesita linea (raro, no creo que haya en pathfinder)
	

	
	//Alcance 
	//public static final int SELF=0; //Reusamos nombres porque estan repetidos
	//public static final int TOUCH=1; 
	public static final int CLOSE=2; //cerca, 5+(cl/2)
	public static final int MEDIUM=3; //medio 20+(cl*2)
	public static final int LONG=4; //largo 80+(cl*8)
	public static final int ANYWHERE=5; //100000
	public static final int FIXED=100; //especial o fijo por conjuro (porbablemente esta constante sobre)
	
	
	//Duracion
	//public static final int INSTANT=-1;  //no aplicable, o en todo caso, hasta el final del round
	public static final int ROUND=1;   //1 round
	public static final int SHORT=2;  //1 round per CL 
	//public static final int MEDIUM=2; //10 round per CL
	//public static final int LONG=4; //600 round per CL
	public static final int PERMANENT=-3; //Hasta que se gaste por otro modo, o simplemente permanente
	
	
	//Casting time
	public static final int INSTANT=-1;
	public static final int STANDARD=0;
	public static final int FULLACTION=0;//TODO: revisar en su momento
	public static final int FULLROUND=1;
	
	
	public int getLevel();
	public String getAttribute();
	public int getDC(BaseInfo caster);
	public String getCasterClass();
	public int getRange(Info caster);
	public int getCasterLevel(BaseInfo caster);
	public String getSave();
	public int getMedium();
	public boolean isWeaponChargeSpell();
	public boolean canCast(BaseInfo caster);
	public boolean isAffectedBySR();
	public SavingThrowEffect getSavingThrow(BaseInfo caster,BaseInfo target);
	public boolean isSomatic();
	public boolean isVerbal(); 
	public boolean isSubjectToArcaneArmorFailure();
	public int getDuration();
	
	
	
}
