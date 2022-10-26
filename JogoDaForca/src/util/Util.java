/**
 * 
 */
package util;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * @author Rafhael Honda da Silva
 *
 */
public class Util {

	public static String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	public static void desabilitaBotoesTeclado(List<JButton> todos, String letra, Color color) {
		var lista = todos.stream().filter(x -> x.getText().toLowerCase().equals(letra.toLowerCase())).toList();
		for(JButton b : lista) {
			b.setBackground(color);
			b.setEnabled(false);
		}
	}
	
	public static void habilitaTodosBotoesTeclado(List<JButton> todos) {
		for(JButton b : todos) {
			b.setBackground(null);
			b.setEnabled(true);
		}
	}
	
	public static void desabilitaTodosBotoesTeclado(List<JButton> todos) {
		for(JButton b : todos) {
			b.setEnabled(false);
		}
	}	
	
	public static void limparDisplayLabels(List<JLabel> todos) {
		for(JLabel label : todos) {
			label.setText("");
			label.setVisible(false);
		}
	}
	
	public static List<JLabel> obtemListaPalavraLabel(String palavra){
		
		int j = 1;
		String letra;
		var resultado = new ArrayList<JLabel>();

		for (int i = 0; i < palavra.length(); i++) {

			letra = palavra.substring(i, j);

			JLabel labelPalavra = new JLabel(letra);
			labelPalavra.setName(letra);
			resultado.add(labelPalavra);

			j++;
			
		}
		
		return resultado;
	}
	
	public static List<JButton> obtemListaAlfabetoButtons(){
		var resultado = new ArrayList<JButton>();
		
		for(int i=0; i<alfabeto.length; i++) {
			var button = new JButton(alfabeto[i]);
			button.setName(alfabeto[i]);
			resultado.add(button);
		}
		return resultado;
	}
	
	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();		        
					AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/sounds/" + url));
					clip.open(inputStream);
					clip.start(); 
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
		    }
		  }
		).start();
	}
	
	public static ImageIcon obtemImagemIcon(String imageName) {
		return new ImageIcon(Util.class.getResource("/resources/images/" + imageName));
	}
	
}
