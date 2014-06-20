package com.stab.data.info.equipment;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.data.info.feat.general.MartialWeaponProficiency_Feat;
import com.stab.data.info.feat.general.NaturalWeaponProficiency_Feat;
import com.stab.data.info.feat.general.SimpleWeaponProficiency_Feat;
import com.stab.data.info.feat.general.WeaponProficiency_Feat;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.model.info.trait.base.gear.WeaponTrait;

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
	boolean touch;
	int category;
	
	boolean twoHanded;
	
	
	
	public BasicWeapon() {
		this.setPriority(10);  //Prioridad base para las armas.  Los overrides usaran una posterior, y los encantamientos tambien
		setTwoHanded(false);
		category=SIMPLE;
		touch=false;
		
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
	public void affect(WeaponAttack app) {
		super.affect(app);
		app.setBaseDamageType(baseDamageType);
		app.setCritMultiplier(critMultiplier);
		app.setCritRange(critRange);
		app.setBaseDamage(calcDamage(app));
		
		((PathfinderAttack)app).setTouch(isTouch());
	
		// cambiado el calculo de daño para que añada la tirada de dado como setBaseDamageApplicable
		RolledDamage d=new RolledDamage(this.dices, dice, 0, baseDamageType, app.getInstigator());
		app.setBaseDamageApplicable(d);
	//	System.out.println("Creando rolledDamage para weaponattack "+d.getAmount()+"  "+d.getFinalAmount());
		//los traits anidados ya se comprueban automaticamente.
		
	}

	public void setTouch(boolean touch) {
		this.touch = touch;
	}
	public boolean isTouch() {
		return touch;
	}
	

	protected int calcDamage(WeaponAttack app){
	//	int i=rollDamage();
		int i=0;
		i=i+getDamageModifier(app);
		return i;
	}

	protected int getDamageModifier(WeaponAttack app) {
		return getDamageModifier((BaseInfo)app.getInstigator());
	}
	protected int getDamageModifier(BaseInfo i) {
	
		int d=i.getValue(StabConstants.DAMAGE);
		if (isTwoHanded()) //Realmente, comprobar si esta en both hands
			d=(int)(d*1.5);
		//Mirar si esta en la off hand y meter menos daño
		return d;
	}


/*	protected int rollDamage() {
		return Roll.roll(dices, dice);
	}/**/
	
	protected void setDice(int number,int dice){
		dices=number;
		this.dice=dice;
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
				if (t.getWeapon().equals(this.getBaseItem()))
					return true;
		return false;
		
	}
	/**/
	
	@Override
	public void attackDone(WeaponAttack attack) {
		for (WeaponTrait wt:getTraits(WeaponTrait.class))
			wt.attackDone(attack);
		super.attackDone(attack);
	}
	
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		int v=dices*dice/2;
		for (WeaponTrait wt:getTraits(WeaponTrait.class))
			v=v+wt.getEffectValue();
		v=v+getDamageModifier(i);
		return v;
	}
	
}
