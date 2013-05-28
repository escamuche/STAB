package com.stab.data.info.equipment;

import com.stab.data.animation.LungeAnimation;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.model.info.applicable.base.Damage;

public class WeaponFactory extends ItemFactory{

	
	
	
	
	public static final String HALFLINGSLINGSTAFF = "HALFLINGSLINGSTAFF";
	public static final String SHURIKEN = "SHURIKEN";
	public static final String REPEATINGLIGHTCROSSBOW = "REPEATINGLIGHTCROSSBOW";
	public static final String REPEATINGHEAVYCROSSBOW = "REPEATINGHEAVYCROSSBOW";
	public static final String HANDCROSSBOW = "HANDCROSSBOW";
	public static final String BOLAS = "BOLAS";
	public static final String DWARVENURGROSH = "DWARVENURGROSH";
	public static final String TWOBLADEDSWORD = "TWOBLADEDSWORD";
	public static final String GNOMEHOOKEDHAMMER = "GNOMEHOOKEDHAMMER";
	public static final String DIREFLAIL = "DIREFLAIL";
	public static final String ELVENCURVEBLADE = "ELVENCURVEBLADE";
	public static final String SPIKEDCHAIN = "SPIKEDCHAIN";
	public static final String ORCDOUBLEAXE = "ORCDOUBLEAXE";
	public static final String WHIP = "WHIP";
	public static final String DWARVENAXE = "DWARVENAXE";
	public static final String BASTARDSWORD = "BASTARDSWORD";
	public static final String SIANGHAM = "SIANGHAM";
	public static final String SAI = "SAI";
	public static final String NUNCHAKU = "NUNCHAKU";
	public static final String KAMA = "KAMA";
	public static final String COMPOSITESHORTBOW = "COMPOSITESHORTBOW";
	public static final String SHORTBOW = "SHORTBOW";
	public static final String COMPOSITELONGBOW = "COMPOSITELONGBOW";
	public static final String LONGBOW = "LONGBOW";
	public static final String SCYTHE = "SCYTHE";
	public static final String RANSEUR = "RANSEUR";
	public static final String LANCE = "LANCE";
	public static final String HALBERD = "HALBERD";
	public static final String GUISARME = "GUISARME";
	public static final String GREATSWORD = "GREATSWORD";
	public static final String HEAVYFLAIL = "HEAVYFLAIL";
	public static final String GREATCLUB = "GREATCLUB";
	public static final String GREATAXE = "GREATAXE";
	public static final String GLAIVE = "GLAIVE";
	public static final String FALCHION = "FALCHION";
	public static final String WARHAMMER = "WARHAMMER";
	public static final String TRIDENT = "TRIDENT";
	public static final String HEAVYSPIKEDSHIELD = "HEAVYSPIKEDSHIELD";
	public static final String HEAVYSHIELD = "HEAVYSHIELD";
	public static final String SCIMITAR = "SCIMITAR";
	public static final String RAPIER = "RAPIER";
	public static final String HEAVYPICK = "HEAVYPICK";
	public static final String LONGSWORD = "LONGSWORD";
	public static final String FLAIL = "FLAIL";
	public static final String BATTLEAXE = "BATTLEAXE";
	public static final String SHORTSWORD = "SHORTSWORD";
	public static final String STARKNIFE = "STARKNIFE";
	public static final String LIGHTSPIKEDSHIELD = "LIGHTSPIKEDSHIELD";
	public static final String SPIKEDARMOR = "SPIKEDARMOR";
	public static final String LIGHTSHIELD = "LIGHTSHIELD";
	public static final String SAP = "SAP";
	public static final String LIGHTPICK = "LIGHTPICK";
	public static final String KUKRI = "KUKRI";
	public static final String HANDAXE = "HANDAXE";
	public static final String LIGHTHAMMER = "LIGHTHAMMER";
	public static final String THROWINGAXE = "THROWINGAXE";
	public static final String SLING = "SLING";
	public static final String JAVELIN = "JAVELIN";
	public static final String DART = "DART";
	public static final String LIGHTCROSSBOW = "LIGHTCROSSBOW";
	public static final String HEAVYCROSSBOW = "HEAVYCROSSBOW";
	public static final String BLOWGUN = "BLOWGUN";
	public static final String SPEAR = "SPEAR";
	public static final String QUARTERSTAFF = "QUARTERSTAFF";
	public static final String LONGSPEAR = "LONGSPEAR";
	public static final String SHORTSPEAR = "SHORTSPEAR";
	public static final String MORNINGSTAR = "MORNINGSTAR";
	public static final String HEAVYMACE = "HEAVYMACE";
	public static final String CLUB = "CLUB";
	public static final String SICKLE = "SICKLE";
	public static final String LIGHTMACE = "LIGHTMACE";
	public static final String SPIKEDGAUNTLET = "SPIKEDGAUNTLET";
	public static final String PUNCHINGDAGGER = "PUNCHINGDAGGER";
	public static final String DAGGER = "DAGGER";
	public static final String UNARMED = "UNARMED";
	public static final String GAUNTLET = "GAUNTLET";
	public static final String MEDIUMSLAM = "MEDIUMSLAM";
	public static final String SMALLBITE = "SMALLBITE";
	public static final String MEDIUMCLAW = "MEDIUMCLAW";
	public static final String MEDIUMBITE = "MEDIUMBITE";
	
