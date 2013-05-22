package com.stab.data.actions.player.spells.wizard.level1;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellOnTarget;
import com.stab.data.info.applicable.magic.FortitudeAttack;
import com.stab.data.info.applicable.magic.MagicAttack;
import com.stab.data.info.debuff.RayEnfeeblement_Debuff;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class RayEnfeeblement extends SpellOnTarget{
	
	public static final String ID="RAYENFEEBLEMENT";

	@Override
	public boolean affect(Info instigator, Info receptor, Point point) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target = (BaseInfo)receptor;
		int cl = getCasterLevel(caster);
		
		int bono = (cl/2)+1;
		if(bono>5)
			bono=5;
		
		
		MagicAttack attack = new MagicAttack(caster);
		FortitudeAttack save= new FortitudeAttack(caster);
		int damage = Roll.d6()+bono;
		
		target.apply(attack);
		target.apply(save);
		
		
			if(attack.hits()) {
				if(save.hits()){
					RayEnfeeblement_Debuff debuff = new RayEnfeeblement_Debuff(damage);
					debuff.setTime(cl);
					target.addTrait(debuff);
					return true;
					}
				else{
					RayEnfeeblement_Debuff debuff = new RayEnfeeblement_Debuff(damage/2);
					debuff.setTime(cl);
					target.addTrait(debuff);
					return false;
				}
			}
			return false;
		}
	
	public RayEnfeeblement() {
		
		setLevel(1);
		setCasterClass(StabConstants.WIZARDCASTER);
		
		setResource("actions/rayenfeeblement");
		setName("RayEnfeblement");
		this.setEffectType(DEBUFF);
		setRange(CLOSE);
		setMedium(RAY);
		this.setDescription("A coruscating ray springs from your hand. You must succeed on a ranged touch attack to strike a target. The subject takes a penalty to Strength equal to 1d6+1 per two caster levels (maximum 1d6+5). The subject's Strength score cannot drop below 1. A successful Fortitude save reduces this penalty by half. This penalty does not stack with itself. Apply the highest penalty instead.");
	}
}