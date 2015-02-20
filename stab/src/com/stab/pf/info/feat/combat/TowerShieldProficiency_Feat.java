package com.stab.pf.info.feat.combat;

import com.stab.pf.info.feat.Feat;
import com.stab.pf.info.feat.general.ShieldProficiency_Feat;

public class TowerShieldProficiency_Feat extends Feat{
	
	public static final String ID="TOWERSHIELDPROFICIENCY_FEAT";

	
	
	public TowerShieldProficiency_Feat() {
		this.addRequiredTrait(ShieldProficiency_Feat.ID);
			}
	
}
