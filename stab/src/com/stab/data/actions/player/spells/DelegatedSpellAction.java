package com.stab.data.actions.player.spells;

public class DelegatedSpellAction extends SpellAction {

	
	
	SpellAction inner;
	
	
	public DelegatedSpellAction(SpellAction inner) {
		setInnerSpell(inner);
	}
	
	
	public void setInnerSpell(SpellAction inner) {
		this.inner = inner;
	}
	
	public SpellAction getInnerSpell() {
		return inner;
	}
	
}
