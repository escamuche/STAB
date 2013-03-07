package com.stab.data.scene;

import com.stab.model.basic.scenes.InfoDataScene;

public class Feats extends InfoDataScene{
	public static final String ID="FEATS_SCENE";

	public void createContents() {
		super.createContents();
		setBackground("ui/scroll$S");
		setMusic(null);
		setMargin(60,70);
		setGap(5,15);
		setLayout("--");
		
		
		
		doLayout();
	}
}