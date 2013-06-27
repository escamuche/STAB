package com.stab.data.ui;

import com.stab.client.slick.base.ActionBar;
import com.stab.client.slick.base.MultipageActionBar;
import com.stab.common.Constants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.basic.token.Token;
import com.stab.model.info.trait.base.Equipment;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.ui.Component;
import com.tien.princess.engine.sprite.ui.Icon;
import com.tien.princess.engine.sprite.ui.Panel;
import com.tien.princess.engine.utils.PaintUtils;

public class StabActionBar extends MultipageActionBar {

	public static final String ID=ActionBar.ID;
	
	
	Panel left;
	Panel right;
	
	Icon leftHand,rightHand;

	
	protected Component createLeft() {
		left= new Panel();
		left.setDesiredSize((int)(56*getUIScale()), (int)(56*getUIScale()));
		left.setBackground((Painter)null);
	//	left.setOverlay("ui/consolefront", BOXED);
		left.setMargin(0);
		leftHand=new Icon();
		leftHand.setDesiredPos(BEGIN,BEGIN);
		//leftHand.setDesiredSize((int)(64*getUIScale()), (int)(64*getUIScale()));
		leftHand.setDesiredSize(FILL, FILL);
		leftHand.setBackground("ui/lefthand",Constants.SCALED);
		//leftHand.setPainter("ui/lefthand",Constants.SCALED);
		left.setOverlay(PaintUtils.getPainter("ui/nanoborder$B"));
		left.addChild(leftHand);
		
		
		return left;
	}
	
	
	protected Component createRight() {
		right= new Panel();
		right.setDesiredSize((int)(56*getUIScale()), (int)(56*getUIScale()));
		right.setBackground((Painter)null);
		right.setMargin(0);
		//right.setOverlay("ui/consolefront", BOXED);
		
		rightHand=new Icon();
		rightHand.setDesiredPos(BEGIN,BEGIN);
	//	rightHand.setDesiredSize((int)(64*getUIScale()), (int)(64*getUIScale()));
		rightHand.setBackground("ui/righthand",Constants.SCALED);
	//	rightHand.setPainter("ui/righthand",Constants.SCALED);
		rightHand.setDesiredSize(FILL, FILL);
		right.addChild(rightHand);
		right.setOverlay(PaintUtils.getPainter("ui/nanoborder$B"));
		return right;
		//return right;
	}
	
	
	@Override
	public void setToken(Token t) {
		super.setToken(t);
		rightHand.setPainter((Painter)null);
		String l=t.getCustomString(HumanoidGear.MAINHAND);
		if (l!=null && l.length()>0){
			Equipment w=StabInit.getEquipment(l);
			if (w!=null){
			//	System.out.println("Right hand: "+w.getResource());
				rightHand.setPainter(w.getResource(), Constants.SCALED);
			}
		}
		leftHand.setPainter((Painter)null);
		l=t.getCustomString(HumanoidGear.OFFHAND);
		if (l!=null && l.length()>0){
			Equipment w=StabInit.getEquipment(l);
			if (w!=null){
				leftHand.setPainter(w.getResource(), Constants.SCALED);
			}
		}
	}
	
}
