package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import it.uniroma3.comandi.Comando;
import it.uniroma3.comandi.FabbricaDiComandi;
import it.uniroma3.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;


public class TestFabbricaDiComandiFisarmonica {
	private FabbricaDiComandi f;

	private IO io;
	@Test
	public void testCostruisciComandoGuarda() {
		SetParametri("guarda", "guarda", null);
	}

	@Test
	public void testCostruisciComandoVai() {
		SetParametri("vai", "vai", "nord");
	}
	@Test
	public void testCostruisciComandofine() {
		SetParametri("fine", "fine", null);	
	}
	@Test
	public void testCostruisciComandoaiuto() {
		 SetParametri("aiuto", "aiuto", null);
	}
	@Test
	public void testCostruisciComandoPrendi() {
		 SetParametri("prendi", "prendi", "carta");
		 }
	@Test
	public void testCostruisciComandoPosa() {
		 SetParametri("posa", "posa", "penna");
		 }
	@Test
	public void testCostruisciComandoNonValido() {
		 SetParametri(" null", "comando non valido", null);
		 }
	@Test
	public void testCostruisciComandoVuoto() {
		 SetParametri(" ", "comando non valido", null);
		 }
	private void SetParametri(String nomeComando, String ComandoAtteso, String parametro) {

		this.io=new IOConsole();
		this.f =new FabbricaDiComandiFisarmonica();
		Comando comando= this.f.costruisciComando(nomeComando, this.io);
		if(parametro!=null)
			comando.setParametro(parametro);
		assertEquals(ComandoAtteso,comando.getNome());
		assertEquals(parametro,comando.getParametro());
	}

}
