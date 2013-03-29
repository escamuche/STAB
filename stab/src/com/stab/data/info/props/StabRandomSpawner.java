package com.stab.data.info.props;

import com.stab.data.StabConstants;
import com.stab.model.info.base.RandomSpawner;

public class StabRandomSpawner extends RandomSpawner {

	public static final String ID="RANDOM_INFO";
	
	@Override
	public void setTable(String table) {
	if (table.indexOf(":")==-1)  
		table=StabConstants.getString(table);  //No tiene pinta de tabla, leer de una constante de stabInit
		super.setTable(table);
	}
	
}
