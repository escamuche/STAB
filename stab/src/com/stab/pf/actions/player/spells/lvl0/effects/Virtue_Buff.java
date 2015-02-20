package com.stab.pf.actions.player.spells.lvl0.effects;

import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.Modifier;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.player.spells.Spell;
import com.stab.pf.info.spellcasting.SpellEffect;

public class Virtue_Buff extends  SpellEffect{

	public static final String ID="VIRTUE_BUFF";
	
	public Virtue_Buff(Spell spell, Info caster) {
		super(spell, caster);
		setTime(10);
	//	this.setAnimIcon("actions/bless");				
	//	this.setSound("HolyCast");
	//	this.setResource("actions/bless");                  
	//	this.setName("Virtue");
		setBuffDebuff(BUFF);
		BaseInfo target=getTarget();
		if(target.hasTrait(Virtue_Buff.ID) == true) {
			
			Heal h = new Heal(1,target);
			target.apply(h);
			
		}
		
		else {
			Modifier virtue = new Modifier(StabConstants.MAXHP,"Virtue", +1);
			Heal h = new Heal(1,target);
			target.apply(h);
			target.addTrait(virtue);
			}
		}
	
}
