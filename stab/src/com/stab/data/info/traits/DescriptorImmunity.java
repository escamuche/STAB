package com.stab.data.info.traits;

import java.util.EnumSet;

import com.stab.data.actions.EffectDescriptor;
import com.stab.data.actions.HasDescriptor;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.Trait;

public class DescriptorImmunity extends Trait  implements Attends<Applicable>{

	protected EnumSet<EffectDescriptor> descriptors;
	
	
	public DescriptorImmunity(EffectDescriptor arg0,EffectDescriptor... arg1) {
		setDescriptors(arg0,arg1);
	}
	
	public DescriptorImmunity(EffectDescriptor arg0) {
		setDescriptors(arg0);
	}
	
	@Override
	public boolean canAttend(Applicable a) {
		if (a instanceof HasDescriptor)
			return true;
		return false;
	}

	@Override
	public void attend(Applicable app) {
		EnumSet<EffectDescriptor> desc=((HasDescriptor)app).getDescriptors();
		if (desc==null)
			return;
		if (desc.isEmpty())
			return;
		for (EffectDescriptor e:(EffectDescriptor[])descriptors.toArray())
			if (desc.containsAll(EnumSet.of(e))){
				app.setResult(Applicable.INMUNE);
				return;
			}
				
	}
	
	
	
	public EnumSet<EffectDescriptor> getDescriptors() {
		return descriptors;
	}
	
	public void setDescriptors(EffectDescriptor arg0){
		descriptors= EnumSet.of(arg0);
	}
	
	public void setDescriptors(EffectDescriptor arg0,EffectDescriptor...arg1){
		descriptors= EnumSet.of(arg0, arg1);
	}

}
