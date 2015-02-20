package com.stab.pf.info.equipment;

public class Shield extends Armor {

	
	String effectIcon;
	
	public Shield(String name, int cA, int maxDex, int penalty, int category,
			int fail,String effectIcon) {
		super(name, cA, maxDex, penalty, category, fail);
		this.effectIcon=effectIcon;
		}

	
	
	
	public void setEffectIcon(String effectIcon) {
		this.effectIcon = effectIcon;
	}
	
	public String getEffectIcon() {
		return effectIcon;
	}
	
	
	//TODO:
	//generar una accion de bash con el shield, usando una weapon apropiada
	
}
