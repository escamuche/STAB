package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.Constants;
import com.stab.common.events.DefaultRule;
import com.stab.common.utils.Roll;
import com.stab.data.StabConstants;
import com.stab.data.rules.CharacterSkillRollCondition;
import com.stab.data.ui.RolledSkillOptionButton;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.PlayerEntersScene;
import com.stab.model.basic.scenes.event.condition.PartyValueIs;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.SetPartyValueResponse;
import com.stab.model.basic.scenes.event.response.SetVisibleResponse;
import com.stab.model.basic.scenes.event.response.TravelToSceneResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllMonstersDeadRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
import com.stab.model.basic.ui.Button;
import com.stab.model.basic.ui.Image;
import com.stab.model.basic.ui.Text;
import com.tien.princess.engine.Resources;

public class CryptEverflameAdventure extends Adventure{
		
	public CryptEverflameAdventure() {
		
		
		//INDICAMOS EL DIRECTORIO ADICIONAL DE RECURSOS
		
		Resources.INSTANCE.addDir("everflame");
		
		
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
		
	//escena 1
		
		Narration n1=new Narration();
		n1.createContents();
		n1.setTag("BEGIN");
		n1.setNext("INTRO");
		n1.setBackground("COLOR#orange");
		
		Text t1 = n1.createText("Hace casi 200 años, cuando la tierra que llegaria a ser Nirmathas " +
				"todavia era un vasallo del imperio de Cheliax, el norte del bosque de " +
				"los colmillos era un lugar salvaje y peligroso. Los cruzados que derrotaron " +
				"al surrurrante tirano son ahora una distante memoria, y a aquellos que quedaron " +
				"se les asigno mantener controlados a los orcos de Belkzen y a los undeads que " +
				"quedaban de Ustalav. Como resultado, el gran bosque estaba lleno de peligros, de " +
				"orcos merodeando a mortales depredadores, haciendolo inseguro para los comerciantes " +
				"que buscaban comerciar con la creciente comunidad de Skelt en las laderas de las " +
				"montañas Mindspin en el oeste.");
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
				"a servir a Lastwall en el año 4515 AR. Aunque lucho con distincion, " +
				"pronto se dio cuenta de que buscaba mas de la vida y dejo la milicia " +
				"de Lastwall para encontrar su fortuna en otro sitio. " +
				"Sus viajes le llevaron hasta el lago Encarthan, donde decidio asentarse " +
				"despues de una aventura especialmente provechosa. Usando una parte de su " +
				"fortuna, acondiciono una parte del bosque de los colmillos a la orilla " +
				"del rio Tourondel, haciendolo una parada natural para los viajeros que " +
				"circulen por el rio a Skelt. Durante los proximos 10 años la ciudad ahora conocida " +
				"como Kassen Hold crecio y propero. " +
				"Todo esto cambio cuando Asar Vergas llego a Kassen Hold con un grupo de mercenarios " +
				"bajo sus ordenes. Asar era un viejo compañero de Ekat y ambos viajaron juntos un " +
				"tiempo antes de separarse justo antes de la ultima aventura de Ekat. Al paso de " +
				"los años, Asar se convencio de que Ekat le engaño tras la aventura. Prometiendo " +
				"grandes fortunas a sus mercenarios, Asar asalto la ciudad durante dos meses. Finalmente " +
				"los lugareños encontraron el campamento de los mercenarios en una antigua cripta en lo " +
				"profundo del bosque, y el mismo Ekat fue a lidiar con su antiguo compañero.");
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
				"Con los años la cripta de la llama eterna ha llegado a ser una parte importante de la " +
				"historia de la ciudad, ahora conocida simplemente como Kassen. Los ciudadanos ven el " +
				"lugar como un memorial de los primeros y duros años. Cada otoño a un puñado de lugareños " +
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
				"por tus compañeros que van apareciendo poco a poco. De pronto la campana de la " +
				"iglesia empieza a tañir...");
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
				"con un farol de bruñida plata en sus manos. Tras el hay un viejo poni cargado con " +
				"mochilas y provisiones. Cuando alcanza el centro de la muchedumbre el alcalde " +
				"se para y le habla a la multitud reunida. 'Otra vez el viento del invierno sopla " +
				"a traves del bosque del colmillo, marcando el final de otro otoño. Hay lobos " +
				"en el bosque, aullando ante nuestros muros, serpientes en las sombras, esperando " +
				"golpearnos. Igual que hace 174 años, cuando el mismo Kassen dejo estos muros para " +
				"protegernos a todos, asi sera ahora tambien. ¿Donde estan los heroes? ¿Donde estan " +
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
		
	//escena 6 choice 1
		
		Choice c6=new Choice();
		c6.createContents();
		c6.setBackground("village");
		c6.setTag("TOWN2");
		
		Text t6 = c6.createText("El alcalde hace una pausa para que podais aceptar la mision. Uno a uno " +
				"tus compañeros y tu os acercais,  Uptal os entrega la mula y la lampara. " +
				"Antes de partir compruebas el contenido de la mochila, raciones para 5 dias, " +
				"una tienda de campaña, un saco de dormir de invierno, un odre de agua y un " +
				"trozo de un mapa. Compruebas que cada uno de tus compañeros tiene otro trozo " +
				"y despues de un rato conseguir juntarlos todos en un mapa mas grande que os " +
				"indica vuestro camino. Al terminar vuestros preparativos el alcalde vuelve a " +
				"hablar, '¡Os presento a los bravos heroes que seguiran los pasos de Kassen para " +
				"traernos la llama eterna! Algunos de ellos podrian no regresar, pero yo os digo " +
				"que su sacrificio no sera olvidado. Ir, bravos heroes, y no regreseis sin el fuego " +
				"eterno.' Tras esto el alcalde señala hacia el sur, en direccion a la tumba de Kassen. " +
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
		
		//escena 6a choice 1a
		
				Choice c6a=new Choice();
				c6a.createContents();
				c6a.setBackground("forest");
				c6a.setTag("START");
				
				Text t6a = c6a.createText("Empezais vuestra marcha con ilusion en vuestros corazones. Cuando llevais un par de horas andando por el camino " +
						"a traves del bosque ois un extraño ruido, como un jabali. Aprestais vuestras armas preparados para espantar al animal, pero lo que sale " +
						"cargando de entre los arbustos no es lo que esperais, sino tres criaturas humanoides con piel de color verdosa y grandes " +
						"colmillos. Jurarias que deben ser esas criaturas que has oido alguna vez que se llaman orcos. Sabes de ellos que son fuertes, resistentes " +
						"y malignos hasta la medula.");
				t6a.setPos(Constants.NEXT, Constants.BEGIN);
				t6a.setSize(Constants.FILL, Constants.CONTENT);
				
				c6a.addGUI(t6a);
				c6a.addOption("Tira Iniciativa!","ORCS.start");
				this.addScene(c6a);
				
	//mapa combate 1
		
		DefaultTileMapScene mc1=new DefaultTileMapScene();
		mc1.createContents();
		mc1.createMap(15,15);
		mc1.loadTiled("orcs", 0, 0);
		mc1.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		mc1.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		mc1.setTag("ORCS");
		
		AllMonstersDeadRule r=new AllMonstersDeadRule();
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		mc1.addRule(r);
		AllPlayersDeadRule r2=new AllPlayersDeadRule();
		r2.addResponse(new DefeatResponse(0,"DEFEAT"));
		mc1.addRule(r2);
		this.addScene(mc1);
		
	//escena 7 choice 2
		
		Choice c7=new Choice();
		c7.createContents();
		c7.setTag("VICTORY");
		c7.setBackground("forest");
		
		Text t7 = c7.createText("La dura batalla contra los extraños orcos acaba, dejando una sensacion extraña, por la forma de desaparecer parece " +
				"claro que estas criaturas no eran mas que ilusiones, pero quien y porque haria algo asi.");
		
		RolledSkillOptionButton sb7 = new RolledSkillOptionButton();
		sb7.setText("Investigar la zona.");
		sb7.setSkill(StabConstants.PERCEPTION);
		sb7.setDC(15);
		sb7.setResults("PERCFAIL", "PERCSUCCESS");
		
		c7.addGUI(t7);
		c7.addOption(sb7);
		c7.addOption("Continuar el viaje.", "WOLVES");
		this.addScene(c7);
	
	//escena 8
		
		Narration n8=new Narration();
		n8.createContents();
		n8.setTag("PERCFAIL");
		n8.setNext("WOLVES");
		n8.setBackground("forest");
		
		Text t8 = n8.createText("Buscas por la zona, pero no consigues encontrar nada que te llame la atención. Al cabo de un rato decides continuar con tu camino. ");
		t8.setSize(Constants.CONTENT,Constants.CONTENT);
		
		n8.addGUI(t8);
		this.addScene(n8);
		
	//escena 9
		
		Narration n9=new Narration();
		n9.createContents();
		n9.setTag("PERCSUCCESS");
		n9.setNext("WOLVES");
		n9.setBackground("forest");
		
		Text t9 = n9.createText("Un olor a tabaco de pipa llama poderosamente tu atención. Despues de un rato pensando lo asocias al tabaco que fuma Holgast, el mago de la aldea. " +
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
		
		Text t10 = c10.createText("Despues de derrotar a los extraños orcos ilusorios, seguis avanzando. Gracias al mapa que llevais es relativamente sencillo encontrar el camino correcto. " +
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
		sb10.setResults("SURVIVALFAIL", "SURVIVALSUC");
																					//Si las escenas empiezan por #, eso mueve a todos los jugadores en la escena a la escena indicada
																					//Esto es aplicable a los casos normales tambien.
																				    //Ojo que puede que alguien no este en la escena. eso lo vemos mas adelante con scene.setWaitsForAll()
		//Notese  que esto no le pone icono, pero le cambia el tamaño a que ocupe toda la linea
		//Y esta pendiente de probar, claro :D
		//RolledOptionButton funciona casi igual
		
		c10.addGUI(t10);
		c10.addOption(sb10); 
		c10.addOption("Acampar en el primer sitio que veas", "SURVIVALFAIL");
		this.addScene(c10);
		
	//escena 10a
		
				Narration n10a=new Narration();
				n10a.createContents();
				n10a.setTag("SURVIVALSUC");
				n10a.setNext("WOLVES2");
				n10a.setBackground("forest");
				
				Text t10a = n10a.createText("Despues de un buen rato buscando encuentras una pequeña elevacion protegida por matorrales tupidos en dos de sus lados. " +
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
				n10b.setTag("SURVIVALFAIL");
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
		
		Text t11 = c11.createText("Despues encendeis una pequeña hoguera y empezais a cocinar un estofado con las raciones que hay en " +
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
		c11.addGUI(bpasar);
		c11.addGUI(tt);
		c11.addGUI(batt);
		c11.addGUI(bwild);
		c11.addGUI(bhuir);
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
		
				Narration n14=new Narration();
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
				n14.addGUI(bini);
				this.addScene(n14);
				
				//escena 15
				
				Narration n15=new Narration();
				n15.createContents();
				n15.setTag("INISUCC");
				n15.setBackground("forest");
				
				Text t15 = n15.createText("Llegas hasta el lobo, dandole un fuerte golpe, aunque no lo suficiente para acabar con el. Enseñandote sus terribles " +
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
				n15.addGUI(bini2);
				this.addScene(n15);
				
		//escena 1
				
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
				
				Choice c18=new Choice();
				c18.createContents();
				c18.setTag("WOLVES4");
				c18.setNext("BANDIT");
				c18.setBackground("forest");
				
				Text t18 = c18.createText("Al cabo de una hora oyes ruidos que se acercan al campamento y ves unos ojos en la oscuridad, brillando " +
						"con una luz intensa. Ves surgir de entre la maleza tres lobos que gruñen y se abalanzan sobre vosotros.");
				t18.setSize(Constants.CONTENT,Constants.CONTENT);
				t18.setPos(Constants.BEGIN, Constants.NEXT);
				
				Image i18 = new Image();
				i18.setImage("wolf$A");
				i18.setPos(Constants.BEGIN, Constants.BEGIN);
				i18.setSize(Constants.PERCENT+50, Constants.PERCENT+50);
				
				DefaultRule r18 = new DefaultRule();
				r18.setEvent(PlayerEntersScene.class);
				r18.addCondition(new PartyValueIs("acampar", false));
				r18.addResponse(new TravelToSceneResponse("CAMP1.start"));
				r18.addOnFail(new TravelToSceneResponse("CAMP2.start"));
				c18.addRule(r18);
				
				
				c18.addGUI(i18);
				c18.addGUI(t18);
				this.addScene(c18);
				
				//mapa combate 2
				
				DefaultTileMapScene mc2=new DefaultTileMapScene();
				mc2.createContents();
				mc2.createMap(15,15);
				mc2.loadTiled("camp1", 0, 0);
				mc2.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
				mc2.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc2.setTag("CAMP1");
				
				AllMonstersDeadRule rm2=new AllMonstersDeadRule();
				rm2.addResponse(new VictoryResponse(0,"VICTORY"));
				mc2.addRule(rm2);
				AllPlayersDeadRule rm3=new AllPlayersDeadRule();
				rm3.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc2.addRule(rm3);
				this.addScene(mc2);
				
				//mapa combate 3
				
				DefaultTileMapScene mc3=new DefaultTileMapScene();
				mc3.createContents();
				mc3.createMap(15,15);
				mc3.loadTiled("camp2", 0, 0);
				mc3.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
				mc3.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
				mc3.setTag("CAMP2");
				
				AllMonstersDeadRule rm4=new AllMonstersDeadRule();
				rm4.addResponse(new VictoryResponse(0,"VICTORY"));
				mc3.addRule(rm4);
				AllPlayersDeadRule rm5=new AllPlayersDeadRule();
				rm5.addResponse(new DefeatResponse(0,"DEFEAT"));
				mc3.addRule(rm4);
				this.addScene(mc3);
				
		//escena 19
				
				Choice c19=new Choice();
				c19.createContents();
				c19.setBackground("forest");
				c19.setTag("BANDIT");
				
				Text t19 = c19.createText("Al dia siguiente continuais vuestro camino a traves del bosque del Colmillo. " +
						"Temprano por la mañana llegais a la orilla del lago Gris, donde pensais rellenar vuestros pellejos de agua y" +
						"tomar un breve descanso. Segun os acercais veis que los arboles empiezan a escasear, revelando un campo de corta " +
						"hierba verde que lleva a la orilla de un ancho y tranquilo lago, que refleja el cielo sobre el. Una dense niebla " +
						"cuelga sobre el centro del lago, oscureciendo la orilla opuesta. Cerca de la orilla, una forma oscura esta tendida " +
						"cerca del agua. Os acercais y veis un hombre muerto en bastante mal estado");
				t19.setSize(Constants.CONTENT,Constants.CONTENT);
				t19.setPos(Constants.BEGIN, Constants.NEXT);
			
				RolledSkillOptionButton sb19a = new RolledSkillOptionButton();
				sb19a.setText("Investigar alrededor del cadaver");
				sb19a.setSkill(StabConstants.PERCEPTION);
				sb19a.setDC(10);
				sb19a.setResults("PERCFAIL", "PERCSUC");
				
				RolledSkillOptionButton sb19b = new RolledSkillOptionButton();
				sb19b.setText("Investigar el cadaver");
				sb19b.setSkill(StabConstants.KNOWLEDGELOCAL);
				sb19b.setDC(10);
				sb19b.setResults("LOCALFAIL", "LOCALSUC");
				
				RolledSkillOptionButton sb19c = new RolledSkillOptionButton();
				sb19c.setText("Investigar sus heridas");
				sb19c.setSkill(StabConstants.HEALSKILL);
				sb19c.setDC(15);
				sb19c.setResults("HEALFAIL", "HEALSUC");
				
				RolledSkillOptionButton sb19d = new RolledSkillOptionButton();
				sb19d.setText("Buscar por la zona");
				sb19d.setSkill(StabConstants.SURVIVAL);
				sb19d.setDC(15);
				sb19d.setResults("SURVFAIL", "SURVSUC");
				
				c19.addGUI(t19);
				c19.addOption(sb19a);
				c19.addOption(sb19b);
				c19.addOption(sb19c);
				c19.addOption(sb19d);
				c19.addOption("Seguir tu camino", "HILLSIDE");
				this.addScene(c19);
				
	//escena derrota
		
		Narration ndefeat=new Narration();
		ndefeat.createContents();
		ndefeat.setTag("DEFEAT");
		ndefeat.setText("Todos los aventureros han muerto!");
		ndefeat.setNext(null);
		this.addScene(ndefeat);
	}
}

