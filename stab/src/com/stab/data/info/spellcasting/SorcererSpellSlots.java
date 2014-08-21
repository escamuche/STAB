package com.stab.data.info.spellcasting;

import com.stab.data.StabConstants;

public class SorcererSpellSlots extends SpontaneousSpellSlots{

	public static final String ID="SORCERER_SLOTS";
	
	static int[][] BASE= new int[][]{
			{3,0,0,0,0,0,0,0,0},
			{4,0,0,0,0,0,0,0,0},
			{5,0,0,0,0,0,0,0,0},
			{6,3,0,0,0,0,0,0,0},
			{6,4,0,0,0,0,0,0,0},
			{6,5,3,0,0,0,0,0,0},
			{6,6,4,0,0,0,0,0,0},
			{6,6,5,3,0,0,0,0,0},
			{6,6,6,4,0,0,0,0,0},
			{6,6,6,5,3,0,0,0,0},
			{6,6,6,6,4,0,0,0,0},
			{6,6,6,6,5,3,0,0,0},
			{6,6,6,6,6,4,0,0,0},
			{6,6,6,6,6,5,3,0,0},
			{6,6,6,6,6,6,4,0,0},
			{6,6,6,6,6,6,5,3,0},
			{6,6,6,6,6,6,6,4,0},
			{6,6,6,6,6,6,6,5,3},
			{6,6,6,6,6,6,6,6,4},
			{6,6,6,6,6,6,6,6,6}
	};
	
	
	
	
	
	public SorcererSpellSlots() {
		setBase(BASE);
		setStat(StabConstants.CHARISMA);
		setCasterClass(StabConstants.SORCERERCASTER);
	}
	
	

}
