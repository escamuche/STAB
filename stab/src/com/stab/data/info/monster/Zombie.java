package com.stab.data.info.monster;

import com.stab.data.StabConstants;
import com.stab.data.info.BasicAttributes;
import com.stab.data.info.buff.Toughness_Buff;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.Modifier;

public class Zombie extends Creature {

	public static final String ID="ZOMBIE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		setMaxHp(9);
		healFully();
		this.setActionSet(new MeleeMonsterActionSet());
		setResource("zombie");
		setText("Zombie");
		setFaction(1);
		this.addTrait(new BasicAttributes());
		
		this.setAttribute(StabConstants.XP,200);
		this.setAttribute(StabConstants.WILLSAVE,+3);
		this.setAttribute(StabConstants.TOHIT,+1);
		this.setAttribute(StabConstants.STRENGHT,17);
		this.setAttribute(StabConstants.DAMAGE,+1);
		
		
		
		Modifier natural = new Modifier().createMod(StabConstants.ARMOR,StabConstants.NATURALARMORMOD,+2);
		Toughness_Buff buff = new Toughness_Buff(this);
		
		this.addTrait(natural);
		this.addTrait(buff);

	//	this.setCurrentAI(new DefaultAIPackage());
		this.setCurrentAI(new ZombieAIPackage());
		
		
		this.setBloodeffEct("PARTICLE#greenblood");
	}
	
}
