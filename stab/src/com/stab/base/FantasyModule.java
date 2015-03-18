package com.stab.base;

import com.stab.common.fw.Loader;
import com.stab.fw.ModInfo;
import com.stab.fw.Module;

@ModInfo(
		id = "FANTASY_MODULE", 
		name = "Fantasy base Module",
		description="A module with the base for fantasy settings",
		version= 1.0,
		priority=10,
		clientNeeded=true
		) 
public class FantasyModule extends Module {

	public static final String ID="FANTASY_MODULE";
	
	public void commonInit(){
		
		Loader.addDir("res");
		
	}
	
	
	@Override
	public void serverInit() {
		super.serverInit();
	
	}
	
}
