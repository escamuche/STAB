package com.stab.data.info.props;

import java.awt.Rectangle;

import com.stab.annotations.Injected;
import com.stab.model.info.Info;

public class Wall extends Info {

	
	public static final String ID="WALL";
	
	@Injected
	int tile;
	
	
	@Override
	public void init() {
		super.init();
		this.setSize(1, 1);
		tile=2;
		
	}
	
	public void setTile(int tile) {
		this.tile = tile;
	}
	
	@Override
	public void enter() {
		super.enter();
		Rectangle r=this.getBounds();
		for (int y = r.y; y < r.y + r.height; y++)
			for (int x = r.x; x < r.x + r.width; x++) {
				this.getMapLogic().setTile(x, y, tile);		
			}
		
		destroy();
	}
	
}
