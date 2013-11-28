package com.stab.data.actions;

import java.awt.Point;

import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.info.applicable.SavingThrowEffect;
import com.stab.data.info.feat.general.SelectiveChanneling_Feat;
import com.stab.data.info.monster.monstertraits.ConstructTraits;
import com.stab.data.info.monster.monstertraits.UndeadTraits;
import com.stab.data.utils.PathfinderUtils;
import com.stab.model.action.Action;
import com.stab.model.action.AoE;
import com.stab.model.action.SelfAction;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.applicable.base.Heal;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.request.basic.ActionRequest;

public class ChannelPossitiveEnergyAction extends PathfinderAction implements SelfAction, AoE{
	
	
	public static final String ID="CHANNELPOSITIVE_ACTION";
	public static final String RESOURCE_ID="CHANNEL_ENERGY";

	@Override
	public float getLength(Info caster) {
		return 4; //Por defecto, por ahora
	}

	public ChannelPossitiveEnergyAction() {
		this.setName("Channel Positive energy");
		this.setResource("actions/curelightwounds");
		this.setRequiredResource(RESOURCE_ID, 1);
		this.setEffectType(HEAL);
		setRelations(Action.TARGET_ENEMY,Action.TARGET_FRIEND,Action.TARGET_SELF);
	}

	@Override
	public int getAreaType() {
		return AoE.BURST;
	}

	@Override
	public float getWidth(Info caster) {
		return 0;
	}

	@Override
	public int getRequiredLine() {
		return IN_SIGHT;
	}

	@Override
	public boolean affectsSelf() {
		return true;
	}

	@Override
	public int affect(Info instigator, Info t, Point point,ActionRequest ar) {
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)t;
		if (target.hasTrait(ConstructTraits.class))
			return OK;
		
		if (target.hasTrait(UndeadTraits.class)){
			
			SavingThrowEffect st=getSavingThrow(caster,target);
			st.check();
			if (st.success()){
				target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#damage/smallHolyBurn");
				Damage d= new Damage((int)(getAmount(caster)/2),Damage.HOLY_DAMAGE,caster);
				target.apply(d);
			}else{
				target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#damage/holyBurn");
				Damage d= new Damage(getAmount(caster),Damage.HOLY_DAMAGE,caster);
				target.apply(d);
			}
			
			
			return OK;
		}
		
		if (caster.isEnemy(target))
			if (caster.hasTrait(SelectiveChanneling_Feat.class))
				return OK;
		
		Heal h= new Heal(getAmount(caster),caster);
		target.apply(h);
		target.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#effects/healing");
		
		return OK;
	}
	
	protected SavingThrowEffect getSavingThrow(BaseInfo caster, BaseInfo target) {
		SavingThrowEffect st= new SavingThrowEffect(caster, StabConstants.WILLSAVE, target);
		st.setTargetNumber(10+PathfinderUtils.getBonus(caster.getValue(StabConstants.WISDOM)));
		return st;
	}

	@Override
	protected void playExecuteActionAnimation(Info caster, Info target,	Point pos,ActionRequest ar) {
		super.playExecuteActionAnimation(caster, target, pos, ar);
		caster.playSound("effects/HolyBolt");
		caster.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#spells/holyNova");
		caster.waitAnimation(200);
		sleep(1000);
	}
	
	protected int getAmount(BaseInfo caster) {
		int n=1;
		return Roll.roll(n,6);
	}

	@Override
	public int getEffectType(Info instigator,Info t){
		BaseInfo caster=(BaseInfo)instigator;
		BaseInfo target=(BaseInfo)t;
		
		//comprobar que se excluya el caster si es undead!
		
		if (target.hasTrait(UndeadTraits.class)){
			if (target==caster)
				return NEUTRAL;
			if (caster.isAlly(target))
				if (caster.hasTrait(SelectiveChanneling_Feat.class))
					return NEUTRAL;
			return DAMAGE;
		}
		if (target.hasTrait(ConstructTraits.class))
			return NEUTRAL;
		
		//Aqui controlar si es aliado (si se tiene el feat para excluir)
		if (caster.isEnemy(target))
			if (caster.hasTrait(SelectiveChanneling_Feat.class))
				return NEUTRAL;
		return HEAL;
	}
	
	
	@Override
	public int getEffectSubType(Info instigator, Info target) {
		int i=getEffectType(instigator, target);
		if (i==HEAL)
			return 0;
		return Damage.HOLY_DAMAGE;
		//return super.getEffectSubType(instigator, target);
	}
	
	@Override
	public int getEffectValue(BaseInfo i, Info target) {
	
		return 6;
	}

}

