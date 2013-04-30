package com.stab.data.tokens;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.DoorToken;
import com.stab.model.info.base.Door;

public class RDoorToken extends DoorToken{
	
	public static final String ID="RDOOR_TOKEN";

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int DOOR=BytePropertiesMapData.WALL;
	public static int OPEN=BytePropertiesMapData.SHADE;
	
	
	static 	int[][]closedibmd=new int[][]{
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,DOOR},
	} ;
	static 	int[][]openibmd=new int[][]{
		{OPEN,OPEN,OPEN,OPEN,OPEN,OPEN,OPEN,OPEN},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
		
	} ;
	
	@Override
	protected int[][] getByteMapData() {
		if (getState()==Door.CLOSED)
			return closedibmd;
		return openibmd;
		
	}
	
	
 
	
}
