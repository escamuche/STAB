package com.stab.data.adventure.everflame;

import com.stab.data.StabConstants;
import com.stab.data.info.applicable.PathfinderAttack;
import com.stab.data.info.other.Blocked;
import com.stab.data.info.props.CDoor;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Modifier;

public class CrackDoor extends CDoor  implements Attends<PathfinderAttack> {
	
	public static final String ID="CRACKDOOR";

	public void init() {
		super.init();
		setMaxHp(30);
		healFully();
		setResource("cdoorCracks"); //Pensarse si cambiarlo para hacerlo mas notable
		setText("Cracked Door");
		setDescription("A wooden door, with a small crack in the middle");
		Blocked b= new Blocked();
		this.addTrait(b);
		
	}
	
	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof PathfinderAttack)
			return true;
		return false;
	}

	@Override
	public void attend(PathfinderAttack app) {
		if (app.hasAttended(this)) //No aplicar multiples veces
			return;
		
		PathfinderAttack a=(PathfinderAttack)app;
		if(a.isRanged())
		if (this.getMapLogic().isAdyacent(this, a.getInstigator())) //No penalizar por cover adyacente al atacante
			return;
		a.attended(this);
	
		int bonus=4;

		a.addModifier(new Modifier(StabConstants.PASSIVEDEFENSE,StabConstants.COVER,bonus));
		
		
	}
	
}
