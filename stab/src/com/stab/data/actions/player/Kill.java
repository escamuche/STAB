package com.stab.data.actions.player;

import com.stab.data.StabConstants;
import com.stab.model.action.TargetAction;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.events.common.ConsoleMessage;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.util.Roll;

public class Kill extends TargetAction{
	
	public static final String ID="Kill";

	@Override
	public boolean execute(Info yo, Info target) {
		BaseInfo aMatar = (BaseInfo)target;
		BaseInfo elqueMata = (BaseInfo)yo;
		
		int ac = aMatar.getValue(StabConstants.ARMOR);
		int dar = elqueMata.getValue(StabConstants.TOHIT) + Roll.d20();
		elqueMata.getScene().sendMessage(ConsoleMessage.SUCCESS, "Impactas a armadura " + dar);
		if ac < dar then {
		Damage d= new Damage(elqueMata.getValue(StabConstants.DAMAGE), Damage.SLASHING_DAMAGE,yo);
		aMatar.apply(d);
		elqueMata.getScene().sendMessage(ConsoleMessage.SUCCESS, d.getAmount()+" de daño");
	    return true;
	    }
		
		else {
			elqueMata.getScene().sendMessage(ConsoleMessage.SUCCESS, "Fallas el golpe");
			return false;
		}
		}
	
	public Kill() {
     setRange(1);
     setTargetClass(PhysicalToken.class);
     setResource("actions/ability_warrior_defensivestance");
	}

	public static void main(String[] args) {

	}
	

}
