package com.stab.data;



import com.stab.adventure.AdventureLibrary;
import com.stab.adventure.Game;
import com.stab.client.ClientEntityManager;
import com.stab.client.VisualEngine;
import com.stab.client.slick.StabVisualEngine;
import com.stab.client.slick.base.visualobjects.Button_sprite;
import com.stab.client.slick.base.visualobjects.token.ImageToken_sprite;
import com.stab.common.fw.ServiceManager;
import com.stab.data.actions.PathfinderPathAction;
import com.stab.data.actions.PathfinderSearchAction;
import com.stab.data.actions.StabActionState;
import com.stab.data.actions.feats.Expertise;
import com.stab.data.actions.feats.PowerAttack;
import com.stab.data.actions.general.DefendAction;
import com.stab.data.actions.general.HealAction;
import com.stab.data.actions.general.PathfinderWeaponAttackAction;
import com.stab.data.actions.general.PushAction;
import com.stab.data.actions.monster.AcidFlask;
import com.stab.data.actions.player.abilities.ChannelPossitiveEnergyAction;
import com.stab.data.actions.player.abilities.NobilityDomain;
import com.stab.data.actions.player.abilities.Rage;
import com.stab.data.actions.player.abilities.SmiteEvil;
import com.stab.data.actions.player.spells.DismissSpellAction;
import com.stab.data.actions.player.spells.cleric.level0.Virtue;
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
import com.stab.data.actions.player.spells.druid.level1.CalmAnimals;
import com.stab.data.actions.player.spells.druid.level1.CharmAnimal;
import com.stab.data.actions.player.spells.druid.level1.DetectAnimals;
import com.stab.data.actions.player.spells.druid.level1.DetectSnares;
import com.stab.data.actions.player.spells.druid.level1.Entangle;
import com.stab.data.actions.player.spells.druid.level1.FaerieFire;
import com.stab.data.actions.player.spells.druid.level1.Goodberry;
import com.stab.data.actions.player.spells.druid.level1.HideAnimals;
import com.stab.data.actions.player.spells.druid.level1.Longstrider;
import com.stab.data.actions.player.spells.druid.level1.MagicFang;
import com.stab.data.actions.player.spells.druid.level1.PassTrace;
import com.stab.data.actions.player.spells.druid.level1.ProduceFlame;
import com.stab.data.actions.player.spells.druid.level1.Shillelagh;
import com.stab.data.actions.player.spells.druid.level1.SpeakAnimals;
import com.stab.data.actions.player.spells.druid.level1.SummonNature1;
import com.stab.data.actions.player.spells.lvl0.AcidSplash;
import com.stab.data.actions.player.spells.lvl0.Daze;
import com.stab.data.actions.player.spells.lvl0.DetectMagic;
import com.stab.data.actions.player.spells.lvl0.DisruptUndead;
import com.stab.data.actions.player.spells.lvl0.Flare;
import com.stab.data.actions.player.spells.lvl0.Light;
import com.stab.data.actions.player.spells.lvl0.RayFrost;
import com.stab.data.actions.player.spells.lvl0.Resistance;
import com.stab.data.actions.player.spells.lvl0.Stabilize;
import com.stab.data.actions.player.spells.lvl0.TouchFatigue;
import com.stab.data.actions.player.spells.wizard.level1.BurningHands;
import com.stab.data.actions.player.spells.wizard.level1.CharmPerson;
import com.stab.data.actions.player.spells.wizard.level1.ChillTouch;
import com.stab.data.actions.player.spells.wizard.level1.EnlargePerson;
import com.stab.data.actions.player.spells.wizard.level1.ExpeditiousRetreat;
import com.stab.data.actions.player.spells.wizard.level1.HoldPortal;
import com.stab.data.actions.player.spells.wizard.level1.Identify;
import com.stab.data.actions.player.spells.wizard.level1.Jump;
import com.stab.data.actions.player.spells.wizard.level1.MageArmor;
import com.stab.data.actions.player.spells.wizard.level1.MagicMissile;
import com.stab.data.actions.player.spells.wizard.level1.RayEnfeeblement;
import com.stab.data.actions.player.spells.wizard.level1.Shield;
import com.stab.data.actions.player.spells.wizard.level1.ShockingGrasp;
import com.stab.data.actions.player.spells.wizard.level1.TrueStrike;
import com.stab.data.adventure.ColiseoAdventure;
import com.stab.data.adventure.CryptEverflameAdventure;
import com.stab.data.adventure.TestAdventure;
import com.stab.data.adventure.Zombies;
import com.stab.data.adventure.duskwood.BrotherManfred;
import com.stab.data.adventure.duskwood.DesnaChalice;
import com.stab.data.adventure.duskwood.DuskwoodAdventure;
import com.stab.data.adventure.everflame.Roldare;
import com.stab.data.animation.AlertAnimation;
import com.stab.data.animation.AnimatedIconAnimation;
import com.stab.data.animation.AnimatedSparkAnimation;
import com.stab.data.animation.BasicSparkAnimation;
import com.stab.data.animation.BlockAnimation;
import com.stab.data.animation.BumpAnimation;
import com.stab.data.animation.CenterCamAnimation;
import com.stab.data.animation.CloseDoorAnimation;
import com.stab.data.animation.DamageNumberAnimation;
import com.stab.data.animation.DecayAnimation;
import com.stab.data.animation.DirectedAnimatedSparkAnimation;
import com.stab.data.animation.EffectAddAnimation;
import com.stab.data.animation.EffectRemoveAnimation;
import com.stab.data.animation.ExtraInfoAnimation;
import com.stab.data.animation.FailureAnimation;
import com.stab.data.animation.FlashAnimation;
import com.stab.data.animation.FloatingTextAnimation;
import com.stab.data.animation.GenericProyectileAnimation;
import com.stab.data.animation.GenericProyectileMissAnimation;
import com.stab.data.animation.GenericSpriteAnimation;
import com.stab.data.animation.GenericSpriteOnAnimation;
import com.stab.data.animation.HealNumberAnimation;
import com.stab.data.animation.HorizontalScreenShakeAnimation;
import com.stab.data.animation.LungeAnimation;
import com.stab.data.animation.MagicMissileAnimation;
import com.stab.data.animation.MarkAnimation;
import com.stab.data.animation.MissProyectileAnimation;
import com.stab.data.animation.MissRotatingProyectileAnimation;
import com.stab.data.animation.OpenDoorAnimation;
import com.stab.data.animation.PlaySoundAnimation;
import com.stab.data.animation.RSwingAnimation;
import com.stab.data.animation.RevealAnimation;
import com.stab.data.animation.ShakeAnimation;
import com.stab.data.animation.ShootBeamAnimation;
import com.stab.data.animation.ShootProyectileAnimation;
import com.stab.data.animation.ShootRotatingProyectileAnimation;
import com.stab.data.animation.SidestepAnimation;
import com.stab.data.animation.SpeechBubbleAnimation;
import com.stab.data.animation.StartledAnimation;
import com.stab.data.animation.StepBackAnimation;
import com.stab.data.animation.SuccessAnimation;
import com.stab.data.animation.SwingAnimation;
import com.stab.data.animation.ThrustAnimation;
import com.stab.data.animation.TinkerAnimation;
import com.stab.data.animation.VerticalScreenShakeAnimation;
import com.stab.data.animation.WaitAnimation;
import com.stab.data.animation.WalkAnimation;
import com.stab.data.animation.sprite.StabSpriteFactory;
import com.stab.data.animation.ui.EnterScreenAnimation;
import com.stab.data.animation.ui.LeaveScreenAnimation;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.extra.SkillExtraText;
import com.stab.data.info.monster.bestiary.BloodySkeleton;
import com.stab.data.info.monster.bestiary.Couatl;
import com.stab.data.info.monster.bestiary.DireRat;
import com.stab.data.info.monster.bestiary.EsqueletoArquero;
import com.stab.data.info.monster.bestiary.GiantBombardierBeetle;
import com.stab.data.info.monster.bestiary.GoblinAlchemist;
import com.stab.data.info.monster.bestiary.GoblinChieftain;
import com.stab.data.info.monster.bestiary.GoblinShaman;
import com.stab.data.info.monster.bestiary.GoblinWarrior;
import com.stab.data.info.monster.bestiary.KassenGolem;
import com.stab.data.info.monster.bestiary.Kobold;
import com.stab.data.info.monster.bestiary.Lich;
import com.stab.data.info.monster.bestiary.Orc;
import com.stab.data.info.monster.bestiary.OrcIlu;
import com.stab.data.info.monster.bestiary.PlagueZombie;
import com.stab.data.info.monster.bestiary.SkeletalChampion;
import com.stab.data.info.monster.bestiary.SkeletoParlanchin;
import com.stab.data.info.monster.bestiary.Skeleton;
import com.stab.data.info.monster.bestiary.Wolf;
import com.stab.data.info.monster.bestiary.Zombie;
import com.stab.data.info.other.HasLockInfo;
import com.stab.data.info.other.Key;
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
import com.stab.data.info.props.CDoor;
import com.stab.data.info.props.Crate;
import com.stab.data.info.props.Dummy;
import com.stab.data.info.props.FlameJetTrap;
import com.stab.data.info.props.FloorLever;
import com.stab.data.info.props.IronBars;
import com.stab.data.info.props.LDoor;
import com.stab.data.info.props.RDoor;
import com.stab.data.info.props.SkillNote;
import com.stab.data.info.props.StabRandomSpawner;
import com.stab.data.info.props.Statue;
import com.stab.data.info.props.TriggerPlate;
import com.stab.data.info.props.WoodenDoor;
import com.stab.data.scene.ActionBarSelectionScene2;
import com.stab.data.scene.ActionSlotButton;
import com.stab.data.scene.CharacterSheet;
import com.stab.data.scene.Feats;
import com.stab.data.scene.PrayerBook;
import com.stab.data.scene.SpellBook;
import com.stab.data.scene.StabLobby2;
import com.stab.data.tokens.CDoorToken;
import com.stab.data.tokens.IronBarsToken;
import com.stab.data.tokens.LDoorToken;
import com.stab.data.tokens.RDoorToken;
import com.stab.data.tokens.RoundToken;
import com.stab.data.ui.PathfinderTokenCard;
import com.stab.data.ui.PathfinderTokenTooltip;
import com.stab.data.ui.RolledOptionButton;
import com.stab.data.ui.RolledSkillOptionButton;
import com.stab.data.ui.StabActionBar;
import com.stab.data.utils.DefaultBlockData;
import com.stab.data.utils.StabBlockData;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.InteractAction;
import com.stab.model.basic.scenes.TokenBasedScene;
import com.stab.model.info.trait.base.gear.Equipment;
import com.tien.princess.engine.sprite.factory.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.factory.SpriteFactory;

