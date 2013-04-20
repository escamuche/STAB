package com.stab.data.scene;

import com.stab.data.info.player.BarbarianCharacter;
import com.stab.data.info.player.BardCharacter;
import com.stab.data.info.player.ClericCharacter;
import com.stab.data.info.player.DruidCharacter;
import com.stab.data.info.player.FighterCharacter;
import com.stab.data.info.player.MonkCharacter;
import com.stab.data.info.player.PaladinCharacter;
import com.stab.data.info.player.RangerCharacter;
import com.stab.data.info.player.RogueCharacter;
import com.stab.data.info.player.SorcererCharacter;
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
	//	bd.setResource("SHADER#infernal#back/lobby$S");
	//	bd.setResource("COLOR#blue");
		Button i=new Button();
	/*	i.setPos(30,200);
		i.setSize(200,400);
		i.setIcon("warrior$S");
		i.setAction("warrior");
//		i.setMode(Constants.ICON);
//		i.setText("Warrior");
		i.setMargin(10);
		add(i);
		/**/
		
		i.setPos(30,200);
		i.setSize(140,200);
		i.setIcon("barbarian$S");
		i.setAction("barbarian");
//		i.setMode(Constants.ICON);
//		i.setText("Warrior");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(170+35,200);
		i.setSize(140,200);
		i.setIcon("bard$S");
		i.setAction("bard");
//		i.setMode(Constants.AVATAR);
//		i.setText("Rogue");
		i.setMargin(10);
//		i.setDisabled(true);
		add(i);
		i=new Button();
		i.setPos(310+70,200);
		i.setSize(140,200);
		i.setIcon("cleric$S");
		i.setAction("cleric");
//		i.setText("Wizard");
		i.setMargin(10);
//		i.setDisabled(true);
		add(i);
		i=new Button();
		i.setPos(450+105,200);
		i.setSize(140,200);
		i.setIcon("druid$S");
		i.setAction("druid");
//		i.setMode(Constants.BANNER);
//		i.setText("Cleric");
		i.setMargin(10);
//		i.setDisabled(true);
		add(i);
	
		i=new Button();
		i.setPos(690+20,200);
		i.setSize(140,200);
		i.setIcon("fighter$S");
		i.setAction("fighter");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(830+40,200);
		i.setSize(140,200);
		i.setIcon("monk$S");
		i.setAction("monk");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(40,440);
		i.setSize(140,200);
		i.setIcon("paladin$S");
		i.setAction("paladin");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(170+50,440);
		i.setSize(140,200);
		i.setIcon("ranger$S");
		i.setAction("ranger");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(310+100,440);
		i.setSize(140,200);
		i.setIcon("rogue$S");
		i.setAction("rogue");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(450+150,440);
		i.setSize(140,200);
		i.setIcon("sorcerer$S");
		i.setAction("sorcerer");
		i.setMargin(10);
		add(i);
		
		i=new Button();
		i.setPos(590+200,440);
		i.setSize(140,200);
		i.setIcon("wizard$S");
		i.setAction("wizard");
		i.setMargin(10);
		add(i);
		
		Music m=new Music();
		m.setResource("calm1");
		this.add(m);
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		player.setIcon(option);
		player.removeAllInfo();
		
	//	Character infowarrior=new WarriorCharacter();
		Character infowizard=new WizardCharacter();
		Character infocleric=new ClericCharacter();
		Character infobarbarian=new BarbarianCharacter();
		Character infobard=new BardCharacter();
		Character infodruid=new DruidCharacter();
		Character infofighter=new FighterCharacter();
		Character infomonk=new MonkCharacter();
		Character infopaladin=new PaladinCharacter();
		Character inforanger=new RangerCharacter();
		Character inforogue=new RogueCharacter();
		Character infosorcerer=new SorcererCharacter();
		
	/*	if(option.equals("warrior")) {
		player.setIcon("tokens/tokenWarrior");
		player.addInfo(infowarrior);
		infowarrior.setText(player.getName());
		}
		/**/
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
		if(option.equals("barbarian")) {
			player.setIcon("tokens/tokenBarbarian");
			player.addInfo(infobarbarian);
			infobarbarian.setText(player.getName());
			}
		if(option.equals("bard")) {
			player.setIcon("tokens/tokenBard");
			player.addInfo(infobard);
			infobard.setText(player.getName());
			}
		if(option.equals("druid")) {
			player.setIcon("tokens/tokenDruid");
			player.addInfo(infodruid);
			infodruid.setText(player.getName());
			}
		if(option.equals("fighter")) {
			player.setIcon("tokens/tokenFighter");
			player.addInfo(infofighter);
			infofighter.setText(player.getName());
			}
		if(option.equals("monk")) {
			player.setIcon("tokens/tokenMonk");
			player.addInfo(infomonk);
			infomonk.setText(player.getName());
			}
		if(option.equals("paladin")) {
			player.setIcon("tokens/tokenPaladin");
			player.addInfo(infopaladin);
			infopaladin.setText(player.getName());
			}
		if(option.equals("ranger")) {
			player.setIcon("tokens/tokenRanger");
			player.addInfo(inforanger);
			inforanger.setText(player.getName());
			}
		if(option.equals("rogue")) {
			player.setIcon("tokens/tokenRogue");
			player.addInfo(inforogue);
			inforogue.setText(player.getName());
			}
		if(option.equals("sorcerer")) {
			player.setIcon("tokens/tokenSorcerer");
			player.addInfo(infosorcerer);
			infosorcerer.setText(player.getName());
			}
//		info.setText(player.getName());
	
//		player.addInfo(info);
		
	//	player.discardInfo();
	//	player.addInfo(new WarriorCharacter());
	
		travelToScene(player,CharacterSheet.ID);
	}
	
}
