package com.stab.data.actions.player.spells;

import com.stab.data.StabConstants;
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
	
}
