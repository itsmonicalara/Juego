import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class EmptySlot extends Item implements Serializable{
	
	EmptySlot() {
		name = "";
	}
}