package com.stab.data;

import com.stab.adventure.AdventureLibrary;
import com.stab.client.ClientEntityManager;
import com.stab.common.fw.ServiceManager;
import com.stab.data.actions.monster.SkeletonRangedAction;
import com.stab.data.actions.monster.ZombieClawAction;
import com.stab.data.actions.player.ClericBasicMelee;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.Kill;
import com.stab.data.actions.player.RangedKill;
import com.stab.data.actions.player.WizardBasicMelee;
import com.stab.data.actions.player.feats.Expertise;
import com.stab.data.actions.player.feats.PowerAttack;
import com.stab.data.actions.player.spells.cleric.level0.Guidance;
import com.stab.data.actions.player.spells.cleric.level0.ResistanceCleric;
import com.stab.data.actions.player.spells.cleric.level1.Bane;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.DivineFavor;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.InflictLight;
import com.stab.data.actions.player.spells.wizard.level0.AcidSplash;
import com.stab.data.actions.player.spells.wizard.level0.Flare;
import com.stab.data.actions.player.spells.wizard.level0.OpenClose;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.Resistance;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;
import com.stab.data.adventure.TestAdventure;
import com.stab.data.adventure.Zombies;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.animation.CloseDoorAnimation;
import com.stab.data.animation.DamageNumberAnimation;
import com.stab.data.animation.EffectAddAnimation;
import com.stab.data.animation.EffectRemoveAnimation;
import com.stab.data.animation.HealNumberAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.OpenDoorAnimation;
import com.stab.data.animation.ShakeAnimation;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.WalkAnimation;
import com.stab.data.info.monster.EsqueletoArquero;
import com.stab.data.info.monster.Zombie;
import com.stab.data.info.player.ClericCharacter;
import com.stab.data.info.player.WarriorCharacter;
import com.stab.data.info.player.WizardCharacter;
import com.stab.data.info.props.Barrel;
import com.stab.data.info.props.Crate;
import com.stab.data.info.props.Dummy;
import com.stab.data.info.props.WoodenDoor;
import com.stab.data.scene.CharacterSheet;
import com.stab.data.scene.Feats;
import com.stab.data.scene.PrayerBook;
import com.stab.data.scene.SpellBook;
import com.stab.data.scene.StabLobby;
import com.stab.data.utils.DefaultBlockData;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.InteractAction;
import com.stab.model.info.trait.Modifier;

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
		Zombies z=new Zombies();
		ServiceManager.getService(AdventureLibrary.class).register(z);
	}
	
	
	static void createFactory(){
		of= new BasicObjectFactory();
		of.setMapping(StabLobby.class);
		of.setMapping(CharacterSheet.class);
		of.setMapping(SpellBook.class);
		of.setMapping(Feats.class);
		of.setMapping(WarriorCharacter.class);
		of.setMapping(Crate.class);
		of.setMapping(WoodenDoor.class);
		of.setMapping(Barrel.class);
		of.setMapping(Dummy.class);
		of.setMapping(WizardCharacter.class);
		of.setMapping(Zombie.class);
		of.setMapping(ClericCharacter.class);
		of.setMapping(EsqueletoArquero.class);
		of.setMapping(PrayerBook.class);
		
		
		
		//BlockData
		of.setMapping(DefaultBlockData.class);
		//Animations
		of.setMapping(WalkAnimation.class);
		of.setMapping(OpenDoorAnimation.class);
		of.setMapping(CloseDoorAnimation.class);
		of.setMapping(DamageNumberAnimation.class);
		of.setMapping(HealNumberAnimation.class);
		of.setMapping(EffectAddAnimation.class);
		of.setMapping(EffectRemoveAnimation.class);
		of.setMapping(ShootProyectileAnimation.class);
		of.setMapping(MissProyectileAnimation.class);
		of.setMapping(SwingAnimation.class);
		of.setMapping(BasicSparkAnimation.class);
		of.setMapping(ShakeAnimation.class);
		of.setMapping(ShootBeamAnimation.class);
	}
	
	static void initActions(){
		//accciones
		getActionLibrary().register(new DefendAction());
		getActionLibrary().getAction(InteractAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(new Kill());
		getActionLibrary().register(new RangedKill());
		getActionLibrary().register(new ZombieClawAction());
		getActionLibrary().register(new ClericBasicMelee());
		getActionLibrary().register(new WizardBasicMelee());
		getActionLibrary().register(new SkeletonRangedAction());
		//feats
		getActionLibrary().register(new PowerAttack());
		getActionLibrary().register(new Expertise());
		//conjuros
		getActionLibrary().register(new AcidSplash());
		getActionLibrary().register(new Flare());
		getActionLibrary().register(new OpenClose());
		getActionLibrary().register(new RayFrost());
		getActionLibrary().register(new Resistance());
		
		getActionLibrary().register(new MageArmor());
		getActionLibrary().register(new Shield());
		getActionLibrary().register(new ShockingGrasp());
		getActionLibrary().register(new MagicMissile());
		getActionLibrary().register(new ChillTouch());
		getActionLibrary().register(new TrueStrike());
		getActionLibrary().register(new EnlargePerson());
		
		getActionLibrary().register(new Guidance());
		getActionLibrary().register(new ResistanceCleric());
		
		getActionLibrary().register(new CureLight());
		getActionLibrary().register(new Bless());
		getActionLibrary().register(new Bane());
		getActionLibrary().register(new DivineFavor());
		getActionLibrary().register(new Doom());
		getActionLibrary().register(new InflictLight());
		
	
	}
	
	
	public static ActionLibrary getActionLibrary(){
		return ActionLibrary.getActionLibrary();
	}
}
