import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Story implements Serializable{

	private Ventana ventana;
	private VisibilityManager visibilityManager;

	Hero player;
	Monster monster;

	private int RING = 0;
	public int experiencia = 0;

	Item[] mochila = new Item[5];
	Jugo jugo = new Jugo();
	Pastillas pastillas = new Pastillas();
	EmptySlot emptySlot = new EmptySlot();

	public String inventoryStatus = "closed";

	public Story(Ventana ventana, VisibilityManager visibilityManager) {
		this.ventana = ventana;
		this.visibilityManager = visibilityManager;
	}

	public void defaultPlayer(int selectedCharacter) {
		
		if(selectedCharacter == 1) {
			player = new Estudiante("Est.", 14, 2, 2);
		} else if (selectedCharacter == 2) {
			player = new Maestro("Maestro", 15, 4, 1);
		} else {
			player = new Reportero("Reportero", 15, 1, 4);
		}

		ventana.hpLabel.setText("HP: " + player.hp);
		ventana.attackLabel.setText("Ataque: " + player.attack);
		ventana.magicLabel.setText("Magia: " + player.magia);
		ventana.nameLabel.setText("Clase: " + player.name);
		
		player.weapon = new Navaja();
		ventana.weaponLabel.setText("Arma: " + player.weapon.name);

		mochila[0] = jugo;
 		mochila[1] = emptySlot;
 		mochila[2] = emptySlot;
 		mochila[3] = emptySlot;
 		mochila[4] = emptySlot;

 		oficinas();
	}

	public void selectPosition(String position) {

		switch(position) {
			case "oficinas": oficinas(); break;
			case "hablarDirector": hablarDirector(); break;
			case "atacarDirector": atacarDirector(); break;
			case "hablarSra": hablarSra(); break;
			case "explanada": explanada(); break;
			case "cafe": cafe(); break;
			case "facultad": facultad(); break;
			case "west1": west1(); break;
			case "east1": east1(); break;
			case "west2": west2(); break;
			case "east2": east2(); break;
			case "west3": west3(); break;
			case "east3": east3(); break;
			case "boss": boss(); break;
			case "fight": fight(); break;
			case "normalAttack": normalAttack(); break;
			case "magicAttack": magicAttack(); break;
			case "ability": ability(); break;
			case "monsterAttack": monsterAttack(); break;
			case "defeatMonster": defeatMonster(); break;
			case "death": death(); break;
			case "ending": ending(); break;
			case "titleScreen": titleScreen(); break;
		}
	}

	public void itemUsed(int slotNumber) {
		player.hp += mochila[slotNumber].healingValue;
		ventana.hpLabel.setText("HP: " + player.hp);
		mochila[slotNumber] = emptySlot;
		ventana.item1.setText(mochila[0].name);
		ventana.item2.setText(mochila[1].name);
		ventana.item3.setText(mochila[2].name);
		ventana.item4.setText(mochila[3].name);
		ventana.item5.setText(mochila[4].name);
	}

	public void oficinas() {
		ventana.mainTextArea.setText("Te encuentras en las oficinas de la UNAM. \n El director se encuentra frente a ti. \n" +
			"Hay una Sra. a tus espaldas. \n\n Escoge:");
		ventana.c1.setText("Hablarle al director");
		ventana.c2.setText("Atacar al director");
		ventana.c3.setText("Hablarle a la Sra.");
		ventana.c4.setText("Salir de las oficinas");
		
		ventana.position1 = "hablarDirector";
		ventana.position2 = "atacarDirector";
		ventana.position3 = "hablarSra";
		ventana.position4 = "explanada";
	}

	public void hablarDirector() {

		if(RING == 0) {
			ventana.mainTextArea.setText("Director: Hola, estoy muy ocupado. \n" + 
				"Lo siento, pero no puedo perder mi tiempo contigo.");
			ventana.c1.setText(">>");
			ventana.c2.setText("");
			ventana.c3.setText("");
			ventana.c4.setText("");

			ventana.position1 = "oficinas";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		} else {
			ending();
		}
	}

	public void atacarDirector() {
		ventana.mainTextArea.setText("Director: Oye, tranquilo! \n El director te ha dado un zape. \n\n (Has perdido 3 de vida)");
		player.hp -= 3;
		ventana.hpLabel.setText("HP: " + player.hp);
		ventana.c1.setText(">>");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		if(player.hp > 0) {
			ventana.position1 = "oficinas";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		} else {
			ventana.position1 = "death";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		}
	}

	public void hablarSra() {
		int slotNumber = 0;
		while(mochila[slotNumber] != emptySlot && slotNumber < 4) {
			slotNumber++;
		}
		if(mochila[slotNumber] == emptySlot) {
			ventana.mainTextArea.setText("Sra.: Te ves muy mal. \n Toma esto. \n\n (Has recibido Pastillas)");
			mochila[slotNumber] = pastillas;
		} else {
			ventana.mainTextArea.setText("Sra.: ...");
		}
		ventana.c1.setText(">>");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "oficinas";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void explanada() {
		ventana.mainTextArea.setText("Llegaste a la explanada. \n Oficinas: 10 km al sur.");
		ventana.c1.setText("Ir hacia el norte");
		ventana.c2.setText("Girar a la izquierda");
		ventana.c3.setText("Girar a la derecha");
		ventana.c4.setText("Ir hacia el sur");

		ventana.position1 = "cafe";
		ventana.position2 = "west1";
		ventana.position3 = "east1";
		ventana.position4 = "oficinas";
	}

	public void cafe() {
		ventana.mainTextArea.setText("Llegaste a la cafe. \n Oficinas: 20 km al sur.");
		ventana.c1.setText("Ir hacia el norte");
		ventana.c2.setText("Girar a la izquierda");
		ventana.c3.setText("Girar a la derecha");
		ventana.c4.setText("Ir hacia el sur");

		ventana.position1 = "facultad";
		ventana.position2 = "west2";
		ventana.position3 = "east2";
		ventana.position4 = "explanada";
	}

	public void facultad() {
		ventana.mainTextArea.setText("Llegaste a la facultad. \n Oficinas: 40 km al sur.");
		ventana.c1.setText("Ir hacia el norte");
		ventana.c2.setText("Girar a la izquierda");
		ventana.c3.setText("Girar a la derecha");
		ventana.c4.setText("Ir hacia el sur");

		ventana.position1 = "boss";
		ventana.position2 = "west3";
		ventana.position3 = "east3";
		ventana.position4 = "cafe";
	}

	public void west1() {
		monster = new Porro("Porro", 20, 4);
		ventana.mainTextArea.setText(monster.name + " salvaje ha aparecido!");
		ventana.c1.setText("Pelear!");
		ventana.c2.setText("Correr!");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "fight";
		ventana.position2 = "explanada";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void west2() {
		ventana.mainTextArea.setText("Comida gratis! \n Te sientas a comerte unos pambazos. \n\n" +
			"(Has recuperado 2 de vida)");
		player.hp += 2;
		ventana.hpLabel.setText("HP: " + player.hp);
		ventana.c1.setText("Regresar");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "cafe";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void west3() {
		monster = new Police("Auxiliar", 40, 8);
		ventana.mainTextArea.setText(monster.name + " salvaje ha aparecido!");
		ventana.c1.setText("Pelear!");
		ventana.c2.setText("Correr!");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "fight";
		ventana.position2 = "facultad";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void east1() {
		ventana.mainTextArea.setText("Llegaste a la zona de objetos perdidos. \n\n (Obtuviste una Espada)");
		player.weapon = new Espada();
		ventana.weaponLabel.setText("Arma: " + player.weapon.name);
		ventana.c1.setText("Go back");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "explanada";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void east2() {
		monster = new Porro("Porro", 20, 4);
		ventana.mainTextArea.setText(monster.name + " salvaje ha aparecido!");
		ventana.c1.setText("Pelear!");
		ventana.c2.setText("Correr!");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "fight";
		ventana.position2 = "cafe";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void east3() {
		monster = new Police("Auxiliar", 40, 8);
		ventana.mainTextArea.setText(monster.name + " salvaje ha aparecido!");
		ventana.c1.setText("Pelear!");
		ventana.c2.setText("Correr!");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "fight";
		ventana.position2 = "facultad";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void boss() {
		monster = new Rector("Rector", 100, 20);
		ventana.mainTextArea.setText(monster.name + " salvaje ha aparecido!");
		ventana.c1.setText("Pelear!");
		ventana.c2.setText("Correr!");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "fight";
		ventana.position2 = "facultad";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void fight() {
		ventana.mainTextArea.setText("Vida " + monster.name + ": " + monster.hp + "\n\n Escoge:");
		ventana.c1.setText("Atacar!");
		ventana.c2.setText("Utilizar magia!");
		ventana.c3.setText("Utilizar habilidad!");
		ventana.c4.setText("Correr!");
		
		ventana.position1 = "normalAttack";
		ventana.position2 = "magicAttack";
		ventana.position3 = "ability";
		ventana.position4 = "cafe";
	}

	public void normalAttack() {
		int playerDamage = new java.util.Random().nextInt(player.attack + player.weapon.damage + 1);
		ventana.mainTextArea.setText("Atacaste al " + monster.name + " y le bajaste " + playerDamage + " de vida!");
		monster.hp -= playerDamage;
		ventana.c1.setText(">>");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		if(monster.name == "Rector") {
			if(monster.hp > 0) {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "defeatBoss";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		} else {
			if(monster.hp > 0) {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "defeatMonster";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		}
	}
	public void magicAttack() {
		int playerDamage = new java.util.Random().nextInt(player.magia + 1);
		ventana.mainTextArea.setText("Le lanzaste un hechizo al " + monster.name + " y le bajaste " + playerDamage + " de vida!");
		monster.hp -= playerDamage;
		ventana.c1.setText(">>");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		if(monster.name == "Rector") {
			if(monster.hp > 0) {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "defeatBoss";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		} else {
			if(monster.hp > 0) {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "defeatMonster";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		}
	}

	public void ability() {
		if(player.name == "Est.") {
			ventana.mainTextArea.setText("Vaya! \n" + player.habilidadEspecialTexto);
			player.hp += player.habilidadEspecial;
			ventana.hpLabel.setText("HP: " + player.hp);
			ventana.c1.setText(">>");
			ventana.c2.setText("");
			ventana.c3.setText("");
			ventana.c4.setText("");

			ventana.position1 = "monsterAttack";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		} else if(player.name == "Maestro") {
			ventana.mainTextArea.setText("Vaya! \n" + player.habilidadEspecialTexto);
			monster.hp -= player.habilidadEspecial;
			ventana.c1.setText(">>");
			ventana.c2.setText("");
			ventana.c3.setText("");
			ventana.c4.setText("");

			if(monster.hp < 0) {
				ventana.position1 = "defeatMonster";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		} else {
			ventana.mainTextArea.setText("Vaya! \n" + player.habilidadEspecialTexto);
			player.hp += player.habilidadEspecial1;
			monster.hp -= player.habilidadEspecial2;
			ventana.hpLabel.setText("HP: " + player.hp);
			ventana.c1.setText(">>");
			ventana.c2.setText("");
			ventana.c3.setText("");
			ventana.c4.setText("");

			if(monster.hp < 0) {
				ventana.position1 = "defeatMonster";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			} else {
				ventana.position1 = "monsterAttack";
				ventana.position2 = "";
				ventana.position3 = "";
				ventana.position4 = "";
			}
		}
	}

	public void monsterAttack() {
		int monsterDamage = new java.util.Random().nextInt(monster.attack + 1);
		ventana.mainTextArea.setText("El " + monster.name + " te ha atacado y perdiste " + monsterDamage + " de vida!");
		player.hp -= monsterDamage;
		ventana.hpLabel.setText("HP: " + player.hp);
		ventana.c1.setText(">>");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		if(player.hp > 0) {
			ventana.position1 = "fight";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		} else {
			ventana.position1 = "death";
			ventana.position2 = "";
			ventana.position3 = "";
			ventana.position4 = "";
		}
	}

	public void defeatMonster() {
		ventana.mainTextArea.setText("Has derrotado al " + monster.name + "!" + "\n\n (Has ganado 10 de experiencia)");
		experiencia += 10;
		ventana.c1.setText("Ir a un lugar seguro");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "cafe";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void defeatBoss() {
		ventana.mainTextArea.setText("Has derrotado al " + monster.name + "! \n Parece que ha dejado algo en el suelo... \n\n" + 
			"(Obtuviste una Estrella)");
		RING = 1;
		ventana.c1.setText("Regresar");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "facultad";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void death() {
		ventana.mainTextArea.setText("Has muerto... \n\n <GAME OVER>");
		ventana.c1.setText("A la pantalla de inicio...");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "titleScreen";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void ending() {
		ventana.mainTextArea.setText("Director: Te deshiciste del rector!? \n Eres demasiado bueno para ser verdad! \n" + 
			"Bienvenido! \n\n <THE END>");
		ventana.c1.setText("A la pantalla de inicio...");
		ventana.c2.setText("");
		ventana.c3.setText("");
		ventana.c4.setText("");

		ventana.position1 = "titleScreen";
		ventana.position2 = "";
		ventana.position3 = "";
		ventana.position4 = "";
	}

	public void titleScreen() {
		visibilityManager.showTitleScreen();
	}
}