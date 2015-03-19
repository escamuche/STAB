package com.stab.cards;

import com.stab.common.utils.Roll;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.applicable.base.SkillRoll;

public class TableSkillRoll extends SkillRoll
{

	static int[] chances={0,10,25,50,75,90,100}; 
	
	public static final int IMPOSSIBLE=50;
	public static final int AUTOMATIC=51;
	
	public TableSkillRoll(BaseInfo instigator, String skill, int target) {
		super(instigator, skill, target);
		//No es necesario, porque no tiramos normalmente, pero por si acaso lo dejo claro
		this.cantCrit();
		setDice(100);
		setBotchRange(0);
		setCritRange(0);
	}
	
	public void validate() {
		if (getResult()==AUTOMATIC_FAIL || getResult()==AUTOMATIC_SUCCESS)
			return;
		if (failed())
			return;
		int r=getFinalModifier();
		int t=getFinalTargetNumber();
		int diff= r-t;
		if (diff<=-3){
			setResult(IMPOSSIBLE);
		}else
			if (diff>=3){
				setResult(AUTOMATIC);
			}else{
			
				int roll=Roll.d100();
				if (roll<=chances[diff+3])
					setResult(SUCCESS);
				else
					setResult(FAIL);
			}
			
	}

	@Override
	public boolean failed() {
		if (getResult()==IMPOSSIBLE)
			return true;
		if (getResult()==AUTOMATIC)
			return false;
		return super.failed();
	}
	
	
	
}
