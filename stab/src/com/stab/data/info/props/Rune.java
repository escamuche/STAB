package com.stab.data.info.props;

import java.awt.Point;

import com.stab.annotations.Injected;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.SpellAction;
import com.stab.data.actions.player.spells.ActionDummy;
import com.stab.data.actions.player.spells.SpellUtils;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.model.action.Action;
import com.stab.model.basic.token.Token;
import com.stab.model.extras.OnlyVisibleWithMode;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.util.StabUtils;

public class Rune extends TriggerArea {

	public static final String ID="RUNE";
	
	@Injected
	String spell;
	
	SpellAction action;
	ActionDummy dummy;
	
	@Injected
	boolean rechargeable;
	
	int lvl;
	
	@Override
	public void init() {
		super.init();
		rechargeable=false;
		this.setSelectable(Token.SELECTABLE);
		this.setText("Magic Rune");
		this.setDescription("A glowing magical rune. Touching it will trigger a spell.");
		OnlyVisibleWithMode m= new OnlyVisibleWithMode(DetectMagic.VISIONMODE);
		addExtra(m);
	}
	
	
	public void setSpell(String s){
		SpellAction a;
		a=(SpellAction)StabUtils.getActionLibrary().getAction(s);
		String cc=a.getSpell().getCasterClass();
		lvl=a.getSpell().getMinimumCasterLevel();
		setAction(SpellUtils.asSpellLike(s, cc, lvl));
	}
	
	public void setAction(SpellAction action) {
		this.action = action;
		
		this.setDescription("A magical rune. It will trigger a "+SpellUtils.getGenericDescription(action.getSpell()));
	}
	
	@Override
	public void enter() {
		super.enter();
		dummy=new ActionDummy();
		dummy.setPos(this.getCenter());
		dummy.setSize(1,1);
		OnlyVisibleWithMode m= new OnlyVisibleWithMode(DetectMagic.VISIONMODE);
		dummy.addExtra(m);
		dummy.setResource(SpellUtils.getVisualAura(this.action.getSpell()));
		dummy.setAttribute(StabConstants.BAB, lvl);
		this.getScene().add(dummy);
	}
	@Override
	protected void onEnter(Info info) {
		super.onEnter(info);
		

		boolean b=cast(info);
		b=true;//parecia una buena idea, pero mejor no. o no se descargara si falla.
		if (b){
			
			if (rechargeable)
				this.setState(OFF);
			else
				destroy();
		}
	}
	
	
	@Override
	public void setState(int state) {
		super.setState(state);
		if (getState()==ON){
			if (dummy!=null)
				dummy.setVisible(true);
		}else{
			if (dummy!=null)
				dummy.setVisible(false);
		}
			
	}

	@Override
	public void destroy() {
		super.destroy();
		dummy.destroy();
	}
	
	public boolean cast(Info info){
		
		Point p=info.getPos();
	
		int result=action.execute(dummy, info, p, null);
		if (result==Action.OK)
			return true;
		
		return false;
	}
	
}

