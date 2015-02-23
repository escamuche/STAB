package com.stab.pf.actions.player.spells.lvl1;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import com.stab.model.ai.traits.CompanionAITrait;
import com.stab.model.basic.scenes.map.TileMapScene;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.base.Creature;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.activity.Activity;
import com.stab.model.request.basic.ActionRequest;
import com.stab.pf.StabConstants;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.player.spells.SpellOnTile;
import com.stab.pf.actions.player.spells.lvl1.effects.SummonActivity;
import com.stab.pf.actions.player.spells.lvl1.effects.SummonedCreature;
import com.stab.pf.info.monster.bestiary.Wolf;
import com.stab.util.StabUtils;

public class SummonMonsterI extends SpellOnTile   {

	public static final String ID="SUMMONMONSTER_I";
	
	public SummonMonsterI() {
		 setAoE(true);
		 
		 setLevel(1);
		 setCasterClass(StabConstants.WIZARDCASTER);
		 setRange(CLOSE);
		 
	     setResource("actions/summonmonster1");
	     setName("Summon Monster I");
	     this.setEffectType(SUMMON);
	     this.setDescription("Summons a creature to fight by your side. Summoned creatures return to their plane when the spell expires");
	     this.setLosType(IN_SIGHT);
	     setDescriptors(EffectDescriptor.CONJURATION,EffectDescriptor.SUMMONING);
	     setDuration(SHORT);
	     setCastingTime(ROUND);
	}
	
	
	@Override
	public int getRequiredLine() {
		return IN_SIGHT;
	}
	
	public float getLength(Info caster) {
		return 2; 
	}
	
	@Override
	public Class getActivityClass() {
		return SummonActivity.class;
	}
	
	@Override
	public Activity createActivity(ActionRequest ar) {
		return new SummonActivity(this);
	}
	
	
	@Override
	public int execute(Info origin, Info target, Point point, ActionRequest ar) {

		
		
		for (Creature c:getSummonedCreatures(origin,point,ar)){
			SummonedCreature sc=new SummonedCreature();
			sc.setTime(getSpell().getFinalCasterLevel());
sc.setTime(10);
			c.addTrait(sc);
			c.setFaction(origin.getFaction());
			CompanionAITrait comp= new CompanionAITrait();
			comp.setMaster((BaseInfo)origin);
			c.addTrait(comp);
			c.setInitiative(((BaseInfo)origin).getInitiative());
			c.setPriorityInsert(true);
			//Colocar la criatura
			if (origin.getScene() instanceof TileMapScene)
				((TileMapScene)origin.getScene()).findEntranceFor(c, point, 3);
			origin.getScene().add(c);
			c.playAnimation(VisualEffect.SPARK_ANIMATION,"PARTICLE#spells/summoned");
			c.playSound("effects/SpiritWolf");
		}
		return OK;
	}
	
	
	protected Collection<Creature> getSummonedCreatures(Info origin,Point point,ActionRequest ar){
		ArrayList<Creature> list= new ArrayList<Creature>();
		
		Wolf f= (Wolf)StabUtils.getEntity(Wolf.ID);
		list.add(f);
		
		return list;
	}
	
}
