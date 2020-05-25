import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Hero extends Personaje implements Serializable {
	
	public int magia;
	public Weapon weapon;
	public int habilidadEspecial, habilidadEspecial1, habilidadEspecial2;
	public String habilidadEspecialTexto;

	public Hero(String name, int hp, int attack, int magia) {
		super(name, hp, attack);
		this.magia = magia;
		this.weapon = weapon;
	}
}