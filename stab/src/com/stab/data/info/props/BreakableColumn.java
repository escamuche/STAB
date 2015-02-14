package com.stab.data.info.props;

import java.awt.Point;
import java.util.Random;

import com.stab.model.action.Action;
import com.stab.model.basic.token.Token;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.ListensTo;
import com.stab.model.info.applicable.base.Damage;
import com.stab.model.info.base.FloorDecoration;
import com.stab.util.StabUtils;

public class BreakableColumn extends Column {
	
	public static final String ID="BREAKABLE_COLUMN";
	
	@Override
	public void init() {
		super.init();
		setInvulnerable(false);
		setSelectable(Token.SELECTABLE);
		setMaxHp(80);
		setMaxHp(8);
		setDestroyedResource("props/1x1BrokenColumn");
		//TODO: añadir damage reduction o algo, o por material
	}
	
	String[] debris={"decor/2x2Debris"};
	
	@Override
	protected void onDeath() {
	    Action a=StabUtils.getActionLibrary().getAction(com.stab.data.actions.traps.CaveIn.ID);
	    Point p=new Point(getX()+new Random().nextInt(2)-1,getY()+new Random().nextInt(2)-1);
	    a.execute(this, null, p, null);
	    FloorDecoration d=(FloorDecoration)getEntityManager().createElement(FloorDecoration.ID);
		d.setPos(p);
		d.setSize(1,1);
		d.setResource(debris[new Random().nextInt(debris.length)]); 
		getScene().add(d);
		super.onDeath();
	}
	

}
