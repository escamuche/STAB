package com.stab.data.actions.player.spells.lvl1.effects;

import com.stab.data.StabConstants;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.model.info.applicable.AnimationApplicable;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.RolledDamage;
import com.stab.model.info.applicable.base.WeaponAttack;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.gear.WeaponTrait;

public class MagicStoneWeaponTrait extends WeaponTrait {

	@Override
	public void affect(WeaponAttack app) {
		app.addModifier(new Modifier(StabConstants.TOHITRANGED,StabConstants.ENHANCEMENTMOD,1));
		app.addModifier(new Modifier(StabConstants.DAMAGERANGED,StabConstants.ENHANCEMENTMOD,1));
		if (app.getTarget().hasTrait(UndeadTraits.class)){
			app.addOnDamage(new RolledDamage(6, 1, Damage.IMPACT_DAMAGE, null));
			app.addOnDamage(new AnimationApplicable(app.getTarget(), VisualEffect.SPARK_ANIMATION,"SHADERCIRCLE#shockwave"));
		}
		
	}
}
