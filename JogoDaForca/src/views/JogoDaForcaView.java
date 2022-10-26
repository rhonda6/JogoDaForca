/**
 * 
 */
package views;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author Rafhael Honda da Silva
 *
 */
public class JogoDaForcaView {
	
	private JFrame f;
	
	private JLabel labelDica;
	
	private JLabel labelImagemForca;

	private JLabel labelTotalTentativas;
	
	private JLabel labelTamanhoPalavra;
	
	private JLabel labelAcertos;
	
	private JLabel labelContadorAcertos;
	
	private JLabel labelErros;
	
	private JLabel labelContadorErros;

	private JLabel labelMensagem;
	
	private List<JLabel> listaLetrasLabels;
	
	private List<JButton> listaAlfabetoButtons;
	
	private JButton buttonNovoJogo;
	
	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}
	
	public JLabel getLabelDica() {
		return labelDica;
	}

	public void setLabelDica(JLabel labelDica) {
		this.labelDica = labelDica;
	}
	
	public JLabel getLabelImagemForca() {
		return labelImagemForca;
	}

	public void setLabelImagemForca(JLabel labelImagemForca) {
		this.labelImagemForca = labelImagemForca;
	}
	
	public JLabel getLabelTotalTentativas() {
		return labelTotalTentativas;
	}

	public void setLabelTotalTentativas(JLabel labelTotalTentativas) {
		this.labelTotalTentativas = labelTotalTentativas;
	}
	
	public JLabel getLabelTamanhoPalavra() {
		return labelTamanhoPalavra;
	}

	public void setLabelTamanhoPalavra(JLabel labelTamanhoPalavra) {
		this.labelTamanhoPalavra = labelTamanhoPalavra;
	}
	
	public JLabel getLabelAcertos() {
		return labelAcertos;
	}

	public void setLabelAcertos(JLabel labelAcertos) {
		this.labelAcertos = labelAcertos;
	}

	public JLabel getLabelErros() {
		return labelErros;
	}

	public void setLabelErros(JLabel labelErros) {
		this.labelErros = labelErros;
	}

	public JLabel getLabelContadorAcertos() {
		return labelContadorAcertos;
	}

	public void setLabelContadorAcertos(JLabel labelContadorAcertos) {
		this.labelContadorAcertos = labelContadorAcertos;
	}

	public JLabel getLabelContadorErros() {
		return labelContadorErros;
	}

	public void setLabelContadorErros(JLabel labelContadorErros) {
		this.labelContadorErros = labelContadorErros;
	}

	public JLabel getLabelMensagem() {
		return labelMensagem;
	}

	public void setLabelMensagem(JLabel labelMensagem) {
		this.labelMensagem = labelMensagem;
	}

	public List<JLabel> getListaLetrasLabels() {
		return listaLetrasLabels;
	}

	public void setListaLetrasLabels(List<JLabel> listaLetrasLabels) {
		this.listaLetrasLabels = listaLetrasLabels;
	}

	public List<JButton> getListaAlfabetoButtons() {
		return listaAlfabetoButtons;
	}

	public void setListaAlfabetoButtons(List<JButton> listaAlfabetoButtons) {
		this.listaAlfabetoButtons = listaAlfabetoButtons;
	}

	public JButton getButtonNovoJogo() {
		return buttonNovoJogo;
	}

	public void setButtonNovoJogo(JButton buttonNovoJogo) {
		this.buttonNovoJogo = buttonNovoJogo;
	}

	/**
	 * @param args
	 */
	public JogoDaForcaView() {
		// TODO Auto-generated method stub
		
		f = new JFrame();
		f = new JFrame("Jogo da Forca");
		f.setSize(685, 640);
		f.setResizable(false);
		f.getContentPane().setBackground(Color.WHITE); 
		
		int posY = 10;
		
		labelDica = new JLabel("Dica: ");
		labelDica.setBounds(10, posY, 600, 30);
		f.add(labelDica);
		
		posY += 30;
		
		labelTotalTentativas = new JLabel("Total de tentativas disponível: ");
		labelTotalTentativas.setBounds(10, posY, 600, 30);
		f.add(labelTotalTentativas);
		
		posY += 30;
		
		labelTamanhoPalavra = new JLabel("Quantidade de letras: ");
		labelTamanhoPalavra.setBounds(10, posY, 600, 30);
		f.add(labelTamanhoPalavra);
		
		posY += 30;
		
		labelAcertos = new JLabel("Acertos: ");
		labelAcertos.setBounds(10, posY, 100, 30);
		f.add(labelAcertos);
		
		labelContadorAcertos = new JLabel();
		labelContadorAcertos.setBounds(60, posY, 100, 30);
		f.add(labelContadorAcertos);
		
		posY += 30;
					
		labelErros = new JLabel("Erros: ");
		labelErros.setBounds(10, posY, 100, 30);
		f.add(labelErros);
		
		labelContadorErros = new JLabel();
		labelContadorErros.setBounds(60, posY, 100, 30);
		f.add(labelContadorErros);
		
		
		posY += 350;

		buttonNovoJogo = new JButton("Novo Jogo");
		buttonNovoJogo.setBounds(10, posY, 150, 30);
		f.add(buttonNovoJogo);
		
		labelMensagem = new JLabel("");
		labelMensagem.setBounds(180, posY, 100, 30);
		f.add(labelMensagem);
		
		labelImagemForca = new JLabel();
		labelImagemForca.setBounds(200, 25, 550, 400);
		f.add(labelImagemForca);

		f.setLayout(null);
		f.setVisible(true);
		
		listaLetrasLabels = new ArrayList<JLabel>();
		listaAlfabetoButtons  = new ArrayList<JButton>();

	}	
		
	/*

	public static void teste(List<JLabel> lista) {
		// TODO Auto-generated method stub

		String entrada, letra;
		do {
			entrada = JOptionPane.showInputDialog(null, "Digite a letra", "", JOptionPane.INFORMATION_MESSAGE);

			if (entrada == null)
				return;

		} while (entrada == null || entrada.equals(""));

		letra = entrada;

		var itens = lista.stream().filter(x -> x.getText().toLowerCase().equals(letra.toLowerCase())).toList();

		for (JLabel item : itens) {
			item.setVisible(true);
		}
	}
	*/
}
