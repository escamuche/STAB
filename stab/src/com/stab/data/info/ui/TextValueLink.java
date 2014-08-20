package com.stab.data.info.ui;

import com.stab.model.basic.ui.Text;
import com.stab.model.info.BaseInfo;

public class TextValueLink {
	
	String field;
	Object value;
	Text object;
	boolean attr;
	
	public TextValueLink(String field,Text object) {
		this.field=field;
		this.object=object;
		this.value=null;
		attr=false;
	}
	
	public void setAttr(boolean attr) {
		this.attr = attr;
	}
	
	
	
	public void check(BaseInfo info){
		Object val=getValue(info,field);
		if (!compare(val)){
			value=val;
			assign();
		}
	}
	
	protected boolean compare(Object val){
		return (val==value);
	}
	
	protected void assign(){
		object.setText(value.toString());
	}

	
	public boolean isAttr() {
		return attr;
	}
	
	public String getField() {
		return field;
	}
	
	public Text getObject() {
		return object;
	}
	
	protected Object getValue(BaseInfo info, String field2) {
		Object o=null;
		if (isAttr())
			o=info.getAttributeValue(field2);
		else
			o=info.getValue(field2);
		return o;
	}
}