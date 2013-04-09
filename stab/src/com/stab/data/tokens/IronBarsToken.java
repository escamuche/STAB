package com.stab.data.tokens;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.base.Door;

public class IronBarsToken extends DoorToken{

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int BAR=BytePropertiesMapData.SHADE;
	
	static	int[][]openbmd=new int[][]{{BytePropertiesMapData.EMPTY}};
	
	static 	int[][]closedbmd=new int[][]{{EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										
										 
	} ;
	
	@Override
	protected int[][] getByteMapData() {
		if (getState()==Door.CLOSED)
			return closedbmd;
		return openbmd;
		
	}
	
	
 
	
}
