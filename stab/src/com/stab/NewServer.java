package com.stab;

import com.stab.base.FantasyModule;
import com.stab.client.StabServer;
import com.stab.fw.ModuleDefinition;
import com.stab.fw.ModuleLibrary;
import com.stab.pf.PfModule;
import com.stab.util.StabUtils;

public class NewServer extends StabServer{


	
	
	public static void main(String[] args) {
		NewServer newServer=new NewServer();
		newServer.start();
	}		
	

	
	
	public void specificInit(){
		ModuleLibrary ml=StabUtils.getModuleLibrary();
		ModuleDefinition md= ml.fakeModule(FantasyModule.class.getResourceAsStream("/com/stab/base/module.cfg"));
		ml.addModuleDefinition(md);
		
		 md= ml.fakeModule(PfModule.class.getResourceAsStream("/com/stab/pf/module.cfg"));
		ml.addModuleDefinition(md);
		
		//md= ml.fakeModule(PfModule.class.getResourceAsStream("/com/stab/cards/module.cfg"));
		//ml.addModuleDefinition(md);
	}
	
	
}
