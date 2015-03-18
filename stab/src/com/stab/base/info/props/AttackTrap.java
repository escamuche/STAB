package com.stab.base.info.props;

import java.awt.Point;

import com.stab.annotations.Injected;
import com.stab.common.utils.PathUtils;
import com.stab.model.action.base.WeaponAttackAction;
import com.stab.model.basic.token.Token;
import com.stab.model.info.ActionDummy;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Creature;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.base.TriggeredActionTrap;
import com.stab.model.info.trait.base.gear.Weapon;
import com.stab.pf.StabConstants;
import com.stab.pf.PfModule;
import com.stab.pf.info.equipment.RangedWeapon;
import com.stab.util.StabUtils;

public class AttackTrap extends TriggeredActionTrap{

	public static final String ID="ATTACK_TRAP";
	
	
	@Injected
	String weapon;
	
	@Injected
	int bonus;
	
	Weapon useWeapon;
	ActionDummy dummy;
	
	
	@Override
	public void init() {
		super.init();
		bonus=0;
	}
	
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
		useWeapon=PfModule.getWeaponFactory().getWeapon(weapon);
	}
	
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public void enter() {
		super.enter();
		dummy=new ActionDummy();
		dummy.setPos(this.getCenter());
		dummy.setSize(1,1);
		dummy.setAttribute(StabConstants.BAB, bonus);
		dummy.addTrait(useWeapon);
		dummy.setFaction(NEUTRAL_FACTION);
		this.getScene().add(dummy);
	}
	
	
	
	@Override
	protected void performAction() {
		
		Point tile=this.getPos();
		tile=PathUtils.advancePoint(tile, this.getAngle());
		
		//Buscamos un objetivo valido.
		//Para ello diferenciamos entre si somos ranged o no
		BaseInfo target=null;
		int range=0;
		if (useWeapon instanceof RangedWeapon){
			range=((RangedWeapon)useWeapon).getMaxRange();
		}
		int r=0;
		boolean solid=false;
		while(target==null && r<=range && !solid){
			for (Token t:this.getMapLogic().getTokensAt(tile.x, tile.y)){
				if ((t.getInfo() instanceof Creature) || (t.getInfo() instanceof Obstacle))
					target=(BaseInfo)t.getInfo();
			}
			if (target==null){
				Point p=PathUtils.advancePoint(tile, this.getAngle());
				if (this.getMapLogic().isTileSolid(p.x, p.y))
					solid=true;
				else
					tile=p;
			}
			r++;
		}
		//Si no hemos encontrado un objetivo valido, usaremos un dummy invisible para poder hacer las animaciones.
		boolean falseEnemy=false;
		if (target==null){
			falseEnemy=true;
			target= new ActionDummy();
			target.setAttribute(StabConstants.ARMORDEFENSE,100);
			target.setPos(tile);
			target.setSize(1,1);
			target.setFaction(-10000);
			target.setMaxHp(1);
			target.setHp(1);
			this.getScene().add(target);
		}
		dummy.setPos(this.getCenter());
		//creamos el ataque y lo ejecutamos.
		WeaponAttackAction a=(WeaponAttackAction)StabUtils.getGameLogic().getAttackAction(useWeapon);
		a.execute(dummy, target, tile, null);
		
		if (falseEnemy)
			target.destroy();
		
	}

}
