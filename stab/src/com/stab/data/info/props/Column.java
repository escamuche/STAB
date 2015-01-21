package com.stab.data.info.props;

import java.util.Random;

import com.stab.model.basic.token.Token;

public class Column extends Statue {

	public static final String ID="COLUMN";
	
	static String[] res={"props/1x1Column1","props/1x1Column2","props/1x1Column3"};
	
	@Override
	public void init() {
		super.init();
		this.setInvulnerable(true);
		setResource(res[new Random().nextInt(3)]);
		this.setText("Column");
		this.setSelectable(Token.NOT_SELECTABLE);
		this.setDescription("A stone column, cracked, but standing still");
		setAngle('R');
	}
	
}
