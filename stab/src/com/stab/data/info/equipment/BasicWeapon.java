package com.stab.data.info.equipment;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.AttackData;
import com.stab.data.info.feat.general.MartialWeaponProficiency_Feat;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.data.info.feat.general.SimpleWeaponProficiency_Feat;
import com.stab.data.info.feat.general.WeaponProficiency_Feat;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Trait;
import com.stab.util.Roll;

/**
 * arma basica, con los datos principales
 * notese que puede tener traits añadidos (ej: veneno, un buff temporal, etc)
 * por ejemplo si es de flaming, seria un trait del arma.
 * el encantamiento de +1 ... pensarselo, probablemente sea una buena idea, pero se pueden liar los modificadores
 * (quizas meter una estructura de modificadores en attackdata, aunque suene muy complejo)
 *
 */
public class BasicWeapon extends Weapon {

	
	public static final int SIMPLE=0;
	public static final int MARTIAL=1;
	public static final int EXOTIC=2;
	public static final int NATURAL=3;
	public static final int SPECIAL=4;  //Ray y touch (para spells)
	
	int dice; 
	int dices;
	int baseDamageType;
	int critRange;
	int critMultiplier;
	
	String animationIcon;
	String animationType;
	
	int category;
	
	boolean twoHanded;
	
	String baseWeapon;
	
	public BasicWeapon() {
		this.setPriority(10);  //Prioridad base para las armas.  Los overrides usaran una posterior, y los encantamientos tambien
		setTwoHanded(false);
		category=SIMPLE;
		baseWeapon=null;
	}
	
	
	public void setTwoHanded(boolean twoHanded) {
		this.twoHanded = twoHanded;
		if (twoHanded)
			setSlots(HumanoidGear.BOTHHANDS);
		else
			setSlots(HumanoidGear.MAINHAND,HumanoidGear.OFFHAND);
	}
	
	public boolean isTwoHanded() {
		return twoHanded;
	}
	
	public void setCategory(int category) {
		this.category = category;
	}
	public int getCategory() {
		return category;
	}
	
	public void setBaseWeapon(String baseWeapon) {
		this.baseWeapon = baseWeapon;
	}
	public String getBaseWeapon() {
		return baseWeapon;
	}
	
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, 
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,1,2,animationIcon,animationType);
	}
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			 String animationIcon, String animationType){
		this(name,numberofDice,dice,baseDamageType,critRange,2,animationIcon,animationType);
	}
	
	public BasicWeapon(String name,int numberofDice, int dice, int baseDamageType, int critRange,
			int critMultiplier, String animationIcon, String animationType) {
		this();
		this.setName(name);
		this.dice = dice;
		this.dices = numberofDice;
		this.baseDamageType = baseDamageType;
		this.critRange = critRange;
		this.critMultiplier = critMultiplier;
		this.animationIcon = animationIcon;
		this.animationType = animationType;
	}




	@Override
	public void attend(AttackData app) {
		super.attend(app);
		app.setBaseDamageType(baseDamageType);
		app.setCritMultiplier(critMultiplier);
		app.setCritRange(critRange);
		app.setBaseDamage(calcDamage(app));
		
		app.setAnimationIcon(animationIcon);
		app.setAnimationType(animationType);
		
		//los traits anidados ya se comprueban automaticamente.
		
	}

	
	

	protected int calcDamage(AttackData app){
		int i=rollDamage();
		i=i+getDamageModifier(app);
		return i;
	}

	protected int getDamageModifier(AttackData app) {
		BaseInfo i=(BaseInfo)app.getInstigator();
		int d=i.getValue(StabConstants.DAMAGE);
		if (isTwoHanded()) //Realmente, comprobar si esta en both hands
			d=(int)(d*1.5);
		//Mirar si esta en la off hand y meter menos daño
		return d;
	}


	protected int rollDamage() {
		return Roll.roll(dices, dice);
	}
	
	protected void setDice(int number,int dice){
		dices=number;
		this.dice=dice;
	}
	
	public void setAnimationIcon(String animationIcon) {
		this.animationIcon = animationIcon;
	}
	public String getAnimationIcon() {
		return animationIcon;
	}
	public void setAnimationType(String animationType) {
		this.animationType = animationType;
	}
	public String getAnimationType() {
		return animationType;
	}
	public void setCritMultiplier(int critMultiplier) {
		this.critMultiplier = critMultiplier;
	}
	public void setCritRange(int critRange) {
		this.critRange = critRange;
	}
	public int getCritMultiplier() {
		return critMultiplier;
	}
	public int getCritRange() {
		return critRange;
	}
	
	public void setBaseDamageType(int baseDamageType) {
		this.baseDamageType = baseDamageType;
	}
	public int getBaseDamageType() {
		return baseDamageType;
	}
	
	
	
	public boolean isProficient(BaseInfo i){
		switch(category){
			case SIMPLE: if (i.hasTrait( SimpleWeaponProficiency_Feat.ID ))
						return true;
						break;
			case MARTIAL: if (i.hasTrait( MartialWeaponProficiency_Feat.ID ))
				return true;
				break;
			case NATURAL: if (i.hasTrait( NaturalWeaponProficiency_Feat.ID ))
				return true;
				break;
			case SPECIAL:
				return true;
		}
		//Si no, buscar el trait especifico
		
		for (WeaponProficiency_Feat t:i.getTraits(WeaponProficiency_Feat.class))
				if (t.getWeapon().equals(this.getBaseWeapon()))
					return true;
		return false;
		
	}
	/**/
	
}
