package com.stab.base.tokens;

import com.stab.common.map.BytePropertiesMapData;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.basic.token.interfaces.AffectsVisibility;

public class SlabToken extends PhysicalToken implements AffectsVisibility{
	
	public static final String ID="SLAB_TOKEN";

	public static int EMPTY=BytePropertiesMapData.EMPTY;
	public static int SOLI2=BytePropertiesMapData.SHADE;
	public static int SOLID=BytePropertiesMapData.SHADEVIEW;
	
	
	static 	int[][]closedibmd=new int[][]{{EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLI2},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLID},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,SOLI2,SOLI2},
										 {EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY},
										
										 
	} ;
	

	protected int[][] getByteMapData() {
		return closedibmd;
	
	}

	@Override
	public boolean isSolid() {
		return false;
	}
	
	@Override
	public boolean breaksLoS() {
		return false;
	}

	@Override
	public float getTransparency() {
		return 1.0f;
	}
	
	


}

