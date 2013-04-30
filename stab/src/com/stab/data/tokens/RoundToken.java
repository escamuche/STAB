package com.stab.data.tokens;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.basic.token.interfaces.AffectsVisibility;

public class RoundToken extends PhysicalToken  implements AffectsVisibility{
	
	public static final String ID="ROUD_TOKEN";

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int SOLID=BytePropertiesMapData.SHADESOLID;
	
	
	static 	int[][]closedibmd=new int[][]{{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,SOLID,SOLID,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID,EMPTY,EMPTY},
										 {EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID,EMPTY,EMPTY},
										 {EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID,EMPTY,EMPTY},
										 {EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,SOLID,SOLID,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										
										 
	} ;
	

	protected int[][] getByteMapData() {
		return closedibmd;
	
	}


	@Override
	public float getTransparency() {
		return 0;
	}
	
	
 
	
}
