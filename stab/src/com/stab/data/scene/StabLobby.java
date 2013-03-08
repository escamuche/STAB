package com.stab.data.scene;

import com.stab.data.info.player.ClericCharacter;
import com.stab.data.info.player.WarriorCharacter;
import com.stab.data.info.player.WizardCharacter;
import com.stab.model.Player;
import com.stab.model.Scene;
import com.stab.model.basic.scenes.Lobby;
import com.stab.model.basic.ui.Backdrop;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Music;
import com.stab.model.info.base.Character;

public class StabLobby  extends Scene{

	public static final String ID =Lobby.ID;
	
	
	@Override
	public void init() {
		super.init();
		
		Backdrop bd=new Backdrop();
		add(bd);
		bd.setResource("back/lobby$S");
		Button i=new Button();
		i.setPos(30,200);
		i.setSize(200,400);
		i.setIcon("warrior$S");
		i.setAction("warrior");
//		i.setMode(Constants.ICON);
//		i.setText("Warrior");
		i.setMargin(10);
		add(i);
		i=new Button();
		i.setPos(230+40,200);
		i.setSize(200,400);
		i.setIcon("rogue$S");
		i.setAction("rogue");
//		i.setMode(Constants.AVATAR);
//		i.setText("Rogue");
		i.setMargin(10);
		i.setDisabled(true);
		add(i);
		i=new Button();
		i.setPos(430+80,200);
		i.setSize(200,400);
		i.setIcon("wizard$S");
		i.setAction("wizard");
//		i.setText("Wizard");
		i.setMargin(10);
//		i.setDisabled(true);
		add(i);
		i=new Button();
		i.setPos(630+120,200);
		i.setSize(200,400);
		i.setIcon("cleric$S");
		i.setAction("cleric");
//		i.setMode(Constants.BANNER);
//		i.setText("Cleric");
		i.setMargin(10);
//		i.setDisabled(true);
		add(i);
	
		Music m=new Music();
		m.setResource("calm1");
		this.add(m);
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		player.setIcon(option);
		
		Character infowarrior=new WarriorCharacter();
		Character infowizard=new WizardCharacter();
		Character infocleric=new ClericCharacter();
		
		if(option.equals("warrior")) {
		player.setIcon("tokens/tokenWarrior");
		player.addInfo(infowarrior);
		infowarrior.setText(player.getName());
		}
		
		if(option.equals("wizard")) {
			player.setIcon("tokens/tokenWizard");
			player.addInfo(infowizard);	
			infowizard.setText(player.getName());
			}
		
		if(option.equals("cleric")) {
			player.setIcon("tokens/tokenCleric");
			player.addInfo(infocleric);	
			infocleric.setText(player.getName());
			}
//		info.setText(player.getName());
	
//		player.addInfo(info);
		
		
		//player.setCharacter(info);
	
		travelToScene(player,null);
	}
	
}
