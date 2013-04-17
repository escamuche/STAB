package com.stab.data.utils;

import com.stab.client.slick.base.map.StabBlockProperties;
import com.stab.common.map.blocks.BlockData;

public class StabBlockData  extends BlockData {
	
	public static final String ID="STAB_BLOCKDATA";
	
	public StabBlockData() {
		 fill(StabBlockProperties.EMPTY,64);
		 set(StabBlockProperties.SOLID_WALL,2,8);
		 set(StabBlockProperties.EMPTY_TILE,1,9,17,25);
		 set(StabBlockProperties.GLASS,16);
	}
}
