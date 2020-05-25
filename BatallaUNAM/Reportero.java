import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Reportero extends Hero implements Serializable{

	public Reportero(String name, int hp, int attack, int magia) {
		super(name, hp, attack, magia);

		habilidadEspecialTexto = "Has recuperado 2 de vida! \n Le has quitado 4 de vida al oponente!!";
		habilidadEspecial1 = 2;
		habilidadEspecial2 = 4;
	}
}