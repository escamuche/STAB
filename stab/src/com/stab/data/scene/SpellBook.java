package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.scenes.InfoDataScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Text;

public class SpellBook extends InfoDataScene{
	
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
	
		Text t2=new Text();
		t2.setText("LEVEL 0");
		t2.setPos(Constants.BEGIN,Constants.NEXT);
		t2.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t2);
		
		Button acidsplash=new Button();
	    acidsplash.setText("Acid Splash");
	    acidsplash.setIcon("ui/point");
	    acidsplash.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //acidsplash.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
	    acidsplash.setPos(Constants.BEGIN,Constants.NEXT); //Middle= en la mitad del ancho. End= al final del todo
	    acidsplash.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(acidsplash);
		
		Button flare=new Button();
		flare.setText("Flare");
		flare.setIcon("ui/point");
		flare.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //flare.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		flare.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		flare.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(flare);
		
		Button openclose=new Button();
		openclose.setText("Open/Close");
		openclose.setIcon("ui/point");
		openclose.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //openclose.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		openclose.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		openclose.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(openclose);
		
		Button rayfrost=new Button();
		rayfrost.setText("Ray of Frost");
		rayfrost.setIcon("ui/point");
		rayfrost.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //rayfrost.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		rayfrost.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		rayfrost.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(rayfrost);
		
		Button resistance=new Button();
		resistance.setText("Resistance");
		resistance.setIcon("ui/point");
		resistance.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //resistance.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		resistance.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		resistance.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(resistance);
		
		Text t3=new Text();
		t3.setText("NIVEL 1");
		t3.setPos(Constants.BEGIN,Constants.NEXT);
		t3.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(t3);
		
		Button magearmor=new Button();
		magearmor.setText("Mage Armor");
		magearmor.setIcon("ui/point");
		magearmor.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //magearmor.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		magearmor.setPos(Constants.BEGIN,Constants.NEXT); //Middle= en la mitad del ancho. End= al final del todo
		magearmor.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(magearmor);
		
		Button shield=new Button();
		shield.setText("Shield");
		shield.setIcon("ui/point");
		shield.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //shield.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		shield.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		shield.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(shield);
		
		Button shockinggrasp=new Button();
		shockinggrasp.setText("Shocking Grasp");
		shockinggrasp.setIcon("ui/point");
		shockinggrasp.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
	    //shockinggrasp.setAction(""); //Esta accion nos llegara a playerOption cuando lo pulse
		shockinggrasp.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		shockinggrasp.setSize(Constants.PERCENT+20,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(shockinggrasp);
		
		Button finish=new Button();
		finish.setText("Continuar");
		finish.setIcon("ui/point");
		finish.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
		finish.setAction("CONTINUAR"); //Esta accion nos llegara a playerOption cuando lo pulse
		finish.setPos(Constants.MIDDLE,Constants.END); //Middle= en la mitad del ancho. End= al final del todo
		finish.setSize(Constants.PERCENT+50,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(finish);
		
		Button atras=new Button();
		atras.setText("Atras");
		atras.setIcon("ui/point");
		atras.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
		atras.setAction("CONTINUAR"); //Esta accion nos llegara a playerOption cuando lo pulse
		atras.setPos(Constants.BEGIN,Constants.END); //Middle= en la mitad del ancho. End= al final del todo
		atras.setSize(Constants.PERCENT+15,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
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
