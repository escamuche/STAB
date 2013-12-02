package com.stab.data.utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import com.stab.common.utils.PathUtils;
import com.stab.data.actions.general.WeaponAttackAction;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.buff.spells.Shield_Buff;
import com.stab.data.info.debuff.condition.UnableToActCondition;
import com.stab.data.info.equipment.Armor;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.data.info.equipment.RangedWeapon;
import com.stab.data.info.equipment.Shield;
import com.stab.data.info.equipment.SpellDeliverWeapon;
import com.stab.data.info.equipment.Weapon;
import com.stab.model.basic.scenes.MapLogic;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.Equipment;

public class PathfinderUtils {
	
	public static boolean isLightArmored(Creature c) {
		
		if (c.getEquipment(HumanoidGear.ARMOR) instanceof Armor) {
			Armor a = (Armor)c.getEquipment(HumanoidGear.ARMOR);
			if(a.getCategory()<Armor.MEDIUM_ARMOR){
				return true;
				}
			}

		else {
			
			return true;
		}
		
		return false;
		
	}
	
	
	public static String getShieldIcon(Creature c){
		if (c.hasTrait(Shield_Buff.class))
			return "PARTICLE#spells/mageShield";
		if (c.getEquipment(HumanoidGear.OFFHAND) instanceof Shield) {
			Shield a = (Shield)c.getEquipment(HumanoidGear.OFFHAND);
			return a.getEffectIcon();
		}
		return null;
	}
	
	
	//no iria nada mal un getWeapon() para saber que arma lleva un info (mirando mainhand, y si no lleva nada offhand), pensandose lo de las
	//armas naturales, etc.
	public static Weapon getWeapon(Creature c){
		Equipment e= c.getEquipment(HumanoidGear.MAINHAND);
		if (e instanceof Weapon)
			return (Weapon)e;
		 e= c.getEquipment(HumanoidGear.OFFHAND);
		if (e instanceof Weapon)
			return (Weapon)e;
		return null;
	}
	
	public static int getReach(BaseInfo c){
		WeaponAttackAction aa= new WeaponAttackAction();
		return aa.getRange(c);
	}
	
	//Threats
	public static boolean threats(Creature c,BaseInfo target){
		return threats(c,target,target.getBounds());
	}
	public static  boolean threatsAt(Creature c,BaseInfo target,Point at){
		Rectangle r=new Rectangle(at.x,at.y,target.getWidth(),target.getHeight());
		return threats(c,target,r);
	}
	public static boolean threats(Creature c,BaseInfo target,Rectangle r){
		if (!c.isAwareOf(target)){
			return false;
		}
		if (!c.isEnemy(target))
			return false;
		System.out.println("Checking threat ");
		//comprobacion de si puede verlo (puede que este aware, pero puede estar ciego, el target ser invisible, etc)
		if (!c.canSense(target)){
			System.out.println("Cant see it");
			return false;
		}
		for (Point p: c.getMapLogic().getPointsInRect(r))
			if (threats(c,target,p))
				return true;
		return false; 
	}
	public static boolean threats(Creature c,Point tile){
		return threats(c,null,tile);
	}
	public static boolean threats(Creature c,BaseInfo target,Point tile){
		if (!threats(c)){
			//System.out.println("No threat");
			return false;
		}
		WeaponAttackAction aa= new WeaponAttackAction();
		float dist=c.getMapLogic().getDistance(c.getToken(), tile);
		if (aa.getRange(c)<dist){
			//System.out.println("No range!");
			return false;
		}
		//Los
		if (target!=null){
			if (!c.getMapLogic().isLOSTo(c.getToken(),target.getToken(), tile)) {
			//	System.out.println("No los!");
				return false;
			}
		}else{
			if (!c.getMapLogic().isLOS(c.getToken(), tile)){
			//	System.out.println("No los!");
				return false;
			}
		}
		return true;
	}
	public static boolean threats(Creature c){
		if (c.isDestroyed())
			return false;
		if (c.hasTrait(UnableToActCondition.class))
			return false;
		Weapon w=getWeapon(c);
		if (w==null)
			return false;
		if (w instanceof RangedWeapon)
			return false;
		if (w instanceof SpellDeliverWeapon)
			if (((SpellDeliverWeapon)w).isRanged())
			return false;
		if (!c.getActionSet().contains(WeaponAttackAction.ID))
			return false;
		return true;
	}
	
	
	//enemigos que me amenazan en una casilla
	public static Collection<Creature> getThreateningMe(Point p,BaseInfo me, Collection<Info> infos){
		ArrayList<Creature> enemies=new ArrayList<Creature>();
		for (Info i:infos){
			if (i instanceof Creature){
				Creature c=(Creature)i;
				if (!c.isAlly(me))
					if (threats(c,me))
						enemies.add(c);
			}
		}
		return enemies;
	}
	
	
	/**
	 * Crea un efecto de tirada de salvacion con los efectos indicados si se falla la tirada
	 * @param instigator
	 * @param target
	 * @param save
	 * @param diff
	 * @param effects
	 * @return
	 */
	public static SavingThrowEffect createST(BaseInfo instigator, BaseInfo target, String save,int diff, Applicable... effects){
		SavingThrowEffect s= new SavingThrowEffect(instigator, save, target);
		s.setTargetNumber(diff);
		for (Applicable a:effects)
			s.addApplicable(a);
		return s;
	}
	
