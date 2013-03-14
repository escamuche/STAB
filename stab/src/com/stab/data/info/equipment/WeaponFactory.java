package com.stab.data.info.equipment;

import java.util.Hashtable;

import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.applicable.base.Damage;

public class WeaponFactory {

	
	
	Hashtable<String,BasicWeapon> weapons;
	
		
	
	public void register(String id, BasicWeapon w){
		weapons.put(id, w);
	}
	
	public  void init(){
		//Esta es incorrecta, como ejemplo
		BasicWeapon w=new BasicWeapon("longsword",1,8,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LONGSWORD",w);  //Notese que el identificador no tiene por que ser el nombre. el nombre es texto legible, el identificador es para uso interno nuestro
		
		//detras del tipo de daño van el rango de critico (1=20, 2=19-20, etc) y el multiplicador. Son opcionales, como se ve en el ejemplo
		//Por defecto son 1 y 2  (critico 20 x2)
		BasicWeapon w2=new BasicWeapon("longsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("LONGSWORD2",w2); 
		
		//ambiar eso por los valores correctos, vamos
		//Luego podemos pensarnos si extraer como constantes las cadenas de texto (eclipse puede hacerlo mas o menos automatico)
		
	}
	
}
