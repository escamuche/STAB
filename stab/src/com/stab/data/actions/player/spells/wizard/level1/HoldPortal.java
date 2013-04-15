package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Door;

public class HoldPortal extends SpellOnTarget{
	
	public static final String ID="HOLDPORTAL";

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		
		
		//Cambiar para que solo cierre. Pendiente tema con llave. Duracion 1 min/level
		Door Atacado = (Door)target;
		Atacado.infoInteracts(caster);
		return true;
	}
	
	public HoldPortal() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetClass(DoorToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("HoldPortal");
		this.setEffectType(SPECIAL);
		setRange(MEDIUM);
	}
}
