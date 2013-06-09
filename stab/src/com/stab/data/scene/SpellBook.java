package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Text;

public class SpellBook extends ActionBarSelectionScene{
	
	public static final String ID="SPELLBOOK_SCENE";
	
	public void createContents() {
		super.createContents();
		
		
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		//setLayout("--");
		
		Text t1=new Text();
		t1.setText("SELECCIONA TUS CONJUROS");
		t1.setPos(Constants.MIDDLE,Constants.BEGIN);
		t1.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t1);
	
		
		
		for(int b=20;b<34;b++) {
			ActionSlotButton boton=createButton(b);
			if (b==20 || b==25 || b==30)
				boton.setPos(Constants.BEGIN,Constants.NEXT_MAX);
			addGUI(boton);
			}
		
		Text t2=new Text();
		t2.setText(" ");
		t2.setPos(Constants.BEGIN,Constants.NEXT);
		t2.setSize(0,120);
		addGUI(t2);
		
		createActionBar();
		
		/*Text t2=new Text();
		t2.setText("LEVEL 0");
		t2.setPos(Constants.BEGIN,Constants.NEXT);
		t2.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t2); 
		acidsplash=new Button();
	    acidsplash.setText("Acid Splash");
	    acidsplash.setIcon("ui/point");
	    acidsplash.setMode(Label.LABEL);  
	    //acidsplash.setAction(""); 
	    acidsplash.setPos(Constants.BEGIN,Constants.NEXT); 
	    acidsplash.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(acidsplash);
		
		Button flare=new Button();
		flare.setText("Flare");
		flare.setIcon("ui/point");
		flare.setMode(Label.LABEL);  
	    //flare.setAction(""); 
		flare.setPos(Constants.NEXT,Constants.PREVIOUS); 
		flare.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(flare);
		
		Button openclose=new Button();
		openclose.setText("Open/Close");
		openclose.setIcon("ui/point");
		openclose.setMode(Label.LABEL);  
	    //openclose.setAction(""); 
		openclose.setPos(Constants.NEXT,Constants.PREVIOUS); 
		openclose.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(openclose);
		
		Button rayfrost=new Button();
		rayfrost.setText("Ray of Frost");
		rayfrost.setIcon("ui/point");
		rayfrost.setMode(Label.LABEL);  
	    //rayfrost.setAction(""); 
		rayfrost.setPos(Constants.NEXT,Constants.PREVIOUS); 
		rayfrost.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(rayfrost);
		
		Button resistance=new Button();
		resistance.setText("Resistance");
		resistance.setIcon("ui/point");
		resistance.setMode(Label.LABEL);  
	    //resistance.setAction(""); 
		resistance.setPos(Constants.NEXT,Constants.PREVIOUS); 
		resistance.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(resistance);
		
		Text t3=new Text();
		t3.setText("NIVEL 1");
		t3.setPos(Constants.BEGIN,Constants.NEXT);
		t3.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t3);
		
		Button magearmor=new Button();
		magearmor.setText("Mage Armor");
		magearmor.setIcon("ui/point");
		magearmor.setMode(Label.LABEL);  
	    //magearmor.setAction(""); 
		magearmor.setPos(Constants.BEGIN,Constants.NEXT); 
		magearmor.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(magearmor);
		
		Button shield=new Button();
		shield.setText("Shield");
		shield.setIcon("ui/point");
		shield.setMode(Label.LABEL); 
	    //shield.setAction(""); 
		shield.setPos(Constants.NEXT,Constants.PREVIOUS); 
		shield.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(shield);
		
		Button shockinggrasp=new Button();
		shockinggrasp.setText("Shocking Grasp");
		shockinggrasp.setIcon("ui/point");
		shockinggrasp.setMode(Label.LABEL);  
	    //shockinggrasp.setAction(""); 
		shockinggrasp.setPos(Constants.NEXT,Constants.PREVIOUS); 
		shockinggrasp.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(shockinggrasp);
		
		Button magicmissile=new Button();
		magicmissile.setText("Magic Missile");
		magicmissile.setIcon("ui/point");
		magicmissile.setMode(Label.LABEL); 
	    //magicmissile.setAction(""); 
		magicmissile.setPos(Constants.NEXT,Constants.PREVIOUS); 
		magicmissile.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(magicmissile);
		
		Button chill=new Button();
		chill.setText("Chill Touch");
		chill.setIcon("ui/point");
		chill.setMode(Label.LABEL); 
	    //chill.setAction(""); 
		chill.setPos(Constants.NEXT,Constants.PREVIOUS); 
		chill.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(chill);
		
		Button strike=new Button();
		strike.setText("True Strike");
		strike.setIcon("ui/point");
		strike.setMode(Label.LABEL); 
	    //strike.setAction(""); 
		strike.setPos(Constants.BEGIN,Constants.NEXT); 
		strike.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(strike);
	
		Button enlarge=new Button();
		enlarge.setText("Enlarge Person");
		enlarge.setIcon("ui/point");
		enlarge.setMode(Label.LABEL); 
	    //enlarge.setAction(""); 
		enlarge.setPos(Constants.NEXT,Constants.PREVIOUS); 
		enlarge.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(enlarge);*/
		
		Button finish=new Button();
		finish.setText("Continuar");
		finish.setImage("ui/point");
		finish.setMode(Label.LABEL);  
		finish.setAction("CONTINUAR"); 
		finish.setPos(Constants.MIDDLE,Constants.END); 
		finish.setSize(Constants.PERCENT+50,Constants.CONTENT); 
		addGUI(finish);
		
		Button atras=new Button();
		atras.setText("Atras");
		atras.setImage("ui/point");
		atras.setMode(Label.LABEL);  
		atras.setAction("ATRAS"); 
		atras.setPos(Constants.BEGIN,Constants.END); 
		atras.setSize(Constants.PERCENT+15,Constants.CONTENT); 
		addGUI(atras);
		
		
		doLayout();
	}
	
	
	
	@Override
	public void playerOption(Player player, String option) {
		
		//Aqui otras posibilidades (Ej: añadir un trait al pulsar un boton, etc)
		//Altamente recomendable llamar a refreshInfo si se cambia cualquier cosa en el info
		
		if ("CONTINUAR".equals(option))
			travelToScene(player,null);
		
		if ("ATRAS".equals(option))
			travelToScene(player,CharacterSheet.ID);
		
	}

}
