package com.stab.data.info.applicable;

import com.stab.data.StabConstants;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.util.Roll;

public class Attack extends Applicable{

	
	public static final int HIT = 0;
	public static final int MISS = 10;
	public static final int CRITICAL= 5;
	public static final int BOTCH = 11;

	//En un futuro añadir o reutilizar los que hay para "le has dado a una imagen" o "fallo por concealment", etc
	//Añadir tambien si ha sido CA, dodge, cover, parry o block lo que ha parado el ataque (con vistas a animacion)
	
	int modificador=0;  //Modificador particular para este ataque. Las clases que Attends<Attack> iran añadiendo 
						//Modificadores (ej:  proteccion contra el mal, que representa un +2 a la ca, se aplica como ponerle un -2 a 
						//la tirada
	
	int critRange=1;   //Rango de critico
	int confirmMod=0;  //Bono a confirmar
	int ac=10;	  //La ca a dar
	int hit=0;   //El bono a la tirada
	
	public Attack(BaseInfo instigator) {
		super(instigator);
	}
	
	public void addModifier(int m){
		modificador+=m;
	}

	public int getModifier() {
		return modificador;
	}
	
	public void setCritRange(int critRange) {
		this.critRange = critRange;
	}
	public void setConfirmMod(int confirmMod) {
		this.confirmMod = confirmMod;
	}
	public void setAC(int ac) {
		this.ac = ac;
	}
	
	@Override
	public void setInstigator(Info instigator) {
		super.setInstigator(instigator);
		hit=((BaseInfo)instigator).getValue(StabConstants.TOHIT);
	}
	
	@Override
	public void setTarget(BaseInfo target) {
		super.setTarget(target);
		setAC(target.getValue(StabConstants.ARMOR));
	}

	@Override
	public void apply() {
		BaseInfo aMatar = getTarget();
		BaseInfo elqueMata = (BaseInfo) getInstigator();
		
		
		int dado = Roll.d20();

		ac=ac; 

		hit=hit+modificador;
		System.out.println(dado + " en el dado!");
		
		
		if (dado >= (21-critRange)) {
			System.out.println("Posibilidad de Critico!");
			int confirc=Roll.d20();
			int caconfirc=hit + confirc+ confirmMod;
			if(ac <= caconfirc) {
				System.out.println("Critico!!!");
				setResult(CRITICAL);
			   	}
			else{
				System.out.println("Fallaste la confirmacion!");
				setResult(HIT);
				}
			}
		
		
		if (dado == 1) {
			System.out.println("Posibilidad de Pifia!");
		    int confirp=Roll.d20();
		    int caconfirp=hit + confirp+ confirmMod;
		    if(ac <= caconfirp) {
		    	System.out.println("Casi!");
		    	setResult(MISS);
		    	}
		    	else{
		    		System.out.println("Pifia!!!");
		    		setResult(BOTCH);
		    		}
			}
		
		
		int dar = elqueMata.getValue(StabConstants.TOHIT) + dado;
		System.out.println("Impactas a armadura " + dar);
	
		if (ac <= dar) { //si das a ca
			setResult(HIT);
		}
		else{
			setResult(MISS);
		}
					
	}
	
	public boolean hits(){
		return getResult()==HIT || getResult()==CRITICAL;
	}
	
	public boolean misses(){
		return !hits();
	}
	
	public boolean isCritical(){
		return getResult()==CRITICAL;
	}
	public boolean isBotch(){
		return getResult()==BOTCH;
	}
	
	@Override
	public void validate() {
		
	}
}
