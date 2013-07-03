package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data,
			List<Negociacao> negociacoes) {

		double abertura = 0;
		double fechamento = 0;
		double maximo = 0;
		double minimo = 0;
		double volume = 0;

		if (!negociacoes.isEmpty()) {
			abertura = negociacoes.get(0).getPreco();
			fechamento = negociacoes.get(negociacoes.size()-1).getPreco();
			minimo = Double.MAX_VALUE;
			maximo = Double.MIN_VALUE;
		}
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		return new Candlestick(abertura, fechamento, minimo, maximo, volume,
				data);
		
	}
}
