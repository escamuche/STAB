package com.stab.data;

import java.lang.reflect.Field;

public class StabConstants {
	
	
	//Constantes de comportamiento
	
	public static final boolean USEMAXHPFORMONSTERS=true;

	
	//Atributos
	public static final String MAXHP="MAXHP";
	public static final String MAXMP="MAXMP";
	public static final String SIZE="SIZE";
	public static final String TOHIT="TOHIT";
	public static final String ARMOR="ARMOR";
	public static final String EXPERIENCE="EXPERIENCE";
	public static final String DAMAGE = "DAMAGE";
	public static final String TOHITRANGED="TOHITRANGED";
	public static final String DAMAGERANGED="DAMAGERANGED";
	public static final String DC="DC";	
	public static final String STRENGHT="STRENGHT";
	public static final String DEXTERITY="DEXTERITY";
	public static final String CONSTITUTION="CONSTITUTION";
	public static final String INTELIGENCE="INTELIGENCE";
	public static final String WISDOM="WISDOM";
	public static final String CHARISMA="CHARISMA";
	public static final String DAMAGEREDUCTION="DAMAGEREDUCTION"; //Este mejor como trait attends<Damage>

	public static final String BASESPEED="BASESPEED";
	public static final String ARMORMODSPEED="ARMORMODSPEED";
	
	
	public static final String FORTITUDESAVE="FORTITUDESAVE";    
	public static final String REFLEXSAVE="REFLEXSAVE";
	public static final String WILLSAVE="WILLSAVE";
	public static final String BAB="BAB";
	public static final String SPELLRESISTANCE="SPELLRESISTANCE";
	public static final String CMB="CMB";
	
	//public static final String CMDTRIP="CMDTRIP";	///Esto mejor por trait implements Attend<BullRush>
	//public static final String CMDBULLRUSH="CMDBULLRUSH";
	//public static final String CMDDISARM="CMDDISARM";
	//public static final String CMDGRAPPLE="CMDGRAPPLE";
	//public static final String CMDOVERRUN="CMDOVERRUN";
	//public static final String CMDSUNDER="CMDSUNDER";
	
	//En una primera aproximacion meteria solo los basicos
	public static final String ACROBATICS="ACROBATICS";
	public static final String APPRAISE="APPRAISE";
	public static final String BLUFF="BLUFF";
	public static final String CLIMB="CLIMB";
	public static final String CRAFTALCHEMY="CRAFTALCHEMY";
	public static final String DIPLOMACY="DIPLOMACY";
	public static final String CRAFTARMOR="CRAFTARMOR";
	public static final String CRAFTBOWS="CRAFTBOWS";
	public static final String CRAFTTRAPS="CRAFTTRAPS";
	public static final String CRAFTWEAPON="CRAFTWEAPON";
	public static final String CRAFTVARIES="CRAFTVARIES";
	public static final String DISABLEDEVICES="DISABLEDEVICES";
	public static final String DISGUISE="DISGUISE";
	public static final String ESCAPEARTIST="ESCAPEARTIST";
	public static final String FLYSKILL="FLYSKILL";
	public static final String HANDLEANIMAL="HANDLEANIMAL";
	public static final String HEALSKILL="HEALSKILL";
	public static final String INTIMIDATE="INTIMIDATE";
	public static final String KNOWLEDGEARCANA="KNOWLEDGEARCANA";
	public static final String KNOWLEDGEDUNGEONEERING="KNOWLEDGEDUNDEONEERING";
	public static final String KNOWLEDGEENGINEERING="KNODLEDGEENGINEERING";
	public static final String KNOWLEDGEGREOGRAPPHY="KNOWLEDGEGEOGRAPHY";
	public static final String KNOWLEDGEHISTORY="KNOWLEDGEHISTORY";
	public static final String KNOWLEDGELOCAL="KNOWLEDGELOCAL";
	public static final String KNOWLEDGENATURE="KNOWLEDGENATURE";
	public static final String KNOWLEDGENOBILITY="KNOWLEDGENOBILITY";
	public static final String KNOWLEDGEPLANES="KNOWLEDGEPLANES";
	public static final String KNOWLEDGERELIGION="KNOWLEDGERELIGION";
	public static final String LINGUISTIC="LINGUISTIC";
	public static final String PERCEPTION="PERCEPTION";
	public static final String PERFORMACT="PERFORMACT";
	public static final String PERFORMCOMEDY="PERFORMCOMEDY";
	public static final String PERFORMDANCE="PERFORMDANCE";
	public static final String PERFORMKEYBOARD="PERFORMKEYBOARD";
	public static final String PERFORMORATORY="PERFORMORATORY";
	public static final String PERFORMPERCUSION="PERFORMPERCUSION";
	public static final String PERFORMSTRING="PERFORMSTRING";
	public static final String PERFORMWIND="PERFORMWIND";
	public static final String PERFORMSING="PERFORMSING";
	public static final String PROFESSIONSKILL="PROFESSIONSKILL";
	public static final String RIDE="RIDE";
	public static final String SENSEMOTIVE="SENSEMOTIVE";
	public static final String SLEIGHTOFHAND="SLEIGHTOFHAND";
	public static final String SPELLCRAFT="SPELLCRAFT";
	public static final String STEALTH="STEALTH";
	public static final String SURVIVAL="SURVIVAL";
	public static final String SWIMSKILL="SWIMSKILL";
	public static final String USEMAGICDEVICE="USEMAGICDEVICE";
	
	
	
	
	//Podemos empezar solo con gold?
	public static final String MONEYPLATINUM="MONEYPLATINUM";
	public static final String MONEYGOLD="MONEYGOLD";
	public static final String MONEYSILVER="MONEYSILVER";
	public static final String MONEYCOPPER="MONEYCOPPER";
	
	
	public static final String SPELLKNOWN0="SPELLKNOWN0";
	public static final String SPELLKNOWN1="SPELLKNOWN1";
	public static final String SPELLKNOWN2="SPELLKNOWN2";
	public static final String SPELLKNOWN3="SPELLKNOWN3";
	public static final String SPELLKNOWN4="SPELLKNOWN4";
	public static final String SPELLKNOWN5="SPELLKNOWN5";
	public static final String SPELLKNOWN6="SPELLKNOWN6";
	public static final String SPELLKNOWN7="SPELLKNOWN7";
	public static final String SPELLKNOWN8="SPELLKNOWN8";
	public static final String SPELLKNOWN9="SPELLKNOWN9";
	
//	public static final String CASTERLEVEL="CASTERLEVEL";
/*	public static final String CASTERLEVELBARD="CASTERLEVELBARD";
	public static final String CASTERLEVELCLERIC="CASTERLEVELCLERIC";
	public static final String CASTERLEVELDRUID="CASTERLEVELDRUID";
	public static final String CASTERLEVELPALADIN="CASTERLEVELPALADIN";
	public static final String CASTERLEVELRANGER="CASTERLEVELRANGER";
	public static final String CASTERLEVELSORCERER="CASTERLEVELSORCERER";
	public static final String CASTERLEVELWIZARD="CASTERLEVELWIZARD";
/**/	
	public static final String LEVEL="LEVEL";
	public static final String WIZARDCASTER="WIZARDCASTER";
	public static final String CLERICCASTER="CLERICCASTER";
	public static final String BARDCASTER="BARDCASTER";
	public static final String DRUIDCASTER="DRUIDCASTER";
	public static final String PALADINCASTER="PALADINCASTER";
	public static final String SORCERERCASTER="SORCERERCASTER";
	public static final String RANGERCASTER="RANGERCASTER";
	
