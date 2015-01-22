package com.stab.data.tokens;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.basic.token.interfaces.AffectsVisibility;

public class NicheToken  extends PhysicalToken implements AffectsVisibility{
	
	public static final String ID="NICHE_TOKEN";

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int SOLID=BytePropertiesMapData.SHADEVIEW;
	
	
	static 	int[][]closedibmd=new int[][]{{SOLID,SOLID,SOLID,SOLID,SOLID,SOLID,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,SOLID,SOLID,SOLID,SOLID},
										 {SOLID,SOLID,SOLID,SOLID,SOLID,SOLID,SOLID,SOLID},
										
										 
	} ;
	
	
	@Override
	public boolean isSolid() {
		return false;
	}
	

	protected int[][] getByteMapData() {
		return closedibmd;
	
	}


	@Override
	public float getTransparency() {
		return 1.0f;
	}
	
	


}
