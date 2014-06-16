package com.stab.data.info.extra;

import com.stab.model.Entity;

public class DisguisesAsExtra extends SkillCheckExtra {

	
	public static final String ID="DISGUISES_AS";
	
	String name;
	
	String description;
	
	String resource;
	
	
	public DisguisesAsExtra(){
		name=null;
		resource=null;
		description=null;
	}


	public String getName() {
		return name;
	}


	public String getDescription() {
		return description;
	}


	public String getResource() {
		return resource;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setResource(String resource) {
		this.resource = resource;
	}
	
	
	@Override
	public void setOwner(Entity owner) {
		super.setOwner(owner);
		
	}
	
}
