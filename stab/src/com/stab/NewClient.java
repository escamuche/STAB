package com.stab;

import com.stab.client.StabClient;
import com.stab.data.StabInit;
import com.tien.princess.engine.sprite.ui.Component;

public class NewClient extends  StabClient {




	


	public static void main(String[] args) {
	
		
	//	Component.DEBUG=true;
		
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
