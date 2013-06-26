package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.data.animation.ui.EnterScreenAnimation;
import com.stab.data.animation.ui.LeaveScreenAnimation;
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
import com.stab.model.basic.ui.Image;
import com.stab.model.basic.ui.Music;
import com.stab.model.info.base.Character;

public class StabLobby2  extends Scene{

	public static final String ID =Lobby.ID;
	Button[] chars;
	
	
	@Override
	public void init() {
		super.init();
		chars= new Button[12];
		Backdrop bd=new Backdrop();
		add(bd);
		bd.setResource("back/lobby$S");
	//	bd.setResource("SHADER#distort#back/lobby$S");
	//	bd.setResource("SHADER#infernal#back/lobby$S");
	//	bd.setResource("COLOR#blue");
		
		Image ff1= new Image();
		ff1.setPos(Constants.CENTER,Constants.CENTER);
		ff1.setSize(Constants.FULL, Constants.FULL);
		ff1.setImage("PARTICLE#backFireflies");
		add(ff1);
		
		createButton(0,"barbarian$S","barbarian");
		createButton(1,"bard$S","bard");
		createButton(2,"cleric$S","cleric");
		createButton(3,"druid$S","druid");
		createButton(4,"fighter$S","fighter");
		createButton(5,"monk$S","monk");
		createButton(6,"paladin$S","paladin");
		createButton(7,"ranger$S","ranger");
		createButton(8,"rogue$S","rogue");
		createButton(9,"sorcerer$S","sorcerer");
		createButton(10,"wizard$S","wizard");
		

		Image ff2= new Image();
		ff2.setPos(Constants.CENTER,Constants.CENTER);
		ff2.setSize(Constants.FULL, Constants.FULL);
		ff2.setImage("PARTICLE#backFireflies");
		//add(ff2);
		
		Music m=new Music();
		m.setResource("Magnificent");
		this.add(m);
	}
	
	@Override
	public void firstPlayerEnter() {
		super.firstPlayerEnter();
		
		//chars[0].playAnimation(WaitAnimation.ID,500);
			
		for (int f=0;f<6;f++)
			if (chars[f]!=null)
				chars[f].playAnimation(EnterScreenAnimation.ID,Constants.LEFT);
			
		for (int f=6;f<12;f++)
			if (chars[f]!=null)
				chars[f].playAnimation(EnterScreenAnimation.ID,Constants.RIGHT);
	/**/
	}
	
	
	public void createButton(int n,String image,String action){
		Button i=new Button();
		if (n<6){
			i.setPos(70+150*n,200);
		}else
			i.setPos(70+150*(n-6),440);
		i.setSize(140,200);
		i.setImage(image);
		i.setAction(action);
		i.setMargin(14);
		i.setBackground("FOUR#red#ui/card$X");
		//i.setVisible(false);
		add(i);
		chars[n]=i;
	}
	
	@Override
	public void playerOption(Player player, String option) {
		
		player.setIcon(option);
		player.removeAllInfo();
		
		int d=-1;
		
	
		if(option.equals("wizard")) {
			player.setIcon("tokens/tokenWizard");
			Character infowizard=new WizardCharacter();
			player.addInfo(infowizard);	
			infowizard.setText(player.getName());
			d=11;
			}
		if(option.equals("cleric")) {
			player.setIcon("tokens/tokenCleric");
			Character infocleric=new ClericCharacter();
			player.addInfo(infocleric);	
			infocleric.setText(player.getName());
			d=2;
			}
		if(option.equals("barbarian")) {
			player.setIcon("tokens/tokenBarbarian");
			Character infobarbarian=new BarbarianCharacter();
			player.addInfo(infobarbarian);
			infobarbarian.setText(player.getName());
			d=0;
			}
		if(option.equals("bard")) {
			player.setIcon("tokens/tokenBard");
			Character infobard=new BardCharacter();
			player.addInfo(infobard);
			infobard.setText(player.getName());
			d=1;
			}
		if(option.equals("druid")) {
			player.setIcon("tokens/tokenDruid");
			Character infodruid=new DruidCharacter();
			player.addInfo(infodruid);
			infodruid.setText(player.getName());
			d=3;
			}
		if(option.equals("fighter")) {
			player.setIcon("tokens/tokenFighter");
			Character infofighter=new FighterCharacter();
			player.addInfo(infofighter);
			infofighter.setText(player.getName());
			d=4;
			}
		if(option.equals("monk")) {
			player.setIcon("tokens/tokenMonk");
			Character infomonk=new MonkCharacter();
			player.addInfo(infomonk);
			infomonk.setText(player.getName());
			d=5;
			}
		if(option.equals("paladin")) {
			player.setIcon("tokens/tokenPaladin");
			Character infopaladin=new PaladinCharacter();
			player.addInfo(infopaladin);
			infopaladin.setText(player.getName());
			d=6;
			}
		if(option.equals("ranger")) {
			player.setIcon("tokens/tokenRanger");
			Character inforanger=new RangerCharacter();
			player.addInfo(inforanger);
			inforanger.setText(player.getName());
			d=7;
			}
		if(option.equals("rogue")) {
			player.setIcon("tokens/tokenRogue");
			Character inforogue=new RogueCharacter();
			player.addInfo(inforogue);
			inforogue.setText(player.getName());
			d=8;
			}
		if(option.equals("sorcerer")) {
			player.setIcon("tokens/tokenSorcerer");
			Character infosorcerer=new SorcererCharacter();
			player.addInfo(infosorcerer);
			infosorcerer.setText(player.getName());
			d=9;
			}
		
	
		for (int f=0;f<6;f++)
			if (f!=d)
			if (chars[f]!=null)
				chars[f].playAnimation(LeaveScreenAnimation.ID,Constants.LEFT);
		for (int f=6;f<12;f++)
			if (f!=d)
			if (chars[f]!=null)
				chars[f].playAnimation(LeaveScreenAnimation.ID,Constants.RIGHT);
		
		try{
			Thread.sleep(1500);
		}catch(Exception e){}
		
	//	travelToScene(player,ActionBarSelectionScene2.ID);
		travelToScene(player,null);
	}
	
}
