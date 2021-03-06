package com.stab.adventure;

import com.stab.adventure.everflame.ClimbAction;
import com.stab.adventure.everflame.ClimbWaypoint;
import com.stab.common.Constants;
import com.stab.common.events.DefaultRule;
import com.stab.common.fw.Loader;
import com.stab.common.utils.Roll;
import com.stab.fw.Module;
import com.stab.model.action.ActionLibrary;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.InfoInteractsWith;
import com.stab.model.basic.scenes.event.PlayerEntersScene;
import com.stab.model.basic.scenes.event.condition.CharacterSkillRollCondition;
import com.stab.model.basic.scenes.event.condition.PartyValueIs;
import com.stab.model.basic.scenes.event.condition.TargetInfoIsTag;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.SetPartyValueResponse;
import com.stab.model.basic.scenes.event.response.SetVisibleResponse;
import com.stab.model.basic.scenes.event.response.TravelAllToSceneResponse;
import com.stab.model.basic.scenes.event.response.TravelToSceneResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllMonstersDeadRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersAtZoneRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Image;
import com.stab.model.basic.ui.Text;
import com.stab.model.basic.ui.advanced.RolledSkillOptionButton;
import com.stab.pf.PfModule;
import com.stab.pf.StabConstants;
import com.stab.pf.scene.DefaultStabMapScene;
import com.stab.pf.utils.StabBlockData;
import com.stab.util.StabUtils;

public class CryptEverflameAdventure extends Adventure{
		
