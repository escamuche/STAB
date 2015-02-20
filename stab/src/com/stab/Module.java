package com.stab;

import com.stab.adventure.Game;
import com.stab.client.ClientEntityManager;
import com.stab.common.fw.ServiceManager;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.fw.MappedInheritedObjectFactory;
import com.stab.model.action.Action;
import com.stab.model.action.ActionLibrary;

public abstract class Module {

	public static final int BASE=1;
	public static final int RULESET=10;
	public static final int EXPANSION=50;
	public static final int CONTENT=100;
	
	
	private String id;
	private int priority;
	private MappedInheritedObjectFactory of=null; 

	
	String name;
	String description;
	boolean main;
	
	public Module(String ID,int priority,boolean main) {
		this.id=ID;
		this.priority=priority;
		this.main=main;
	}
	
	public String getID(){
		return id;
	}
	public int getPriority() {
		return priority;
	}
	
	public boolean isMain() {
		return main;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public MappedInheritedObjectFactory getFactory(){
		return of;
	}
	public void setFactory(MappedInheritedObjectFactory of) {
		this.of = of;
	}
	
	 public void clientInit(){
		commonInit();
		ClientEntityManager em=ServiceManager.getService(ClientEntityManager.class);
		if (em!=null)
			em.registerFactory(of);
			
		 
	 }
	 
	 
	 public void serverInit(){
		commonInit();
		EntityManager em=ServiceManager.getService(EntityManager.class);
		if (em!=null)
			em.registerFactory(of);
		if (isMain()){
			Game g=createGame();
			g.init();
			ServiceManager.register(Game.class,g);
		}
	
	 }
	 
	 
	 protected Game createGame(){
		 return new Game();
	 }
	 
	 public void commonInit(){
		if (of==null)
			createFactory();
		
	 }
	 
	 void createFactory(){
		setFactory(new BasicObjectFactory());
	 }
	
	 
	public void setMapping(Class c){
		of.setMapping(c);
	}
	public void setMapping(String id,Class c){
		of.setMapping(id,c);
	}
	public void setMapping(String id,String c){
		of.setMapping(id,c);
	}
	public  void registerAction(Class c){
		 ActionLibrary.getActionLibrary().register(c);
	}
	public  void registerAction(String id,Action a){
		 ActionLibrary.getActionLibrary().register(id, a);
	}

	 
}
