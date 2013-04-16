package com.stab.data.adventure;

import com.stab.adventure.Adventure;
import com.stab.common.events.DefaultRule;
import com.stab.data.info.props.Dummy;
import com.stab.data.utils.StabBlockData;
import com.stab.model.basic.scenes.Choice;
import com.stab.model.basic.scenes.Narration;
import com.stab.model.basic.scenes.event.InfoDestroyed;
import com.stab.model.basic.scenes.event.condition.InfoIsClass;
import com.stab.model.basic.scenes.event.response.VictoryResponse;
import com.stab.model.basic.scenes.map.DefaultTileMapScene;

public class CryptEverflame extends Adventure{
	

	public CryptEverflame() {
		setName("Crypt of Everflame");
		setMinLevel(1);
		setMaxLevel(1);
		setMinPlayers(1);
		setMaxPlayers(5);
		setAuthor("Jason Bulmahn");
		setDescription("Hace casi 200 años, cuando la tierra que llegaria a ser Nirmathas " +
				"todavia era un vasallo del imperio de Cheliax, el norte del bosque de " +
				"los colmillos era un lugar salvaje y peligroso. Los cruzados que derrotaron " +
				"al surrurrante tirano son ahora una distante memoria, y a aquellos que quedaron " +
				"se les asigno mantener controlados a los orcos de Belkzen y a los undeads que " +
				"quedaban de Ustalav. Como resultado, el gran bosque estaba lleno de peligros, de " +
				"orcos merodeando a mortales depredadores, haciendolo inseguro para los comerciantes " +
				"que buscaban comerciar con la creciente comunidad de Skelt en las laderas de las " +
				"montañas Mindspin en el oeste.");
	
		setIcon("everflame$S");
	}
	
	public void init(){
		super.init();
		clearScenes();
		
		Narration n=new Narration();
		n.createContents();
		n.setTag("BEGIN");
		n.setNext("CHOICE");
		n.setBackground("ui/kassen");
		n.setText("Ekat Kassen era un cruzado y buscador de fortuna que llego " +
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
				"profundo del bosque, y el mismo Ekat fue a lidiar con su antiguo compañero. " +
				"La batalla fue terriblemente sangrienta, solo unos pocos de la gente de la ciudad volvio " +
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
				"a la edad adult, un bocado de aventura antes de empezar a a trabajar y casarse. " +
				"La aventura empieza como una solemne ceremonia, con los habitantes de Kassen reuniendose " +
				"para desear suerte a los aventureros, igual que hicieron cuando Kassen fue a enfrentarse " +
				"con los mercenarios. ");
		
		this.addScene(n);

		Choice c=new Choice();
		c.createContents();
		c.setTag("CHOICE");
		c.setText("Cuando los aventureros retornan unos pocos dias despues, la ciudad una gran fiesta en su honor. " +
				"Esto tambien marca la ultima celebracion antes de que comience el duro invierno. ");
		c.addOption("Continuar","BATTLE.Balconada");
		//c.addOption("Bajar por las escaleras de la izquierda","BATTLE.stairs2");
		c.addOption("Marcharse","VICTORY");
		this.addScene(c);
		
		DefaultTileMapScene ms=new DefaultTileMapScene();
		ms.createContents();
		ms.createMap(24,16);
		ms.loadTiled("coliseo", 0, 0);
		ms.setTiles(DefaultTileMapScene.DEFAULT,"tiles");
		ms.setProperties(DefaultTileMapScene.DEFAULT, StabBlockData.ID);
		ms.setTag("BATTLE");
		
		DefaultRule r=new DefaultRule();
		r.setEvent(InfoDestroyed.class);
		r.addCondition(new InfoIsClass(Dummy.class));
		r.addResponse(new VictoryResponse(0,"VICTORY"));
		ms.addRule(r);
		this.addScene(ms);
		
		Narration n2=new Narration();
		n2.createContents();
		n2.setTag("VICTORY");
		n2.setText("Victoria!");
		n2.setNext(null);
		this.addScene(n2);
	}
	
}