	public CryptEverflameAdventure() {
		
		
		//INDICAMOS EL DIRECTORIO ADICIONAL DE RECURSOS
		
		Loader.addDir("everflame");
		
		
		setName("Crypt of Everflame");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		setMaxPlayers(5);
		setAuthor("Jason Bulmahn");
		setDescription("Los jovenes heroes de la ciudad de Kassen estan listos para su prueba de madurez, una vieja ceremonia en la que tendran que traer una llama encendida en la llama eterna que arde en la tumba del fundador de la ciudad.");
		setIcon("everflame");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
//indice
		
		Choice n0 = new Choice();
		n0.createContents();
		n0.setTag("BEGIN");
		n0.setBackground("cover");
		
		n0.addOption("Empezar", "INTRO0");
		n0.addOption("Punto de salvado 1 (orcos)","START");
		n0.addOption("Punto de salvado 2 (lobos)","WOLVES");
		n0.addOption("Punto de salvado 3 (bandido)","BANDIT");
		//n0.addOption("Punto de salvado 4 (las cuerdas)", "ROPECLIFFS.Start");
		n0.addOption("Punto de salvado 4 (colina)", "HILLSIDE1");
		n0.addOption("Punto de salvado 5 (cripta)", "CRYPT1");
		n0.addOption("Punto de salvado 6 (Dungeon nivel 1)", "UPPER1");
		n0.addOption("Punto de salvado 7 (roldare)", "ROLDARE1");
		n0.addOption("Punto de salvado 8 (Dungeon nivel 2)", "LOWER.start");
		
		
		this.addScene(n0);
		
//escena 1
		
		Narration n1=new Narration();
		n1.createContents();
		n1.setTag("INTRO0");
		n1.setNext("INTRO");
		n1.setBackground("COLOR#orange");
		
		Text t1 = n1.createText("Hace casi 200 a�os, cuando la tierra que llegaria a ser Nirmathas " +
				"todavia era un vasallo del imperio de Cheliax, el norte del bosque de " +
				"los colmillos era un lugar salvaje y peligroso. Los cruzados que derrotaron " +
				"al surrurrante tirano son ahora una distante memoria, y a aquellos que quedaron " +
				"se les asigno mantener controlados a los orcos de Belkzen y a los undeads que " +
				"quedaban de Ustalav. Como resultado, el gran bosque estaba lleno de peligros, de " +
				"orcos merodeando a mortales depredadores, haciendolo inseguro para los comerciantes " +
				"que buscaban comerciar con la creciente comunidad de Skelt en las laderas de las " +
				"monta�as Mindspin en el oeste.");
		t1.setPos(Constants.BEGIN, Constants.NEXT);
		t1.setSize(Constants.FILL, Constants.CONTENT);
		
		Image i1 = new Image();
		i1.setImage("nirmathas$A");
		i1.setPos(Constants.BEGIN, Constants.BEGIN);
		i1.setSize(Constants.CONTENT, Constants.PERCENT+50);
		
		n1.addGUI(i1);
		n1.addGUI(t1);
		this.addScene(n1);
		
//escena 2
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("INTRO");
		n2.setNext("INTRO2");
		n2.setBackground("COLOR#orange");
		
		Text t2 = n2.createText("Ekat Kassen era un cruzado y buscador de fortuna que llego " +
				"a servir a Lastwall en el a�o 4515 AR. Aunque lucho con distincion, " +
				"pronto se dio cuenta de que buscaba mas de la vida y dejo la milicia " +
				"de Lastwall para encontrar su fortuna en otro sitio. " +
				"Sus viajes le llevaron hasta el lago Encarthan, donde decidio asentarse " +
				"despues de una aventura especialmente provechosa. Usando una parte de su " +
				"fortuna, acondiciono una parte del bosque de los colmillos a la orilla " +
				"del rio Tourondel, haciendolo una parada natural para los viajeros que " +
				"circulen por el rio a Skelt. Durante los proximos 10 a�os la ciudad ahora conocida " +
				"como Kassen Hold crecio y propero. " +
				"Todo esto cambio cuando Asar Vergas llego a Kassen Hold con un grupo de mercenarios " +
				"bajo sus ordenes. Asar era un viejo compa�ero de Ekat y ambos viajaron juntos un " +
				"tiempo antes de separarse justo antes de la ultima aventura de Ekat. Al paso de " +
				"los a�os, Asar se convencio de que Ekat le enga�o tras la aventura. Prometiendo " +
				"grandes fortunas a sus mercenarios, Asar asalto la ciudad durante dos meses. Finalmente " +
				"los lugare�os encontraron el campamento de los mercenarios en una antigua cripta en lo " +
				"profundo del bosque, y el mismo Ekat fue a lidiar con su antiguo compa�ero.");
		t2.setPos(Constants.NEXT, Constants.BEGIN);
		t2.setSize(Constants.FILL, Constants.CONTENT);
		
		Image i2 = new Image();
		i2.setImage("nirmathasmap$A");
		i2.setPos(Constants.BEGIN, Constants.BEGIN);
		i2.setSize(Constants.PERCENT+40, Constants.FILL);
		
		n2.addGUI(i2);
		n2.addGUI(t2);
		this.addScene(n2);
		
//escena 3
		
		Narration n3=new Narration();
		n3.createContents();
		n3.setTag("INTRO2");
		n3.setNext("INTRO3");
		n3.setBackground("COLOR#orange");
		
		Text t3 = n3.createText("La batalla fue terriblemente sangrienta, solo unos pocos de la gente de la ciudad volvio " +
				"para contar lo sucedido. Al final Asar murio y sus mercenarios fueron derrotados, pero " +
				"Ekat sufrio una herida mortal. Murio dos dias mas tarde el 11 de Neth de 4535 " +
				"En honor a su amado fundador le enterraron en la antigua cripta, enterrando sus huesos " +
				"en un lugar de honor, sobre el simple sarcofago usado para enterrar los restos de Asar," +
				"sus mercenarios y la gente del pueblo que perdieron sus vidas ese dia. Colocaron una " +
				"llama eterna de manera que todos los que le visitaran encontraran calor en la oscuridad. " +
				"Con los a�os la cripta de la llama eterna ha llegado a ser una parte importante de la " +
				"historia de la ciudad, ahora conocida simplemente como Kassen. Los ciudadanos ven el " +
				"lugar como un memorial de los primeros y duros a�os. Cada oto�o a un pu�ado de lugare�os " +
				"se les concede el honor de encender la linterna. Muchos lo ven como  una prueba de madurez " +
				"a la edad adulta, probar la aventura antes de empezar a a trabajar y casarse. " +
				"La aventura empieza como una solemne ceremonia, con los habitantes de Kassen reuniendose " +
				"para desear suerte a los aventureros, igual que hicieron cuando Kassen fue a enfrentarse " +
				"con los mercenarios. " +
				"Cuando los aventureros retornan unos pocos dias despues, la ciudad celebra una gran fiesta en su honor. " +
				"Esto tambien marca la ultima celebracion antes de que comience el duro invierno. ");
		t3.setPos(Constants.NEXT, Constants.BEGIN);
		t3.setSize(Constants.FILL, Constants.CONTENT);
		
		Image i3 = new Image();
		i3.setImage("kassen$A");
		i3.setPos(Constants.BEGIN, Constants.BEGIN);
		i3.setSize(Constants.PERCENT+35, Constants.FILL);
		
		n3.addGUI(i3);
		n3.addGUI(t3);
		this.addScene(n3);
		
//escena 4
		
		Narration n4=new Narration();
		n4.createContents();
		n4.setTag("INTRO3");
		n4.setNext("TOWN");
		n4.setBackground("village");
		
		Text t4 = n4.createText("Estamos a 4 de Neth, los primeros vientos del invierno empiezan a soplar. " +
				"Este fue el dia, en 5435, en el que Ekat Kassen y sus hombres marcharon al " +
				"encuentro de Asar y sus mercenarios. Y hoy sera el dia en el que junto con tus " +
				"amigos marcharas a hacerte adulto. Debes ir a la plaza del pueblo al mediodia " +
				"tal y como marca la tradicion, para aceptar la busqueda. Debes viajar ligero, " +
				"llevando solo lo necesario. Cuando llegas a la plaza, esta desierta, excepto " +
				"por tus compa�eros que van apareciendo poco a poco. De pronto la campana de la " +
				"iglesia empieza a ta�ir...");
		t4.setPos(Constants.BEGIN, Constants.NEXT);
		t4.setSize(Constants.FILL, Constants.CONTENT);
		
		Image i4=new Image();
		i4.setImage("town$A");
		i4.setPos(Constants.BEGIN, Constants.BEGIN);
		i4.setSize(Constants.FILL, Constants.PERCENT+60);
		
		n4.addGUI(i4);
		n4.addGUI(t4);
		this.addScene(n4);

//escena 5
		
		Narration n5=new Narration();
		n5.createContents();
		n5.setBackground("village");
		n5.setTag("TOWN");
		n5.setNext("TOWN2");
		
		Text t5 = n5.createText("La campana sobre el cercano templo de Erastil empieza a tocar su cancion " +
				"del mediodia, levantando ecos en la silenciosa ciudad de Kassen. Mientras " +
				"los ecos se extinguen, los primeros aldeanos empiezan a entrar en la plaza, " +
				"vestidos totalmente de negro como si de un funeral se tratase. Lentamente llenan " +
				"la plaza, moviendose sobre el duro y frio suelo, sus ojos bajos y " +
				"murmurando. Despues de un rato un murmullo se eleva de la multitud mientras " +
				"la gente lentamente abre paso para permitir que el alcalde Uptal entre. El avanza " +
				"con un farol de bru�ida plata en sus manos. Tras el hay un viejo poni cargado con " +
				"mochilas y provisiones. Cuando alcanza el centro de la muchedumbre el alcalde " +
				"se para y le habla a la multitud reunida. 'Otra vez el viento del invierno sopla " +
				"a traves del bosque del colmillo, marcando el final de otro oto�o. Hay lobos " +
				"en el bosque, aullando ante nuestros muros, serpientes en las sombras, esperando " +
				"golpearnos. Igual que hace 174 a�os, cuando el mismo Kassen dejo estos muros para " +
				"protegernos a todos, asi sera ahora tambien. �Donde estan los heroes? �Donde estan " +
				"los bravos que se aventuraran hasta la tumba de kassen para volver con la llama " +
				"que mantendra a esta comunidad a salvo durante otro invierno?' ");
		t5.setPos(Constants.BEGIN, Constants.NEXT);
		t5.setSize(Constants.FILL, Constants.CONTENT);		
		
		Image i5 = new Image();
		i5.setImage("uptal$A");
		i5.setPos(Constants.BEGIN, Constants.NEXT);
		i5.setSize(Constants.PERCENT+30, Constants.PERCENT+30);
		
		n5.addGUI(i5);
		n5.addGUI(t5);
		this.addScene(n5);
		
//escena 6
		
		Choice c6=new Choice();
		c6.createContents();
		c6.setBackground("village");
		c6.setTag("TOWN2");
		
		Text t6 = c6.createText("El alcalde hace una pausa para que podais aceptar la mision. Uno a uno " +
				"tus compa�eros y tu os acercais,  Uptal os entrega la mula y la lampara. " +
				"Antes de partir compruebas el contenido de la mochila, raciones para 5 dias, " +
				"una tienda de campa�a, un saco de dormir de invierno, un odre de agua y un " +
				"trozo de un mapa. Compruebas que cada uno de tus compa�eros tiene otro trozo " +
				"y despues de un rato conseguir juntarlos todos en un mapa mas grande que os " +
				"indica vuestro camino. Al terminar vuestros preparativos el alcalde vuelve a " +
				"hablar, '�Os presento a los bravos heroes que seguiran los pasos de Kassen para " +
				"traernos la llama eterna! Algunos de ellos podrian no regresar, pero yo os digo " +
				"que su sacrificio no sera olvidado. Ir, bravos heroes, y no regreseis sin el fuego " +
				"eterno.' Tras esto el alcalde se�ala hacia el sur, en direccion a la tumba de Kassen. " +
				"Los aldeanos os despiden de forma fria, reflejandose la solemnidad del momento en sus " +
				"rostros. ");
		t6.setPos(Constants.NEXT, Constants.BEGIN);
		t6.setSize(Constants.FILL, Constants.CONTENT);
		
		Image i6 = new Image();
		i6.setImage("zone$A");
		i6.setPos(Constants.BEGIN, Constants.BEGIN);
		i6.setSize(Constants.PERCENT+30, Constants.PERCENT+90);
		
		c6.addGUI(i6);
		c6.addGUI(t6);
		c6.addOption("Empezar la aventura!","START");
		this.addScene(c6);
		
//escena 6a
		
				Choice c6a=new Choice();
				c6a.createContents();
				c6a.setBackground("forest");
				c6a.setTag("START");
				
				Text t6a = c6a.createText("Empezais vuestra marcha con ilusion en vuestros corazones. Cuando llevais un par de horas andando por el camino " +
						"a traves del bosque ois un extra�o ruido, como un jabali. Aprestais vuestras armas preparados para espantar al animal, pero lo que sale " +
						"cargando de entre los arbustos no es lo que esperais, sino tres criaturas humanoides con piel de color verdosa y grandes " +
						"colmillos. Jurarias que deben ser esas criaturas que has oido alguna vez que se llaman orcos. Sabes de ellos que son fuertes, resistentes " +
						"y malignos hasta la medula.");
				t6a.setPos(Constants.NEXT, Constants.BEGIN);
				t6a.setSize(Constants.FILL, Constants.CONTENT);
				
				DefaultRule r6a= new DefaultRule();
				r6a.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p6a = new SetPartyValueResponse("save1",true);
				r6a.addResponse(p6a);
				c6a.addRule(r6a);
				
				c6a.addGUI(t6a);
				c6a.addOption("Tira Iniciativa!","ORCS.start");
				this.addScene(c6a);
				
//mapa combate 1
		
		DefaultTileMapScene mc1=new DefaultTileMapScene();
		mc1.createContents();
		mc1.createMap(15,15);
		mc1.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		mc1.loadTiled("orcs", 0, 0);
		mc1.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		
		mc1.setTag("ORCS");
		
		AllMonstersDeadRule r=new AllMonstersDeadRule();
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		mc1.addRule(r);
		AllPlayersDeadRule r2=new AllPlayersDeadRule();
		r2.addResponse(new DefeatResponse(0,"DEFEATORCS"));
		mc1.addRule(r2);
		this.addScene(mc1);
		
//escena 6b
		
				Choice c6b=new Choice();
				c6b.createContents();
				c6b.setTag("DEFEATORCS");
				c6b.setBackground("forest");
				
				Text t6b = c6b.createText("Los orcos demuestran ser demasiado duros para vosotros. Cuando el ultimo de vuestro grupo toca el suelo ves " +
						"mientras agonizas tendido que los orcos parecen desaparecer por arte de magia. Despues tus heridas desaparecen igualmente. Parece " +
						"como si fueran una elaborada ilusion, pero no parece tener sentido. Os incorporais con la adrenalina aun al maximo y os mirais sin " +
						"saber muy bien que hacer ahora.");
				
				RolledSkillOptionButton sb6b = new RolledSkillOptionButton();
				sb6b.setText("Investigar la zona.");
				sb6b.setSkill(StabConstants.PERCEPTION);
				sb6b.setDC(15);
				sb6b.setResults("8PERCFAIL", "8PERCSUCCESS");
				
				c6b.addGUI(t6b);
				c6b.addOption(sb6b);
				c6b.addOption("Continuar el viaje.", "WOLVES");
				this.addScene(c6b);
				
//escena 7 choice 2
		
		Choice c7=new Choice();
		c7.createContents();
		c7.setTag("VICTORY");
		c7.setBackground("forest");
		
		Text t7 = c7.createText("La dura batalla contra los extra�os orcos acaba, dejando una sensacion extra�a, por la forma de desaparecer parece " +
				"claro que estas criaturas no eran mas que ilusiones, pero quien y porque haria algo asi.");
		
		RolledSkillOptionButton sb7 = new RolledSkillOptionButton();
		sb7.setText("Investigar la zona.");
		sb7.setSkill(StabConstants.PERCEPTION);
		sb7.setDC(15);
		sb7.setResults("8PERCFAIL", "8PERCSUCCESS");
		
		c7.addGUI(t7);
		c7.addOption(sb7);
		c7.addOption("Continuar el viaje.", "WOLVES");
		this.addScene(c7);
	
//escena 8
		
		Narration n8=new Narration();
		n8.createContents();
		n8.setTag("8PERCFAIL");
		n8.setNext("WOLVES");
		n8.setBackground("forest");
		
		Text t8 = n8.createText("Buscas por la zona, pero no consigues encontrar nada que te llame la atenci�n. Al cabo de un rato decides continuar con tu camino. ");
		t8.setSize(Constants.CONTENT,Constants.CONTENT);
		
		n8.addGUI(t8);
		this.addScene(n8);
		
//escena 9
		
		Narration n9=new Narration();
		n9.createContents();
		n9.setTag("8PERCSUCCESS");
		n9.setNext("WOLVES");
		n9.setBackground("forest");
		
		Text t9 = n9.createText("Un olor a tabaco de pipa llama poderosamente tu atenci�n. Despues de un rato pensando lo asocias al tabaco que fuma Holgast, el mago de la aldea. " +
				"Mientras vas meditando sobre ello decides continuar tu viaje.");
		t9.setSize(Constants.CONTENT,Constants.CONTENT);
		t9.setPos(Constants.BEGIN, Constants.NEXT);
		
		Image i9 = new Image();
		i9.setImage("holgast$A");
		i9.setPos(Constants.BEGIN, Constants.BEGIN);
		i9.setSize(Constants.PERCENT+30, Constants.PERCENT+30);
		
		n9.addGUI(i9);
		n9.addGUI(t9);
		this.addScene(n9);
		
//escena 10 choice 3
		
		Choice c10=new Choice();
		c10.createContents();
		c10.setBackground("forest");
		c10.setTag("WOLVES");
		
		Text t10 = c10.createText("Despues de derrotar a los extra�os orcos ilusorios, seguis avanzando. Gracias al mapa que llevais es relativamente sencillo encontrar el camino correcto. " +
				"Despues de todo el dia andando queda poco para que oscurezca. Empezais a buscar un sitio para montar las tiendas mientras las sombras de " +
				"los arboles se alargan mas y mas, cubriendolo todo y dando un aspecto ominoso al bosque antes placido. Con una sensacion de desasosiego " +
				"empezais a montar el campamento. ");
		t10.setSize(Constants.CONTENT,Constants.CONTENT);
		t10.setPos(Constants.BEGIN, Constants.NEXT);
	
		
		//Ejemplo de rolledSkill
		RolledSkillOptionButton sb10= new RolledSkillOptionButton();
		sb10.setText("Tirar survival para buscar un buen sitio de acampar");
		sb10.setSkill(StabConstants.SURVIVAL);
		sb10.setDC(10);
		sb10.setResults("10SURVIVALFAIL", "10SURVIVALSUC");
																					//Si las escenas empiezan por #, eso mueve a todos los jugadores en la escena a la escena indicada
																					//Esto es aplicable a los casos normales tambien.
																				    //Ojo que puede que alguien no este en la escena. eso lo vemos mas adelante con scene.setWaitsForAll()
		//Notese  que esto no le pone icono, pero le cambia el tama�o a que ocupe toda la linea
		//Y esta pendiente de probar, claro :D
		//RolledOptionButton funciona casi igual
		
		DefaultRule r10= new DefaultRule();
		r10.setEvent(PlayerEntersScene.class);
		SetPartyValueResponse p10 = new SetPartyValueResponse("save2",true);
		r10.addResponse(p10);
		c10.addRule(r10);
		
		c10.addGUI(t10);
		c10.addOption(sb10); 
		c10.addOption("Acampar en el primer sitio que veas", "10SURVIVALFAIL");
		this.addScene(c10);
		
//escena 10a
		
				Narration n10a=new Narration();
				n10a.createContents();
				n10a.setTag("10SURVIVALSUC");
				n10a.setNext("WOLVES2");
				n10a.setBackground("forest");
				
				Text t10a = n10a.createText("Despues de un buen rato buscando encuentras una peque�a elevacion protegida por matorrales tupidos en dos de sus lados. " +
						"Satisfecho con el sitio montais campamento bajo las estrellas. ");
				t10a.setSize(Constants.CONTENT,Constants.CONTENT);
				t10a.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r10a= new DefaultRule();
				r10a.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p10a = new SetPartyValueResponse("acampar",true);
				r10a.addResponse(p10a);
				n10a.addRule(r10a);
				
				n10a.addGUI(t10a);
				this.addScene(n10a);
				
//escena 10b
				
				Narration n10b=new Narration();
				n10b.createContents();
				n10b.setTag("10SURVIVALFAIL");
				n10b.setNext("WOLVES2");
				n10b.setBackground("forest");
				
				Text t10b = n10b.createText("Por mucho que buscas no consigues ver un sitio bien protegido y la falta de luz hace que acampes en cualquier sitio. " +
						"Aun asi estas contento de poder descansar un poco despues del duro dia. ");
				t10b.setSize(Constants.CONTENT,Constants.CONTENT);
				t10b.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r10b= new DefaultRule();
				r10b.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p10b = new SetPartyValueResponse("acampar",false);
				r10b.addResponse(p10b);
				n10b.addRule(r10b);
				
				n10b.addGUI(t10b);
				this.addScene(n10b);
		
//escena 11 choice 4
		
		Choice c11=new Choice();
		c11.createContents();
		c11.setBackground("forest");
		c11.setTag("WOLVES2");
		
		Text t11 = c11.createText("Despues encendeis una peque�a hoguera y empezais a cocinar un estofado con las raciones que hay en " +
	"vuestras mochilas. Mientras cocinais ois a lo lejos unos aullidos. Al cabo de una hora volveis a oir los aullidos pero ahora mucho mas cerca. " +
	"Pasa otra media hora...");
		
		Text tt=c11.createText("...Veis un gran lobo observandoos escondido entre los matorrales. Claramente intenta huir despues de veros, seguramente con la " +
				"intencion de traer al resto de su manada para atacaros. Debeis actuar rapidamente. ");
		tt.setVisible(false);
		
		Button batt = new Button();
		batt.setText("Atacar al lobo.");
		batt.setVisible(false);
		batt.setAction("WOLVES3");
		
		RolledSkillOptionButton bwild= new RolledSkillOptionButton();
		bwild.setText("Tirar Wild Empathy contra el lobo");
		bwild.setSkill(StabConstants.HANDLEANIMAL);
		bwild.setDC(15);
		bwild.setResults("WILDFAIL", "WILDSUCC");
		bwild.setVisible(false);
		
		Button bhuir = new Button();
		bhuir.setText("Dejar huir al lobo.");
		bhuir.setVisible(false);
		bhuir.setAction("WOLVES4");
		
		Button bpasar = new Button();
		bpasar.setText("Pasar la noche");
		bpasar.setAction("WOLVES4");
		
		
		DefaultRule rr= new DefaultRule();
		rr.setEvent(PlayerEntersScene.class);
		rr.addCondition(new CharacterSkillRollCondition(StabConstants.PERCEPTION, Roll.d20()+6));
		rr.addResponse(new SetVisibleResponse(tt, true));
		rr.addResponse(new SetVisibleResponse(batt, true));
		rr.addResponse(new SetVisibleResponse(bwild, true));
		rr.addResponse(new SetVisibleResponse(bhuir, true));
		rr.addResponse(new SetVisibleResponse(bpasar, false));
		c11.addRule(rr);
		
		c11.addGUI(t11);
		c11.addOption(bpasar);
		c11.addGUI(tt);
		c11.addOption(batt);
		c11.addOption(bwild);
		c11.addOption(bhuir);
		this.addScene(c11);
	
//escena 12
		
		Narration n12=new Narration();
		n12.createContents();
		n12.setTag("WILDFAIL");
		n12.setNext("WOLVES4");
		n12.setBackground("forest");
		
		Text t12 = n12.createText("El lobo se queda escuchandote ladeando la cabeza. Al cabo de un rato sin embargo salta hacia delante y huye. Esperas no tener mas problemas" +
				"con lobos esta noche. Volveis a dormir aunque decidis mantener a alguien haciendo guardia solamente por precaucion. ");
		t12.setSize(Constants.CONTENT,Constants.CONTENT);
		t12.setPos(Constants.BEGIN, Constants.NEXT);
		
		Image i12 = new Image();
		i12.setImage("wolf$A");
		i12.setPos(Constants.BEGIN, Constants.BEGIN);
		i12.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
		
		n12.addGUI(i12);
		n12.addGUI(t12);
		this.addScene(n12);
		
//escena 13
		
		Narration n13=new Narration();
		n13.createContents();
		n13.setTag("WILDSUCC");
		n13.setNext("BANDIT");
		n13.setBackground("forest");
		
		Text t13 = n13.createText("El lobo se queda escuchandote ladeando la cabeza. Al cabo de un rato se acerca a ti olisqueando tu mano y con un salto " +
				"desaparece en el bosque. Crees que esta manada no os dara mas problemas, al menos esta noche. El resto de la noche pasa " +
				"con tranquilidad. ");
		t13.setSize(Constants.CONTENT,Constants.CONTENT);
		t13.setPos(Constants.BEGIN, Constants.NEXT);
		
		Image i13 = new Image();
		i13.setImage("wolf$A");
		i12.setPos(Constants.BEGIN, Constants.BEGIN);
		i12.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
		
		n13.addGUI(i13);
		n13.addGUI(t13);
		this.addScene(n13);
		
//escena 14
		
				Choice n14=new Choice();
				n14.createContents();
				n14.setTag("WOLVES3");
				n14.setBackground("forest");
				
				Text t14 = n14.createText("Intentas atacar al lobo antes de que este pueda huir. Reaccionas todo lo rapido que puedes con la esperanza de " +
						"ser suficientemente veloz.");
				t14.setSize(Constants.CONTENT,Constants.CONTENT);
				t14.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i14 = new Image();
				i14.setImage("wolf$A");
				i14.setPos(Constants.BEGIN, Constants.BEGIN);
				i14.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				RolledSkillOptionButton bini= new RolledSkillOptionButton();
				bini.setText("Tirar iniciativa");
				bini.setSkill(StabConstants.INICIATIVEMOD);
				bini.setDC(Roll.d20()+2);
				bini.setResults("INIFAIL", "INISUCC");
				
				n14.addGUI(i14);
				n14.addGUI(t14);
				n14.addOption(bini);
				this.addScene(n14);
				
//escena 15
				
				Choice n15=new Choice();
				n15.createContents();
				n15.setTag("INISUCC");
				n15.setBackground("forest");
				
				Text t15 = n15.createText("Llegas hasta el lobo, dandole un fuerte golpe, aunque no lo suficiente para acabar con el. Ense�andote sus terribles " +
						"dientes intenta huir y perderse en el bosque. Desesperamente intentas conectar otro golpe que acabe con el antes de que consiga huir");
				t15.setSize(Constants.CONTENT,Constants.CONTENT);
				t15.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i15 = new Image();
				i15.setImage("wolf$A");
				i15.setPos(Constants.BEGIN, Constants.BEGIN);
				i15.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				RolledSkillOptionButton bini2= new RolledSkillOptionButton();
				bini2.setText("Atacar");
				bini2.setSkill(StabConstants.INICIATIVEMOD);
				bini2.setDC(Roll.d20()+2);
				bini2.setResults("INIFAIL", "INISUCC2");
				
				n15.addGUI(i15);
				n15.addGUI(t15);
				n15.addOption(bini2);
				this.addScene(n15);
				
//escena 16
				
				Narration n16=new Narration();
				n16.createContents();
				n16.setTag("INIFAIL");
				n16.setNext("WOLVES4");
				n16.setBackground("forest");
				
				Text t16 = n16.createText("No consigues incapacitar al lobo antes de que este desaparezca bajo unos arbustos. Solo consigues oir como se pierde " +
						"cada vez mas lejos de vosotros. Afortunadamente huyo y nadie ha resultado herido. Volveis al campamento a intentar pasar lo que queda de noche.");
				t16.setSize(Constants.CONTENT,Constants.CONTENT);
				t16.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i16 = new Image();
				i16.setImage("wolf$A");
				i16.setPos(Constants.BEGIN, Constants.BEGIN);
				i16.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				n16.addGUI(i16);
				n16.addGUI(t16);
				this.addScene(n16);
				
//escena 17
				
				Narration n17=new Narration();
				n17.createContents();
				n17.setTag("INISUCC2");
				n17.setBackground("BANDIT");
				
				Text t17 = n17.createText("Consigues incapacitar al lobo antes de que este desaparezca bajo unos arbustos.  Afortunadamente nadie ha " +
						"resultado herido. Arrastrais el cadaver del gran lobo y volveis al campamento a intentar pasar lo que queda de noche.");
				t17.setSize(Constants.CONTENT,Constants.CONTENT);
				t17.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i17 = new Image();
				i17.setImage("wolf$A");
				i17.setPos(Constants.BEGIN, Constants.BEGIN);
				i17.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				n17.addGUI(i17);
				n17.addGUI(t17);
				this.addScene(n17);
				
//escena 18
				
				Narration n18=new Narration();
				n18.createContents();
				n18.setTag("WOLVES4");
				n18.setBackground("forest");
				
				Text t18 = n18.createText("Al cabo de una hora oyes ruidos que se acercan al campamento y ves unos ojos en la oscuridad, brillando " +
						"con una luz intensa. Ves surgir de entre la maleza tres lobos que gru�en y se abalanzan sobre vosotros.");
				t18.setSize(Constants.CONTENT,Constants.CONTENT);
				t18.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i18 = new Image();
				i18.setImage("wolf$A");
				i18.setPos(Constants.BEGIN, Constants.BEGIN);
				i18.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				
				DefaultRule r18 = new DefaultRule();
				r18.setEvent(PlayerEntersScene.class);
				r18.addCondition(new PartyValueIs("acampar", false));
				r18.addResponse(new TravelToSceneResponse("CAMP2.Campamento"));
				r18.addOnFail(new TravelToSceneResponse("CAMP1.Campamento"));
				n18.addRule(r18);
			
				n18.addGUI(i18);
				n18.addGUI(t18);
				this.addScene(n18);
				
//mapa combate 2
				
				DefaultTileMapScene mc2=new DefaultTileMapScene();
				mc2.createContents();
				mc2.createMap(12,12);
				mc2.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc2.loadTiled("camp1", 0, 0);
				mc2.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
				
				mc2.setTag("CAMP1");
				
				AllMonstersDeadRule rm2=new AllMonstersDeadRule();
				rm2.addResponse(new VictoryResponse(0,"BANDIT"));
				mc2.addRule(rm2);
				AllPlayersDeadRule rm3=new AllPlayersDeadRule();
				rm3.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc2.addRule(rm3);
				this.addScene(mc2);
				
//mapa combate 3
				
				DefaultTileMapScene mc3=new DefaultTileMapScene();
				mc3.createContents();
				mc3.createMap(12,12);
				mc3.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc3.loadTiled("camp2", 0, 0);
				mc3.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
			
				mc3.setTag("CAMP2");
				
				AllMonstersDeadRule rm4=new AllMonstersDeadRule();
				rm4.addResponse(new VictoryResponse(0,"BANDIT"));
				mc3.addRule(rm4);
				AllPlayersDeadRule rm5=new AllPlayersDeadRule();
				rm5.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc3.addRule(rm5);
				this.addScene(mc3);
				
//escena 19
				
				Choice c19=new Choice();
				c19.createContents();
				c19.setBackground("forest");
				c19.setTag("BANDIT");
				
				Text t19 = c19.createText("Al dia siguiente continuais vuestro camino a traves del bosque del Colmillo. " +
						"Temprano por la ma�ana llegais a la orilla del lago Gris, donde pensais rellenar vuestros pellejos de agua  y" +
						"tomar un breve descanso. Segun os acercais veis que los arboles empiezan a escasear, revelando un campo de corta " +
						"hierba verde que lleva a la orilla de un ancho y tranquilo lago, que refleja el cielo sobre el. Una densa niebla " +
						"cuelga sobre el centro del lago, oscureciendo la orilla opuesta. En la orilla, una forma oscura esta tendida " +
						"cerca del agua. Os acercais y veis un hombre muerto en bastante mal estado");
				t19.setSize(Constants.CONTENT,Constants.CONTENT);
				t19.setPos(Constants.BEGIN, Constants.NEXT);
			
				RolledSkillOptionButton sb19a = new RolledSkillOptionButton();
				sb19a.setText("Investigar alrededor del cadaver");
				sb19a.setSkill(StabConstants.PERCEPTION);
				sb19a.setDC(10);
				sb19a.setResults("PERCFAIL", "PERCSUCC");
				
				DefaultRule r19a = new DefaultRule();
				r19a.setEvent(PlayerEntersScene.class);
				r19a.addCondition(new PartyValueIs("banditperception", true));
				r19a.addResponse(new SetVisibleResponse(sb19a,false));
				c19.addRule(r19a);
				
				RolledSkillOptionButton sb19b = new RolledSkillOptionButton();
				sb19b.setText("Investigar el cadaver");
				sb19b.setSkill(StabConstants.KNOWLEDGELOCAL);
				sb19b.setDC(10);
				sb19b.setResults("LOCALFAIL", "LOCALSUCC");
				
				DefaultRule r19b = new DefaultRule();
				r19b.setEvent(PlayerEntersScene.class);
				r19b.addCondition(new PartyValueIs("banditlocal", true));
				r19b.addResponse(new SetVisibleResponse(sb19b,false));
				c19.addRule(r19b);
				
				RolledSkillOptionButton sb19c = new RolledSkillOptionButton();
				sb19c.setText("Investigar sus heridas");
				sb19c.setSkill(StabConstants.HEALSKILL);
				sb19c.setDC(15);
				sb19c.setResults("HEALFAIL", "HEALSUCC");
				
				DefaultRule r19c = new DefaultRule();
				r19c.setEvent(PlayerEntersScene.class);
				r19c.addCondition(new PartyValueIs("banditheal", true));
				r19c.addResponse(new SetVisibleResponse(sb19c,false));
				c19.addRule(r19c);
				
				RolledSkillOptionButton sb19d = new RolledSkillOptionButton();
				sb19d.setText("Buscar por la zona");
				sb19d.setSkill(StabConstants.SURVIVAL);
				sb19d.setDC(15);
				sb19d.setResults("SURVFAIL", "SURVSUCC");
				
				DefaultRule r19d = new DefaultRule();
				r19d.setEvent(PlayerEntersScene.class);
				r19d.addCondition(new PartyValueIs("banditsurvival", true));
				r19d.addResponse(new SetVisibleResponse(sb19d,false));
				c19.addRule(r19d);
				
				DefaultRule r19e= new DefaultRule();
				r19e.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p19e = new SetPartyValueResponse("save3",true);
				r19e.addResponse(p19e);
				c19.addRule(r19e);
				
				c19.addGUI(t19);
				c19.addOption(sb19a);
				c19.addOption(sb19b);
				c19.addOption(sb19c);
				c19.addOption(sb19d);
				c19.addOption("Seguir tu camino", "HILLSIDE1");
				this.addScene(c19);
				
//escena 20a
				
				Narration n20a=new Narration();
				n20a.createContents();
				n20a.setTag("PERCFAIL");
				n20a.setNext("BANDIT");
				n20a.setBackground("forest");
				
				Text t20a = n20a.createText("Buscas pero no consigues ver nada que te llame la atencion.");
				t20a.setSize(Constants.CONTENT,Constants.CONTENT);
				t20a.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20a= new DefaultRule();
				r20a.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20a = new SetPartyValueResponse("banditperception",true);
				r20a.addResponse(p20a);
				n20a.addRule(r20a);
				
				n20a.addGUI(t20a);
				this.addScene(n20a);
				
//escena 20b
				
				Narration n20b=new Narration();
				n20b.createContents();
				n20b.setTag("PERCSUCC");
				n20b.setNext("BANDIT");
				n20b.setBackground("forest");
				
				Text t20b = n20b.createText("Encuentras una espada corta que parece de buena calidad y una bolsa de cuero con 86 monedas de oro. Las guardas en tu mochila.");
				t20b.setSize(Constants.CONTENT,Constants.CONTENT);
				t20b.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20b= new DefaultRule();
				r20b.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20b = new SetPartyValueResponse("banditperception",true);
				r20b.addResponse(p20b);
				n20b.addRule(r20b);
				
				n20b.addGUI(t20b);
				this.addScene(n20b);
				
//escena 20c
				
				Narration n20c=new Narration();
				n20c.createContents();
				n20c.setTag("LOCALFAIL");
				n20c.setNext("BANDIT");
				n20c.setBackground("forest");
				
				Text t20c = n20c.createText("Buscas pero no consigues ver nada que te llame la atencion.");
				t20c.setSize(Constants.CONTENT,Constants.CONTENT);
				t20c.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20c= new DefaultRule();
				r20c.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20c = new SetPartyValueResponse("banditlocal",true);
				r20c.addResponse(p20c);
				n20c.addRule(r20c);
				
				n20c.addGUI(t20c);
				this.addScene(n20c);
				
//escena 20d
				
				Narration n20d=new Narration();
				n20d.createContents();
				n20d.setTag("LOCALSUCC");
				n20d.setNext("BANDIT");
				n20d.setBackground("forest");
				
				Text t20d = n20d.createText("Ves que las ropas que lleva el cadaver no son locales, pero dirias que este hombre venia de una gran ciudad, seguramente cercana.");
				t20d.setSize(Constants.CONTENT,Constants.CONTENT);
				t20d.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20d = new DefaultRule();
				r20d.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20d = new SetPartyValueResponse("banditlocal",true);
				r20d.addResponse(p20d);
				n20d.addRule(r20d);
				
				n20d.addGUI(t20d);
				this.addScene(n20d);
				
//escena 20e
				
				Narration n20e=new Narration();
				n20e.createContents();
				n20e.setTag("HEALFAIL");
				n20e.setNext("BANDIT");
				n20e.setBackground("forest");
				
				Text t20e = n20e.createText("Miras el cadaver pero no consigues ver nada que te llame la atencion.");
				t20e.setSize(Constants.FILL,Constants.CONTENT);
				t20e.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20e= new DefaultRule();
				r20e.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20e = new SetPartyValueResponse("banditheal",true);
				r20e.addResponse(p20e);
				n20e.addRule(r20e);
				
				n20e.addGUI(t20e);
				this.addScene(n20e);
				
//escena 20f
				
				Narration n20f=new Narration();
				n20f.createContents();
				n20f.setTag("HEALSUCC");
				n20f.setNext("BANDIT");
				n20f.setBackground("forest");
				
				Text t20f = n20f.createText("Miras sus heridas y ves que son heridas de mordiscos de una criatura bastante grande. Son 2 grandes agujeros, dirias " +
						"que de algun tipo de serpiente gigante. El pobre hombre debio acercarse al lago a coger agua y fue atacado. Dirias que debe llevar muerto " +
						"dos o tres meses al menos.");
				t20f.setSize(Constants.CONTENT,Constants.CONTENT);
				t20f.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20f= new DefaultRule();
				r20f.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20f = new SetPartyValueResponse("banditheal",true);
				r20f.addResponse(p20f);
				n20f.addRule(r20f);
				
				n20f.addGUI(t20f);
				this.addScene(n20f);
				
//escena 20g
				
				Narration n20g=new Narration();
				n20g.createContents();
				n20g.setTag("SURVFAIL");
				n20g.setNext("BANDIT");
				n20g.setBackground("forest");
				
				Text t20g = n20g.createText("Buscas pero no consigues ver nada que te llame la atencion.");
				t20g.setSize(Constants.FILL,Constants.CONTENT);
				t20g.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20g= new DefaultRule();
				r20g.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20g = new SetPartyValueResponse("banditsurvival",true);
				r20g.addResponse(p20g);
				n20g.addRule(r20g);
				
				n20g.addGUI(t20g);
				this.addScene(n20g);
				
//escena 20h
				
				Narration n20h=new Narration();
				n20h.createContents();
				n20h.setTag("SURVSUCC");
				n20h.setNext("BANDIT");
				n20h.setBackground("forest");
				
				Text t20h = n20h.createText("Encuentras un antiguo campamento a unos tres kilometros al este. Claramente lleva varios meses sin ser usado " +
						"y dirias que aqui acampo un peque�o grupo de hombres.");
				t20h.setSize(Constants.CONTENT,Constants.CONTENT);
				t20h.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r20h = new DefaultRule();
				r20h.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p20h = new SetPartyValueResponse("banditsurvival",true);
				r20h.addResponse(p20h);
				n20h.addRule(r20h);
				
				n20h.addGUI(t20h);
				this.addScene(n20h);
				
//escena 21
				
				Narration n21=new Narration();
				n21.createContents();
				n21.setTag("HILLSIDE1");
				n21.setNext("HILLSIDE2");
				n21.setBackground("crypt");
				
				Text t21 = n21.createText("Dejais el lago Gris atras y viajais unas tres horas hasta llegar " +
						"al valle donde segun el mapa se encuentra la Cripta de la Llama Eterna. Los arboles de " +
						"esta zona son muy antiguos. El tiempo hace el viaje aun mas miserable cuando una " +
						"fria lluvia empieza a caer. Veis un camino que lleva aun mas adentro en el bosque, a " +
						"traves de un laberinto de arboles y tupidos matorrales. El camino sube una peque�a " +
						"loma y mas alla se abre a un ancho valle, cuyo lado opuesto parece una serpiente " +
						"ondulante. En el medio se ve una colina detras de un terraplen. La lluvia hace que " +
						"el suelo sea resbaladizo y traicionero.");
				t21.setSize(Constants.CONTENT,Constants.CONTENT);
				t21.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r21= new DefaultRule();
				r21.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p21 = new SetPartyValueResponse("save4",true);
				r21.addResponse(p21);
				n21.addRule(r21);
				
				n21.addGUI(t21);
				this.addScene(n21);
				
//escena 22
				
				Choice c22=new Choice();
				c22.createContents();
				c22.setTag("HILLSIDE2");
				c22.setBackground("crypt");
				
				Text t22 = c22.createText("La colina es muy resbaladiza y bajar por el terraplen sera muy laborioso.");
				t22.setSize(Constants.CONTENT,Constants.CONTENT);
				t22.setPos(Constants.BEGIN, Constants.NEXT);
				
				c22.addGUI(t22);
				c22.addOption("Bajar la colina.","ROPECLIFFS.Start");
				this.addScene(c22);
		
//escena 23
				
				Choice c23=new Choice();
				c23.createContents();
				c23.setBackground("crypt");
				c23.setTag("CRYPT1");
				
				Text t23 = c23.createText("Hay un arco de piedra en un lateral de una peque�a colina al fondo del valle. " +
						"El musgo a cubierto muchos de sus detalles, pero uno todavia esta muy claro. La piedra sobre el " +
						"arco esta tallada con un simbolo de una llama con una estilizada runa en el medio. Mas alla del " +
						"arco hay un tunel oscuro que lleva a un par de grandes puertas de madera, una de las cuales esta " +
						"ligeramente doblada. Un par de caballos y un trio de ponis yacen destrozados al lado del arco, " +
						"cada cadaver aun atado al poste clavado en el suelo. Una nube de moscas zumba perezosamente sobre ellos.");
				t23.setSize(Constants.CONTENT,Constants.CONTENT);
				t23.setPos(Constants.BEGIN, Constants.NEXT);
			
				RolledSkillOptionButton sb23a = new RolledSkillOptionButton();
				sb23a.setText("Investigar la zona.");
				sb23a.setSkill(StabConstants.PERCEPTION);
				sb23a.setDC(15);
				sb23a.setResults("CRYPTPERCFAIL", "CRYPTPERCSUCC");
				
				DefaultRule r23a = new DefaultRule();
				r23a.setEvent(PlayerEntersScene.class);
				r23a.addCondition(new PartyValueIs("cryptperception", true));
				r23a.addResponse(new SetVisibleResponse(sb23a,false));
				c23.addRule(r23a);
				
				RolledSkillOptionButton sb23b = new RolledSkillOptionButton();
				sb23b.setText("Buscar las alforjas");
				sb23b.setSkill(StabConstants.PERCEPTION);
				sb23b.setDC(10);
				sb23b.setResults("CRYPTPERC2FAIL", "CRYPTPERC2SUCC");
				
				DefaultRule r23b = new DefaultRule();
				r23b.setEvent(PlayerEntersScene.class);
				r23b.addCondition(new PartyValueIs("cryptperception2", true));
				r23b.addResponse(new SetVisibleResponse(sb23b,false));
				c23.addRule(r23b);
				
				RolledSkillOptionButton sb23c = new RolledSkillOptionButton();
				sb23c.setText("Investigar sus heridas");
				sb23c.setSkill(StabConstants.HEALSKILL);
				sb23c.setDC(10);
				sb23c.setResults("CRYPTHEALFAIL", "CRYPTHEALSUCC");
				
				DefaultRule r23c = new DefaultRule();
				r23c.setEvent(PlayerEntersScene.class);
				r23c.addCondition(new PartyValueIs("cryptheal", true));
				r23c.addResponse(new SetVisibleResponse(sb23c,false));
				c23.addRule(r23c);
				
				DefaultRule r23d= new DefaultRule();
				r23d.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p23d = new SetPartyValueResponse("save5",true);
				r23d.addResponse(p23d);
				c23.addRule(r23d);
				
				c23.addGUI(t23);
				c23.addOption(sb23a);
				c23.addOption(sb23b);
				c23.addOption(sb23c);
				c23.addOption("Entrar en la cripta.", "UPPER1");
				this.addScene(c23);
				
//escena 24a
				
				Narration n24a=new Narration();
				n24a.createContents();
				n24a.setTag("CRYPTPERCFAIL");
				n24a.setNext("CRYPT1");
				n24a.setBackground("crypt");
				
				Text t24a = n24a.createText("Buscas pero no consigues ver nada que te llame la atencion.");
				t24a.setSize(Constants.CONTENT,Constants.CONTENT);
				t24a.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24a= new DefaultRule();
				r24a.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24a = new SetPartyValueResponse("cryptperception",true);
				r24a.addResponse(p24a);
				n24a.addRule(r24a);
				
				n24a.addGUI(t24a);
				this.addScene(n24a);
				
//escena 24b
				
				Narration n24b=new Narration();
				n24b.createContents();
				n24b.setTag("CRYPTPERCSUCC");
				n24b.setNext("CRYPT1");
				n24b.setBackground("crypt");
				
				Text t24b = n24b.createText("Ves los restos de un cuerpo humano bajo un caballo. Despues de un buen rato consigues " +
						"sacarlo y veis que apenas son unos huesos polvorientos. Parecen de un cadaver que lleve muerto muchisimos a�os.");
				t24b.setSize(Constants.CONTENT,Constants.CONTENT);
				t24b.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24b= new DefaultRule();
				r24b.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24b = new SetPartyValueResponse("cryptperception",true);
				r24b.addResponse(p24b);
				n24b.addRule(r24b);
				
				n24b.addGUI(t24b);
				this.addScene(n24b);
				
//escena 24c
				
				Narration n24c=new Narration();
				n24c.createContents();
				n24c.setTag("PERC2FAIL");
				n24c.setNext("CRYPT1");
				n24c.setBackground("crypt");
				
				Text t24c = n24c.createText("Buscas pero no consigues ver nada que te llame la atencion.");
				t24c.setSize(Constants.CONTENT,Constants.CONTENT);
				t24c.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24c= new DefaultRule();
				r24c.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24c = new SetPartyValueResponse("cryptperception2",true);
				r24c.addResponse(p24c);
				n24c.addRule(r24c);
				
				n24c.addGUI(t24c);
				this.addScene(n24c);
				
//escena 24d
				
				Narration n24d=new Narration();
				n24d.createContents();
				n24d.setTag("CRYPTPERC2SUCC");
				n24d.setNext("CRYPT1");
				n24d.setBackground("crypt");
				
				Text t24d = n24d.createText("Encuentras una de las alfoljas enterrada cerca. Dentro hay raciones " +
						"para dos dias, un par de cojines bastante comodos, un carcaj con 10 flechas y un poco de aceite de lampara.");
				t24d.setSize(Constants.CONTENT,Constants.CONTENT);
				t24d.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24d = new DefaultRule();
				r24d.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24d = new SetPartyValueResponse("cryptperception2",true);
				r24d.addResponse(p24d);
				n24d.addRule(r24d);
				
				n24d.addGUI(t24d);
				this.addScene(n24d);
				
//escena 24e
				
				Narration n24e=new Narration();
				n24e.createContents();
				n24e.setTag("CRYPTHEALFAIL");
				n24e.setNext("CRYPT1");
				n24e.setBackground("crypt");
				
				Text t24e = n24e.createText("Miras los cadaveres pero no consigues ver nada que te llame la atencion.");
				t24e.setSize(Constants.FILL,Constants.CONTENT);
				t24e.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24e= new DefaultRule();
				r24e.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24e = new SetPartyValueResponse("cryptheal",true);
				r24e.addResponse(p24e);
				n24e.addRule(r24e);
				
				n24e.addGUI(t24e);
				this.addScene(n24e);
				
//escena 24f
				
				Narration n24f=new Narration();
				n24f.createContents();
				n24f.setTag("CRYPTHEALSUCC");
				n24f.setNext("CRYPT1");
				n24f.setBackground("crypt");
				
				Text t24f = n24f.createText("Dirias que los animales llevan muertos dos dias, y las marcas parecen de garras o quizas armas de corte sin afilar.");
				t24f.setSize(Constants.CONTENT,Constants.CONTENT);
				t24f.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r24f = new DefaultRule();
				r24f.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p24f = new SetPartyValueResponse("cryptheal",true);
				r24f.addResponse(p24f);
				n24f.addRule(r24f);
				
				n24f.addGUI(t24f);
				this.addScene(n24f);
				
//escena 25
				
				Choice n25=new Choice();
				n25.createContents();
				n25.setTag("UPPER1");
				n25.setNext("UPPER2");
				n25.setBackground("crypt");
				
				Text t25 = n25.createText("Entras en la cripta. Una atmosfera opresiva te envuelve, mientras te adentras en la oscuridad. Necesitas luz para avanzar " +
						"por la cripta. El techo se encuentra 15 pies sobre vuestras cabezas. Todas las superficies que ves son de piedra. Las paredes estan decoradas " +
						"con patrones de aldeanos luchando contra bandidos enmascarados y monstruos. El arte aun esta en relativo buen estado, aunque el agua y los " +
						"mohos han deteriorados los grabados. El hedor de cieno y putridez cuelga pesadamente en el aire. Una pesada puerta doble cierra la crypta. " +
						"Despues de un rato de luchar contra ella conseguis abrirlas, y entrais en la cripta. Dentro veis varios esqueletos que se disponen a atacaros.");
				t25.setSize(Constants.FILL,Constants.CONTENT);
				t25.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r25= new DefaultRule();
				r25.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p25 = new SetPartyValueResponse("save6",true);
				r25.addResponse(p25);
				n25.addRule(r25);
				
				n25.addGUI(t25);
				n25.addOption("Tirar iniciativa", "UPPER.Start");
				this.addScene(n25);
				
//mapa combate 4
				
				DefaultTileMapScene mc4=new DefaultTileMapScene();
				mc4.createContents();
				mc4.createMap(32,24);
				mc4.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc4.loadTiled("upper", 0, 0);
				mc4.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
			
				mc4.setTag("UPPER");
				
				/*AllMonstersDeadRule r4=new AllMonstersDeadRule();
				r4.addResponse(new VictoryResponse(0,"VICTORY"));
				mc4.addRule(r);
				*/
				
				AllPlayersDeadRule r5=new AllPlayersDeadRule();
				r5.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc4.addRule(r5);
				
				DefaultRule r6= new DefaultRule();
				r6.setEvent(InfoInteractsWith.class);
				TravelAllToSceneResponse p6 = new TravelAllToSceneResponse("ROLDARE1");
				r6.addCondition(new TargetInfoIsTag("roldare"));
				r6.addResponse(p6);
				mc4.addRule(r6);
				
				this.addScene(mc4);
				
		//escena 26
			
				Choice n26=new Choice();
				n26.createContents();
				n26.setTag("ROLDARE1");
				n26.setBackground("crypt");
				
				Text t26 = n26.createText("...Texto de la escena de roldare...");
				t26.setSize(Constants.FILL,Constants.CONTENT);
				t26.setPos(Constants.BEGIN, Constants.BEGIN);
				
				DefaultRule r26= new DefaultRule();
				r26.setEvent(PlayerEntersScene.class);
				SetPartyValueResponse p26 = new SetPartyValueResponse("save7",true);
				r26.addResponse(p26);
				n26.addRule(r26);
				
				n26.addGUI(t26);
				n26.addOption("Intentar calmarlo", "ROLDARE2");
				this.addScene(n26);
				
//mapa combate 5
				
				DefaultTileMapScene mc5=new DefaultTileMapScene();
				mc5.createContents();
				mc5.createMap(30,24);
				mc5.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc5.loadTiled("lower", 0, 0);
				mc5.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
			
				mc5.setTag("LOWER");
				
				/*AllMonstersDeadRule r4=new AllMonstersDeadRule();
				r4.addResponse(new VictoryResponse(0,"VICTORY"));
				mc4.addRule(r);
				*/
				
				AllPlayersDeadRule r7=new AllPlayersDeadRule();
				r7.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc5.addRule(r7);
				
				this.addScene(mc5);
				
	//escena derrota
		
		Narration ndefeat=new Narration();
		ndefeat.createContents();
		ndefeat.setTag("DEFEAT");
		ndefeat.setText("Todos los aventureros han muerto!");
		ndefeat.setNext(null);
		this.addScene(ndefeat);
		
		
		
		
		  
		//Elementos necesarios. Esto tiene que ir fuera de aqui! si no solo se inicializa en el host!
				ActionLibrary.getActionLibrary().register(ClimbAction.class);
				Module m=StabUtils.getModuleLibrary().getModule(PfModule.ID);
				m.setMapping(ClimbWaypoint.class);
				
	//Escena de las cuerdas
				DefaultStabMapScene ropes=new DefaultStabMapScene();
				ropes.createContents();
				ropes.createMap(16,14);
				ropes.setDefaultLightLevel(64);
				ropes.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				ropes.loadTiled("cliff", 0, 0);
				ropes.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		
				ropes.setTag("ROPECLIFFS");
				
				//Regla para hacer visibles las cuerdas si la usaron
				DefaultRule rv= new DefaultRule();
				rv.setEvent(PlayerEntersScene.class);
				rv.addCondition(new PartyValueIs("USARCUERDAS",true));  //Esto esta por revisar!
				rv.addResponse(new SetVisibleResponse("ROPES", true));
				ropes.addRule(rv);
				
				//Regla de todos los players llegan a la salida
				AllPlayersAtZoneRule rz= new AllPlayersAtZoneRule("EXIT");
				rz.addResponse(new VictoryResponse(0,"CRYPT1"));
				ropes.addRule(rz);
				
				//regla estandar de todos muertos -> defeat... pensarse el meterla en la escena estandar
				r2=new AllPlayersDeadRule();
				r2.addResponse(new DefeatResponse(0,"DEFEAT"));
				ropes.addRule(r2);
				this.addScene(ropes);
		
				
				//Estoy en proceso de poner metodos para facilitar agregar esas reglas automaticamente en DefaultStabMapScene
				
	}
}

