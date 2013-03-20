package com.stab.data.info.equipment;

import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.trait.base.TraitFactory;

public class WeaponFactory extends TraitFactory{

	
	
	
	
	private static final String HALFLINGSLINGSTAFF = "HALFLINGSLINGSTAFF";
	private static final String SHURIKEN = "SHURIKEN";
	private static final String REPEATINGLIGHTCROSSBOW = "REPEATINGLIGHTCROSSBOW";
	private static final String REPEATINGHEAVYCROSSBOW = "REPEATINGHEAVYCROSSBOW";
	private static final String HANDCROSSBOW = "HANDCROSSBOW";
	private static final String BOLAS = "BOLAS";
	private static final String DWARVENURGROSH = "DWARVENURGROSH";
	private static final String TWOBLADEDSWORD = "TWOBLADEDSWORD";
	private static final String GNOMEHOOKEDHAMMER = "GNOMEHOOKEDHAMMER";
	private static final String DIREFLAIL = "DIREFLAIL";
	private static final String ELVENCURVEBLADE = "ELVENCURVEBLADE";
	private static final String SPIKEDCHAIN = "SPIKEDCHAIN";
	private static final String ORCDOUBLEAXE = "ORCDOUBLEAXE";
	private static final String WHIP = "WHIP";
	private static final String DWARVENAXE = "DWARVENAXE";
	private static final String BASTARDSWORD = "BASTARDSWORD";
	private static final String SIANGHAM = "SIANGHAM";
	private static final String SAI = "SAI";
	private static final String NUNCHAKU = "NUNCHAKU";
	private static final String KAMA = "KAMA";
	private static final String COMPOSITESHORTBOW = "COMPOSITESHORTBOW";
	private static final String SHORTBOW = "SHORTBOW";
	private static final String COMPOSITELONGBOW = "COMPOSITELONGBOW";
	private static final String LONGBOW = "LONGBOW";
	private static final String SCYTHE = "SCYTHE";
	private static final String RANSEUR = "RANSEUR";
	private static final String LANCE = "LANCE";
	private static final String HALBERD = "HALBERD";
	private static final String GUISARME = "GUISARME";
	private static final String GREATSWORD = "GREATSWORD";
	private static final String HEAVYFLAIL = "HEAVYFLAIL";
	private static final String GREATCLUB = "GREATCLUB";
	private static final String GREATAXE = "GREATAXE";
	private static final String GLAIVE = "GLAIVE";
	private static final String FALCHION = "FALCHION";
	private static final String WARHAMMER = "WARHAMMER";
	private static final String TRIDENT = "TRIDENT";
	private static final String HEAVYSPIKEDSHIELD = "HEAVYSPIKEDSHIELD";
	private static final String HEAVYSHIELD = "HEAVYSHIELD";
	private static final String SCIMITAR = "SCIMITAR";
	private static final String RAPIER = "RAPIER";
	private static final String HEAVYPICK = "HEAVYPICK";
	private static final String LONGSWORD = "LONGSWORD";
	private static final String FLAIL = "FLAIL";
	private static final String BATTLEAXE = "BATTLEAXE";
	private static final String SHORTSWORD = "SHORTSWORD";
	private static final String STARKNIFE = "STARKNIFE";
	private static final String LIGHTSPIKEDSHIELD = "LIGHTSPIKEDSHIELD";
	private static final String SPIKEDARMOR = "SPIKEDARMOR";
	private static final String LIGHTSHIELD = "LIGHTSHIELD";
	private static final String SAP = "SAP";
	private static final String LIGHTPICK = "LIGHTPICK";
	private static final String KUKRI = "KUKRI";
	private static final String HANDAXE = "HANDAXE";
	private static final String LIGHTHAMMER = "LIGHTHAMMER";
	private static final String THROWINGAXE = "THROWINGAXE";
	private static final String SLING = "SLING";
	private static final String JAVELIN = "JAVELIN";
	private static final String DART = "DART";
	private static final String LIGHTCROSSBOW = "LIGHTCROSSBOW";
	private static final String HEAVYCROSSBOW = "HEAVYCROSSBOW";
	private static final String BLOWGUN = "BLOWGUN";
	private static final String SPEAR = "SPEAR";
	private static final String QUARTERSTAFF = "QUARTERSTAFF";
	private static final String LONGSPEAR = "LONGSPEAR";
	private static final String SHORTSPEAR = "SHORTSPEAR";
	private static final String MORNINGSTAR = "MORNINGSTAR";
	private static final String HEAVYMACE = "HEAVYMACE";
	private static final String CLUB = "CLUB";
	private static final String SICKLE = "SICKLE";
	private static final String LIGHTMACE = "LIGHTMACE";
	private static final String SPIKEDGAUNTLET = "SPIKEDGAUNTLET";
	private static final String PUNCHINGDAGGER = "PUNCHINGDAGGER";
	private static final String DAGGER = "DAGGER";
	private static final String UNARMED = "UNARMED";
	private static final String GAUNTLET = "GAUNTLET";
	private static final String MEDIUMSLAM = "MEDIUMSLAM";
	private static final String SMALLBITE = "SMALLBITE";
	private static final String MEDIUMCLAW = "MEDIUMCLAW";
	
