package com.stab.base.info.props;

import java.awt.Point;

import com.stab.base.actions.traps.FlameJet;
import com.stab.common.utils.PathUtils;
import com.stab.model.info.base.DecoGadget;
import com.stab.model.info.interfaces.RemoteActivated;
import com.stab.util.StabUtils;

public class FlameJetTrap extends DecoGadget implements RemoteActivated{

	public static final String ID="FLAMEJET_TRAP";
	@Override
	
	 public void init() {
		super.init();
		setResource("fireslits");
		setText("Flame trap");
		setDescription("Some slits on the side, with scorched markings");
		setDeviceDc(10,10);
	};
	
	public void channelOn() {
		super.channelOn();
		if (!isEnabled())
			return;
		revealForRange(12);
		setVisible(true);
		
		//Use action on corresponding tile
		
		FlameJet fj= (FlameJet)StabUtils.getActionLibrary().getAction(FlameJet.ID); 
		Point tile;
		double[] dir=PathUtils.getDirStep(this.getAngle());
		tile = new Point ((int)(this.getX()+dir[0]),(int)(this.getY()+dir[1]));
		
	//	System.out.println("Flame jet from "+this.getPos()+" to "+tile+" dir "+this.getAngle());
		//animacion
	//	playSound("flames");
	//	playAnimation(BasicSparkAnimation.ID,"PARTICLE#flamejet",1500,dir[2]);
		fj.execute(this, null, tile,null);
		
	}
	
}
