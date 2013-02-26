package com.stab;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.swing.SwingUtilities;

import com.stab.client.Configuration;
import com.stab.client.ResourceManager;
import com.stab.client.Session;
import com.stab.client.StabClient;
import com.stab.client.StabServer;
import com.stab.client.VisualEngine;
import com.stab.client.slick.StabGame;
import com.stab.client.slick.StabVisualEngine;
import com.stab.common.fw.MappedObjectFactory;
import com.stab.common.fw.ServiceManager;
import com.stab.data.StabInit;
import com.stab.fw.Initializations;
import com.stab.fw.Logs;
import com.stab.util.Roll;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.SlickEngine;

public class NewClient extends  StabClient {




	


	public static void main(String[] args) {
	
		
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
