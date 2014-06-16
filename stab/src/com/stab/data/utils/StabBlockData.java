package com.stab.data.utils;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.map.StabBlockProperties;
import com.stab.common.map.blocks.BlockData;

public class StabBlockData  extends BlockData {
	
	public static final String ID="STAB_BLOCKDATA";
	
	public StabBlockData() {
		
		
		 fill(StabBlockProperties.EMPTY,64);
		 set(StabBlockProperties.SOLID_WALL,2,8,18,26,34,42,50,58);
		 set(StabBlockProperties.EMPTY_TILE,1,9,17,25,33,41,49,57);
		 set(StabBlockProperties.EMPTY_RANDOM_TILE,4,12,20,28,36,44,52,60);
		 set(StabBlockProperties.GLASS,16);
		 
		 
		//StabBlockProperties RED_TILE = StabBlockProperties.EMPTY_TILE.copy(Color.red);
		// set(RED_TILE,1,9,17,25,33,41,49,57);
	}
}
