package com.stab.data.adventure.everflame;

import com.stab.common.events.DefaultRule;
import com.stab.common.events.ManagedEvent;
import com.stab.common.events.Response;
import com.stab.common.events.Rule;
import com.stab.data.StabConstants;
import com.stab.data.actions.player.spells.lvl1.unfinished.RemoveFear;
import com.stab.data.info.equipment.ArmorFactory;
import com.stab.data.info.equipment.EquipmentFactory;
import com.stab.data.info.equipment.WeaponFactory;
import com.stab.data.info.feat.general.Alertness_Feat;
import com.stab.data.info.monster.Humanoid;
import com.stab.model.action.Action;
import com.stab.model.action.DelegatedAction;
import com.stab.model.action.base.DialogAction;
import com.stab.model.basic.scenes.event.InfoBecomesAwareOfInfo;
import com.stab.model.basic.scenes.event.InfoDestroyed;
import com.stab.model.basic.scenes.event.SpecialSceneEvent;
import com.stab.model.basic.scenes.event.condition.InfoIsTag;
import com.stab.model.basic.scenes.event.condition.SpecialEventIs;
import com.stab.model.basic.scenes.event.response.ActivateRuleResponse;
import com.stab.model.basic.scenes.event.response.SendChannelResponse;
import com.stab.model.basic.scenes.event.response.ShowMessageResponse;
import com.stab.model.basic.scenes.event.response.infos.PlayAnimationResponse;
import com.stab.model.basic.scenes.event.response.infos.SetFactionResponse;
import com.stab.model.extras.ContextualOption;
import com.stab.model.info.BaseInfo;
import com.stab.model.info.Info;
import com.stab.model.info.applicable.base.SkillRoll;
import com.stab.model.info.interfaces.ActionPerformedListener;
import com.stab.model.info.interfaces.HasDialog;
import com.stab.model.info.trait.base.VisualEffect;
import com.stab.model.info.trait.base.activity.ComplexActivity;
import com.stab.model.info.trait.base.activity.Dialog;
import com.stab.model.info.trait.base.activity.stage.DecisionStage;
import com.stab.model.info.trait.base.activity.stage.QueryStage;
import com.stab.model.info.trait.base.activity.stage.SendSceneEventStage;
import com.stab.model.info.trait.base.activity.stage.SkillRollStage;
import com.stab.model.request.basic.ActionRequest;

public class Roldare extends Humanoid implements HasDialog, ActionPerformedListener {

	public static final String ID="ROLDARE_INFO";
	public static final String EVENT="ROLDARE_CALMED";
	
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
		d.setCancelOnTurnEnd(true);
		
		Dialog d1= new Dialog();
		d1.addIText("Roldare! no me reconoces?");
		d1.addTText("Monstruos! Monstruos por todas partes!");
		d1.addIText("Calmate! tienes que calmarte! Ya estas a salvo!");
		
		QueryStage q= new QueryStage("V1","¿Cómo intentarás calmar a Roldare?","Intentar razonar con él","Intentar intimidarle","Engañarle para que crea que esta a salvo");
		d1.addStage(q);
		
		
		Dialog dd= new Dialog();
		dd.addTText("Que?... ah... no sois los monstruos!");
		dd.addStage(new SendSceneEventStage(EVENT));
		
		Dialog da= new Dialog();
		da.addIText("Roldare, somos nosotros... intenta calmarte... somos tus amigos");
		//Esto como muestra del proceso completo. Hay un atajo en dialog para los casos sencillos
		da.addStage(new SkillRollStage(ComplexActivity.INSTIGATOR,StabConstants.DIPLOMACY,10,"V2"));
		DecisionStage ds2= new DecisionStage("V2");
		ds2.addOption(SkillRoll.SUCCESS, dd);
		ds2.addOption(SkillRoll.CRITICAL, dd);
		da.addStage(ds2);
		da.addIText("NO! Monstruos! Alejaos de mi!");
		
		
		Dialog db= new Dialog();
		db.addIText("Roldare, maldita sea! Suelta el arma y abre la puerta! Si no acabaré contigo como con el resto de monstruos de esta cripta!");
		db.addOnSkillSuccess(StabConstants.INTIMIDATE, 10, dd);
		db.addIText("NO! No pienso abrir! no me cogereis con vida!");
		
