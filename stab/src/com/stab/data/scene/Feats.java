package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.basic.scenes.InfoDataScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Label;

public class Feats extends InfoDataScene{
	public static final String ID="FEATS_SCENE";

	public void createContents() {
		super.createContents();
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		setLayout("--");
		
		Button atras=new Button();
		atras.setText("Atras");
		atras.setIcon("ui/point");
		atras.setMode(Label.LABEL);  
		atras.setAction("ATRAS");
		atras.setPos(Constants.BEGIN,Constants.END); 
		atras.setSize(Constants.PERCENT+15,Constants.CONTENT);
		addGUI(atras);
		
		Button finish=new Button();
		finish.setText("Continuar");
		finish.setIcon("ui/point");
		finish.setMode(Label.LABEL);  
		finish.setAction("CONTINUAR");
		finish.setPos(Constants.MIDDLE,Constants.END); 
		finish.setSize(Constants.PERCENT+50,Constants.CONTENT); 
		addGUI(finish);
		
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