	/**
	 * Crea un efecto de tirada de salvacion con los efectos indicados si se falla la tirada y mitad de daño si se pasa
	 * (no se aplican efectos si la tirada se evade)
	 * @param instigator
	 * @param target
	 * @param save
	 * @param diff
	 * @param effects
	 * @return
	 */
	public static SavingThrowEffect createST_Half(BaseInfo instigator, BaseInfo target, String save,int diff, Applicable... effects){
		SavingThrowEffect s= new SavingThrowEffect(instigator, save, target);
		s.setTargetNumber(diff);
		for (Applicable a:effects)
			if (a instanceof Damage)
				s.addApplicable(((Damage)a),true);
			else
				s.addApplicable(a);
		return s;
	}


	public static int getBonus(int val) {
		if (val>=10)
			return (val-10)/2;
		else
			return (val-11)/2;
	}
	
	public static Collection<Creature> getFlankersFor(BaseInfo target,Point p, Collection<Info> infos){
		HashSet<Creature> enemies=new HashSet<Creature>();

		char c=PathUtils.getPointPos(target.getBounds(), p);
		c=PathUtils.reverse(c);
		if (c=='S'){
			System.out.println("Check de flank desde dentro del target!");
			return enemies;
		}
	//	System.out.println("Check de flank desde "+p+" en direccion "+c+" sobre "+ target);
		MapLogic ml=target.getMapLogic();
		for (Info i:infos)
			if (i instanceof Creature){
				boolean add=false;
					for (Point tp:ml.getPointsInRect(i.getBounds()))
					if (c==PathUtils.getPointPos(target.getBounds(),tp))
						add=true;
				if (add){
				//	System.out.println("   Chechking "+i+" "+i.getPos()+"at dir "+PathUtils.getPointPos(target.getBounds(),i.getPos()));
					if (canFlank((Creature)i,target)){
						enemies.add((Creature)i);
				//		System.out.println("and can flank");
					}
				}
			}
	//	System.out.println("-");
		return enemies;
	}
			
	public static Collection<Creature> getFlankersFor(BaseInfo target, BaseInfo attacker, Collection<Info> infos){
		HashSet<Creature> enemies=new HashSet<Creature>();
		MapLogic ml=target.getMapLogic();
		for (Point tp:ml.getPointsInRect(attacker.getBounds())){
			Collection<Creature> candidates=getFlankersFor(target,tp,infos);
			enemies.addAll(candidates);
				
		}
		if (enemies.contains(attacker))
			enemies.remove(attacker);
		return enemies;
		
	
	}
	
	public static boolean willIFlankAt(BaseInfo target, BaseInfo attacker, Point pos, Collection<Info> infos){
		return !getFlankersAt(target, attacker, pos, infos).isEmpty();
	}
	public static Collection<Creature> getFlankersAt(BaseInfo target, BaseInfo attacker, Point pos, Collection<Info> infos){
	
		HashSet<Creature> enemies=new HashSet<Creature>();
		MapLogic ml=target.getMapLogic();
		Rectangle r=new Rectangle(pos.x,pos.y,attacker.getWidth(),attacker.getHeight());
		for (Point tp:ml.getPointsInRect(r)){
			Collection<Creature> candidates=getFlankersFor(target,tp,infos);
			enemies.addAll(candidates);
				
		}
		if (enemies.contains(attacker))
			enemies.remove(attacker);
		return enemies;
		
	}
	
	public static boolean canFlank(Creature attacker,BaseInfo defender){
		if (!threats(attacker, defender))
			return false;
		//TODO: uncanny dodge
		
		return true;
	}
	
}
