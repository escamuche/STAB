package com.stab.data.info.props;

import java.util.Collection;

import com.stab.annotations.NoToken;
import com.stab.common.utils.Utils;
import com.stab.model.basic.token.PhysicalToken;
import com.stab.model.basic.token.Token;
import com.stab.model.info.Info;
import com.stab.model.info.base.DecoGadget;
import com.stab.model.info.base.Door;
import com.stab.model.info.interfaces.RemoteActivated;

//necesita token para poder emitir el sonido (en un futuro sera posicional, claro)
public class SecretDoor extends DecoGadget implements RemoteActivated{

public static final String ID="SECRETDOOR";

	public void init() {
		super.init();
		setSelectable(Token.NOT_SELECTABLE);
	
		setResource("blank");
	}
	
	
	
	@Override
	public void enter() {
		 this.getMapLogic().setTile(getX(), getY(),2 );
		 setState(Door.CLOSED);
		
	}
	
	
	@Override
		public void channelOn(int ch) {
		System.out.println("CHANNEL "+ch);
			super.channelOn(ch);
		}
	
	@Override
		public void channelOff(int ch) {
			super.channelOff(ch);
		}
	
	protected void open(){
	
		playSound("effects/StoneDoor");
	    this.getMapLogic().setTile(getX(), getY(), 1);
		 setState(Door.OPEN);
	}
	
	protected void close(){
		playSound("effects/StoneDoor");
		 this.getMapLogic().setTile(getX(), getY(),2 );

		 setState(Door.CLOSED);

	}

	
	
		
		@Override
		public void turnOn() {
			
		}
		@Override
		public void turnOff() {
			
		}
		
		
		protected boolean canClose(Info actor) {
		
			if (this.getState()==Door.CLOSED)
				return false;
			// revisar que no haya ningun objeto fisico en esta posicion!
			Collection<Token> tokens=getMapLogic().getTokensIn(this.getBounds());
		//	Collection<Token> tokens=getMapLogic().getTokensAt(this.getX(),this.getY(),Token.class);
		
			if (tokens.contains(this.getToken()))
				tokens.remove(this.getToken());
			Collection<Token> ftokens=Utils.filter(tokens, PhysicalToken.class);
			if (!ftokens.isEmpty())
				return false;
			return true;
		}


		protected boolean canOpen(Info actor) {
			if (this.getState()==Door.OPEN)
				return false;
			return true;
		}
		
		
		@Override
			public void channelOn() {
				if (canOpen(this))
					open();
			}
			@Override
			public void channelOff() {
				if (canClose(this))
					close();
			}
			
	
}
