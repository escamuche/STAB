package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.base.Door;

public class HoldPortal extends SpellOnTarget{
	
	public static final String ID="HOLDPORTAL";

	@Override
	protected boolean fullEffect(BaseInfo caster, BaseInfo target, Point point) {
		//Cambiar para que solo cierre. Pendiente tema con llave. Duracion 1 min/level
				Door Atacado = (Door)target;
				Atacado.infoInteracts(caster);
		return super.fullEffect(caster, target, point);
	}
	
	public HoldPortal() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		setTargetTokenClass(DoorToken.class);
		setResource("actions/ability_druid_naturalperfection");
		setName("HoldPortal");
		this.setEffectType(SPECIAL);
		setRange(MEDIUM);
		this.setDescription("This spell magically holds shut a door, gate, window, or shutter of wood, metal, or stone. The magic affects the portal just as if it were securely closed and normally locked. A knock spell or a successful dispel magic spell can negate a hold portal spell.");
	}
}
