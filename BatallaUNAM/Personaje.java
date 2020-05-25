import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public abstract class Personaje implements Serializable{
	
	public String name;
	public int hp;
	public int attack;

	public Personaje(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.attack = attack;
	}
}