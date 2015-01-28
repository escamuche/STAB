package com.stab.data.ui;

import org.newdawn.slick.Input;

import com.stab.client.slick.GameScreen;
import com.stab.client.slick.base.visualobjects.token.Token_sprite;
import com.stab.model.action.base.InteractAction;
import com.stab.model.action.base.SearchAction;
import com.stab.model.action.base.TinkerAction;
import com.tien.princess.engine.Resources;
import com.tien.princess.engine.controllers.BasicController;

public class TokenController2 extends BasicController{
		
		
		public static final int PING=31;

		GameScreen screen;
		
		

		public TokenController2(GameScreen screen) {
			this.screen=screen;
		}
		
		public void init(){
		/*defineKey(Input.KEY_UP,UP);
			defineKey(Input.KEY_DOWN,DOWN);
			defineKey(Input.KEY_LEFT,LEFT);
			defineKey(Input.KEY_RIGHT,RIGHT);/**/
			defineKey(Input.KEY_Q,BUTTON1);
			defineKey(Input.KEY_W,BUTTON2);
			defineKey(Input.KEY_E,BUTTON3);
			defineKey(Input.KEY_R,BUTTON4);
			defineKey(Input.KEY_T,BUTTON5);
			defineKey(Input.KEY_P,BUTTON6);
			defineKey(Input.KEY_TAB,PING);
		}
		
		@Override
		public void reCalc() {
			//No recalc, porque no nos interesan los calculos de las diagonales.
		}
		
		
		@Override
		public void keyPressed(int key, char c) {
			super.keyPressed(key, c);
			if (getAction(key)==0)
				return;
			doActionFor(getAction(key));
		}
		
		
		protected void doActionFor(int action) {
			if (action==PING){
				
			}
			
			switch(action){
			
				case PING: screen.sendPing();break;
				case BUTTON1: //if (screen.getSelectedToken()!=null)
								screen.sendAction(screen.getActiveToken(),  "", screen.getSelectedToken(), null);
								break;
				case BUTTON2: //if (screen.getSelectedToken()!=null)
								screen.sendAction(screen.getActiveToken(),  "", screen.getSelectedToken(), null);
								break;
				case BUTTON3: if (screen.getSelectedToken()!=null)
									screen.sendAction(screen.getActiveToken(),  InteractAction.ID, screen.getSelectedToken(), null);
								break;
				case BUTTON4: //if (screen.getSelectedToken()!=null)
								screen.sendAction(screen.getActiveToken(),  SearchAction.ID,null, null);
								break;
				case BUTTON5: if (screen.getSelectedToken()!=null)
								screen.sendAction(screen.getActiveToken(),  TinkerAction.ID, screen.getSelectedToken(), null);
								break;
				case BUTTON6: //if (screen.getSelectedToken()!=null)
								//screen.sendAction(screen.getActiveToken(),  PassDefendAction.ID,null, null);
								break;
			}
		}
		
		
}
