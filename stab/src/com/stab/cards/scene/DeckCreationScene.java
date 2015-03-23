package com.stab.cards.scene;

import java.awt.Point;

import org.newdawn.slick.Color;

import com.stab.common.Constants;
import com.stab.model.Scene;
import com.stab.model.basic.scenes.Lobby;
import com.stab.model.basic.ui.Backdrop;
import com.stab.model.basic.ui.Image;
import com.stab.model.basic.ui.Label;
import com.stab.model.basic.ui.Panel;
import com.stab.model.basic.ui.SceneLayout;
import com.stab.model.basic.ui.Widget;
import com.tien.princess.engine.Resources;




public class DeckCreationScene extends Scene{

	public static final String ID =Lobby.ID;
	
	Panel cards;

	
	@Override
	public void init() {
		super.init();
		SceneLayout layout = new SceneLayout();
		layout.setMargin(new Point(5,5));
		add(layout);
		Backdrop bd=new Backdrop();
		
		add(bd);
		
		Panel p= new Panel();
		p.setBackground("ui/roundrect$B");
		p.setPos(Constants.BEGIN,50);
		p.setSize(220,350);
		p.setMargin(3);
		
		Image i=new Image();
		i.setPos(Constants.BEGIN,Constants.BEGIN);
		i.setSize(Constants.FULL,Constants.FULL);
		i.setImage("ui/paperback$S");
		p.addChild(i);
		
		Label l= new Label();
		l.setMode(Label.BANNER);
		l.setPos(Constants.BEGIN,Constants.BEGIN);
		l.setSize(Constants.FULL,32);
		l.setImage("ui/grayback$S");
		l.setColor(Color.white);
		l.setText("@name");
		p.addChild(l);
		
		i=new Image();
		i.setPos(Constants.BEGIN,Constants.NEXT);
		i.setSize(Constants.FILL,210);
		i.setImage("ui/paperback$S");
		p.addChild(i);
		
		l= new Label();
		l.setPos(Constants.BEGIN,Constants.NEXT);
		l.setSize(Constants.FILL,Constants.FILL);
		l.setColor(Color.black);
		l.setText("@description");
		p.addChild(l);
		
		add(p);
		
		
		
		cards=new Panel();
		cards.setPos(0,400);
		cards.setSize(Constants.FILL,Constants.FILL);
		cards.setOverlay("ui/nanoborder$B");
		add(cards);
		cards.setMargin(5);
		cards.setGap(5, 5);
		
		Widget w=getWidget();
		cards.addChild(w);
	}
	
	
	public Widget getWidget(){
		Widget w= new Widget();
		w.setCloseable(false);
		w.setMargin(5);
		w.setSize(110,150);
		w.setPos(Constants.NEXT,Constants.PREVIOUS);
		w.setBackground("ui/card$S");
		w.setOverlay("ui/nanoborder$X");
		Label l= new Label();
		l.setMode(Label.BANNER);
		l.setPos(Constants.BEGIN,Constants.BEGIN);
		l.setSize(Constants.FILL,Constants.FILL);
		l.setImage("art/camp");
		l.setColor(Color.white);
		l.setText("TEST CARD");
		
		w.addChild(l);
		l= new Label();
		l.setMode(Label.BANNER);
		l.setPos(Constants.END,Constants.BEGIN);
		l.setSize(32,32);
		l.setImage("effects/globe");
		l.setColor(Color.black);
		l.setFont(Resources.BIG_BOLD_FONT);
		l.setText("1");
		w.addChild(l);

		
		
		w.set("name", "test name");
		
		return w;
	}

}
