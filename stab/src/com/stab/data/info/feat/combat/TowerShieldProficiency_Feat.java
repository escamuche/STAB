package com.stab.data.info.feat.combat;

import com.stab.data.info.feat.Feat;
import com.stab.data.info.feat.general.ShieldProficiency_Feat;

public class TowerShieldProficiency_Feat extends Feat{
	
	public static final String ID="TOWERSHIELDPROFICIENCY_FEAT";

	
	
	public TowerShieldProficiency_Feat() {
		this.addRequiredTrait(ShieldProficiency_Feat.ID);
			}
	
}
