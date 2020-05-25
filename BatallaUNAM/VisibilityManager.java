import java.io.Serializable;
import java.text.StringCharacterIterator;
import java.util.*;
import java.io.*;

public class VisibilityManager implements Serializable {

	private Ventana ventana;

	public VisibilityManager(Ventana ventana) {
		this.ventana = ventana;
	}

	public void showTitleScreen() {
		ventana.titleNamePanel.setVisible(true);
		ventana.titleImagePanel.setVisible(true);
		ventana.titleButtonPanel.setVisible(true);
		ventana.characterPanel.setVisible(false);
		ventana.characterImagePanel.setVisible(false);
		ventana.characterButtonPanel.setVisible(false);
		ventana.mainTextPanel.setVisible(false);
		ventana.choiceButtonPanel.setVisible(false);
		ventana.playerStatusPanel.setVisible(false);
		ventana.inventoryPanel.setVisible(false);
	}

	public void showCharacterSelectionScreen() {
		ventana.characterPanel.setVisible(true);
		ventana.characterImagePanel.setVisible(true);
		ventana.characterButtonPanel.setVisible(true);
		ventana.titleNamePanel.setVisible(false);
		ventana.titleImagePanel.setVisible(false);
		ventana.titleButtonPanel.setVisible(false);
	}

	public void showGameScreen() {
		ventana.characterPanel.setVisible(false);
		ventana.characterImagePanel.setVisible(false);
		ventana.characterButtonPanel.setVisible(false);
		ventana.mainTextPanel.setVisible(true);
		ventana.choiceButtonPanel.setVisible(true);
		ventana.playerStatusPanel.setVisible(true);
	}
}