		Dialog dc= new Dialog();
		dc.addIText("Ya esta todo bien... no quedan monstruos, puedes salir y volver a casa");
		dd.addOnSkillSuccess(StabConstants.BLUFF, 10, dd);
		dc.addTText("NO! Aun puedo oirlos!! Puedo oirlos! Vienen a por mi!");
		
		
		DecisionStage ds= new DecisionStage("V1");
		ds.addOption(0, da);
		ds.addOption(1, db);
		ds.addOption(2, dc);
		
		d1.addStage(ds);
		
		d.setInnerActivity(d1);
		
		return d;
	}
	
	
	@Override
	public void actionPerformed(Info info, Action action, int result,
			ActionRequest request) {
		super.actionPerformed(info, action, result, request);
		//Vale, deberia comprobar tambien que yo era el target y que el result ha sido correcto, pero estoy vago
		//System.out.println("Action performed on me "+action.getId());
		if (RemoveFear.ID.equals(action.getId())){
			getScene().notify(new SpecialSceneEvent(getScene(), EVENT));
		}
	}
	
	

	
	@Override
	public void enter() {
		super.enter();
		
		//Regla para volverlo amistoso cuando se le calma (sea por el metodo que sea)
		DefaultRule r= new DefaultRule();
		r.setOnlyOnce(true);
		r.setEvent(SpecialSceneEvent.class);
		r.addCondition(new SpecialEventIs(EVENT));
		r.addResponse(new PlayAnimationResponse("ROLDARE",VisualEffect.CENTER_CAM_ANIMATION));
		r.addResponse(new SetFactionResponse("ROLDARE",0));
		r.addResponse(new PlayAnimationResponse("ROLDARE",VisualEffect.SPEECH_ANIMATION,"Ah! por los cielos! Estoy salvado!"));
		r.addResponse(new PlayAnimationResponse("ROLDARE",VisualEffect.SPEECH_ANIMATION,"Es una locura! la cripta esta llena de monstruos! Tengo que salir de aqui!"));
		r.addResponse(new SendChannelResponse(101, true)); //esto abrira la puerta cerrada
		r.addResponse(new Response(){
			@Override
			public boolean execute(Rule r, ManagedEvent e) {
				test();
				return true;
			}
		});
		
		this.getScene().addRule(r);
		
		//regla para lamentar su muerte
		//Si, si, entinedo que es mas facil meter el codigo en destroyed() pero queria probar las reglas.
		r= new DefaultRule();
		r.setOnlyOnce(true);
		r.setEvent(InfoDestroyed.class);
		r.addCondition(new InfoIsTag("ROLDARE"));
		r.addResponse(new ShowMessageResponse(null,"Lamentablemente, Roldare nunca conseguira volver a su casa. Su muerte pesará siempre en vuestras consciencias..."));
		//opcionalmente meter un setpartyvalue si eso.
		r.setActive(false);//desactivada inicialmente, ver mas abajo
		this.getScene().addRule(r);
		
		//Regla que activa la anterior una vez que os encontrais con roldare. Matarlo accidentalmente sin que el se de cuenta no
		//contaria. Ej: una bola de fuego o algo. Muy improbable, vamos
		DefaultRule r2= new DefaultRule();
		r2.setOnlyOnce(true);
		r2.setEvent(InfoBecomesAwareOfInfo.class);
		r2.addCondition(new InfoIsTag("ROLDARE"));
		r2.addResponse(new ActivateRuleResponse(r));
		this.getScene().addRule(r2);
		
	}
	
	public void test(){
		System.out.println("Una prueba, por la fuerza bruta :D");
		this.setDescription("Un aldeano del pueblo, ahora algo mas calmado");
		//Aqui habria que meter mas cosas: cambiar la ai para que quiera salir, pero mantenerse cerca de sus aliados
		//quizas cambiar la opcion de dialogo para que explique a los pjs lo sucedido, cosas asi.
	}
	
}