	public static final String LUCKMOD="LUCKMOD";
	public static final String SACREDMOD="SACREDMOD";
	public static final String COMPETENCEMOD="COMPETENCEMOD";
	public static final String DODGEMOD=null; //Para que se trate como untyped y se acumule
	public static final String NATURALARMORMOD="NATURALARMORMOD";
	public static final String DEFLECTIONMOD="DEFLECTIONMOD";
	public static final String INSIGHTMOD="INSIGHTMOD";
	public static final String ENHANCEMENTMOD="ENHANCEMENTMOD";
	public static final String SHIELDMOD="SHIELDMOD";
	public static final String ARMORMOD="ARMORMOD";
	public static final String SIZEMOD="SIZEMOD";
	public static final String RACIALMOD="RACIALMOD";
	public static final String MISCELANEOMOD="MISCELANEOMOD";
	public static final String AGEMOD="AGEMOD";
	public static final String MORALMOD="MORALMOD";
	public static final String RESISTANCEMOD="RESISTANCEMOD";
	public static final String INICIATIVEMOD="INICIATIVEMOD";
	public static final String XP="XP";
	
	public static final String PASSIVEDEFENSE="PASSIVEDEFENSE";
	public static final String ACTIVEDEFENSE="ACTIVEDEFENSE";
	public static final String SHIELDDEFENSE="SHIELDDEFENSE";
	public static final String ARMORDEFENSE="ARMORDEFENSE";
	public static final String AC="AC";  //CA calculada, para ayudar a los logs
	
	public static final String ARMORCHECKPENALTY="ARMORCHECKPENALTY";
	public static final String SPELLFAILURE="SPELLFAILURE";
	public static final String DEXLIMIT="DEXLIMIT";
	
	public static final int FINE_SIZE=0;
	public static final int DIMINUTE_SIZE=1;
	public static final int TINY_SIZE=2;
	public static final int SMALL_SIZE=3;
	public static final int MEDIUM_SIZE=4;
	public static final int LARGE_SIZE=5;
	public static final int HUGE_SIZE=6;
	public static final int GARGANTUAN_SIZE=7;
	public static final int COLOSSAL_SIZE=8;
	
	public static final String HITDICETYPE="HITDICETYPE";
	public static final String HITDICENUMBER="HITDICENUMBER";
	
	public static final String RAGEROUNDS="RAGEROUNDS";
	public static final String RAGEROUNDSSPENT="RAGEROUNDSSPENT";	
	
	
	
	public static final String PERCEPTION_DC="PERCEPTION_DC"; //La dificultad para detectarlo con search (trampas, oculto, etc)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String getString(String table) {
		try{
			Field f=StabConstants.class.getDeclaredField(table);
			return	f.get(null).toString();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("No existe la constante "+table);
		}
		return null;
	}
	
}
