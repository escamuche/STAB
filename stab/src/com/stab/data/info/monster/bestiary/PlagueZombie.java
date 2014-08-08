package com.stab.data.info.monster.bestiary;

import com.stab.data.actions.monster.BileSplash;
import com.stab.data.info.traits.DisguisesAsExtra;

public class PlagueZombie extends Zombie {

	public static final String ID="PLAGUEZOMBIE_INFO";
	
	@Override
	public void init() {
		super.init();
		setText("Plague zombie");
		setDescription("Foul vapor emanate from its swollen belly. Seems about to burst!");
		setResource("plaguezombie");
		
		DisguisesAsExtra d= new DisguisesAsExtra(new Zombie());
		d.setSkill(null,0);
		addTrait(d);
	
	}
	
	
	@Override
	protected void onDeath() {
		BileSplash b= new BileSplash();
		b.execute(this, this, this.getPos(), null);
		super.onDeath();
		
	}
	
}
