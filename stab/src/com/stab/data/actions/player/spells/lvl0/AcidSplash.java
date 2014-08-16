package com.stab.data.actions.player.spells.lvl0;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;

public class AcidSplash extends SpellOnTarget{
	
	public static final String ID="ACIDSPLASH";
	
	

	
	public AcidSplash() {
     
	 setLevel(0);
	 setCasterClass(StabConstants.WIZARDCASTER);
    
     setResource("actions/spells/chemical_bolt");
     setName("AcidSplash");
     this.setEffectType(DAMAGE);
     this.setEffectSubType(Damage.ACID_DAMAGE);
     setRange(CLOSE);
     setMedium(MISSILE);
     setWeapon(AcidSplash.ID);
     setDescriptors(EffectDescriptor.CONJURATION,EffectDescriptor.CREATION);
     setAffectedBySR(false);
     this.setDescription("You fire a small orb of acid at the target. You must succeed on a ranged touch attack to hit your target. The orb deals 1d3 points of acid damage. This acid disappears after 1 round.");
 	}

	
	
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
		return 3;
	}
}