package com.stab.data.info.buff;

import com.stab.common.Constants;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.abilities.Rage;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.sprite.SpecialEffectsSpriteFactory;
import com.stab.data.info.debuff.Rage_Debuff;
import com.stab.model.basic.token.DecorToken;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.trait.Modifier;
import com.stab.model.info.trait.base.Buff;

public class Rage_Buff extends Buff {
	
	public static final String ID="RAGE_BUFF";
	int rounds = 0; // Plantear si deberia ser 0 o 1 para ver si lo desactivas justo despues de activarlo deberia meter fatigued o no
	
	public Rage_Buff() {
		
		this.setAnimIcon("actions/rage");				
		this.setSound("HolyCast");
		this.setResource("actions/rage");                  
		this.setName("Rage");
		this.setUnique(true);
			
			Modifier cons=new Modifier(StabConstants.CONSTITUTION,StabConstants.MORALMOD,+4);
			Modifier stre=new Modifier(StabConstants.STRENGHT,StabConstants.MORALMOD, +4);
			Modifier will=new Modifier(StabConstants.WILLSAVE,StabConstants.MORALMOD, +2);
			Modifier ac=new Modifier(StabConstants.PASSIVEDEFENSE, -2);
		
			addTrait(cons);
			addTrait(stre);
			addTrait(will);
			addTrait(ac);
		
		}
	
	@Override
	public void applyTo(BaseInfo baseInfo) {
		super.applyTo(baseInfo);
		baseInfo.heal(2, false);  //se mete aqui para q solo cure cuando te aplique el buff
	}
	
	@Override
	public void removeFrom(BaseInfo baseInfo) {
		super.removeFrom(baseInfo);
		Rage_Debuff debuff = new Rage_Debuff(); //igual que el buff necesitamos uno nuevo para clonarlo, cuando te quita el buff automaticamente te mete el debuff
		debuff.setTime(rounds*2); // doble duracion del debuff que los rounds gastados en rabia
		 if(rounds>0)  //comprueba que no se aplique si no hay rounds de debuff
			 baseInfo.addTrait(debuff);
	}	
	
	@Override
	public void turnStarts() { //lo comprueba al principio de cada turno
		rounds ++; //suma 1 al numero de rounds gastados
		BaseInfo i = getTarget(); //sacamos un baseinfo de la manga para aplicarle los atributos
		i.spendResource(Rage.RESOURCE_ID, 1);
		int j = i.getValue(StabConstants.RAGEROUNDSSPENT);
		i.setAttribute(StabConstants.RAGEROUNDSSPENT, j+1); //y los aplicamos
		super.turnStarts(); //esto es para q no desaparezca el baseinfo al principio del turno
	}
	
	
	@Override
	protected DecorToken createEffectToken() {
		DecorToken t=createEffectToken(null,Constants.AURAS);
		t.setResource("PARTICLE#generic/redAuraSmall");
		return t;
	}
	
	
	
}