public class StabInit {

	static BasicObjectFactory of=null; 
	
	static WeaponFactory wf;
	static ArmorFactory af;
	static EquipmentFactory ef;
	
	static AbstractSpriteFactory spritefactory;
	
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
			sv.getFactory().setMapping(PathfinderTokenCard.class);
			sv.getFactory().setMapping(StabActionBar.class);
			sv.getFactory().setMapping(IronBarsToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(LDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(CDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RoundToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RolledOptionButton.ID,Button_sprite.class);
			sv.getFactory().setMapping(RolledSkillOptionButton.ID,Button_sprite.class);
			sv.getFactory().setMapping(PathfinderTokenTooltip.class);
		}
	}
	
	public static void setMapping(Class c){
		of.setMapping(c);
	}

	public static void serverInit(){
		initializeData();
		EntityManager em=ServiceManager.getService(EntityManager.class);
		if (em!=null)
			em.registerFactory(of);
		
		PathfinderGame g = new PathfinderGame();
		g.init();
		ServiceManager.register(Game.class,g);
		
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
		//ServiceManager.getService(AdventureLibrary.class).register(z);
		DuskwoodAdventure a= new DuskwoodAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(a);
		
		ColiseoAdventure c=new ColiseoAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(c);
		CryptEverflameAdventure e=new CryptEverflameAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(e);
		
	}
	
	
	static void createFactory(){
		of= new BasicObjectFactory();
		
		
		of.setMapping(StabActionState.class);
		
		//scenes
		of.setMapping(StabLobby2.class);
		of.setMapping(CharacterSheet.class);
		of.setMapping(SpellBook.class);
		of.setMapping(Feats.class);
		of.setMapping(PrayerBook.class);
		of.setMapping(ActionBarSelectionScene2.class);
		
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
		of.setMapping(Statue.class);
		of.setMapping(IronBars.class);
		of.setMapping(TriggerPlate.class);
		of.setMapping(FlameJetTrap.class);
		of.setMapping(LDoor.class);
		of.setMapping(RDoor.class);
		of.setMapping(CDoor.class);
		of.setMapping(SkillNote.class);
		of.setMapping(SkillExtraText.class);
		of.setMapping(HasLockInfo.class);
		of.setMapping(Key.class);
		of.setMapping(FloorLever.class);
		
		//criaturas
		of.setMapping(Zombie.class);
		of.setMapping(EsqueletoArquero.class);
		of.setMapping(DireRat.class);
		of.setMapping(Kobold.class);
		of.setMapping(GoblinWarrior.class);
		of.setMapping(GoblinShaman.class);
		of.setMapping(GoblinAlchemist.class);
		of.setMapping(GoblinChieftain.class);
		of.setMapping(SkeletalChampion.class);
		of.setMapping(Couatl.class);
		of.setMapping(Lich.class);
		of.setMapping(OrcIlu.class);
		of.setMapping(Wolf.class);
		of.setMapping(Orc.class);
		of.setMapping(Skeleton.class);
		of.setMapping(GiantBombardierBeetle.class);
		of.setMapping(SkeletoParlanchin.class);
		of.setMapping(KassenGolem.class);
		of.setMapping(BloodySkeleton.class);
		of.setMapping(PlagueZombie.class);
		
		
		//pnjs. trampa por ahora, mas adelante los registrara la aventura
		of.setMapping(Roldare.class);
		of.setMapping(BrotherManfred.class);
		of.setMapping(DesnaChalice.class);
		
		//botones
		of.setMapping(ActionSlotButton.class);
		of.setMapping(RolledOptionButton.class);
		of.setMapping(RolledSkillOptionButton.class);
		
		//BlockData
		of.setMapping(DefaultBlockData.class);
		of.setMapping(StabBlockData.class);
		
		//Animations
		of.setMapping(PlaySoundAnimation.class);
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
		of.setMapping(RSwingAnimation.class);
		of.setMapping(ShootRotatingProyectileAnimation.class);
		of.setMapping(MissRotatingProyectileAnimation.class);
		of.setMapping(BlockAnimation.class);
		of.setMapping(StepBackAnimation.class);
		of.setMapping(SidestepAnimation.class);
		of.setMapping(RevealAnimation.class);
		of.setMapping(SpeechBubbleAnimation.class);
		of.setMapping(AlertAnimation.class);
		of.setMapping(StartledAnimation.class);
		of.setMapping(ExtraInfoAnimation.class);
		of.setMapping(HorizontalScreenShakeAnimation.class);
		of.setMapping(VerticalScreenShakeAnimation.class);
		of.setMapping(FloatingTextAnimation.class);
		of.setMapping(GenericProyectileAnimation.class);
		of.setMapping(GenericProyectileMissAnimation.class);
		of.setMapping(GenericSpriteAnimation.class);
		of.setMapping(GenericSpriteOnAnimation.class);
		of.setMapping(DecayAnimation.class);
		of.setMapping(EnterScreenAnimation.class);
		of.setMapping(LeaveScreenAnimation.class);
		of.setMapping(WaitAnimation.class);
		of.setMapping(FlashAnimation.class);
		of.setMapping(MarkAnimation.class);
		of.setMapping(AnimatedIconAnimation.class);
		of.setMapping(AnimatedSparkAnimation.class);
		of.setMapping(DirectedAnimatedSparkAnimation.class);
		of.setMapping(SuccessAnimation.class);
		of.setMapping(FailureAnimation.class);
		of.setMapping(TinkerAnimation.class);
		of.setMapping(CenterCamAnimation.class);
		of.setMapping(BumpAnimation.class);
		
		//Tokens
		of.setMapping(IronBarsToken.class);
		TokenBasedScene.tokenFactory.setMapping(IronBars.ID, IronBarsToken.ID);
		of.setMapping(LDoorToken.class);
		TokenBasedScene.tokenFactory.setMapping(LDoor.ID, LDoorToken.ID);
		of.setMapping(RDoorToken.class);
		TokenBasedScene.tokenFactory.setMapping(RDoor.ID, RDoorToken.ID);
		of.setMapping(CDoorToken.class);
		TokenBasedScene.tokenFactory.setMapping(CDoor.ID, CDoorToken.ID);
		of.setMapping(RoundToken.class);
		TokenBasedScene.tokenFactory.setMapping(Statue.ID, RoundToken.ID);
		
		
		
		//Factorias
		
		wf=new WeaponFactory();
		af=new ArmorFactory();
		ef=new EquipmentFactory();
		
		
		
	}
	
	
	public static void register(Class c){
		of.setMapping(c);
	}
	
