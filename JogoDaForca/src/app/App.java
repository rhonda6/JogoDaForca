/**
 * 
 */
package app;

import controllers.JogoDaForcaController;
import models.Palavra;
import views.JogoDaForcaView;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Palavra m = new Palavra();
		JogoDaForcaView v = new JogoDaForcaView();
		JogoDaForcaController c = new JogoDaForcaController(m, v);
		c.initController();
	}
}
