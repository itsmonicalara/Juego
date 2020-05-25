import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class Police extends Monster implements Serializable{

	public Police(String name, int hp, int attack) {
		super(name, hp, attack);
	}
}