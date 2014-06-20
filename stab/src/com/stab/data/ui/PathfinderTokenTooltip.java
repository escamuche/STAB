package com.stab.data.ui;

import org.newdawn.slick.Color;

import com.stab.client.slick.base.DefaultTokenTooltip;
import com.stab.client.slick.base.TokenTooltip;
import com.stab.common.Constants;
import com.stab.data.StabInit;
import com.stab.data.info.equipment.HumanoidGear;
import com.stab.model.basic.token.Token;
import com.stab.model.info.trait.base.Activity;
import com.stab.model.info.trait.base.gear.Equipment;
import com.tien.princess.engine.sprite.common.painters.Painter;
import com.tien.princess.engine.sprite.ui.Icon;
import com.tien.princess.engine.sprite.ui.Panel;
import com.tien.princess.engine.sprite.ui.Text;

public class PathfinderTokenTooltip extends DefaultTokenTooltip {
	
	public static final String ID=TokenTooltip.ID;
	
	Panel equip;
	Icon left,armor,right;
    Text activity;
	
	@Override
	protected void init() {
		super.init();
		
		activity=new Text();
		addChild(activity);
		activity.setDesiredPos(CENTER,NEXT);
		activity.setDesiredSize(100, CONTENT);
		equip=new Panel();
		equip.setDesiredPos(CENTER,NEXT);
		equip.setDesiredSize(CONTENT, 54);
		equip.setMargin(1);
		equip.setBackground((Color)null);
		addChild(equip);
		left= new Icon();
		left.setDesiredPos(BEGIN,BEGIN);
		left.setDesiredSize(50, 50);
		equip.addChild(left);
		armor= new Icon();
		armor.setDesiredPos(NEXT,BEGIN);
		armor.setDesiredSize(50, 50);
		equip.addChild(armor);
		right= new Icon();
		right.setDesiredPos(NEXT,BEGIN);
		right.setDesiredSize(50, 50);
		equip.addChild(right);
	}
	
	
	@Override
	public void refreshData() {
		super.refreshData();
		boolean b=false;
		
		Token t=getToken();
		String l;
		
		activity.setVisible(false);
		activity.setText("");
		String act=t.getCustomString(Activity.ACTIVITY);
		if (act!=null && act.length()>0){
			activity.setText(act);
			activity.setVisible(true);
		}
		
		left.setVisible(false);
		right.setVisible(false);
		armor.setVisible(false);
		
		left.setPainter((Painter)null);
		l=t.getCustomString(HumanoidGear.OFFHAND);
		if (l!=null && l.length()>0){
			Equipment w=StabInit.getEquipment(l);
			if (w!=null){
				left.setPainter(w.getResource(), Constants.SCALED);
				b=true;
				left.setVisible(true);
			}
		}
		armor.setPainter((Painter)null);
		l=t.getCustomString(HumanoidGear.ARMOR);
		if (l!=null && l.length()>0){
			Equipment w=StabInit.getEquipment(l);
			if (w!=null){
				armor.setPainter(w.getResource(), Constants.SCALED);
				b=true;
				armor.setVisible(true);
			}
		}
		right.setPainter((Painter)null);
		l=t.getCustomString(HumanoidGear.MAINHAND);
		if (l!=null && l.length()>0){
			Equipment w=StabInit.getEquipment(l);
			if (w!=null){
				right.setPainter(w.getResource(), Constants.SCALED);
				b=true;
				right.setVisible(true);
			}
		}
		equip.setVisible(b);
	}
	
}
