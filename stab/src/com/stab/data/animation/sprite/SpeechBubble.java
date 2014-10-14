package com.stab.data.animation.sprite;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.util.SpeechLayerComponent;
import com.stab.data.animation.state.SpeechPanelState;
import com.tien.princess.engine.sprite.common.updaters.pos.Orbit;
import com.tien.princess.engine.sprite.ui.Label;
import com.tien.princess.engine.sprite.ui.states.UIStateSet;
import com.tien.princess.engine.sprite.ui.states.animating.ComponentFadeOutState;
import com.tien.princess.engine.utils.PaintUtils;

public class SpeechBubble extends Label implements SpeechLayerComponent {//,MouseComponent {

	SpeechPanelState st;
	
	@Override
	protected void init() {
		super.init();
		setBackground(PaintUtils.getPainter("speech$X"));
		setDesiredSize(240,CONTENT);
		setCap(220);
		setTextColor(Color.black);
		setMargin(20,16,8,24);
		this.setMode(BANNER);
		ComponentFadeOutState fade= new ComponentFadeOutState(500, UIStateSet.DESTROYED);
		fade.addUpdater(new Orbit());
		this.addState(fade);
		st= new SpeechPanelState();
	//	this.setState(st);
	}
	
	
	@Override
	public void setText(String text) {
		super.setText(text);
		int ln=text.length()*60;
		if (ln<1200)
			ln=1200;
		st.setTimed(ln, ComponentFadeOutState.ID);
		this.setState(st);
		
	}
	
	@Override
	public void setIcon(String img) {
		super.setIcon(img);
		if (st.getTimed()<1200)
			st.setTimed(1200, ComponentFadeOutState.ID);
	}
	
	@Override
	protected void sizeChanged() {
		super.sizeChanged();
		setR(this.getHeight()+10);
		setA(Math.toRadians(-80));
		
	}



	public boolean mouseClicked(int button, int x, int y, int times) {
		setState(ComponentFadeOutState.ID);
		return false;
	}



	public boolean mouseDragged(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean mouseMoved(int oldx, int oldy, int newx, int newy) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean mousePressed(int Button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean mouseReleased(int button, int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean mouseWheelMoved(int amount) {
		// TODO Auto-generated method stub
		return false;
	}



	public void mouseEntered() {
		// TODO Auto-generated method stub
		
	}



	public void mouseExited() {
		// TODO Auto-generated method stub
		
	}
	
/*	@Override
	public boolean isVisible() {
		boolean b=super.isVisible();
		if (!b)
			return b;
		if (this.getScreen() instanceof MapGameScreen){
			return ((MapGameScreen)getScreen()).isVisible((int)(getX()/Game.TILEWIDTH), (int)(getY()/Game.TILEHEIGHT));
		}
		return true;
	}
	/**/
}
