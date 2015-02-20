package com.stab.pf.actions.player.spells;

import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;

//Dummy para las interacciones de algunos hechizos.
//Se usa en los casos en los que el caster no es quien realiza la accion, sino el hechizo en si mismo
//Por ejemplo: en un open close, para que no sea el caster quien abra la puerta, y asi si la aguja envenenada salta, no le haga da�o a nadie
//WIP


public class ActionDummy extends BaseInfo {

	
	@Override
	public void init() {
		super.init();
		setSelectable(Token.NOT_SELECTABLE);
		setInvulnerable(true);
	}
	
}