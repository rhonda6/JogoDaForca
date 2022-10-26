package controllers;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.Palavra;
import util.Util;
import views.JogoDaForcaView;

/**
 * @author Rafhael Honda da Silva
 *
 */

public class JogoDaForcaController {

	private Palavra model;
	private JogoDaForcaView view;
	private int contadorAcertos = 0;
	private int contadorErros = 0;
	private Palavra palavraSelecionada;

	/**
	 * 
	 */
	public JogoDaForcaController(Palavra m, JogoDaForcaView v) {
		model = m;
		view = v;

		contadorAcertos = 0;
		contadorErros = 0;

	}

	public void initController() {

		displayTeclado();
		view.getButtonNovoJogo().addActionListener(e -> buttonNovoJogoListener());

		Util.desabilitaTodosBotoesTeclado(view.getListaAlfabetoButtons());

		var image = Util.obtemImagemIcon("jogo-da-forca-01.png");
		view.getLabelImagemForca().setIcon(image);
	}

	public void buttonNovoJogoListener() {

		contadorAcertos = 0;
		contadorErros = 0;

		Util.habilitaTodosBotoesTeclado(view.getListaAlfabetoButtons());
		Util.limparDisplayLabels(view.getListaLetrasLabels());

		view.getLabelContadorAcertos().setText("");
		view.getLabelContadorErros().setText("");
		view.getLabelDica().setText("");
		view.getLabelTamanhoPalavra().setText("");
		view.getLabelMensagem().setText("");
		
		var image = Util.obtemImagemIcon("jogo-da-forca-01.png");
		view.getLabelImagemForca().setIcon(image);

		palavraSelecionada = model.sorteiaPalavra();
		System.out.println(palavraSelecionada);

		view.getLabelDica().setText("Dica: " + palavraSelecionada.getDica());
		view.getLabelTotalTentativas().setText("Total de tentativas disponível: "
				+ palavraSelecionada.obtemTotalTentativas(palavraSelecionada.getPalavra()));
		view.getLabelTamanhoPalavra()
				.setText("Tamanho da palavra: " + palavraSelecionada.getPalavra().length() + " letras.");

		displayLetras(palavraSelecionada.getPalavra());
		view.getButtonNovoJogo().setEnabled(false);

	}

	public void displayLetras(String palavra) {

		int labelPosX = 50;
		int labelPosY = 400;

		var lista = Util.obtemListaPalavraLabel(palavra);
		for (JLabel label : lista) {

			label.setBounds(labelPosX, labelPosY, 200, 50);
			label.setFont(new Font("Arial", Font.PLAIN, 44));
			label.setVisible(false);
			view.getF().add(label);
			view.getListaLetrasLabels().add(label);

			/*
			 * JLabel labelTracoLetra = new JLabel("--");
			 * labelTracoLetra.setBounds(labelPosX, labelPosY + 50, 200, 30);
			 * labelTracoLetra.setFont(new Font("Arial", Font.PLAIN, 44));
			 * labelTracoLetra.setVisible(true); view.getF().add(labelTracoLetra);
			 */

			labelPosX += 50;
		}
	}

	public void displayTeclado() {

		int posX = 10;
		int posY = 520;
		int contadorButton = 0;

		var listaLetraLabels = view.getListaLetrasLabels();
		var listaButtons = Util.obtemListaAlfabetoButtons();
		for (JButton b : listaButtons) {

			b.addActionListener(e -> buttonAlfabetoListener(listaLetraLabels, e));

			if (contadorButton == 13) {
				contadorButton = 0;
				posX = 10;
				posY += 35;
			}
			b.setBounds(posX, posY, 48, 30);

			view.getF().add(b);
			view.getListaAlfabetoButtons().add(b);

			posX += 50;
			contadorButton++;
		}
	}

	public void buttonAlfabetoListener(List<JLabel> lista, ActionEvent e) {

		String letra = e.getActionCommand();
		var itens = lista.stream().filter(x -> x.getText().toLowerCase().equals(letra.toLowerCase())).toList();
		if (itens.size() > 0) {
			for (JLabel item : itens) {
				item.setVisible(true);
				contadorAcertos++;
				view.getLabelContadorAcertos().setText(Integer.toString(contadorAcertos));
			}
			Util.playSound("acerto.wav");
			Util.desabilitaBotoesTeclado(view.getListaAlfabetoButtons(), letra, Color.GREEN);
			if (contadorAcertos == palavraSelecionada.getPalavra().length()) {
				view.getLabelMensagem().setText("Você venceu.");
				Util.playSound("venceu.wav");
				view.getButtonNovoJogo().setEnabled(true);
			}

		} else {
			/* a letra não pertence a palavra */
			Util.playSound("erro.wav");
			Util.desabilitaBotoesTeclado(view.getListaAlfabetoButtons(), letra, Color.RED);
			contadorErros++;
			view.getLabelContadorErros().setText(Integer.toString(contadorErros));
			if (contadorErros <= 7) {
				var image = Util.obtemImagemIcon("jogo-da-forca-0" + contadorErros + ".png");
				view.getLabelImagemForca().setIcon(image);
			}

			if (contadorErros >= model.obtemTotalTentativas(palavraSelecionada.getPalavra())) {				
				Util.playSound("perdeu.wav");
				view.getLabelMensagem().setText("Você perdeu.");
				Util.desabilitaTodosBotoesTeclado(view.getListaAlfabetoButtons());
				view.getButtonNovoJogo().setEnabled(true);
			}

		}
	}
}