	static void initActions(){
		//accciones
		
		getActionLibrary().register(PushAction.class);
		getActionLibrary().register(DismissSpellAction.class);
		
		getActionLibrary().register(DefendAction.class);
		getActionLibrary().getAction(InteractAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(PathfinderWeaponAttackAction.class);
		getActionLibrary().register(PathfinderPathAction.class);
		getActionLibrary().register(Rage.class);
		getActionLibrary().register(HealAction.class);
	//	getActionLibrary().getAction(SearchAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(PathfinderSearchAction.class);
		getActionLibrary().register(ChannelPossitiveEnergyAction.class);
		getActionLibrary().register(SmiteEvil.class);
		getActionLibrary().register(NobilityDomain.class);
		getActionLibrary().register(AcidFlask.class);
		
		//feats
		getActionLibrary().register(PowerAttack.class);
		getActionLibrary().register(Expertise.class);
		
		//conjuros
			//bard0
		/*getActionLibrary().register(new DancingLights_Bard.class);
		getActionLibrary().register(new Daze_Bard.class);
		getActionLibrary().register(new DetectMagic_Bard.class);
		getActionLibrary().register(new Flare_Bard.class);
		getActionLibrary().register(new GhostSound_Bard.class);
		getActionLibrary().register(new Light_Bard.class);
		getActionLibrary().register(new Lullaby.class);
		getActionLibrary().register(new MageHand_Bard.class);
		getActionLibrary().register(new Mending_Bard.class);
		getActionLibrary().register(new Message_Bard.class);
		getActionLibrary().register(new OpenClose_Bard.class);
		getActionLibrary().register(new Resistance_Bard());
			
			//bard1
		getActionLibrary().register(new Alarm_Bard());
		getActionLibrary().register(new AnimateRope_Bard());
		getActionLibrary().register(new CauseFear_Bard());
		getActionLibrary().register(new CharmPerson_Bard());
		getActionLibrary().register(new ComprehendLanguages_Bard());
		getActionLibrary().register(new CureLight_Bard());
		getActionLibrary().register(new DetectSecretDoors_Bard());
		getActionLibrary().register(new DisguiseSelf_Bard());
		getActionLibrary().register(new Erase_Bard());
		getActionLibrary().register(new ExpeditiousRetreat_Bard());
		getActionLibrary().register(new FeatherFall_Bard());
		getActionLibrary().register(new Grease_Bard());
		getActionLibrary().register(new HideousLaughter());
		getActionLibrary().register(new Hypnotism_Bard());
		getActionLibrary().register(new Identify_Bard());
		getActionLibrary().register(new LesserConfusion());
		getActionLibrary().register(new MagicAura_Bard());
		getActionLibrary().register(new RemoveFear_Bard());
		getActionLibrary().register(new SilentImage_Bard());
		getActionLibrary().register(new Sleep_Bard());
		getActionLibrary().register(new SummonMonster1_Bard());
		getActionLibrary().register(new UndetectableAlignment());
		getActionLibrary().register(new UnseenServant_Bard());
		getActionLibrary().register(new Ventriloquism_Bard());
		*/
			//cleric0
	//	getActionLibrary().register(Guidance.class);
	//	getActionLibrary().register(Resistance.class);
	//	getActionLibrary().register(Virtue.class);
	//	getActionLibrary().register(Light.class);
		
			//cleric1
		getActionLibrary().register(Bane.class);
		getActionLibrary().register(Bless.class);
		getActionLibrary().register(Command.class);
		getActionLibrary().register(CureLight.class);
		getActionLibrary().register(DivineFavor.class);
		getActionLibrary().register(Doom.class);
		getActionLibrary().register(EntropicShield.class);
		getActionLibrary().register(InflictLight.class);
		getActionLibrary().register(MagicStone.class);
		getActionLibrary().register(ShieldFaith.class);
/*		
			//druid0
		getActionLibrary().register(new CreateWater_Druid());
		getActionLibrary().register(new DetectMagic_Druid());
		getActionLibrary().register(new DetectPoison_Druid());
		getActionLibrary().register(new Flare_Druid());
		getActionLibrary().register(new Guidance_Druid());
		getActionLibrary().register(new Light_Druid());
		getActionLibrary().register(new Mending_Druid());
		getActionLibrary().register(new PurifyFood_Druid());
		getActionLibrary().register(new Resistance_Druid());
		getActionLibrary().register(new Stabilize_Druid());
		getActionLibrary().register(new Virtue_Druid());
	/**/	
			//druid1
		getActionLibrary().register(CalmAnimals.class);
		getActionLibrary().register(CharmAnimal.class);
		//getActionLibrary().register(new CureLight_Druid());
		getActionLibrary().register(DetectAnimals.class);
		getActionLibrary().register(DetectSnares.class);
		//getActionLibrary().register(new EndureElements_Druid());
		getActionLibrary().register(Entangle.class);
		getActionLibrary().register(FaerieFire.class);
		getActionLibrary().register(Goodberry.class);
		getActionLibrary().register(HideAnimals.class);
		//getActionLibrary().register(new Jump_Druid());
		getActionLibrary().register(Longstrider.class);
		getActionLibrary().register(MagicFang.class);
		//getActionLibrary().register(new MagicStone_Druid());
		//getActionLibrary().register(new ObscuringMist_Druid());
		getActionLibrary().register(PassTrace.class);
		getActionLibrary().register(ProduceFlame.class);
		getActionLibrary().register(Shillelagh.class);
		getActionLibrary().register(SpeakAnimals.class);
		getActionLibrary().register(SummonNature1.class);
		
	/*	//sorcerer0
	getActionLibrary().register(new AcidSplash_Sorcerer());
	getActionLibrary().register(new Bleed_Sorcerer());
	getActionLibrary().register(new Daze_Sorcerer());
	getActionLibrary().register(new DisruptUndead_Sorcerer());
	getActionLibrary().register(new Flare_Sorcerer());
	getActionLibrary().register(new Light_Sorcerer());
	getActionLibrary().register(new MageHand_Sorcerer());
	getActionLibrary().register(new OpenClose_Sorcerer());
	getActionLibrary().register(new RayFrost_Sorcerer());
	getActionLibrary().register(new Resistance_Sorcerer());
	getActionLibrary().register(new TouchFatigue_Sorcerer());

		//sorcerer1
	getActionLibrary().register(new BurningHands_Sorcerer());
	getActionLibrary().register(new CharmPerson_Sorcerer());
	getActionLibrary().register(new ChillTouch_Sorcerer());
	getActionLibrary().register(new EnlargePerson_Sorcerer());
	getActionLibrary().register(new ExpeditiousRetreat_Sorcerer());
	getActionLibrary().register(new HoldPortal_Sorcerer());
	getActionLibrary().register(new Identify_Sorcerer());
	getActionLibrary().register(new Jump_Sorcerer());
	getActionLibrary().register(new MageArmor_Sorcerer());
	getActionLibrary().register(new MagicMissile_Sorcerer());
	getActionLibrary().register(new RayEnfeeblement_Sorcerer());
	getActionLibrary().register(new Shield_Sorcerer());
	getActionLibrary().register(new ShockingGrasp_Sorcerer());
	getActionLibrary().register(new TrueStrike_Sorcerer());
		/**/	
		//lvl0
		getActionLibrary().register(DetectMagic.class);
		getActionLibrary().register(AcidSplash.class);
		getActionLibrary().register(Daze.class);
//		getActionLibrary().register(DancingLights.class);
		getActionLibrary().register(DisruptUndead.class);
		getActionLibrary().register(Flare.class);
		getActionLibrary().register(Light.class);
	//	getActionLibrary().register(MageHand.class);
	//	getActionLibrary().register(OpenClose.class);
		getActionLibrary().register(RayFrost.class);
		getActionLibrary().register(Resistance.class);
		getActionLibrary().register(TouchFatigue.class);
		getActionLibrary().register(Stabilize.class);
		getActionLibrary().register(Virtue.class);
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//wizard1
		getActionLibrary().register(BurningHands.class);
		getActionLibrary().register(CharmPerson.class);
		getActionLibrary().register(ChillTouch.class);
		getActionLibrary().register(EnlargePerson.class);
		getActionLibrary().register(ExpeditiousRetreat.class);
		getActionLibrary().register(HoldPortal.class);
		getActionLibrary().register(Identify.class);
		getActionLibrary().register(Jump.class);
		getActionLibrary().register(MageArmor.class);
		getActionLibrary().register(MagicMissile.class);
		getActionLibrary().register(RayEnfeeblement.class);
		getActionLibrary().register(Shield.class);
		getActionLibrary().register(ShockingGrasp.class);
		getActionLibrary().register(TrueStrike.class);

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

	
	
	public static Equipment getEquipment(String s){
		Equipment e= StabInit.getWeaponFactory().getWeapon(s);
		if (e!=null)
			return e;
		e=StabInit.getArmorFactory().getArmor(s);
		if (e!=null)
			return e;
		e=StabInit.getEquipmentFactory().getItem(s); 
		return e;
	}

	public static SpriteFactory  getSpriteFactory() {
		if (spritefactory==null)
			spritefactory=createSpriteFactory();
		return spritefactory;
	}

	private static AbstractSpriteFactory createSpriteFactory() {
		return new StabSpriteFactory();
	}
	
	
	
	
}
