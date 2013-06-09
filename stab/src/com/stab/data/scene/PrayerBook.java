package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Text;

public class PrayerBook extends ActionBarSelectionScene{
	
	public static final String ID="PRAYERBOOK_SCENE";
	
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
		
		Button guidance=new Button();
		guidance.setText("Guidance");
		guidance.setIcon("ui/point");
		guidance.setMode(Label.LABEL); 
	    //bless.setAction(""); 
		guidance.setPos(Constants.BEGIN,Constants.NEXT); 
		guidance.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(guidance);
		
		Button resistance=new Button();
		resistance.setText("Resistance");
		resistance.setIcon("ui/point");
		resistance.setMode(Label.LABEL); 
	    //bless.setAction(""); 
		resistance.setPos(Constants.NEXT,Constants.PREVIOUS); 
		resistance.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(resistance);
		
		Text t3=new Text();
		t3.setText("NIVEL 1");
		t3.setPos(Constants.BEGIN,Constants.NEXT);
		t3.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t3);
		
		Button curelight=new Button();
		curelight.setText("Cure Light");
		curelight.setIcon("ui/point");
		curelight.setMode(Label.LABEL);  
	    //curelight.setAction(""); 
		curelight.setPos(Constants.BEGIN,Constants.NEXT); 
		curelight.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(curelight);
		
		Button bless=new Button();
		bless.setText("Bless");
		bless.setIcon("ui/point");
		bless.setMode(Label.LABEL); 
	    //bless.setAction(""); 
		bless.setPos(Constants.NEXT,Constants.PREVIOUS); 
		bless.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(bless);
		
		Button bane=new Button();
		bane.setText("Bane");
		bane.setIcon("ui/point");
		bane.setMode(Label.LABEL); 
	    //bless.setAction(""); 
		bane.setPos(Constants.NEXT,Constants.PREVIOUS); 
		bane.setSize(Constants.PERCENT+20,Constants.CONTENT); 
		addGUI(bane);*/
		
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

