package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.Constants;
import com.stab.common.events.DefaultRule;
import com.stab.data.StabConstants;
import com.stab.data.rules.CharacterSkillRollCondition;
import com.stab.data.ui.RolledSkillOptionButton;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.PlayerEntersScene;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.SetVisibleResponse;
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
		
		//Text t1=new Text();
		n1.setText("Hace casi 200 años, cuando la tierra que llegaria a ser Nirmathas " +
				"todavia era un vasallo del imperio de Cheliax, el norte del bosque de " +
				"los colmillos era un lugar salvaje y peligroso. Los cruzados que derrotaron " +
				"al surrurrante tirano son ahora una distante memoria, y a aquellos que quedaron " +
				"se les asigno mantener controlados a los orcos de Belkzen y a los undeads que " +
				"quedaban de Ustalav. Como resultado, el gran bosque estaba lleno de peligros, de " +
				"orcos merodeando a mortales depredadores, haciendolo inseguro para los comerciantes " +
				"que buscaban comerciar con la creciente comunidad de Skelt en las laderas de las " +
				"montañas Mindspin en el oeste.");
		//t1.setPos(Constants.BEGIN, Constants.BEGIN);
		//t1.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i1 = new Image();
		i1.setImage("nirmathas$S");
		i1.setPos(Constants.BEGIN, Constants.NEXT);
		i1.setSize(Constants.FILL, Constants.FILL);
		
		//n1.addGUI(t1);
		n1.addGUI(i1);
		this.addScene(n1);
		
	//escena 2
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("INTRO");
		n2.setNext("INTRO2");
		n2.setBackground("COLOR#orange");
		
		//Text t2=new Text();
		n2.setText("Ekat Kassen era un cruzado y buscador de fortuna que llego " +
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
		//t2.setSize(Constants.CONTENT,Constants.CONTENT);
		//t2.setPos(Constants.BEGIN, Constants.BEGIN);
		
		Image i2 = new Image();
		i2.setImage("nirmathasmap$S");
		i2.setPos(Constants.BEGIN, Constants.NEXT);
		i2.setSize(Constants.FILL, Constants.FILL);
		
		//n2.addGUI(t2);
		n2.addGUI(i2);
		this.addScene(n2);
		
	//escena 3
		
		Narration n3=new Narration();
		n3.createContents();
		n3.setTag("INTRO2");
		n3.setNext("INTRO3");
		n3.setBackground("COLOR#orange");
		
		//Text t3 = new Text();
		n3.setText("La batalla fue terriblemente sangrienta, solo unos pocos de la gente de la ciudad volvio " +
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
		//t3.setSize(Constants.CONTENT,Constants.CONTENT);
		//t3.setPos(Constants.BEGIN, Constants.BEGIN);
		
		Image i3 = new Image();
		i3.setImage("kassen$S");
		i3.setPos(Constants.BEGIN, Constants.NEXT);
		i3.setSize(Constants.FILL, Constants.FILL);
		
		//n3.addGUI(t3);
		n3.addGUI(i3);
		this.addScene(n3);
		
	//escena 4
		
		Narration n4=new Narration();
		n4.createContents();
		n4.setTag("INTRO3");
		n4.setNext("TOWN");
		n4.setBackground("COLOR#orange");
		
		//Text t4 = new Text();
		n4.setText("Estamos a 4 de Neth, los primeros vientos del invierno empiezan a soplar. " +
				"Este fue el dia, en 5435, en el que Ekat Kassen y sus hombres marcharon al " +
				"encuentro de Asar y sus mercenarios. Y hoy sera el dia en el que junto con tus " +
				"amigos marcharas a hacerte adulto. Debes ir a la plaza del pueblo al mediodia " +
				"tal y como marca la tradicion, para aceptar la busqueda. Debes viajar ligero, " +
				"llevando solo lo necesario. Cuando llegas a la plaza, esta desierta, excepto " +
				"por tus compañeros que van apareciendo poco a poco. De pronto la campana de la " +
				"iglesia empieza a tañir...");
		//t4.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i4=new Image();
		i4.setImage("town$S");
		i4.setPos(Constants.BEGIN, Constants.NEXT);
		i4.setSize(Constants.FILL, Constants.FILL);
		
		//n4.addGUI(t4);
		n4.addGUI(i4);
		this.addScene(n4);

	//escena 5
		
		Narration n5=new Narration();
		n5.createContents();
		n5.setBackground("COLOR#orange");
		n5.setTag("TOWN");
		n5.setNext("TOWN2");
		
		//Text t5 = new Text();
		n5.setText("La campana sobre el cercano templo de Erastil empieza a tocar su cancion " +
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
		//t5.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i5 = new Image();
		i5.setImage("uptal$S");
		i5.setPos(Constants.BEGIN, Constants.NEXT);
		i5.setSize(Constants.FILL, Constants.FILL);
		
		//n5.addGUI(t5);
		n5.addGUI(i5);
		this.addScene(n5);
		
	//escena 6 choice 1
		
		Choice c6=new Choice();
		c6.createContents();
		c6.setBackground("COLOR#orange");
		c6.setTag("TOWN2");
		
		//Text t6 = new Text();
		c6.setText("El alcalde hace una pausa para que podais aceptar la mision. Uno a uno " +
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
		//t6.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i6 = new Image();
		i6.setImage("zone$S");
		i6.setPos(Constants.BEGIN, Constants.NEXT);
		i6.setSize(Constants.FILL, Constants.FILL);
		
		//c6.addGUI(t6);
		c6.addOption("Empezar la aventura!","SMOKE");
		c6.addGUI(i6);
		this.addScene(c6);
		
	//mapa combate 1
		
		DefaultTileMapScene mc1=new DefaultTileMapScene();
		mc1.createContents();
		mc1.createMap(15,15);
		mc1.loadTiled("everflame2", 0, 0);
		mc1.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		mc1.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		mc1.setTag("EVERFLAME2");
		
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
		c7.setTag("SMOKE");
		c7.setBackground("COLOR#yellow");
		
		//Text t7 = new Text();
		c7.setText("La dura batalla contra los extraños orcos acaba, dejando una sensacion extraña, por la forma de desaparecer parece " +
				"claro que estas criaturas no eran mas que ilusiones, pero quien y porque haria algo asi.");
		//t7.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i7 = new Image();
		i7.setImage("forest$S");
		i7.setPos(Constants.BEGIN, Constants.NEXT);
		i7.setSize(Constants.FILL, Constants.FILL);
		
		RolledSkillOptionButton sb7 = new RolledSkillOptionButton();
		sb7.setText("Investigar la zona.");
		sb7.setSkill(StabConstants.PERCEPTION);
		sb7.setDC(15);
		sb7.setResults("PERCFAIL", "PERCSUCCESS");
		
		//c7.addGUI(t7);
		c7.addOption(sb7);
		c7.addOption("Continuar el viaje.", "WOLVES");
		c7.addGUI(i7);
		this.addScene(c7);
	
	//escena 8
		
		Narration n8=new Narration();
		n8.createContents();
		n8.setTag("PERCFAIL");
		n8.setNext("WOLVES");
		n8.setBackground("COLOR#white");
		
		//Text t8 = new Text();
		n8.setText("Buscas por la zona, pero no consigues encontrar nada que te llame la atención. Al cabo de un rato decides continuar con tu camino. ");
		//t8.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i8 = new Image();
		i8.setImage("forest$S");
		i8.setPos(Constants.BEGIN, Constants.NEXT);
		i8.setSize(Constants.FILL, Constants.FILL);
		
		//n8.addGUI(t8);
		n8.addGUI(i8);
		this.addScene(n8);
		
	//escena 9
		
		Narration n9=new Narration();
		n9.createContents();
		n9.setTag("PERCSUCCESS");
		n9.setNext("WOLVES");
		n9.setBackground("COLOR#green");
		
		//Text t9 = new Text();
		n9.setText("Un olor a tabaco de pipa llama poderosamente tu atención. Despues de un rato pensando lo asocias al tabaco que fuma Holgast, el mago de la aldea. " +
				"Mientras vas meditando sobre ello decides continuar tu viaje.");
		//t9.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i9 = new Image();
		i9.setImage("everflame$S");
		i9.setPos(Constants.BEGIN, Constants.NEXT);
		i9.setSize(Constants.FILL, Constants.FILL);
		
		//n9.addGUI(t9);
		n9.addGUI(i9);
		this.addScene(n9);
		
	//escena 10 choice 3
		
		Choice c10=new Choice();
		c10.createContents();
		c10.setBackground("COLOR#white");
		c10.setTag("WOLVES");
		
		//Text t10 = new Text();
		c10.setText("Despues de derrotar a los extraños orcos ilusorios, seguis avanzando. Gracias al mapa que llevais es relativamente sencillo encontrar el camino correcto. " +
				"Despues de todo el dia andando queda poco para que oscurezca. Empezais a buscar un sitio para montar las tiendas mientras las sombras de " +
				"los arboles se alargan mas y mas, cubriendolo todo y dando un aspecto ominoso al bosque antes placido. Con una sensacion de desasosiego " +
				"empezais a montar el campamento. ");
		//t10.setSize(Constants.CONTENT,Constants.CONTENT);
	
		Image i10 = new Image();
		i10.setImage("forest$S");
		i10.setPos(Constants.BEGIN, Constants.NEXT);
		i10.setSize(Constants.FILL, Constants.FILL);
		
		//Ejemplo de rolledSkill
		RolledSkillOptionButton sb10= new RolledSkillOptionButton();
		sb10.setText("Tirar survival para buscar un buen sitio de acampar");
		sb10.setSkill(StabConstants.SURVIVAL);
		sb10.setDC(10);
		sb10.setResults("WOLVESSUC", "WOLVESFAIL");
																					//Si las escenas empiezan por #, eso mueve a todos los jugadores en la escena a la escena indicada
																					//Esto es aplicable a los casos normales tambien.
																				    //Ojo que puede que alguien no este en la escena. eso lo vemos mas adelante con scene.setWaitsForAll()
		//Notese  que esto no le pone icono, pero le cambia el tamaño a que ocupe toda la linea
		//Y esta pendiente de probar, claro :D
		//RolledOptionButton funciona casi igual
		
		//c10.addGUI(t10);
		c10.addOption(sb10); 
		c10.addOption("Acampar en el primer sitio que veas", "WOLVESFAIL");
		c10.addGUI(i10);
		this.addScene(c10);
		
	//escena 11 choice 4
		
		Choice c11=new Choice();
		c11.createContents();
		c11.setBackground("COLOR#white");
		c11.setTag("WOLVES2");
		
		//Text t11 = new Text();
		c11.setText("Despues encendeis una pequeña hoguera y empezais a cocinar un estofado con las raciones que hay en " +
	"vuestras mochilas. Mientras cocinais ois a lo lejos unos aullidos. Al cabo de una hora volveis a oir los aullidos pero ahora mucho mas cerca. " +
	"Pasa otra media hora...");
		//t11.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i11 = new Image();
		i11.setImage("forest$S");
		i11.setPos(Constants.BEGIN, Constants.NEXT);
		i11.setSize(Constants.FILL, Constants.FILL);
		
		Text tt=c11.createText("...Veis un gran lobo observandoos escondido entre los matorrales. Claramente intenta huir despues de veros, seguramente con la " +
				"intencion de traer al resto de su manada para atacaros. Debeis actuar rapidamente. ");
		tt.setVisible(false);
		
		Button sb = new Button();
		sb.setText("Atacar al lobo");
		sb.setVisible(false);
		sb.setAction("WOLVES3");
		
		Button fb = new Button();
		fb.setText("Pasar la noche");
		sb.setAction("WOLVES4");
		
		
		DefaultRule rr= new DefaultRule();
		rr.setEvent(PlayerEntersScene.class);
		rr.addCondition(new CharacterSkillRollCondition(StabConstants.PERCEPTION, 15));
		rr.addResponse(new SetVisibleResponse(tt, true));
		rr.addResponse(new SetVisibleResponse(sb, true));
		rr.addResponse(new SetVisibleResponse(fb, false));
		c11.addRule(rr);
		
		//c11.addGUI(t11);
		c11.addGUI(tt);
		c11.addGUI(fb);
		c11.addGUI(sb);
		c11.addGUI(i11);
		this.addScene(c11);
		
	//escena 12 choice 5
		
		Choice c12 = new Choice();
		c12.createContents();
		c12.setBackground("COLOR#white");
		c12.setTag("WOLVES3");
		
		//Text t12 = new Text();
		c12.setText("...Veis un gran lobo observandoos escondido entre los matorrales. Claramente intenta huir despues de veros, seguramente con la " +
				"intencion de traer al resto de su manada para atacaros. Debeis actuar rapidamente. ");
		//t12.setSize(Constants.CONTENT,Constants.CONTENT);
		
		Image i12 = new Image();
		i12.setImage("wolf$S");
		i12.setPos(Constants.BEGIN, Constants.NEXT);
		i12.setSize(Constants.FILL, Constants.FILL);
		
		//c12.addGUI(t12);
		
		c12.addOption("Atacar al lobo", "EVERFLAME1.start");
		c12.addOption("Tirar wild empathy contra el lobo", "WOLVES4");
		c12.addOption("Dejar que el lobo huya", "EVERFLAME1.start");
		
		this.addScene(c12);
		
	//escena 13
		
		Narration n13=new Narration();
		n13.createContents();
		n13.setTag("WOLVES4");
		n13.setNext("BANDITS");
		
		//Text t13 = new Text();
		n13.setText("El lobo se queda escuchandote ladeando la cabeza. Al cabo de un rato se acerca a ti olisqueando tu mano y con un salto " +
				"desaparece en el bosque. Crees que esta manada no os dara mas problemas, al menos esta noche. El resto de la noche pasa " +
				"con tranquilidad. ");
		//t13.setSize(Constants.FILL, Constants.FILL);
		
		Image i13 = new Image();
		i13.setImage("wolf");
		i12.setPos(Constants.BEGIN, Constants.NEXT);
		i12.setSize(Constants.FILL, Constants.FILL);
		
		//n9.addGUI(t13);
		n13.addGUI(i13);
		this.addScene(n13);
		
	//escena derrota
		
		Narration ndefeat=new Narration();
		ndefeat.createContents();
		ndefeat.setTag("DEFEAT");
		ndefeat.setText("Todos los aventureros han muerto!");
		ndefeat.setNext(null);
		this.addScene(ndefeat);
	}
}

