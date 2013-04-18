package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.events.DefaultRule;
import com.stab.data.info.monster.bestiary.OrcIlu;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.InfoDestroyed;
import com.stab.model.basic.scenes.event.condition.InfoIsClass;
import com.stab.model.basic.scenes.event.response.DefeatResponse;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.event.rule.AllMonstersDeadRule;
import com.stab.model.basic.scenes.event.rule.AllPlayersDeadRule;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;
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
		setIcon("ui/crypteverflame_adventure/everflame$S");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n1=new Narration();
		n1.createContents();
		n1.setTag("BEGIN");
		n1.setNext("INTRO");
		n1.setText("Hace casi 200 años, cuando la tierra que llegaria a ser Nirmathas " +
				"todavia era un vasallo del imperio de Cheliax, el norte del bosque de " +
				"los colmillos era un lugar salvaje y peligroso. Los cruzados que derrotaron " +
				"al surrurrante tirano son ahora una distante memoria, y a aquellos que quedaron " +
				"se les asigno mantener controlados a los orcos de Belkzen y a los undeads que " +
				"quedaban de Ustalav. Como resultado, el gran bosque estaba lleno de peligros, de " +
				"orcos merodeando a mortales depredadores, haciendolo inseguro para los comerciantes " +
				"que buscaban comerciar con la creciente comunidad de Skelt en las laderas de las " +
				"montañas Mindspin en el oeste.");
		this.addScene(n1);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("INTRO");
		n2.setNext("INTRO2");
		n2.setBackground("ui/crypteverflame_adventure/kassen");
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
		
		this.addScene(n2);
		
		Narration n3=new Narration();
		n3.createContents();
		n3.setTag("INTRO2");
		n3.setNext("INTRO3");
		n3.setBackground("ui/crypteverflame_adventure/zone");
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
				"Cuando los aventureros retornan unos pocos dias despues, la ciudad cdelebra una gran fiesta en su honor. " +
				"Esto tambien marca la ultima celebracion antes de que comience el duro invierno. ");
		
		this.addScene(n3);
		
		Narration n4=new Narration();
		n4.createContents();
		n4.setTag("INTRO3");
		n4.setNext("TOWN");
		n4.setBackground("ui/crypteverflame_adventure/zone");
		n4.setText("Estamos a 4 de Neth, los primeros vientos del invierno empiezan a soplar. " +
				"Este fue el dia, en 5435, en el que Ekat Kassen y sus hombres marcharon al " +
				"encuentro de Asar y sus mercenarios. Y hoy sera el dia en el que junto con tus " +
				"amigos marcharas a hacerte adulto. Debes ir a la plaza del pueblo al mediodia " +
				"tal y como marca la tradicion, para aceptar la busqueda. Debes viajar ligero, " +
				"llevando solo lo necesario. Cuando llegas a la plaza, esta desierta, excepto " +
				"por tus compañeros que van apareciendo poco a poco. De pronto la campana de la " +
				"iglesia empieza a tañir...");
		
		this.addScene(n4);

		Narration n5=new Narration();
		n5.createContents();
		n5.setBackground("ui/crypteverflame_adventure/town");
		n5.setTag("TOWN");
		n5.setNext("TOWN2");
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
		this.addScene(n5);
		
		Choice c=new Choice();
		c.createContents();
		c.setBackground("ui/crypteverflame_adventure/town");
		c.setTag("TOWN2");
		c.setText("El alcalde hace una pausa para que podais aceptar la mision. Uno a uno " +
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
		c.addOption("Empezar la aventura!","EVERFLAME1.start");
		this.addScene(c);
		
		DefaultTileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		ms.createMap(15,15);
		ms.loadTiled("everflame1", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.setTag("EVERFLAME1");
		
		AllMonstersDeadRule r=new AllMonstersDeadRule();
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		ms.addRule(r);
		AllPlayersDeadRule r2=new AllPlayersDeadRule();
		r2.addResponse(new DefeatResponse(0,"DEFEAT"));
		ms.addRule(r2);
		this.addScene(ms);
		
		Choice c2=new Choice();
		c2.createContents();
		c2.setTag("VICTORY");
		c2.setNext("WOLVES");
		c2.setText("La dura batalla contra los extraños orcos acaba, dejando una sensacion extraña, por la forma de desaparecer parece" +
				"claro que estas criaturas no eran mas que ilusiones, pero quien y porque haria algo asi.");
		c2.addOption("Investigar la zona.", "EVERFLAME1.start");
		c2.addOption("Ayudar a otro a investigar la zona.", "EVERFLAME1.start");
		c2.addOption("Continuar el viaje.", "WOLVES");
		this.addScene(c2);
		
		Narration ndefeat=new Narration();
		ndefeat.createContents();
		ndefeat.setTag("DEFEAT");
		ndefeat.setText("Todos los aventureros han muerto!");
		ndefeat.setNext(null);
		this.addScene(ndefeat);
		
		Choice c3=new Choice();
		c3.createContents();
		c3.setBackground("ui/crypteverflame_adventure/town");
		c3.setTag("WOLVES");
		c3.setText("Despues de derrotar a los orcos seguis avanzando. Gracias al mapa que llevais es relativamente sencillo encontrar el camino correcto. " +
				"Despues de todo el dia andando queda poco para que oscurezca. Empezais a buscar un sitio para montar las tiendas mientras las sombras de " +
				"los arboles se alargan mas y mas, cubriendolo todo y dando un aspecto ominoso al bosque antes placido. Con una sensacion de desasosiego " +
				"empezais a montar el campamento. ");
		c3.addOption("Tirar survival para buscar un buen sitio de acampar", "EVERFLAME1.start");
		c3.addOption("Ayudar a alguien a buscar un sitio", "EVERFLAME1.start");
		c3.addOption("Acampar en el primer sitio que veas", "EVERFLAME1.start");
		this.addScene(c3);
		
		Choice c4=new Choice();
		c4.createContents();
		c4.setBackground("ui/crypteverflame_adventure/town");
		c4.setTag("WOLVES2");
		c4.setText("Despues encendeis una pequeña hoguera y empezais a cocinar un estofado con las raciones que hay en " +
	"vuestras mochilas. Mientras cocinais ois a lo lejos unos aullidos. Al cabo de una hora volveis a oir los aullidos pero ahora mucho mas cerca. " +
	"Pasa otra media hora...");
		c4.addOption("Tirar percepcion!", "EVERFLAME1.start");
		this.addScene(c4);
		
		Choice c5 = new Choice();
		c5.createContents();
		c5.setBackground("ui/crypteverflame_adventure/town");
		c5.setTag("WOLVES3");
		c5.setText("Veis un gran lobo observandoos escondido entre los matorrales. Claramente intenta huir despues de veros, seguramente con la" +
				"intencion de traer al resto de su manada para atacaros. Debeis actuar rapidamente. ");
		c5.addOption("Atacar al lobo", "EVERFLAME1.start");
		c5.addOption("Tirar wild empathy contra el lobo", "WOLVES4");
		c5.addOption("Dejar que el lobo huya", "EVERFLAME1.start");
		this.addScene(c5);
		
		Narration n6=new Narration();
		n6.createContents();
		n6.setBackground("ui/crypteverflame_adventure/town");
		n6.setTag("WOLVES4");
		n6.setNext("BANDITS");
		n6.setText("El lobo se queda escuchandote ladeando la cabeza. Al cabo de un rato se acerca a ti olisqueando tu mano y con un salto " +
				"desaparece en el bosque. Crees que esta manada no os dara mas problemas, al menos esta noche. El resto de la noche pasa " +
				"con tranquilidad. ");
		this.addScene(n6);
		
	}
}
