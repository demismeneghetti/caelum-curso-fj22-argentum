package br.com.caelum.argentum.modelo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.reader.LeitorXML;

public class LeitorXMLTest {

	@Test
	public void carregaXMLComUmaNegociacaoEmListaUnitaria() {
		
		String xmlDeTeste = "<list>" + 
							"	<negociacao>" +
							"		<preco>43.5</preco>" +
							"		<quantidade>1000</quantidade>" +
							"		<data>" +
							"			<time>1322233344455</time>" +
							"		</data>" +
							"	</negociacao>" +
							"</list>";
		
		LeitorXML leitor = new LeitorXML();
		
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		
		List<Negociacao> negociacoes = leitor.carrega(xml);
		
	}

}