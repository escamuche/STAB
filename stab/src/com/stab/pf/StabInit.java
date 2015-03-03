package com.stab.pf;



import com.stab.adventure.AdventureLibrary;
import com.stab.adventure.ColiseoAdventure;
import com.stab.adventure.CryptEverflameAdventure;
import com.stab.adventure.Game;
import com.stab.adventure.RndGenTestAdventure;
import com.stab.adventure.TestAdventure;
import com.stab.adventure.Zombies;
import com.stab.adventure.duskwood.BrotherManfred;
import com.stab.adventure.duskwood.DesnaChalice;
import com.stab.adventure.duskwood.DuskwoodAdventure;
import com.stab.adventure.everflame.CrackDoor;
import com.stab.adventure.everflame.CrackDoorToken;
import com.stab.adventure.everflame.OrcIlu;
import com.stab.adventure.everflame.Roldare;
import com.stab.base.actions.monster.AcidFlask;
import com.stab.base.actions.traps.FlameJet;
import com.stab.base.actions.traps.WallScythe;
import com.stab.base.animation.BlockAnimation;
import com.stab.base.animation.CloseDoorAnimation;
import com.stab.base.animation.DrinkPotionAnimation;
import com.stab.base.animation.FlySwarmAnimation;
import com.stab.base.animation.LungeAnimation;
import com.stab.base.animation.OpenDoorAnimation;
import com.stab.base.animation.RSwingAnimation;
import com.stab.base.animation.SidestepAnimation;
import com.stab.base.animation.StepBackAnimation;
import com.stab.base.animation.SwingAnimation;
import com.stab.base.animation.SwingAtAnimation;
import com.stab.base.animation.ThrustAnimation;
import com.stab.base.info.StabConnector;
import com.stab.base.info.other.HasLockInfo;
import com.stab.base.info.other.Key;
import com.stab.base.info.props.AttackTrap;
import com.stab.base.info.props.Barrel;
import com.stab.base.info.props.Brazier;
import com.stab.base.info.props.BreakableColumn;
import com.stab.base.info.props.CDoor;
import com.stab.base.info.props.CaveIn;
import com.stab.base.info.props.Chest;
import com.stab.base.info.props.Column;
import com.stab.base.info.props.Crate;
import com.stab.base.info.props.Exit;
import com.stab.base.info.props.FlameJetTrap;
import com.stab.base.info.props.FloorLever;
import com.stab.base.info.props.IronBars;
import com.stab.base.info.props.LDoor;
import com.stab.base.info.props.Niche;
import com.stab.base.info.props.RDoor;
import com.stab.base.info.props.Rune;
import com.stab.base.info.props.SecretDoor;
import com.stab.base.info.props.Slab;
import com.stab.base.info.props.StabRandomGenDecoration;
import com.stab.base.info.props.StabRandomSpawner;
import com.stab.base.info.props.Statue;
import com.stab.base.info.props.TorchStand;
import com.stab.base.info.props.TreasureChest;
import com.stab.base.info.props.TriggerPlate;
import com.stab.base.info.props.WallButton;
import com.stab.base.info.props.WoodenDoor;
import com.stab.base.tokens.CDoorToken;
import com.stab.base.tokens.IronBarsToken;
import com.stab.base.tokens.LDoorToken;
import com.stab.base.tokens.NicheToken;
import com.stab.base.tokens.RDoorToken;
import com.stab.base.tokens.RoundToken;
import com.stab.base.tokens.SlabToken;
import com.stab.client.ClientEntityManager;
import com.stab.client.VisualEngine;
import com.stab.client.animation.AlertAnimation;
import com.stab.client.animation.AnimatedIconAnimation;
import com.stab.client.animation.AnimatedSparkAnimation;
import com.stab.client.animation.BasicSparkAnimation;
import com.stab.client.animation.BasicSparkAnimationAt;
import com.stab.client.animation.BumpAnimation;
import com.stab.client.animation.CenterCamAnimation;
import com.stab.client.animation.CirclingAnimation;
import com.stab.client.animation.DamageNumberAnimation;
import com.stab.client.animation.DecayAnimation;
import com.stab.client.animation.DirectedAnimatedSparkAnimation;
import com.stab.client.animation.EffectAddAnimation;
import com.stab.client.animation.EffectRemoveAnimation;
import com.stab.client.animation.EnterScreenAnimation;
import com.stab.client.animation.ExtraInfoAnimation;
import com.stab.client.animation.FailureAnimation;
import com.stab.client.animation.FlashAnimation;
import com.stab.client.animation.FloatingTextAnimation;
import com.stab.client.animation.GenericProyectileAnimation;
import com.stab.client.animation.GenericProyectileMissAnimation;
import com.stab.client.animation.GenericSpriteAnimation;
import com.stab.client.animation.GenericSpriteOnAnimation;
import com.stab.client.animation.HealNumberAnimation;
import com.stab.client.animation.HorizontalScreenShakeAnimation;
import com.stab.client.animation.LeaveScreenAnimation;
import com.stab.client.animation.LootDropAnimation;
import com.stab.client.animation.MarkAnimation;
import com.stab.client.animation.MissProyectileAnimation;
import com.stab.client.animation.MissRotatingProyectileAnimation;
import com.stab.client.animation.PlaySoundAnimation;
import com.stab.client.animation.RevealAnimation;
import com.stab.client.animation.ShakeAnimation;
import com.stab.client.animation.ShockwaveAnimation;
import com.stab.client.animation.ShootBeamAnimation;
import com.stab.client.animation.ShootProyectileAnimation;
import com.stab.client.animation.ShootRotatingProyectileAnimation;
import com.stab.client.animation.SpeechBubbleAnimation;
import com.stab.client.animation.StartledAnimation;
import com.stab.client.animation.SuccessAnimation;
import com.stab.client.animation.TinkerAnimation;
import com.stab.client.animation.VerticalScreenShakeAnimation;
import com.stab.client.animation.WaitAnimation;
import com.stab.client.animation.WalkAnimation;
import com.stab.client.slick.StabVisualEngine;
import com.stab.client.slick.base.visualobjects.Button_sprite;
import com.stab.client.slick.base.visualobjects.token.ImageToken_sprite;
import com.stab.common.fw.Loader;
import com.stab.common.fw.ServiceManager;
import com.stab.fw.BasicObjectFactory;
import com.stab.fw.EntityManager;
import com.stab.fw.MappedInheritedObjectFactory;
import com.stab.model.action.ActionLibrary;
import com.stab.model.action.base.WakeDormants;
import com.stab.model.basic.scenes.TokenBasedScene;
import com.stab.model.basic.ui.advanced.RolledOptionButton;
import com.stab.model.basic.ui.advanced.RolledSkillOptionButton;
import com.stab.model.extras.SkillExtraText;
import com.stab.model.info.base.SkillNote;
import com.stab.model.info.base.TriggeredActionTrap;
import com.stab.model.info.base.Wall;
import com.stab.model.info.trait.base.gear.Equipment;
import com.stab.pf.actions.feats.Expertise;
import com.stab.pf.actions.feats.PowerAttack;
import com.stab.pf.actions.general.DefendAction;
import com.stab.pf.actions.general.HealAction;
import com.stab.pf.actions.general.PassDefendAction;
import com.stab.pf.actions.general.PathfinderPathAction;
import com.stab.pf.actions.general.PathfinderSearchAction;
import com.stab.pf.actions.general.PathfinderWeaponAttackAction;
import com.stab.pf.actions.general.PushAction;
import com.stab.pf.actions.player.abilities.ChannelPossitiveEnergyAction;
import com.stab.pf.actions.player.abilities.NobilityDomain;
import com.stab.pf.actions.player.abilities.Rage;
import com.stab.pf.actions.player.abilities.SmiteEvil;
import com.stab.pf.actions.player.spells.DismissSpellAction;
import com.stab.pf.actions.player.spells.cleric.level1.Bane;
import com.stab.pf.actions.player.spells.cleric.level1.Bless;
import com.stab.pf.actions.player.spells.cleric.level1.CureLight;
import com.stab.pf.actions.player.spells.cleric.level1.InflictLight;
import com.stab.pf.actions.player.spells.cleric.level1.unfinished.Command;
import com.stab.pf.actions.player.spells.druid.level1.CalmAnimals;
import com.stab.pf.actions.player.spells.druid.level1.CharmAnimal;
import com.stab.pf.actions.player.spells.druid.level1.DetectAnimals;
import com.stab.pf.actions.player.spells.druid.level1.DetectSnares;
import com.stab.pf.actions.player.spells.druid.level1.Entangle;
import com.stab.pf.actions.player.spells.druid.level1.FaerieFire;
import com.stab.pf.actions.player.spells.druid.level1.Goodberry;
import com.stab.pf.actions.player.spells.druid.level1.HideAnimals;
import com.stab.pf.actions.player.spells.druid.level1.Longstrider;
import com.stab.pf.actions.player.spells.druid.level1.MagicFang;
import com.stab.pf.actions.player.spells.druid.level1.PassTrace;
import com.stab.pf.actions.player.spells.druid.level1.ProduceFlame;
import com.stab.pf.actions.player.spells.druid.level1.Shillelagh;
import com.stab.pf.actions.player.spells.druid.level1.SpeakAnimals;
import com.stab.pf.actions.player.spells.druid.level1.SummonNature1;
import com.stab.pf.actions.player.spells.lvl0.AcidSplash;
import com.stab.pf.actions.player.spells.lvl0.Bleed;
import com.stab.pf.actions.player.spells.lvl0.DancingLights;
import com.stab.pf.actions.player.spells.lvl0.Daze;
import com.stab.pf.actions.player.spells.lvl0.DetectMagic;
import com.stab.pf.actions.player.spells.lvl0.DisruptUndead;
import com.stab.pf.actions.player.spells.lvl0.Flare;
import com.stab.pf.actions.player.spells.lvl0.Guidance;
import com.stab.pf.actions.player.spells.lvl0.Light;
import com.stab.pf.actions.player.spells.lvl0.Lullaby;
import com.stab.pf.actions.player.spells.lvl0.OpenClose;
import com.stab.pf.actions.player.spells.lvl0.RayFrost;
import com.stab.pf.actions.player.spells.lvl0.Resistance;
import com.stab.pf.actions.player.spells.lvl0.Stabilize;
import com.stab.pf.actions.player.spells.lvl0.TouchFatigue;
import com.stab.pf.actions.player.spells.lvl0.Virtue;
import com.stab.pf.actions.player.spells.lvl0.effects.DancingLights_effect;
import com.stab.pf.actions.player.spells.lvl1.BurningHands;
import com.stab.pf.actions.player.spells.lvl1.DivineFavor;
import com.stab.pf.actions.player.spells.lvl1.Doom;
import com.stab.pf.actions.player.spells.lvl1.EntropicShield;
import com.stab.pf.actions.player.spells.lvl1.MageArmor;
import com.stab.pf.actions.player.spells.lvl1.MagicMissile;
import com.stab.pf.actions.player.spells.lvl1.MagicStone;
import com.stab.pf.actions.player.spells.lvl1.RayEnfeeblement;
import com.stab.pf.actions.player.spells.lvl1.Shield;
import com.stab.pf.actions.player.spells.lvl1.ShieldFaith;
import com.stab.pf.actions.player.spells.lvl1.SummonMonsterI;
import com.stab.pf.actions.player.spells.lvl1.TrueStrike;
import com.stab.pf.actions.player.spells.lvl1.unfinished.ChillTouch;
import com.stab.pf.actions.player.spells.lvl1.unfinished.ExpeditiousRetreat;
import com.stab.pf.actions.player.spells.lvl1.unfinished.RemoveFear;
import com.stab.pf.actions.player.spells.lvl1.unfinished.ShockingGrasp;
import com.stab.pf.actions.player.spells.wizard.level1.HoldPortal;
import com.stab.pf.actions.player.spells.wizard.level1.Identify;
import com.stab.pf.actions.player.spells.wizard.level1.Jump;
import com.stab.pf.actions.player.spells.wizard.level1.unfinished.CharmPerson;
import com.stab.pf.actions.player.spells.wizard.level1.unfinished.EnlargePerson;
import com.stab.pf.animations.MagicMissileAnimation;
import com.stab.pf.animations.sprite.StabSpriteFactory;
import com.stab.pf.info.equipment.ArmorFactory;
import com.stab.pf.info.equipment.EquipmentFactory;
import com.stab.pf.info.equipment.PathfinderItemPickup;
import com.stab.pf.info.equipment.WeaponFactory;
import com.stab.pf.info.monster.bestiary.BloodySkeleton;
import com.stab.pf.info.monster.bestiary.Couatl;
import com.stab.pf.info.monster.bestiary.DireRat;
import com.stab.pf.info.monster.bestiary.EsqueletoArquero;
import com.stab.pf.info.monster.bestiary.GiantBombardierBeetle;
import com.stab.pf.info.monster.bestiary.GoblinAlchemist;
import com.stab.pf.info.monster.bestiary.GoblinChieftain;
import com.stab.pf.info.monster.bestiary.GoblinShaman;
import com.stab.pf.info.monster.bestiary.GoblinWarrior;
import com.stab.pf.info.monster.bestiary.KassenGolem;
import com.stab.pf.info.monster.bestiary.Kobold;
import com.stab.pf.info.monster.bestiary.Lich;
import com.stab.pf.info.monster.bestiary.Orc;
import com.stab.pf.info.monster.bestiary.PlagueZombie;
import com.stab.pf.info.monster.bestiary.SkeletalChampion;
import com.stab.pf.info.monster.bestiary.SkeletoParlanchin;
import com.stab.pf.info.monster.bestiary.Skeleton;
import com.stab.pf.info.monster.bestiary.Wolf;
import com.stab.pf.info.monster.bestiary.Zombie;
import com.stab.pf.info.player.BarbarianCharacter;
import com.stab.pf.info.player.BardCharacter;
import com.stab.pf.info.player.ClericCharacter;
import com.stab.pf.info.player.DruidCharacter;
import com.stab.pf.info.player.FighterCharacter;
import com.stab.pf.info.player.MonkCharacter;
import com.stab.pf.info.player.PaladinCharacter;
import com.stab.pf.info.player.RangerCharacter;
import com.stab.pf.info.player.RogueCharacter;
import com.stab.pf.info.player.SorcererCharacter;
import com.stab.pf.info.player.WarriorCharacter;
import com.stab.pf.info.player.WizardCharacter;
import com.stab.pf.scene.StabLobby2;
import com.stab.pf.ui.TokenController2;
import com.stab.pf.ui.visual.PathfinderTokenCard;
import com.stab.pf.ui.visual.PathfinderTokenTooltip;
import com.stab.pf.ui.visual.StabActionBar;
import com.stab.pf.utils.DefaultBlockData;
import com.stab.pf.utils.StabBlockData;
import com.tien.princess.engine.sprite.factory.AbstractSpriteFactory;
import com.tien.princess.engine.sprite.factory.SpriteFactory;

