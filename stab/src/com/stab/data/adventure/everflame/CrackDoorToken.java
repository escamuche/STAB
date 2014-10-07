package com.stab.data.adventure.everflame;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.base.Door;

public class CrackDoorToken extends   DoorToken{
	
	public static final String ID="CRACKDOOR_TOKEN";

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int BAR=BytePropertiesMapData.WALL;
	
	static	int[][]openibmd=new int[][]{{BytePropertiesMapData.EMPTY}};
	
	static 	int[][]closedibmd=new int[][]{{EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,BAR,BAR,EMPTY,EMPTY,EMPTY},
										
										 
	} ;
	
	@Override
	protected int[][] getByteMapData() {
		if (getState()==Door.CLOSED)
			return closedibmd;
		return openibmd;
		
	}
	
}
