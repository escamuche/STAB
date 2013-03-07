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
		
		armor = new Text();
		armor.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		armor.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(armor);
		
		bab= new Text();
		bab.setText("--");
		bab.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		bab.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(bab);
		
		daño= new Text();
		daño.setText("--");
		daño.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		daño.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(daño);
		
		fortitude= new Text();
		fortitude.setText("--");
		fortitude.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		fortitude.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(fortitude);
		
		reflex= new Text();
		reflex.setText("--");
		reflex.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		reflex.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(reflex);
		
		will= new Text();
		will.setText("--");
		will.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		will.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(will);
		
		fuerza= new Text();
		fuerza.setText("--");
		fuerza.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		fuerza.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(fuerza);
		
		destreza= new Text();
		destreza.setText("--");
		destreza.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		destreza.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(destreza);
		
		constitucion= new Text();
		constitucion.setText("--");
		constitucion.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		constitucion.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(constitucion);
		
		inteligencia= new Text();
		inteligencia.setText("--");
		inteligencia.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		inteligencia.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(inteligencia);
		
		sabiduria= new Text();
		sabiduria.setText("--");
		sabiduria.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		sabiduria.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(sabiduria);
		
		carisma= new Text();
		carisma.setText("--");
		carisma.setPos(Constants.NEXT,Constants.PREVIOUS );//Next para que vaya a continuacion del ultimo componente en la X, Previous, para que este a la altura del anterior componente
		carisma.setSize(Constants.FILL,Constants.CONTENT);
		addGUI(carisma);
		
		
		doLayout();  //Acabar con doLayout() para que organize la pantalla
	}
	
	@Override
	protected void refreshInfo(Info i) {
		PathfinderCharacter pc=(PathfinderCharacter)i;
		
		nombre.setText(i.getResource());
		if (i instanceof WarriorCharacter) {
			clase.setText("Guerrero");
			armor.setText(StabConstants.ARMOR);
			bab.setText(StabConstants.BAB);
			daño.setText(StabConstants.DAMAGE);
			fuerza.setText(StabConstants.STRENGHT);
			destreza.setText(StabConstants.DEXTERITY);
			constitucion.setText(StabConstants.CONSTITUTION);
			inteligencia.setText(StabConstants.INTELIGENCE);
			sabiduria.setText(StabConstants.WISDOM);
			carisma.setText(StabConstants.CHARISMA);
			fortitude.setText(StabConstants.FORTITUDESAVE);
			reflex.setText(StabConstants.REFLEXSAVE);
			will.setText(StabConstants.WILLSAVE);
		}
		else
			if (i instanceof ClericCharacter) {
				clase.setText("Clérigo");
				armor.setText(StabConstants.ARMOR);
				bab.setText(StabConstants.BAB);
				daño.setText(StabConstants.DAMAGE);
				fuerza.setText(StabConstants.STRENGHT);
				destreza.setText(StabConstants.DEXTERITY);
				constitucion.setText(StabConstants.CONSTITUTION);
				inteligencia.setText(StabConstants.INTELIGENCE);
				sabiduria.setText(StabConstants.WISDOM);
				carisma.setText(StabConstants.CHARISMA);
				fortitude.setText(StabConstants.FORTITUDESAVE);
				reflex.setText(StabConstants.REFLEXSAVE);
				will.setText(StabConstants.WILLSAVE);
			}
			else
				if (i instanceof WizardCharacter) {
					clase.setText("Mago");
					armor.setText(StabConstants.ARMOR);
					bab.setText(StabConstants.BAB);
					daño.setText(StabConstants.DAMAGE);
					fuerza.setText(StabConstants.STRENGHT);
					destreza.setText(StabConstants.DEXTERITY);
					constitucion.setText(StabConstants.CONSTITUTION);
					inteligencia.setText(StabConstants.INTELIGENCE);
					sabiduria.setText(StabConstants.WISDOM);
					carisma.setText(StabConstants.CHARISMA);
					fortitude.setText(StabConstants.FORTITUDESAVE);
					reflex.setText(StabConstants.REFLEXSAVE);
					will.setText(StabConstants.WILLSAVE);
				}
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		//Aqui otras posibilidades (Ej: añadir un trait al pulsar un boton, etc)
		//Altamente recomendable llamar a refreshInfo si se cambia cualquier cosa en el info
		
		if ("CONTINUAR".equals(option));
			travelToScene(player,null); //Esto nos llevara a la taverna
		
	}
	
}