public class StabInit {

	static MappedInheritedObjectFactory of=null; 
	
	static WeaponFactory wf;
	static ArmorFactory af;
	static EquipmentFactory ef;
	
	static AbstractSpriteFactory spritefactory;
	
	public static void clientInit(){
		
		Loader.addDir("res");
	//	Loader.addDir("pfres");
		
		initializeData();
		ClientEntityManager cm=ServiceManager.getService(ClientEntityManager.class);
		if (cm!=null)
			cm.registerFactory(of);
		else{
			
		}

		getSpriteFactory();
		
		StabVisualEngine sv=(StabVisualEngine)ServiceManager.getService(VisualEngine.class);
		if (sv!=null){
		//	sv.getFactory().setMapping(ActionSlotButton.ID,Button_sprite.class);
			sv.getFactory().setMapping(PathfinderTokenCard.class);
			sv.getFactory().setMapping(StabActionBar.class);
			sv.getFactory().setMapping(IronBarsToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(LDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(CDoorToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RoundToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(NicheToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(SlabToken.ID,ImageToken_sprite.class);
			sv.getFactory().setMapping(RolledOptionButton.ID,Button_sprite.class);
			sv.getFactory().setMapping(RolledSkillOptionButton.ID,Button_sprite.class);
			sv.getFactory().setMapping(PathfinderTokenTooltip.class);
			sv.getFactory().setMapping(TokenController2.class);
			
			//TODO: trampa gorda... es necesario solucionar esto, asi como el mapa
			//Por ahora no queda otro remedio
			sv.getFactory().setMapping(CrackDoorToken.ID,ImageToken_sprite.class);
		
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
		//Factorias
		
		wf=new WeaponFactory();
		af=new ArmorFactory();
		ef=new EquipmentFactory();
	}
	
	static void initAdventures(){
		ServiceManager.getService(AdventureLibrary.class).clear();
		
		TestAdventure t=new TestAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(t);
		Zombies z=new Zombies();
		//ServiceManager.getService(AdventureLibrary.class).register(z);
		DuskwoodAdventure a= new DuskwoodAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(a);
		
		RndGenTestAdventure r= new RndGenTestAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(r);
		
		ColiseoAdventure c=new ColiseoAdventure();
	//	ServiceManager.getService(AdventureLibrary.class).register(c);
		CryptEverflameAdventure e=new CryptEverflameAdventure();
		ServiceManager.getService(AdventureLibrary.class).register(e);
		
	}
	
	
	static void createFactory(){
		of= new BasicObjectFactory();
		
		
		//of.setMapping(StabActionState.class);
		of.setMapping(PathfinderItemPickup.class);
		
		//scenes
		of.setMapping(StabLobby2.class);
		/*of.setMapping(CharacterSheet.class);
		of.setMapping(SpellBook.class);
		of.setMapping(Feats.class);
		of.setMapping(PrayerBook.class);
		of.setMapping(ActionBarSelectionScene2.class);
		/**/
		
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
		of.setMapping(StabRandomGenDecoration.class);
		of.setMapping(Crate.class);
		of.setMapping(WoodenDoor.class);
		of.setMapping(Barrel.class);
		of.setMapping(Brazier.class);
		of.setMapping(TorchStand.class);
		of.setMapping(StabRandomSpawner.class);
		of.setMapping(Statue.class);
		of.setMapping(Column.class);
		of.setMapping(Niche.class);
		of.setMapping(Slab.class);
		of.setMapping(Column.class);
		of.setMapping(BreakableColumn.class);
		of.setMapping(IronBars.class);
		of.setMapping(TriggerPlate.class);
		of.setMapping(WallButton.class);
		of.setMapping(FlameJetTrap.class);
		of.setMapping(LDoor.class);
		of.setMapping(RDoor.class);
		of.setMapping(CDoor.class);
		of.setMapping(SecretDoor.class);
		of.setMapping(SkillNote.class);
		of.setMapping(SkillExtraText.class);
		of.setMapping(HasLockInfo.class);
		of.setMapping(Key.class);
		of.setMapping(FloorLever.class);
		of.setMapping(Chest.class);
		of.setMapping(TreasureChest.class);
		of.setMapping(Rune.class);
		of.setMapping(TriggeredActionTrap.class);
		of.setMapping(AttackTrap.class);
		of.setMapping(CaveIn.class);
		of.setMapping(Exit.class);
		of.setMapping(Wall.class);
		of.setMapping(StabConnector.class);
	
		
		//efectos especiales
		of.setMapping(DancingLights_effect.class);
		
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
		of.setMapping(CrackDoor.class);
		of.setMapping(CrackDoorToken.class);
		TokenBasedScene.tokenFactory.setMapping(CrackDoor.ID, CrackDoorToken.ID);
	//	of.setMapping(CrackDoorToken.ID,ImageToken_sprite.class);
		of.setMapping(BrotherManfred.class);
		of.setMapping(DesnaChalice.class);
		
		//botones
	//	of.setMapping(ActionSlotButton.class);
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
		of.setMapping(SwingAtAnimation.class);
		of.setMapping(BasicSparkAnimation.class);
		of.setMapping(BasicSparkAnimationAt.class);
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
		of.setMapping(LootDropAnimation.class);
		of.setMapping(DrinkPotionAnimation.class);
		of.setMapping(CirclingAnimation.class);
		of.setMapping(FlySwarmAnimation.class);
		of.setMapping(ShockwaveAnimation.class);
		
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
		of.setMapping(NicheToken.class);
		TokenBasedScene.tokenFactory.setMapping(Niche.ID, NicheToken.ID);
		of.setMapping(SlabToken.class);
		TokenBasedScene.tokenFactory.setMapping(Slab.ID, SlabToken.ID);
		
		
	
		
		
		
	}
	
	
	public static void register(Class c){
		of.setMapping(c);
	}
	
	static void initActions(){
		//accciones
		getActionLibrary().register(PassDefendAction.class);
		getActionLibrary().register(PushAction.class);
		getActionLibrary().register(DismissSpellAction.class);
		
		getActionLibrary().register(DefendAction.class);
	//	getActionLibrary().getAction(InteractAction.ID).setResource("actions/inv_gizmo_02");
		getActionLibrary().register(PathfinderWeaponAttackAction.class);
		getActionLibrary().register(PathfinderPathAction.class);
		getActionLibrary().register(Rage.class);
		getActionLibrary().register(HealAction.class);
		getActionLibrary().register(PathfinderSearchAction.class);
		getActionLibrary().register(ChannelPossitiveEnergyAction.class);
		getActionLibrary().register(SmiteEvil.class);
		getActionLibrary().register(NobilityDomain.class);
		getActionLibrary().register(AcidFlask.class);
		
		getActionLibrary().register(FlameJet.class);
		getActionLibrary().register(WallScythe.class);
		getActionLibrary().register(com.stab.base.actions.traps.CaveIn.class);
		getActionLibrary().register(WakeDormants.class);
		
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
		
		getActionLibrary().register(InflictLight.class);
		getActionLibrary().register(MagicStone.class);
		
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
		getActionLibrary().register(Bleed.class);
		getActionLibrary().register(Daze.class);
		getActionLibrary().register(DisruptUndead.class);
		getActionLibrary().register(DancingLights.class);
		getActionLibrary().register(Flare.class);
		getActionLibrary().register(Guidance.class);
		getActionLibrary().register(Light.class);
		getActionLibrary().register(Lullaby.class);
	//	getActionLibrary().register(MageHand.class);
		getActionLibrary().register(OpenClose.class);
		getActionLibrary().register(RayFrost.class);
		getActionLibrary().register(Resistance.class);
		getActionLibrary().register(TouchFatigue.class);
		getActionLibrary().register(Stabilize.class);
		getActionLibrary().register(Virtue.class);
		
		//lvl 1
		
		getActionLibrary().register(BurningHands.class);
		getActionLibrary().register(EntropicShield.class);
		getActionLibrary().register(MageArmor.class);
		getActionLibrary().register(MagicMissile.class);
		getActionLibrary().register(SummonMonsterI.class);
		getActionLibrary().register(ShieldFaith.class);
		
		getActionLibrary().register(RemoveFear.class);
		
		
		
		//wizard1
		
		getActionLibrary().register(CharmPerson.class);
		getActionLibrary().register(ChillTouch.class);
		getActionLibrary().register(EnlargePerson.class);
		getActionLibrary().register(ExpeditiousRetreat.class);
		getActionLibrary().register(HoldPortal.class);
		getActionLibrary().register(Identify.class);
		getActionLibrary().register(Jump.class);
		
		
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