	private static final String RAY = "RAY";
	private static final String MISSILE = "MISSILE";
	private static final String TOUCH = "TOUCH";


	public Weapon getWeapon(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Weapon)w;
		//log
		return null;
	}
	
	
	
	public void register(String id, Weapon w) {
		super.register(id, w);
		if (w instanceof BasicWeapon){
			BasicWeapon bw=((BasicWeapon)w);
			if (bw.getBaseWeapon()==null)
				bw.setBaseWeapon(id);
			//TODO: en un futuro, icono a partir de eso mismo
		}
	}
	
	
	public  void init(){
		super.init();
		
		BasicWeapon w;
		
		
		//Para hechizos
		w=new BasicWeapon("Ray",0,1,Damage.GENERIC_DAMAGE,"",ShootBeamAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		register(RAY,w);
		w=new BasicWeapon("Missile",0,1,Damage.GENERIC_DAMAGE,"",ShootProyectileAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		register(MISSILE,w);
		w=new BasicWeapon("Touch",0,1,Damage.GENERIC_DAMAGE,"",SwingAnimation.ID);
		w.setCategory(BasicWeapon.SPECIAL);
		register(TOUCH,w);
		
		//Armas de criaturas
		w=new BasicWeapon("Claw",1,6,Damage.SLASHING_DAMAGE,"effects/zombieclaw",SwingAnimation.ID);
		register(MEDIUMCLAW,w);
		w=new BasicWeapon("Bite",1,4,Damage.PIERCING_DAMAGE,"effects/zombieclaw",SwingAnimation.ID);
		register(SMALLBITE,w);
		w=new BasicWeapon("Slam",1,6,Damage.IMPACT_DAMAGE,"effects/zombieclaw",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(MEDIUMSLAM,w);
		
		//Armas
		
		
		w=new BasicWeapon("gauntlet",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(GAUNTLET,w);
		
		w=new BasicWeapon("unarmed",1,3,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(UNARMED,w);
		
		w=new BasicWeapon("dagger",1,4,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register(DAGGER,w);
		
		w=new BasicWeapon("punchingdagger",1,4,Damage.PIERCING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register(PUNCHINGDAGGER,w);
		
		w=new BasicWeapon("spikedgauntlet",1,4,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SPIKEDGAUNTLET,w);
		
		w=new BasicWeapon("lightmace",1,6,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(LIGHTMACE,w);
		
		w=new BasicWeapon("sickle",1,6,Damage.SLASHING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(SICKLE,w);
		
		w=new BasicWeapon("club",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(CLUB,w);
		
		w=new BasicWeapon("heavymace",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYMACE,w);
		
		w=new BasicWeapon("morningstar",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
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
		
		w=new RangedWeapon("throwingaxe",1,6,Damage.SLASHING_DAMAGE,"effects/sword",ShootProyectileAnimation.ID);
		register(THROWINGAXE,w);
		
		w=new BasicWeapon("lighthammer",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(LIGHTHAMMER,w);
		
		w=new BasicWeapon("handaxe",1,6,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register(HANDAXE,w);
		
		w=new BasicWeapon("kukri",1,4,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
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
		
		w=new BasicWeapon("shortsword",1,6,Damage.PIERCING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register(SHORTSWORD,w);
		
		w=new BasicWeapon("battleaxe",1,8,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register(BATTLEAXE,w);
		
		w=new BasicWeapon("flail",1,8,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(FLAIL,w);
		
		w=new BasicWeapon("longsword",1,8,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		register(LONGSWORD,w);
		
		w=new BasicWeapon("heavypick",1,6,Damage.PIERCING_DAMAGE,1,4,"effects/sword",SwingAnimation.ID);
		register(HEAVYPICK,w);
		
		w=new BasicWeapon("rapier",1,6,Damage.PIERCING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register(RAPIER,w);
		
		w=new BasicWeapon("scimitar",1,6,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		register(SCIMITAR,w);
		
		w=new BasicWeapon("heavyshield",1,4,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYSHIELD,w);
		
		w=new BasicWeapon("heavyspikedshield",1,6,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(HEAVYSPIKEDSHIELD,w);
		
		w=new BasicWeapon("trident",1,8,Damage.PIERCING_DAMAGE,"effects/sword",SwingAnimation.ID);
		register(TRIDENT,w);
		
		w=new BasicWeapon("warhammer",1,8,Damage.IMPACT_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		register(WARHAMMER,w);
		
		w=new BasicWeapon("falchion",2,4,Damage.SLASHING_DAMAGE,3,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(FALCHION,w);
		
		w=new BasicWeapon("glaive",1,10,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GLAIVE,w);
		
		w=new BasicWeapon("greataxe",1,12,Damage.SLASHING_DAMAGE,1,3,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GREATAXE,w);
		
		w=new BasicWeapon("greatclub",1,10,Damage.IMPACT_DAMAGE,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(GREATCLUB,w);
		
		w=new BasicWeapon("heavyflail",1,10,Damage.IMPACT_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
		w.setTwoHanded(true);
		register(HEAVYFLAIL,w);
		
		w=new BasicWeapon("greatsword",2,6,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
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
		
		w=new BasicWeapon("bastardsword",1,10,Damage.SLASHING_DAMAGE,2,2,"effects/sword",SwingAnimation.ID);
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
