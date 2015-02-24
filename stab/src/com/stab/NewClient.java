package com.stab;

import com.stab.client.StabClient;
import com.stab.pf.StabInit;
import com.tien.princess.engine.Resources;

public class NewClient extends  StabClient {




	


	public static void main(String[] args) {
		
		//Component.DEBUG=true;
		
		NewClient client=new NewClient();
		client.start();
	
	}

	
	
	public void specificInit(){
		StabInit.clientInit();
	}


	@Override
	public void spawnServer() {
		NewServer srv=new NewServer();
		srv.start();
	}
	
}
