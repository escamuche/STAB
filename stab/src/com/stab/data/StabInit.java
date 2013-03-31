package com.stab.data;



import com.stab.adventure.AdventureLibrary;
import com.stab.client.ClientEntityManager;
import com.stab.client.VisualEngine;
import com.stab.client.slick.StabVisualEngine;
import com.stab.client.slick.base.visualobjects.Button_sprite;
import com.stab.common.fw.ServiceManager;
import com.stab.data.actions.HealAction;
import com.stab.data.actions.WeaponAttackAction;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.actions.player.DefendAction;
import com.stab.data.actions.player.abilities.Rage;
import com.stab.data.actions.player.spells.cleric.level0.Guidance;
import com.stab.data.actions.player.spells.cleric.level0.ResistanceCleric;
import com.stab.data.actions.player.spells.cleric.level1.Bane;
import com.stab.data.actions.player.spells.cleric.level1.Bless;
import com.stab.data.actions.player.spells.cleric.level1.Command;
import com.stab.data.actions.player.spells.cleric.level1.CureLight;
import com.stab.data.actions.player.spells.cleric.level1.DivineFavor;
import com.stab.data.actions.player.spells.cleric.level1.Doom;
import com.stab.data.actions.player.spells.cleric.level1.EntropicShield;
import com.stab.data.actions.player.spells.cleric.level1.InflictLight;
import com.stab.data.actions.player.spells.cleric.level1.MagicStone;
import com.stab.data.actions.player.spells.cleric.level1.ShieldFaith;
import com.stab.data.actions.player.spells.wizard.level0.AcidSplash;
import com.stab.data.actions.player.spells.wizard.level0.Daze;
import com.stab.data.actions.player.spells.wizard.level0.Flare;
import com.stab.data.actions.player.spells.wizard.level0.OpenClose;
import com.stab.data.actions.player.spells.wizard.level0.RayFrost;
import com.stab.data.actions.player.spells.wizard.level0.Resistance;
import com.stab.data.actions.player.spells.wizard.level0.TouchFatigue;
import com.stab.data.actions.player.spells.wizard.level0.unfinished.DancingLights;
import com.stab.data.actions.player.spells.wizard.level1.CharmPerson;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.wizard.level1.Identify;
import com.stab.data.actions.player.spells.wizard.level1.Jump;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;
import com.stab.data.actions.player.spells.wizard.level1.unfinished.ReducePerson;
import com.stab.data.adventure.ColiseoAdventure;
import com.stab.data.adventure.TestAdventure;
import com.stab.data.adventure.Zombies;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.animation.CloseDoorAnimation;
import com.stab.data.animation.DamageNumberAnimation;
import com.stab.data.animation.EffectAddAnimation;
import com.stab.data.animation.EffectRemoveAnimation;
import com.stab.data.animation.HealNumberAnimation;
import com.stab.data.animation.LungeAnimation;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.OpenDoorAnimation;
import com.stab.data.animation.ShakeAnimation;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.data.animation.WalkAnimation;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.monster.bestiary.Couatl;
import com.stab.data.info.monster.bestiary.DireRat;
import com.stab.data.info.monster.bestiary.EsqueletoArquero;
import com.stab.data.info.monster.bestiary.Goblin;
import com.stab.data.info.monster.bestiary.GoblinShaman;
import com.stab.data.info.monster.bestiary.Kobold;
import com.stab.data.info.monster.bestiary.Lich;
import com.stab.data.info.monster.bestiary.SkeletalChampion;
import com.stab.data.info.monster.bestiary.Zombie;
import com.stab.data.info.player.BarbarianCharacter;
import com.stab.data.info.player.BardCharacter;
import com.stab.data.info.player.ClericCharacter;
import com.stab.data.info.player.DruidCharacter;
import com.stab.data.info.player.FighterCharacter;
import com.stab.data.info.player.MonkCharacter;
import com.stab.data.info.player.PaladinCharacter;
import com.stab.data.info.player.RangerCharacter;
import com.stab.data.info.player.RogueCharacter;
import com.stab.data.info.player.SorcererCharacter;
import com.stab.data.info.player.WarriorCharacter;
import com.stab.data.info.player.WizardCharacter;
import com.stab.data.info.props.Barrel;
import com.stab.data.info.props.Brazier;
import com.stab.data.info.props.Crate;
import com.stab.data.info.props.Dummy;
import com.stab.data.info.props.StabRandomSpawner;
import com.stab.data.info.props.WoodenDoor;
import com.stab.data.scene.ActionSlotButton;
import com.stab.data.scene.CharacterSheet;
import com.stab.data.scene.Feats;
import com.stab.data.scene.PrayerBook;
import com.stab.data.scene.SpellBook;
import com.stab.data.scene.StabLobby;
import com.stab.data.utils.DefaultBlockData;
import com.stab.data.utils.StabBlockData;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.InteractAction;

public class StabInit {

	static BasicObjectFactory of=null; 
	
	static WeaponFactory wf;
	static ArmorFactory af;
	static EquipmentFactory ef;
	
