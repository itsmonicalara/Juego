import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Estudiante extends Hero implements Serializable{

	public Estudiante(String name, int hp, int attack, int magia) {
		super(name, hp, attack, magia);

		habilidadEspecialTexto = "Has recuperado 6 de vida!";
		habilidadEspecial = 6;
	}
}