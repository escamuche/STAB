package com.stab.data.info.feat.combat;

import com.stab.data.info.feat.CombatFeat;
import com.stab.data.info.feat.general.MediumArmorProficiency_Feat;

public class ArcaneArmorMastery_Feat extends CombatFeat{
	
	public static final String ID="ARCANEARMORMASTERY_FEAT";

	
	
	public ArcaneArmorMastery_Feat() {
		
		this.addRequiredTrait(ArcaneArmorTraining_Feat.ID);
		this.addRequiredTrait(MediumArmorProficiency_Feat.ID);
		//falta metodo que compruebe el mayor de los caster level para poner el requisito de caster level 7
	}
	
}