	public static void clientInit(){
		initializeData();
		ClientEntityManager cm=ServiceManager.getService(ClientEntityManager.class);
		if (cm!=null)
			cm.registerFactory(of);
		else{
			
		}
		
		StabVisualEngine sv=(StabVisualEngine)ServiceManager.getService(VisualEngine.class);
		if (sv!=null){
			sv.getFactory().setMapping(ActionSlotButton.ID,Button_sprite.class);
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
		ColiseoAdventure c=new ColiseoAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(c);
		
	}
	
	
	static void createFactory(){
		of= new BasicObjectFactory();
		
		//scenes
		of.setMapping(StabLobby.class);
		of.setMapping(CharacterSheet.class);
		of.setMapping(SpellBook.class);
		of.setMapping(Feats.class);
		of.setMapping(PrayerBook.class);
		
		//personajes
		of.setMapping(WarriorCharacter.class);
		of.setMapping(WizardCharacter.class);
		of.setMapping(ClericCharacter.class);
		of.setMapping(BarbarianCharacter.class);
		of.setMapping(BardCharacter.class);
		of.setMapping(DruidCharacter.class);
		of.setMapping(FighterCharacter.class);
		of.setMapping(MonkCharacter.class);
		of.setMapping(PaladinCharacter.class);
		of.setMapping(RangerCharacter.class);
		of.setMapping(RogueCharacter.class);
		of.setMapping(SorcererCharacter.class);
		
		//objetos
		of.setMapping(Crate.class);
		of.setMapping(WoodenDoor.class);
		of.setMapping(Barrel.class);
		of.setMapping(Dummy.class);
		of.setMapping(Brazier.class);
		of.setMapping(StabRandomSpawner.class);
		
		//criaturas
		of.setMapping(Zombie.class);
		of.setMapping(EsqueletoArquero.class);
		of.setMapping(DireRat.class);
		of.setMapping(Kobold.class);
		of.setMapping(Goblin.class);
		of.setMapping(GoblinShaman.class);
		of.setMapping(SkeletalChampion.class);
		of.setMapping(Couatl.class);
		of.setMapping(Lich.class);
		
		//botones
		of.setMapping(ActionSlotButton.class);
		
		//BlockData
		of.setMapping(DefaultBlockData.class);
		of.setMapping(StabBlockData.class);
		
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
		of.setMapping(ThrustAnimation.class);
		of.setMapping(MagicMissileAnimation.class);
		of.setMapping(LungeAnimation.class);
		
		
		wf=new WeaponFactory();
		af=new ArmorFactory();
		ef=new EquipmentFactory();
	}
	
	static void initActions(){
		//accciones
		getActionLibrary().register(new DefendAction());
		getActionLibrary().getAction(InteractAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(new WeaponAttackAction());
		getActionLibrary().register(new Rage());
		getActionLibrary().register(new HealAction());
		
		//feats
		getActionLibrary().register(new PowerAttack());
		getActionLibrary().register(new Expertise());
		
		//conjuros
		getActionLibrary().register(new DancingLights());
		getActionLibrary().register(new AcidSplash());
		getActionLibrary().register(new Flare());
		getActionLibrary().register(new OpenClose());
		getActionLibrary().register(new RayFrost());
		getActionLibrary().register(new Resistance());
		getActionLibrary().register(new Daze());
		getActionLibrary().register(new TouchFatigue());
		
		getActionLibrary().register(new MageArmor());
		getActionLibrary().register(new Shield());
		getActionLibrary().register(new ShockingGrasp());
		getActionLibrary().register(new MagicMissile());
		getActionLibrary().register(new ChillTouch());
		getActionLibrary().register(new TrueStrike());
		getActionLibrary().register(new EnlargePerson());
		getActionLibrary().register(new ExpeditiousRetreat());
		getActionLibrary().register(new RayEnfeeblement());
		getActionLibrary().register(new ReducePerson());
		getActionLibrary().register(new EntropicShield());
		getActionLibrary().register(new CharmPerson());
		getActionLibrary().register(new ExpeditiousRetreat());
		getActionLibrary().register(new Identify());
		getActionLibrary().register(new Jump());
	
		getActionLibrary().register(new Guidance());
		getActionLibrary().register(new ResistanceCleric());
		
		getActionLibrary().register(new CureLight());
		getActionLibrary().register(new Bless());
		getActionLibrary().register(new Bane());
		getActionLibrary().register(new DivineFavor());
		getActionLibrary().register(new Doom());
		getActionLibrary().register(new InflictLight());
		getActionLibrary().register(new MagicStone());
		getActionLibrary().register(new ShieldFaith());
		getActionLibrary().register(new EntropicShield());
		getActionLibrary().register(new Command());
	
		
	}
	
	
	public static ActionLibrary getActionLibrary(){
		return ActionLibrary.getActionLibrary();
	}
	
	
	public static WeaponFactory getWeaponFactory(){
		return wf;
	}
	
	public static ArmorFactory getArmorFactory(){
		return af;
	}
	public static EquipmentFactory getEquipmentFactory(){
		return ef;
	}

	
	
	
	
	
	
	
}
