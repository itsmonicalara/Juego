import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Monster extends Personaje implements Serializable {

	public Monster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
}