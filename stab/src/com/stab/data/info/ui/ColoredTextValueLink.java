package com.stab.data.info.ui;

import org.newdawn.slick.Color;

import com.stab.model.basic.ui.Text;
import com.stab.model.info.BaseInfo;

public class ColoredTextValueLink extends TextValueLink {

	public ColoredTextValueLink(String field, Text object) {
		super(field, object);
	}
	
	public void check(BaseInfo info){
		Object o1=null;
		o1=info.getAttributeValue(getField());
		Object o2=info.getValue(getField());
			
		if (!compare(o2)){
			value=o2;
			assign();
			Integer i1=(Integer)o1;
			Integer i2=(Integer)o2;
			if (i1>i2)
				getObject().setColor(Color.red);
			else
				if (i1<i2)
					getObject().setColor(Color.green.darker());
				else
					getObject().setColor(Color.black);
		}
	}

}
