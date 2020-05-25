import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Maestro extends Hero implements Serializable{
	
	public Maestro(String name, int hp, int attack, int magia) {
		super(name, hp, attack, magia);

		habilidadEspecialTexto = "Le has quitado 6 de vida al oponente!";
		habilidadEspecial = 6;
	}
}