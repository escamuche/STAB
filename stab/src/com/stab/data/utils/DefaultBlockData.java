package com.stab.data.utils;

import com.stab.common.map.blocks.BlockData;
import com.stab.common.map.blocks.DefaultBlockProperties;

public class DefaultBlockData extends BlockData {
	
	public static final String ID="DEFAULT_BLOCKDATA";
	
	public DefaultBlockData() {
		 fill(DefaultBlockProperties.SOLID,64);
		 set(DefaultBlockProperties.EMPTY,2,8,9,16,17,11);
	}

}
