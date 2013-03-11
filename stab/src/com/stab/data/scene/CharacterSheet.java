package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.data.StabConstants;
import com.stab.data.info.player.ClericCharacter;
import com.stab.data.info.player.PathfinderCharacter;
import com.stab.data.info.player.WarriorCharacter;
import com.stab.data.info.player.WizardCharacter;
import com.stab.model.Player;
import com.stab.model.basic.scenes.InfoDataScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Text;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class CharacterSheet extends InfoDataScene{

	public static final String ID ="CHARACTER_SHEET_SCENE";
	
	Text nombre;
	Text clase;
	Text armor;
	Text bab;
	Text daño;
	Text fuerza;
	Text destreza;
	Text constitucion;
	Text inteligencia;
	Text sabiduria;
	Text carisma;
	Text fortitude;
	Text reflex;
	Text will;
	
	Button spells;
	Button feats;
	Button finish;
	
	
	@Override
	public void createContents() {
		super.createContents();
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		setLayout("--");
		
		Text t1=  new Text();
		t1.setText("Nombre:");
		t1.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t1.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t1);

		nombre= new Text();
		nombre.setText("--");
		nombre.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		nombre.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(nombre);
		
		Text t2=  new Text();
		t2.setText("Clase:");
		t2.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t2.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t2);
		
		clase=  new Text();
		clase.setText("--");
		clase.setPos(Constants.NEXT,Constants.PREVIOUS);
		clase.setSize(Constants.FILL,Constants.CONTENT); //FILL -> ocupar todo lo que pueda
		addGUI(clase);
		
		Text t3=  new Text();
		t3.setText("Armadura:");
		t3.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t3.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t3);
		
		armor = new Text();
		armor.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		armor.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(armor);
		
		Text t4=  new Text();
		t4.setText("Bono a dar:");
		t4.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t4.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t4);
		
		bab= new Text();
		bab.setText("--");
		bab.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		bab.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(bab);
		
		Text t5=  new Text();
		t5.setText("Daño:");
		t5.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t5.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t5);
		
		daño= new Text();
		daño.setText("--");
		daño.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		daño.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(daño);
		
		Text t6=  new Text();
		t6.setText("Fortitude:");
		t6.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t6.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t6);
		
		fortitude= new Text();
		fortitude.setText("--");
		fortitude.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		fortitude.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(fortitude);
		
		Text t7=  new Text();
		t7.setText("Reflex:");
		t7.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t7.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t7);
		
		reflex= new Text();
		reflex.setText("--");
		reflex.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		reflex.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(reflex);
		
		Text t8=  new Text();
		t8.setText("Will:");
		t8.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t8.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t8);
		
		will= new Text();
		will.setText("--");
		will.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		will.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(will);
		
		Text t9=  new Text();
		t9.setText("Fuerza:");
		t9.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t9.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t9);
		
		fuerza= new Text();
		fuerza.setText("--");
		fuerza.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		fuerza.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(fuerza);
		
		Text t10=  new Text();
		t10.setText("Destreza:");
		t10.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t10.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t10);
		
		destreza= new Text();
		destreza.setText("--");
		destreza.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		destreza.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(destreza);
		
		Text t11=  new Text();
		t11.setText("Constitucion:");
		t11.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t11.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t11);
		
		constitucion= new Text();
		constitucion.setText("--");
		constitucion.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		constitucion.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(constitucion);
		
		Text t12=  new Text();
		t12.setText("Inteligencia:");
		t12.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t12.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t12);
		
		inteligencia= new Text();
		inteligencia.setText("--");
		inteligencia.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		inteligencia.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(inteligencia);
		
		Text t13=  new Text();
		t13.setText("Sabiduria:");
		t13.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t13.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t13);
		
		sabiduria= new Text();
		sabiduria.setText("--");
		sabiduria.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		sabiduria.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(sabiduria);
		
		Text t14=  new Text();
		t14.setText("Carisma:");
		t14.setPos(Constants.BEGIN,Constants.NEXT);  //BEGIN = al comienzo de la linea (o de la pantalla si es vertical) NEXT= a continuacion del ultimo componente
		t14.setSize(Constants.CONTENT,Constants.CONTENT); //Content: el tamaño que ocupe lo que necesite (ej: lo necesario para pintar el texto o imagen
		addGUI(t14);
		
		carisma= new Text();
		carisma.setText("--");
		carisma.setPos(Constants.NEXT,Constants.PREVIOUS);//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		carisma.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(carisma);
		
		spells=new Button();
		spells.setText("Conjuros");
		spells.setIcon("ui/point");
		spells.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
		spells.setAction("SPELLS"); //Esta accion nos llegara a playerOption cuando lo pulse
		spells.setPos(Constants.BEGIN,Constants.NEXT); //Middle= en la mitad del ancho. End= al final del todo
		spells.setSize(Constants.PERCENT+10,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(spells);
		
		feats=new Button();
		feats.setText("Feats");
		feats.setIcon("ui/point");
		feats.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
		feats.setAction("FEATS"); //Esta accion nos llegara a playerOption cuando lo pulse
		feats.setPos(Constants.NEXT,Constants.PREVIOUS); //Middle= en la mitad del ancho. End= al final del todo
		feats.setSize(Constants.PERCENT+10,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(feats);
		
		Button atras=new Button();
		atras.setText("Atras");
		atras.setIcon("ui/point");
		atras.setMode(Label.LABEL);  
		atras.setAction("ATRAS"); 
		atras.setPos(Constants.BEGIN,Constants.END); 
		atras.setSize(Constants.PERCENT+15,Constants.CONTENT); 
		addGUI(atras);
		
		finish=new Button();
		finish.setText("Continuar");
		finish.setIcon("ui/point");
		finish.setMode(Label.LABEL);  //Hay varios tipos de boton, indicando la posicion del texto y el icono
		finish.setAction("CONTINUAR"); //Esta accion nos llegara a playerOption cuando lo pulse
		finish.setPos(Constants.MIDDLE,Constants.END); //Middle= en la mitad del ancho. End= al final del todo
		finish.setSize(Constants.PERCENT+50,Constants.CONTENT); //Percent + X = tanto por ciento del ancho total
		addGUI(finish);
		
		
		doLayout();  //Acabar con doLayout() para que organize la pantalla
	}
	
	@Override
	protected void refreshInfo(Info i) {
		PathfinderCharacter pc=(PathfinderCharacter)i;
		
		nombre.setText(i.getResource());
		if (i instanceof WarriorCharacter) 
			clase.setText("Guerrero");
		else
			if (i instanceof ClericCharacter)
				clase.setText("Clérigo");
		
			else
				if (i instanceof WizardCharacter)
					clase.setText("Mago");
		
		armor.setText(""+((BaseInfo) i).getValue(StabConstants.ARMOR));
		bab.setText(""+((BaseInfo) i).getValue(StabConstants.TOHIT));
		daño.setText(""+((BaseInfo) i).getValue(StabConstants.DAMAGE));
		fuerza.setText(""+((BaseInfo) i).getValue(StabConstants.STRENGHT));
		destreza.setText(""+((BaseInfo) i).getValue(StabConstants.DEXTERITY));
		constitucion.setText(""+((BaseInfo) i).getValue(StabConstants.CONSTITUTION));
		inteligencia.setText(""+((BaseInfo) i).getValue(StabConstants.INTELIGENCE));
		sabiduria.setText(""+((BaseInfo) i).getValue(StabConstants.WISDOM));
		carisma.setText(""+((BaseInfo) i).getValue(StabConstants.CHARISMA));
		fortitude.setText(""+((BaseInfo) i).getValue(StabConstants.FORTITUDESAVE));
		reflex.setText(""+((BaseInfo) i).getValue(StabConstants.REFLEXSAVE));
		will.setText(""+((BaseInfo) i).getValue(StabConstants.WILLSAVE));
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		//Aqui otras posibilidades (Ej: añadir un trait al pulsar un boton, etc)
		//Altamente recomendable llamar a refreshInfo si se cambia cualquier cosa en el info
		
		if ("CONTINUAR".equals(option))
			travelToScene(player,null); //Esto nos llevara a la taverna
			
		if ("SPELLS".equals(option)) {
			if(this.getInfo() instanceof WizardCharacter)
			travelToScene(player,SpellBook.ID);
		
			if(this.getInfo() instanceof ClericCharacter)
					travelToScene(player,PrayerBook.ID);
			}
		
		if ("FEATS".equals(option))
			travelToScene(player,Feats.ID);
		
		if ("ATRAS".equals(option))
			travelToScene(player,StabLobby.ID);
	}
	
}