	public static final String RAY = "RAY";
	public static final String MISSILE = "MISSILE";
	public static final String TOUCH = "TOUCH";


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
		
		
		//Para hechizos
		w=new BasicWeapon("Ray",0,1,Damage.GENERIC_DAMAGE,"PARTICLE#rayOfFrost",ShootBeamAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		w.setTouch(true);
		register(RAY,w);
		w=new BasicWeapon("Missile",0,1,Damage.GENERIC_DAMAGE, "PARTICLE#magicmissile",ShootProyectileAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		w.setTouch(true);
		register(MISSILE,w);
		w=new BasicWeapon("Touch",0,1,Damage.GENERIC_DAMAGE,"effects/touch",ThrustAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		w.setTouch(true);
		register(TOUCH,w);
		
		//Armas de criaturas
		w=new BasicWeapon("Claw",1,6,Damage.SLASHING_DAMAGE,"effects/zombieclaw",SwingAnimation.ID);
		register(MEDIUMCLAW,w);
		w=new BasicWeapon("Bite",1,4,Damage.PIERCING_DAMAGE,"effects/zombieclaw",LungeAnimation.ID);
		register(SMALLBITE,w);
		w=new BasicWeapon("Slam",1,6,Damage.IMPACT_DAMAGE,"effects/zombieclaw",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(MEDIUMSLAM,w);
		w=new BasicWeapon("Bite",1,6,Damage.PIERCING_DAMAGE,"effects/zombieclaw",LungeAnimation.ID);
		register(MEDIUMBITE,w);
		
		//Armas
		
		
		w=new BasicWeapon("gauntlet",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(GAUNTLET,w);
		
		w=new BasicWeapon("unarmed",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(UNARMED,w);
		
		w=new BasicWeapon("dagger",1,4,Damage.PIERCING_DAMAGE,2,2,"effects/dagger",ThrustAnimation.ID);
		register(DAGGER,w);
		
		w=new BasicWeapon("punchingdagger",1,4,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register(PUNCHINGDAGGER,w);
		
		w=new BasicWeapon("spikedgauntlet",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SPIKEDGAUNTLET,w);
		
		w=new BasicWeapon("lightmace",1,6,Damage.IMPACT_DAMAGE,"effects/lightmace",SwingAnimation.ID);
		register(LIGHTMACE,w);
		
		w=new BasicWeapon("sickle",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SICKLE,w);
		
		w=new BasicWeapon("club",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(CLUB,w);
		
		w=new BasicWeapon("heavymace",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYMACE,w);
		
		w=new BasicWeapon("morningstar",1,8,Damage.IMPACT_DAMAGE,"effects/morningstar",SwingAnimation.ID);
		register(MORNINGSTAR,w);
		
		w=new BasicWeapon("shortspear",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SHORTSPEAR,w);
		
		w=new BasicWeapon("longspear",1,8,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(LONGSPEAR,w);
		
		w=new BasicWeapon("quarterstaff",1,6,Damage.IMPACT_DAMAGE,"effects/WizardAttack",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(QUARTERSTAFF,w);
		
		w=new BasicWeapon("spear",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(SPEAR,w);
		 
		w=new RangedWeapon("blowgun",1,2,Damage.PIERCING_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(BLOWGUN,w);
		
		w=new RangedWeapon("heavycrossbow",1,10,Damage.PIERCING_DAMAGE,2,2,"effects/sword",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(HEAVYCROSSBOW,w);
		
		w=new RangedWeapon("lightcrossbow",1,8,Damage.PIERCING_DAMAGE,2,2,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(LIGHTCROSSBOW,w);
		
		w=new RangedWeapon("dart",1,4,Damage.PIERCING_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(DART,w);
		
		w=new RangedWeapon("javelin",1,6,Damage.PIERCING_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(JAVELIN,w);
		
		w=new RangedWeapon("sling",1,4,Damage.IMPACT_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(SLING,w);
		
		w=new RangedWeapon("throwingaxe",1,6,Damage.SLASHING_DAMAGE,"effects/axe",ShootProyectileAnimation.ID);
		register(THROWINGAXE,w);
		
		w=new BasicWeapon("lighthammer",1,4,Damage.IMPACT_DAMAGE,"effects/hammer",SwingAnimation.ID);
		register(LIGHTHAMMER,w);
		
		w=new BasicWeapon("handaxe",1,6,Damage.SLASHING_DAMAGE,1,3,"effects/axe",SwingAnimation.ID);
		register(HANDAXE,w);
		
		w=new BasicWeapon("kukri",1,4,Damage.SLASHING_DAMAGE,3,2,"effects/kukri",SwingAnimation.ID);
		register("KUKRI",w);
		
		w=new BasicWeapon("lightpick",1,4,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register(LIGHTPICK,w);
		
		w=new BasicWeapon("sap",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SAP,w);
		
		w=new BasicWeapon("lightshield",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(LIGHTSHIELD,w);
		
		w=new BasicWeapon("spikedarmor",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SPIKEDARMOR,w);
		
		w=new BasicWeapon("lightspikedshield",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(LIGHTSPIKEDSHIELD,w);
		
		w=new BasicWeapon("starknife",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(STARKNIFE,w);
		
		w=new BasicWeapon("shortsword",1,6,Damage.PIERCING_DAMAGE,2,2,"effects/shortsword",ThrustAnimation.ID);
		register(SHORTSWORD,w);
		
		w=new BasicWeapon("battleaxe",1,8,Damage.SLASHING_DAMAGE,1,3,"effects/battleaxe",SwingAnimation.ID);
		register(BATTLEAXE,w);
		
		w=new BasicWeapon("flail",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(FLAIL,w);
		
		w=new BasicWeapon("longsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register(LONGSWORD,w);
		
		w=new BasicWeapon("heavypick",1,6,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register(HEAVYPICK,w);
		
		w=new BasicWeapon("rapier",1,6,Damage.PIERCING_DAMAGE,3,2,"effects/rapier",ThrustAnimation.ID);
		register(RAPIER,w);
		
		w=new BasicWeapon("scimitar",1,6,Damage.SLASHING_DAMAGE,3,2,"effects/scimitar",SwingAnimation.ID);
		register(SCIMITAR,w);
		
		w=new BasicWeapon("heavyshield",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYSHIELD,w);
		
		w=new BasicWeapon("heavyspikedshield",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYSPIKEDSHIELD,w);
		
		w=new BasicWeapon("trident",1,8,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(TRIDENT,w);
		
		w=new BasicWeapon("warhammer",1,8,Damage.IMPACT_DAMAGE,1,3,"effects/warhammer",SwingAnimation.ID);
		register(WARHAMMER,w);
		
		w=new BasicWeapon("falchion",2,4,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(FALCHION,w);
		
		w=new BasicWeapon("glaive",1,10,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GLAIVE,w);
		
		w=new BasicWeapon("greataxe",1,12,Damage.SLASHING_DAMAGE,1,3,"effects/battleaxe",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GREATAXE,w);
		
		w=new BasicWeapon("greatclub",1,10,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GREATCLUB,w);
		
		w=new BasicWeapon("heavyflail",1,10,Damage.IMPACT_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(HEAVYFLAIL,w);
		
		w=new BasicWeapon("greatsword",2,6,Damage.SLASHING_DAMAGE,2,2,"effects/bastardsword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GREATSWORD,w);
		
		w=new BasicWeapon("guisarme",2,4,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GUISARME,w);
		
		w=new BasicWeapon("halberd",1,10,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(HALBERD,w);
		
		w=new BasicWeapon("lance",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(LANCE,w);
		
		w=new BasicWeapon("ranseur",2,4,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(RANSEUR,w);
		
		w=new BasicWeapon("scythe",2,4,Damage.SLASHING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(SCYTHE,w);
		
		w=new RangedWeapon("longbow",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(LONGBOW,w);
		
		w=new RangedWeapon("compositelongbow",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(COMPOSITELONGBOW,w);
	
		w=new RangedWeapon("shortbow",1,6,Damage.PIERCING_DAMAGE,1,3,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(SHORTBOW,w);
	
		w=new RangedWeapon("compositeshortbow",1,6,Damage.PIERCING_DAMAGE,1,3,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(COMPOSITESHORTBOW,w);
	
		w=new BasicWeapon("kama",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(KAMA,w);
	
		w=new BasicWeapon("nunchaku",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(NUNCHAKU,w);
	
		w=new BasicWeapon("sai",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SAI,w);
		
		w=new BasicWeapon("siangham",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SIANGHAM,w);
		
		w=new BasicWeapon("bastardsword",1,10,Damage.SLASHING_DAMAGE,2,2,"effects/bastardsword",SwingAnimation.ID);
		register(BASTARDSWORD,w);
		
		w=new BasicWeapon("dwarvenwaraxe",1,10,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(DWARVENAXE,w);

		w=new BasicWeapon("whip",1,3,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(WHIP,w);
	
		w=new BasicWeapon("orcdoubleaxe",1,8,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(ORCDOUBLEAXE,w);
	
		w=new BasicWeapon("spikedchain",2,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(SPIKEDCHAIN,w);
	
		w=new BasicWeapon("elvencurveblade",1,10,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(ELVENCURVEBLADE,w);
		
		w=new BasicWeapon("direflail",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(DIREFLAIL,w);
		
		w=new BasicWeapon("gnomehookedhammer",1,6,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GNOMEHOOKEDHAMMER,w);
		
		w=new BasicWeapon("twobladedsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(TWOBLADEDSWORD,w);
		
		w=new BasicWeapon("dwarvenurgrosh",1,8,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(DWARVENURGROSH,w);
		
		w=new BasicWeapon("bolas",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(BOLAS,w);
		
		w=new RangedWeapon("handcrossbow",1,4,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register(HANDCROSSBOW,w);
		
		w=new RangedWeapon("repeatingheavycrossbow",1,10,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(REPEATINGHEAVYCROSSBOW,w);
		
		w=new RangedWeapon("repeatinglightcrossbow",1,8,Damage.PIERCING_DAMAGE,2,2,"effects/arrow",ShootProyectileAnimation.ID);
		w.setTwoHanded(true);
		register(REPEATINGLIGHTCROSSBOW,w);
		
		w=new RangedWeapon("shuriken",1,2,Damage.PIERCING_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(SHURIKEN,w);
		
		w=new BasicWeapon("halflingslingstaff",1,8,Damage.IMPACT_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(HALFLINGSLINGSTAFF,w);	
		
	}
	
	
}
