package com.stab.data.actions.player.spells.wizard.level0;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Door;

public class OpenClose extends SpellOnTarget{
	
	public static final String ID="OPENCLOSE";

	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		
		Door Atacado = (Door)target;
		Atacado.infoInteracts(caster);
		return true;
	}
	
	public OpenClose() {
		setLevel(0);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetTokenClass(DoorToken.class);
		setResource("actions/openclose");
		setName("Open/Close");
		this.setEffectType(BUFF);
		setRange(CLOSE);
		this.setDescription("You can open or close (your choice) a door, chest, box, window, bag, pouch, bottle, barrel, or other container. If anything resists this activity (such as a bar on a door or a lock on a chest), the spell fails. In addition, the spell can only open and close things weighing 30 pounds or less. Thus, doors, chests, and similar objects sized for enormous creatures may be beyond this spell's ability to affect.");
	}
}
