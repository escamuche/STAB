package com.stab.data.actions.player.spells;

import com.stab.data.StabConstants;
import com.stab.data.actions.EffectDescriptor;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.base.resource.Resource;
import com.stab.util.StabUtils;

public class SpellUtils {

	
	//Metodos de utilidades para generar versiones de hechizos
	//IE: como otro tipo de caster, como spellLikeAbility
	
	
	public static SpellAction asCaster(String action,String caster,int level){
		SpellAction a;
		a=(SpellAction)StabUtils.getActionLibrary().getAction(action);
		a.setCasterClass(caster);
		a.setLevel(level);
		return a;
	}
	public static SpellAction asCaster(String action,String caster){
		SpellAction a;
		a=(SpellAction)StabUtils.getActionLibrary().getAction(action);
		a.setCasterClass(caster);
		return a;
	}
	public static SpellAction asSpellLike(String action,String caster,int fixedlevel){
		SpellAction a;
		a=(SpellAction)StabUtils.getActionLibrary().getAction(action);
		a.setCasterClass(caster);
		a.getSpell().setFixedCasterLevel(fixedlevel);
		a.getSpell().setSpellLikeAbility(true);
		a.getSpell().setCost(0);
		return a;
	}
	
	static int counter=0;
	//Pensarse si colocarlo como trait? por ahora aqui mas facil
	public static SpellAction addSpellLike(BaseInfo info,String action,String caster,int fixedlevel,int uses){
		SpellAction a= asSpellLike(action,caster,fixedlevel);
		String res=a.getId()+counter++;
		a.setRequiredResource(res, 1);
		Resource r=new Resource(res,uses);
		info.addTrait(r);
		info.getActionSet().addAction(a);
		return a;
	}
	public static SpellAction asItem(String action,String caster,int level,int fixedlevel){
		SpellAction a;
		a=(SpellAction)StabUtils.getActionLibrary().getAction(action);
		a.setCasterClass(caster);
		a.setLevel(level);
		a.getSpell().setFixedCasterLevel(fixedlevel);
		a.getSpell().setSpellLikeAbility(true);
		return a;
	}
	
	
	public static SpellAction asCleric(String action){
		return asCaster(action,StabConstants.CLERICCASTER);
	}
	public static SpellAction asSorcerer(String action){
		return asCaster(action,StabConstants.SORCERERCASTER);
	}
	public static SpellAction asDruid(String action){
		return asCaster(action,StabConstants.DRUIDCASTER);
	}
	public static SpellAction asBard(String action){
		return asCaster(action,StabConstants.BARDCASTER);
	}
	public static SpellAction asWizard(String action){
		return asCaster(action,StabConstants.WIZARDCASTER);
	}
	
	public static String getVisualAura(Spell s){
		String desc="PARTICLE#spells/";
		if (s.getDescriptors()==null)
			return desc+"GenericAura";
		if (s.getDescriptors().contains(EffectDescriptor.ABJURATION))
			return desc+"Abjuration";
		if (s.getDescriptors().contains(EffectDescriptor.CONJURATION))
			return desc+"Conjuration";
		if (s.getDescriptors().contains(EffectDescriptor.EVOCATION))
			return desc+"Evocation";
		if (s.getDescriptors().contains(EffectDescriptor.ENCHANTMENT))
			return desc+"Enchantment";
		if (s.getDescriptors().contains(EffectDescriptor.ILLUSION))
			return desc+"Illusion";
		if (s.getDescriptors().contains(EffectDescriptor.TRANSMUTATION))
			return desc+"TRANSMUTATION";
		if (s.getDescriptors().contains(EffectDescriptor.NECROMANCY))
			return desc+"Necromancy";
		if (s.getDescriptors().contains(EffectDescriptor.DIVINATION))
			return desc+"Divination";
		return desc+"GenericAura";
	
	}
	
	public static String getGenericDescription(Spell s){
		String desc="";
		if (s.getLevel()==0)
			desc="Cantrip ";
		else
		if (s.getLevel()>=9)
			desc="Superior ";
		else
		if (s.getLevel()<3)
			desc="Minor ";
		else if (s.getLevel()>6)
			desc="Major ";
		if (s.getDescriptors().contains(EffectDescriptor.ABJURATION))
			return desc+"Abjuration";
		if (s.getDescriptors().contains(EffectDescriptor.CONJURATION))
			return desc+"Conjuration";
		if (s.getDescriptors().contains(EffectDescriptor.EVOCATION))
			return desc+"Evocation";
		if (s.getDescriptors().contains(EffectDescriptor.ENCHANTMENT))
			return desc+"Enchantment";
		if (s.getDescriptors().contains(EffectDescriptor.ILLUSION))
			return desc+"Illusion";
		if (s.getDescriptors().contains(EffectDescriptor.TRANSMUTATION))
			return desc+"TRANSMUTATION";
		if (s.getDescriptors().contains(EffectDescriptor.NECROMANCY))
			return desc+"Necromancy";
		if (s.getDescriptors().contains(EffectDescriptor.DIVINATION))
			return desc+"Divination";
		return desc+" Generic spell";
	}
	
	
	
	public static int getMinimumCasterLevel(String casterClass, int level) {
		if (level==0)
			return 1;
		int type=0;
		if (casterClass.equals(StabConstants.SORCERERCASTER))
			type=1;
		if (casterClass.equals(StabConstants.BARDCASTER)||casterClass.equals(StabConstants.RANGERCASTER)||casterClass.equals(StabConstants.PALADINCASTER))
		    type=2;
		
		switch(type){
		  case 0: return level*2-1;
		  case 1: if (level==1)
			  		return 1;
		  		  return level*2;
		  case 2:  return (level-1)*3 +1;
			      
		}
		return 0;
	}

	
}
