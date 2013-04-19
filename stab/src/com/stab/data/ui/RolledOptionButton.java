package com.stab.data.ui;

import java.util.Hashtable;

import com.stab.common.utils.Roll;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;

/**
 * Esta clase subira a la libreria
 *
 */
public class RolledOptionButton  extends Button {
	
	
	Hashtable<Integer,String> options;
	
	public static final String ID="ROLLEDOPTIONBUTTON_ENTITY";
	
	int dice;
	
	@Override
	public void init() {
		super.init();
		setAction("ROLL"); //Por poner un valor por defecto
		options= new Hashtable<Integer,String>();
		dice=10;
	}
	
	public void setResult(int i,String result){
		options.put(i, result);
	}
	public void setResult(int i,int j,String result){
		for (int f=i;f<=j;f++)
			options.put(f, result);
	}
	
	
	public void setDice(int dice) {
		this.dice = dice;
	}
	
	@Override
	protected void performAction(Player actor, String action) {
		int result=makeRoll(actor); 
		String r=options.get(result);
		if (r==null)
			r=getAction();
		super.performAction(actor, r);
	}

	protected  int makeRoll(Player actor) {
		return Roll.roll(dice); //Por poner un roll por defecto
	}

}
