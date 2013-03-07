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
import com.stab.model.info.Info;

public class CharacterSheet extends InfoDataScene{

	public static final String ID ="CHARACTER_SHEET_SCENE";
	
	Text nombre;
	Text clase;
	
	
	Button finish;
	
	
	@Override
	public void createContents() {
		super.createContents();
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		
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
		
		clase=  new Text();
		clase.setText("--");
		clase.setPos(Constants.BEGIN,Constants.NEXT);
		clase.setSize(Constants.FILL,Constants.CONTENT); //FILL -> ocupar todo lo que pueda
		addGUI(clase);
		
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
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		//Aqui otras posibilidades (Ej: añadir un trait al pulsar un boton, etc)
		//Altamente recomendable llamar a refreshInfo si se cambia cualquier cosa en el info
		
		if ("CONTINUAR".equals(option));
			travelToScene(player,null); //Esto nos llevara a la taverna
		
	}
	
}
