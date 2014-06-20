package com.stab.data.info.equipment;

import com.stab.model.info.trait.base.gear.ItemFactory;


public class ArmorFactory extends ItemFactory{

	
	
	
	
	public static final String TOWERSHIELD = "TOWERSHIELD";
	public static final String HEAVYSTEELSHIELD = "HEAVYSTEELSHIELD";
	public static final String HEAVYWOODENSHIELD = "HEAVYWOODENSHIELD";
	public static final String LIGHTSTEELSHIELD = "LIGHTSTEELSHIELD";
	public static final String LIGHTWOODENSHIELD = "LIGHTWOODENSHIELD";
	public static final String BUCKLER = "BUCKLER";
	public static final String FULLPLATE = "FULLPLATE";
	public static final String HALFPLATE = "HALFPLATE";
	public static final String BANDEDMAIL = "BANDEDMAIL";
	public static final String SPLINTMAIL = "SPLINTMAIL";
	public static final String BREASTPLATE = "BREASTPLATE";
	public static final String CHAINMAIL = "CHAINMAIL";
	public static final String SCALEMAIL = "SCALEMAIL";
	public static final String HIDE = "HIDE";
	public static final String CHAINSHIRT = "CHAINSHIRT";
	public static final String STUDDEDLEATHER = "STUDDEDLEATHER";
	public static final String LIGHTLEATHER = "LIGHTLEATHER";
	public static final String PADDED = "PADDED";
	public static final String CLOTH= "CLOTH";
	public static final String ROBE= "ROBE";



	public Armor getArmor(String id){
		Object w=createObject(id);
		if (w!=null)
			return (Armor)w;
		//log
		return null;
	}
	
	
	
	
	public  void init(){
		super.init();
		
		Armor a;
		
		a=new Armor("Ropa",0,25,0,Armor.NO_ARMOR,0);
		register(CLOTH,a);
		a=new Armor("Túnica",0,25,0,Armor.NO_ARMOR,0);
		register(ROBE,a);
		
		a=new Armor("padded armor",1,8,0,Armor.LIGHT_ARMOR,5);
		register(PADDED,a);
		
		a=new Armor("padded armor",1,8,0,Armor.LIGHT_ARMOR,5);
		register(PADDED,a);
		
		a=new Armor("leather armor",2,6,0,Armor.LIGHT_ARMOR,10);
		register(LIGHTLEATHER,a);
		
		a=new Armor("studded leather armor",3,5,-1,Armor.LIGHT_ARMOR,15);
		register(STUDDEDLEATHER,a);
		
		a=new Armor("chain shirt armor",4,4,-2,Armor.LIGHT_ARMOR,20);
		register(CHAINSHIRT,a);
		
		a=new Armor("hide armor",4,4,-3,Armor.MEDIUM_ARMOR,20);
		register(HIDE,a);
		
		a=new Armor("scale mail armor",5,3,-4,Armor.MEDIUM_ARMOR,25);
		register(SCALEMAIL,a);
		
		a=new Armor("chainmail armor",6,2,-5,Armor.MEDIUM_ARMOR,30);
		register(CHAINMAIL,a);
		
		a=new Armor("breastplate armor",6,3,-4,Armor.MEDIUM_ARMOR,25);
		register(BREASTPLATE,a);
		
		a=new Armor("splint mail armor",7,0,-7,Armor.HEAVY_ARMOR,40);
		register(SPLINTMAIL,a);
		
		a=new Armor("banded mail armor",7,1,-6,Armor.HEAVY_ARMOR,35);
		register(BANDEDMAIL,a);
		
		a=new Armor("half plate armor",8,0,-7,Armor.HEAVY_ARMOR,40);
		register(HALFPLATE,a);
	
		a=new Armor("full plate armor",9,1,-6,Armor.HEAVY_ARMOR,35);
		register(FULLPLATE,a);
	
		a=new Shield("buckler shield",1,100,-1,Armor.SHIELD,5,"effects/woodenshield");
		register(BUCKLER,a);
		
		a=new Shield("light wooden shield",1,100,-1,Armor.SHIELD,5,"effects/woodenshield");
		register(LIGHTWOODENSHIELD,a);
		
		a=new Shield("light steel shield",1,100,-1,Armor.SHIELD,5,"effects/metalshield");
		register(LIGHTSTEELSHIELD,a);
		
		a=new Shield("heavy wooden shield",2,100,-2,Armor.SHIELD,15,"effects/woodenshield");
		register(HEAVYWOODENSHIELD,a);
		
		a=new Shield("heavy steel shield",2,100,-2,Armor.SHIELD,15,"effects/metalshield");
		register(HEAVYSTEELSHIELD,a);
		
		a=new Shield("tower shield",4,2,-10,Armor.SHIELD,50,"effects/metalshield");
		register(TOWERSHIELD,a);
	
	
	}
	
}
