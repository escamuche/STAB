package com.stab.data.info.equipment;

import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.TraitFactory;

public class WeaponFactory extends TraitFactory{

	
	
	
	
	public Weapon getWeapon(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Weapon)w;
		//log
		return null;
	}
	
	
	
	public  void init(){
		super.init();
		
		BasicWeapon w;
		
		
		w=new BasicWeapon("gauntlet",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("GAUNTLET",w);
		
		w=new BasicWeapon("unarmed",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("UNARMED",w);
		
		w=new BasicWeapon("dagger",1,4,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("DAGGER",w);
		
		w=new BasicWeapon("punchingdagger",1,4,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("PUNCHINGDAGGER",w);
		
		w=new BasicWeapon("spikedgauntlet",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SPIKEDGAUNTLET",w);
		
		w=new BasicWeapon("lightmace",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LIGHTMACE",w);
		
		w=new BasicWeapon("sickle",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SICKLE",w);
		
		w=new BasicWeapon("club",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("CLUB",w);
		
		w=new BasicWeapon("heavymace",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("HEAVYMACE",w);
		
		w=new BasicWeapon("morningstar",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("MORNINGSTAR",w);
		
		w=new BasicWeapon("shortspear",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SHORTSPEAR",w);
		
		w=new BasicWeapon("longspear",1,8,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LONGSPEAR",w);
		
		w=new BasicWeapon("quarterstaff",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("QUARTERSTAFF",w);
		
		w=new BasicWeapon("spear",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("SPEAR",w);
		
		w=new BasicWeapon("blowgun",1,2,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("BLOWGUN",w);
		
		w=new BasicWeapon("heavycrossbow",1,10,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("HEAVYCROSSBOW",w);
		
		w=new BasicWeapon("lightcrossbow",1,8,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("LIGHTCROSSBOW",w);
		
		w=new BasicWeapon("dart",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("DART",w);
		
		w=new BasicWeapon("javelin",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("JAVELIN",w);
		
		w=new BasicWeapon("sling",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SLING",w);
		
		w=new BasicWeapon("throwingaxe",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("THROWINGAXE",w);
		
		w=new BasicWeapon("lighthammer",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LIGHTHAMMER",w);
		
		w=new BasicWeapon("handaxe",1,6,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("HANDAXE",w);
		
		w=new BasicWeapon("kukri",1,4,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register("KUKRI",w);
		
		w=new BasicWeapon("lightpick",1,4,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register("LIGHTPICK",w);
		
		w=new BasicWeapon("sap",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SAP",w);
		
		w=new BasicWeapon("lightshield",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LIGHTSHIELD",w);
		
		w=new BasicWeapon("spikedarmor",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SPIKEDARMOR",w);
		
		w=new BasicWeapon("lightspikedshield",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("LIGHTSPIKEDSHIELD",w);
		
		w=new BasicWeapon("starknife",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("STARKNIFE",w);
		
		w=new BasicWeapon("shortsword",1,6,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("SHORTSWORD",w);
		
		w=new BasicWeapon("battleaxe",1,8,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("BATTLEAXE",w);
		
		w=new BasicWeapon("flail",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("FLAIL",w);
		
		w=new BasicWeapon("longsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("LONGSWORD",w);
		
		w=new BasicWeapon("heavypick",1,6,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register("HEAVYPICK",w);
		
		w=new BasicWeapon("rapier",1,6,Damage.PIERCING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register("RAPIER",w);
		
		w=new BasicWeapon("scimitar",1,6,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register("SCIMITAR",w);
		
		w=new BasicWeapon("heavyshield",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("HEAVYSHIELD",w);
		
		w=new BasicWeapon("heavyspikedshield",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("HEAVYSPIKEDSHIELD",w);
		
		w=new BasicWeapon("trident",1,8,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("TRIDENT",w);
		
		w=new BasicWeapon("warhammer",1,8,Damage.IMPACT_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("WARHAMMER",w);
		
		w=new BasicWeapon("falchion",2,4,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register("FALCHION",w);
		
		w=new BasicWeapon("glaive",1,10,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("GLAIVE",w);
		
		w=new BasicWeapon("greataxe",1,12,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("GREATAXE",w);
		
		w=new BasicWeapon("greatclub",1,10,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("GREATCLUB",w);
		
		w=new BasicWeapon("heavyflail",1,10,Damage.IMPACT_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("HEAVYFLAIL",w);
		
		w=new BasicWeapon("greatsword",2,6,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("GREATSWORD",w);
		
		w=new BasicWeapon("guisarme",2,4,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("GUISARME",w);
		
		w=new BasicWeapon("halberd",1,10,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("HALBERD",w);
		
		w=new BasicWeapon("lance",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("LANCE",w);
		
		w=new BasicWeapon("ranseur",2,4,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("RANSEUR",w);
		
		w=new BasicWeapon("scythe",2,4,Damage.SLASHING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register("SCYTHE",w);
		
		w=new BasicWeapon("longbow",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("LONGBOW",w);
		
		w=new BasicWeapon("compositelongbow",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("COMPOSITELONGBOW",w);
	
		w=new BasicWeapon("shortbow",1,6,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("SHORTBOW",w);
	
		w=new BasicWeapon("compositeshortbow",1,6,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("COMPOSITESHORTBOW",w);
	
		w=new BasicWeapon("kama",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("KAMA",w);
	
		w=new BasicWeapon("nunchaku",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("NUNCHAKU",w);
	
		w=new BasicWeapon("sai",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SAI",w);
		
		w=new BasicWeapon("siangham",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("KUKRI",w);
		
		w=new BasicWeapon("bastardsword",1,10,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("BASTARDSWORD",w);
		
		w=new BasicWeapon("dwarvenwaraxe",1,10,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("DWARVENAXE",w);

		w=new BasicWeapon("whip",1,3,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("WHIP",w);
	
		w=new BasicWeapon("orcdoubleaxe",1,8,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("ORCDOUBLEAXE",w);
	
		w=new BasicWeapon("spikedchain",2,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SPIKEDCHAIN",w);
	
		w=new BasicWeapon("elvencurveblade",1,10,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register("ELVENCURVEBLADE",w);
		
		w=new BasicWeapon("direflail",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("DIREFLAIL",w);
		
		w=new BasicWeapon("gnomehookedhammer",1,6,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register("GNOMEHOOKEDHAMMER",w);
		
		w=new BasicWeapon("twobladedsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("TWOBLADEDSWORD",w);
		
		w=new BasicWeapon("dwarvenurgrosh",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("DWARVENURGROSH",w);
		
		w=new BasicWeapon("bolas",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("KUKRI",w);
		
		w=new BasicWeapon("handcrossbow",1,4,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("HANDCROSSBOW",w);
		
		w=new BasicWeapon("repeatingheavycrossbow",1,10,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("REPEATINGHEAVYCROSSBOW",w);
		
		w=new BasicWeapon("repeatinglightcrossbow",1,8,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register("REPEATINGLIGHTCROSSBOW",w);
		
		w=new BasicWeapon("shuriken",1,2,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register("SHURIKEN",w);
		
		w=new BasicWeapon("halflingslingstaff",1,8,Damage.IMPACT_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register("HALFLINGSLINGSTAFF",w);	
		
	}
	
	
}
