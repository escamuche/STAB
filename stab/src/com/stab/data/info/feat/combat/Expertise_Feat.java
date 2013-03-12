package com.stab.data.info.feat.combat;

import com.stab.data.actions.player.feats.Expertise;
import com.stab.data.info.feat.CombatFeat;
import com.stab.model.info.BaseInfo;

public class Expertise_Feat extends CombatFeat{
	
	public static final String ID="EXPERTISE_FEAT";  //No se si sera necesario por ahora no lo es

	
	
	public Expertise_Feat() {
		//Aqui iran los requisitos (por ahora solo se ppuede pedir que tenga ciertos traits, aun no valores de atributos)
		//Ej: addRequiredTrait()
	}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		grantAction(baseInfo, Expertise.ID);
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		removeAction(baseInfo, Expertise.ID);
	}
	
}
