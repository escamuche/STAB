package com.stab;

import com.stab.base.FantasyModule;
import com.stab.cards.CardsModule;
import com.stab.client.StabClient;
import com.stab.fw.ModuleDefinition;
import com.stab.fw.ModuleLibrary;
import com.stab.pf.PfModule;
import com.stab.util.StabUtils;

public class NewClient extends  StabClient {




	


	public static void main(String[] args) {
		
		//Component.DEBUG=true;
		
		NewClient client=new NewClient();
		client.start();
	
	}

	
	
	public void specificInit(){
		//new PfModule().clientInit();
		ModuleLibrary ml=StabUtils.getModuleLibrary();
		
		ModuleDefinition md= ml.fakeModule(FantasyModule.class.getResourceAsStream("/com/stab/base/module.cfg"));
		ml.addModuleDefinition(md);
		 
		 md= ml.fakeModule(PfModule.class.getResourceAsStream("/com/stab/pf/module.cfg"));
		ml.addModuleDefinition(md);
		
		 
		md= ml.fakeModule(CardsModule.class.getResourceAsStream("/com/stab/cards/module.cfg"));
		ml.addModuleDefinition(md);
	}


	@Override
	public void spawnServer() {
		NewServer srv=new NewServer();
		srv.start();
	}
	
}
