package com.stab.data;

import com.stab.adventure.AdventureLibrary;
import com.stab.client.ClientEntityManager;
import com.stab.common.fw.ServiceManager;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.Kill;
import com.stab.data.actions.player.RangedKill;
import com.stab.data.actions.player.feats.Expertise;
import com.stab.data.actions.player.feats.PowerAttack;
import com.stab.data.actions.player.spells.MagicMissile;
import com.stab.data.adventure.TestAdventure;
import com.stab.data.animation.CloseDoorAnimation;
import com.stab.data.animation.DamageNumberAnimation;
import com.stab.data.animation.EffectAddAnimation;
import com.stab.data.animation.EffectRemoveAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.OpenDoorAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.WalkAnimation;
import com.stab.data.info.player.WarriorCharacter;
import com.stab.data.info.player.WizardCharacter;
import com.stab.data.info.props.Barrel;
import com.stab.data.info.props.Crate;
import com.stab.data.info.props.Dummy;
import com.stab.data.info.props.WoodenDoor;
import com.stab.data.scene.StabLobby;
import com.stab.data.utils.DefaultBlockData;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.InteractAction;

public class StabInit {

	static BasicObjectFactory of=null; 
	
	
	
	public static void clientInit(){
		initializeData();
		ClientEntityManager cm=ServiceManager.getService(ClientEntityManager.class);
		if (cm!=null)
			cm.registerFactory(of);
		else{
			
		}
	}

	public static void serverInit(){
		initializeData();
		EntityManager em=ServiceManager.getService(EntityManager.class);
		if (em!=null)
			em.registerFactory(of);
		
		initAdventures();
		
	}
	
	static void initializeData(){
		if (of==null)
			createFactory();
		//Acciones
		initActions();
	}
	
	static void initAdventures(){
		ServiceManager.getService(AdventureLibrary.class).clear();
		
		TestAdventure t=new TestAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(t);
	}
	
	
	static void createFactory(){
		of= new BasicObjectFactory();
		of.setMapping(StabLobby.class);
		of.setMapping(WarriorCharacter.class);
		of.setMapping(Crate.class);
		of.setMapping(WoodenDoor.class);
		of.setMapping(Barrel.class);
		of.setMapping(Dummy.class);
		of.setMapping(WizardCharacter.class);
		
		
		
		//BlockData
		of.setMapping(DefaultBlockData.class);
		//Animations
		of.setMapping(WalkAnimation.class);
		of.setMapping(OpenDoorAnimation.class);
		of.setMapping(CloseDoorAnimation.class);
		of.setMapping(DamageNumberAnimation.class);
		of.setMapping(EffectAddAnimation.class);
		of.setMapping(EffectRemoveAnimation.class);
		of.setMapping(ShootProyectileAnimation.class);
		of.setMapping(MissProyectileAnimation.class);
	}
	
	static void initActions(){
		
		getActionLibrary().register(new DefendAction());
		getActionLibrary().getAction(InteractAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(new Kill());
		getActionLibrary().register(new PowerAttack());
		getActionLibrary().register(new Expertise());
		getActionLibrary().register(new RangedKill());
		getActionLibrary().register(new MagicMissile());
	}
	
	
	
	
	
	
	
	
	
	
	
	public static ActionLibrary getActionLibrary(){
		return ActionLibrary.getActionLibrary();
	}
}
