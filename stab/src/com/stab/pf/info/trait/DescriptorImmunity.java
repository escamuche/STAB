package com.stab.pf.info.trait;

import java.util.EnumSet;

import com.stab.model.action.Action;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.Applicable;
import com.stab.model.info.applicable.Attends;
import com.stab.model.info.trait.base.AdvancedTrait;
import com.stab.pf.actions.EffectDescriptor;
import com.stab.pf.actions.HasDescriptor;

public class DescriptorImmunity extends AdvancedTrait  implements Attends<Applicable>{

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
	
	
	@Override
	public int valorateTarget(Action a, int type, BaseInfo actor, Info target,
			int value) {
		if (a instanceof HasDescriptor){
			EnumSet<EffectDescriptor> desc=((HasDescriptor)a).getDescriptors();
			if (desc==null)
				return value;
			if (desc.isEmpty())
				return value;
			for (EffectDescriptor e:(EffectDescriptor[])descriptors.toArray())
				if (desc.containsAll(EnumSet.of(e)))
					return 0;
		}
		return super.valorateTarget(a, type, actor, target, value);
	}

}
