package com.stab.base.info.props;

import com.stab.model.info.base.RandomGenFloorDecoration;

public class StabRandomGenDecoration extends RandomGenFloorDecoration{

	public static final String ID="RANDOMGEN_DECORATION";
	
	
	@Override
	public void init() {
		super.init();
		setSize(1,1);
		add("decor/1x1Blood1");
		add("decor/1x1Blood2");
		add("decor/1x1Blood3");
		add("decor/1x1Bones1");
		add("decor/1x1Bones2");
		add("decor/1x1Bones3");
		add("decor/1x1Bones4");
		add("decor/1x1Dirt1");
		add("decor/1x1Dirt2");
		add("decor/1x1Moss1");
		add("decor/1x1Scratch1");
		add("decor/1x1Scratch2");
		add("decor/1x1smallrocks4");
		add("decor/brokenwood");
		add("decor/smallrocks1");
		add("decor/smallrocks2");
		add("decor/smallrocks3");
		add("decor/skeleton1");
		add("decor/skeleton2");
		add("decor/skeleton3");
		add("decor/sink1");
		add("decor/sink2");
		add("decor/mushrooms1");
		add("decor/mushrooms2");
		add("decor/mushrooms3");
		add("decor/brokenBarrel");
		add("decor/brokenStatue1");
		add("decor/brokenStatue2");
		
		add("tiny/bloodstain$C");
		add("tiny/bones$C");
		add("tiny/dart$C");
		add("tiny/dirt$C");
		add("tiny/deadRat$C");
		add("tiny/rocks$C");
		add("tiny/skull$C");
		
		
	}
}
