package com.stab.data.scene;

import com.stab.common.Constants;
import com.stab.model.Player;
import com.stab.model.action.Action;
import com.stab.model.action.ActionSet;
import com.stab.model.basic.scenes.InfoDataScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;

public class ActionBarSelectionScene extends InfoDataScene{
	
	
	//En el createcontents de la subclase, llamar a createActionBar (antes del dolayout)
	//Crear botones para las acciones (usar createButton como atajo, luego configurar mode, tamaño y posicion al gusto)
	
	protected ActionSlotButton createButton(int slot){
		ActionSlotButton b=new ActionSlotButton();
		b.setSlot(slot);
		b.setPos(Constants.NEXT,Constants.PREVIOUS);
		b.setSize(Constants.CONTENT,Constants.CONTENT);
		b.setMode(Constants.LABEL);
		b.setAction("SELECT"+slot);
		return b;
	}
	
	protected void createActionBar(){
		
		for (int f=10;f<20;f++){
				ActionSlotButton b=new ActionSlotButton();
				b.setButtonType(Button.RADIO);
				b.setButtonGroup("ACTIONBAR");
				b.setSlot(f);
				if (f==10)
					b.setPos(Constants.BEGIN,Constants.NEXT_MAX);
				else
					b.setPos(Constants.NEXT,Constants.PREVIOUS);
				addGUI(b);
		}
	}
	
	
	@Override
	protected void refreshInfo(Info i) {
		super.refreshInfo(i);
		ActionSet as=((BaseInfo)i).getActionSet();
		for (ActionSlotButton b:this.getElements(ActionSlotButton.class)){
			Action a= as.getAction(b.getSlot());
			b.setAssociatedAction(a);
		}
	}
	
	
	protected int getSelectedSlot(){
		for (ActionSlotButton b:this.getElements(ActionSlotButton.class)){
			if (b.getSlot()>=10 && b.getSlot()<20)
				if (b.isActivated())
					return b.getSlot();
		}
		return -1;
	}
	
	protected ActionSlotButton getButton(String action){
		for (ActionSlotButton b:this.getElements(ActionSlotButton.class))
			if (b.getAction().equals(action))
				return b;
		return null;
	}
	
	
	@Override
	public void playerOption(Player player, String option) {
		if (option.startsWith("SELECT")){ //Es un boton de seleccion (le hemos puesto ese action a piñon en createbutton)
			ActionSlotButton b=getButton(option); //Buscamos ese boton
			int i=getSelectedSlot();  //buscamos el boton de la barra que esta seleccionado, y a que slot corresponde
			if (i>=10 && b!=null){  //si es correcto todo
				((BaseInfo)this.getInfo()).getActionSet().setAction(b.getAssociatedAction().getId(), i); //le ponemos esa action al actionset en ese slot
				this.refreshInfo(getInfo());//refrescamos todo
				return;
			}
		}
		super.playerOption(player, option);
	}
	
}
