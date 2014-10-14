package com.stab.data.adventure.everflame;

import com.stab.data.StabConstants;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.action.DelegatedAction;
import com.stab.model.action.base.DialogAction;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.interfaces.HasDialog;
import com.stab.model.info.trait.base.activity.ComplexActivity;
import com.stab.model.info.trait.base.activity.Dialog;
import com.stab.model.info.trait.base.activity.stage.DecisionStage;
import com.stab.model.info.trait.base.activity.stage.QueryStage;

public class Roldare extends Humanoid implements HasDialog {

	public static final String ID="ROLDARE_INFO";
	
	@Override
	public void init() {
		super.init();
		setMaxMovePoints(6);
		
		setResource("roldaretoken");
		setText("Roldare");
		setDescription("Uno de los aldeanos, Roldare, visiblemente asustado");
		setFaction(15877);
		this.addTrait(new Alertness_Feat());
		//this.addTrait(new SkillFocus_FeatProfesion());
	//	this.addTrait(new WeaponFocus_Feat(WeaponFactory.LIGHTCROSSBOW));
		
		this.setAttribute(StabConstants.XP,400);
		this.setAttribute(StabConstants.TOHIT,+2);
		this.setAttribute(StabConstants.TOHITRANGED,+2);
		this.setAttribute(StabConstants.STRENGHT,13);
		this.setAttribute(StabConstants.DEXTERITY,14);
		this.setAttribute(StabConstants.CONSTITUTION,11);
		this.setAttribute(StabConstants.WISDOM,8);
		this.setAttribute(StabConstants.CHARISMA,9);
		this.setAttribute(StabConstants.HITDICENUMBER, 3);
		
		this.setAttribute(StabConstants.CLIMB, 7);
		this.setAttribute(StabConstants.CRAFTBOWS, 6);
		this.setAttribute(StabConstants.KNOWLEDGELOCAL, 6);
		this.setAttribute(StabConstants.PERCEPTION, 7);
		this.setAttribute(StabConstants.PROFESSIONSKILL, 8);
		this.setAttribute(StabConstants.RIDE, 8);
		this.setAttribute(StabConstants.SENSEMOTIVE, 7);
		
	//	DefaultAIPackage ai=new DefaultAIPackage();
	//	this.setCurrentAI(ai);
			
	//	this.setBloodeffEct("PARTICLE#damage/redblood");
		
	//	this.equip(StabInit.getWeaponFactory().getWeapon(WeaponFactory.LIGHTCROSSBOW), HumanoidGear.MAINHAND);
	//	this.equip(StabInit.getArmorFactory().getArmor(ArmorFactory.PADDED), HumanoidGear.ARMOR);
		
		//this.equip(StabInit.getWeaponFactory().getWeapon("LONGBOW"), HumanoidGear.BOTHHANDS);
	//	this.equip(StabInit.getArmorFactory().getArmor("STUDDEDLEATHER"), HumanoidGear.ARMOR);
		
		this.equip(ArmorFactory.STUDDEDLEATHER);
		this.equip(WeaponFactory.SHORTBOW);
		this.equip(EquipmentFactory.ARROW);
		
		
	
		//ContextualOption e= new ContextualOption();
		//e.setAction(DialogAction.ID);
		//e.setName("Hablar");
		//e.setDescription("Intentar calmar a Roldare");

		DelegatedAction d= new DelegatedAction(DialogAction.ID);
		d.setName("Hablar");
		d.setDescription("Intentar calmar a Roldare");
		ContextualOption e= new ContextualOption();
		e.setAction(d);
		this.addExtra(e);
	}

	@Override
	public Dialog getDialogFor(BaseInfo instigator) {


		Dialog d= new Dialog();
		d.setInfo(ComplexActivity.TARGET, this);
		
		
		Dialog d1= new Dialog();
		d1.addIText("Roldare! no me reconoces?");
		d1.addTText("Monstruos! Monstruos por todas partes!");
		d1.addIText("Calmate! tienes que calmarte! Ya estas a salvo!");
		
		QueryStage q= new QueryStage("V1","¿Cómo intentarás calmar a Roldare?","Intentar razonar con él","Intentar intimidarle","Engañarle para que crea que esta a salvo");
		d1.addStage(q);
		
		
		Dialog da= new Dialog();
		da.addIText("Roldare, somos nosotros... intenta calmarte... somos tus amigos");
		
		Dialog db= new Dialog();
		db.addIText("Roldare, maldita sea! Suelta el arma y abre la puerta! Si no acabaré contigo como con el resto de monstruos de esta cripta!");
		
		Dialog dc= new Dialog();
		dc.addIText("Ya esta todo bien... no quedan monstruos, puedes salir y volver a casa");
		
		DecisionStage ds= new DecisionStage("V1");
		ds.addOption(0, da);
		ds.addOption(0, db);
		ds.addOption(0, dc);
		
		d.addStage(ds);
		
		d.setInnerActivity(d1);
		
		return d;
	}
	
}