package com.stab.data.info.props;

import com.stab.common.utils.WeightedTable;
import com.stab.model.info.base.RandomSpawner;
import com.stab.pf.StabTables;
import com.stab.util.InfosWeightedTable;

public class StabRandomSpawner extends RandomSpawner {

	public static final String ID=RandomSpawner.ID;
	
	@Override
	public void setTable(String table) {
		if (table.indexOf(":")==-1) { 
			WeightedTable t=StabTables.getTable(table);  //No tiene pinta de tabla, leer de una constante de stabInit
			setTable((InfosWeightedTable)t);
			return;
		}
		super.setTable(table);
	}
	
	
	@Override
	public void spawn(String s) {
		if (s.startsWith("TABLE#")){
			InfosWeightedTable tb= (InfosWeightedTable) StabTables.getTable(s.substring(6));
			String[] data=tb.getTypedValue();
			for(String ss:data){
					spawn(ss);
				}
			return;
		}
		super.spawn(s);
	}
	
	
}
