package br.com.caelum.leilao.dominio.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.ibm.caelum.leilao.builder.CriadorDeLeilao;

public class AvaliadorTest {

	 private Avaliador leiloeiro;
	    private Usuario maria;
	    private Usuario jose;
	    private Usuario joao;

	    @Before
	    public void setUp() {
	        this.leiloeiro = new Avaliador();
	        this.joao = new Usuario("Jo�o");
	        this.jose = new Usuario("Jos�");
	        this.maria = new Usuario("Maria");
	    }

	    @Test
	    public void deveEntenderLancesEmOrdemCrescente() {

	        Leilao leilao = new CriadorDeLeilao()
	            .para("Playstation 3 Novo")
	            .lance(joao, 250)
	            .lance(jose, 300)
	            .lance(maria, 400)
	            .constroi();

	        leiloeiro.avalia(leilao);

	        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.00001);
	        assertEquals(250.0, leiloeiro.getMenorLance(), 0.00001);
	    }

	    @Test
	    public void deveEntenderLeilaoComApenasUmLance() {
	        Leilao leilao = new CriadorDeLeilao()
	        .para("Playstation 3 Novo")
	        .lance(joao, 1000)
	        .constroi();

	        leiloeiro.avalia(leilao);

	        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
	        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
	    }

	    @Test
	    public void deveEncontrarOsTresMaioresLances() {
	        Leilao leilao = new CriadorDeLeilao()
	            .para("Playstation 3 Novo")
	            .lance(joao, 100)
	            .lance(maria, 200)
	            .lance(joao, 300)
	            .lance(maria, 400)
	            .constroi();

	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();
	        assertEquals(3, maiores.size());
	        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
	        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
	        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
	    }
	    
	    @Test(expected=RuntimeException.class)
	    public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
	        Leilao leilao = new CriadorDeLeilao()
	            .para("Playstation 3 Novo")
	            .constroi();

	        leiloeiro.avalia(leilao);
	    }

}