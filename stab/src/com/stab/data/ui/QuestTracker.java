package com.stab.data.ui;

import org.newdawn.slick.Color;

import com.stab.model.basic.ui.Label;

public class QuestTracker extends Label {

	
	public static final int UNDISCOVERED=-1;
	public static final int IN_PROGRESS=1;
	public static final int COMPLETED=2;
	public static final int FAILED=3;
	public static final int CANCELLED=4;
	
	
	int progress;
	int max;
	String message;
	boolean optional;
	int state;
	
	@Override
	public void init() {
		super.init();
		progress=-1;
		max=-1;
		message="";
		optional=false;
		state=IN_PROGRESS;
	}
	
	
	public void setProgress(int progress) {
		this.progress = progress;
		recalc();
	}
	
	public void setMax(int max) {
		this.max = max;
		recalc();
	}
	
	public int getProgress() {
		return progress;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMessage(String message) {
		this.message = message;
		recalc();
	}
	
	public void setOptional(boolean optional) {
		this.optional = optional;
		recalc();
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
		recalc();
	}
	
	public void recalc(){
		String s=this.getMessage();
		if (progress>=0){
			s=s+" ("+progress;
			if (max>=0)
				s=s+"/"+max;
			s=s+")";
		}
		this.setText(s);
		if (state== UNDISCOVERED) this.setVisible(false);
		else setVisible(true);
		switch(state){
			
			case IN_PROGRESS:  if (optional){
									setColor(Color.cyan.darker());
									setImage("ui/pointSmall");
								}	
								else{
									setColor(Color.yellow);
									setImage("ui/point");
								}
								break;
			case COMPLETED: setColor(Color.green);
							setImage("ui/check");
							break;
			case FAILED: if (optional)
							setColor(Color.darkGray);
							
						else	
							setColor(Color.red);
						setImage("ui/fail");
							break;
			case CANCELLED: setColor(Color.darkGray);break;
			
		}
	}
	
}
