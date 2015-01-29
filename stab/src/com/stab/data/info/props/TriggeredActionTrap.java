package com.stab.data.info.props;

import java.awt.Point;

import com.stab.annotations.Injected;
import com.stab.common.utils.PathUtils;
import com.stab.model.action.Action;
import com.stab.model.action.ActionLibrary;
import com.stab.model.basic.Sprite;
import com.stab.model.basic.SpriteListener;
import com.stab.model.info.InfoListener;
import com.stab.model.info.base.DecoGadget;
import com.stab.model.info.base.Obstacle;
import com.stab.model.info.interfaces.RemoteActivated;
import com.stab.model.info.interfaces.TurnBased;

public class TriggeredActionTrap extends DecoGadget implements RemoteActivated,TurnBased, SpriteListener, InfoListener{

	public static final String ID="ACTION_TRAP";
	
	@Injected
	boolean embedded;
	
	Obstacle host;
	
	@Injected
	int disableDC;
	
	@Injected
	String action;
	
	
	int load;
	
	@Injected
	int cooldown;
	
	
	@Injected
	int uses;
	
	Action act;
	
	 public void init() {
		super.init();
		embedded=false;
		host=null;
		load=0;
		cooldown=1;
		uses=-1;
		setText("Trap");
		setDescription("Some devious mechanism, obviously dangerous.");
		setDeviceDc(10,10);
	};
	
	
	@Override
	public void enter() {
		super.enter();
		if (embedded){  //Buscamos un host apropiado.
			for (Obstacle i:this.getScene().getElements(Obstacle.class)){
				if (i.getBounds().intersects(this.getBounds())){
					host=i;
					host.addSpriteListener(this);
					host.addInfoListener(this);
					setPos(host.getPos());
					setAngle(host.getAngle());
					return;
				}
			}
		}
	}
	
	public void setDisableDC(int disableDC) {
		this.disableDC = disableDC;
		setDeviceDc(disableDC,disableDC);
	}
	
	public void channelOn() {
		super.channelOn();
		if (!isEnabled())
			return;
		if (load>0)
			return;
		if (uses==0)
			return;
		revealForRange(12);
		setVisible(true);
		load=cooldown;
		if (uses>0)
			uses--;
		//Use action on corresponding tile
		
		performAction();
	}
	
	protected void performAction(){
		
		Point tile;
		double[] dir=PathUtils.getDirStep(this.getAngle());
		tile = new Point ((int)(this.getX()+dir[0]),(int)(this.getY()+dir[1]));
		
		 
		act.execute(this, null, tile,null);
		
	}
	
	public void setAction(Action act) {
		this.act = act;
		
	}
	
	public void setAction(String action) {
		this.action = action;
		setAction(ActionLibrary.getActionLibrary().getAction(action));
		
	}

	@Override
	public void turnStarts() {
		if (load>0)
			load--;
		
	}

	@Override
	public void turnEnds() {
	
	}
	
	public void setUses(int uses) {
		this.uses = uses;
	}
	
	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}


	@Override
	public void spritePosChanged(Sprite sp) {
	   this.setPos(sp.getPos());//No contemplamos un host de mas tamaño que nosotros.
		
	}


	@Override
	public void spriteSizeChanged(Sprite sp) {
	//no contemplado.
		
	}


	@Override
	public void spriteVisibilityChanged(Sprite sp) {
		
		
	}


	@Override
	public void spriteDestroyed(Sprite sp) {
		this.destroy();
		
	}


	@Override
	public void rotationChanged(char newDir) {
		this.setAngle(newDir);
	}


	@Override
	public void stateChanged(int newState) {
	
	}
	
}
