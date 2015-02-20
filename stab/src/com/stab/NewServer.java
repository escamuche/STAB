package com.stab;

import com.stab.client.StabServer;
import com.stab.pf.StabInit;

public class NewServer extends StabServer{


	
	
	public static void main(String[] args) {
		NewServer newServer=new NewServer();
		newServer.start();
	}		
	

	
	
	public void specificInit(){
		StabInit.serverInit();
	}
	
	
}
