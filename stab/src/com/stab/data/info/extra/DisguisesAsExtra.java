package com.stab.data.info.extra;

import com.stab.model.Entity;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class DisguisesAsExtra extends SkillCheckExtra {

	
	public static final String ID="DISGUISES_AS";
	
	String name;
	
	String description;
	
	String resource;
	
	
	public DisguisesAsExtra(BaseInfo i){
		name=i.getText();
		description=i.getDescription();
		resource=i.getResource();
	}
	
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
		if (!(owner instanceof BaseInfo))
			return;
		BaseInfo i=(BaseInfo)owner;
		if (this.name!=null){
			String tmp=this.name;
			this.name=i.getText();
			i.setText(tmp);
		}
		if (this.resource!=null){
			String tmp=this.resource;
			this.resource=i.getResource();
			i.setResource(tmp);
		}
		if (this.description!=null){
			String tmp=this.description;
			this.description=i.getDescription();
			i.setDescription(tmp);
		}
	}
	
	
	@Override
	public void skillCheckPassed(BaseInfo instigator, Info i) {
		super.skillCheckPassed(instigator, i);
		if (this.name!=null){
			String tmp=this.name;
			i.setText(tmp);
		}
		if (this.resource!=null){
			String tmp=this.resource;
			i.setResource(tmp);
		}
		if (this.description!=null){
			String tmp=this.description;
			i.setDescription(tmp);
		}
	}
}
