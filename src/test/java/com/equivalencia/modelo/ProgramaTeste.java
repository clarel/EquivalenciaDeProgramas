package com.equivalencia.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProgramaTeste {

	@Test
	public void teste_geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida_1() {
		List<String> entradas1 = new ArrayList<>();
		entradas1.add("SE T1 VA-PARA 2 SENAO-va-para 3");
		entradas1.add("FACA F VA-PARA 6");
		entradas1.add("SE T2 VA-PARA 5 SENAO-VA-PARA 4");
		entradas1.add("FACA G VA-PARA 7");
		entradas1.add("FACA F VA-PARA 7");
		entradas1.add("SE T3 VA-PARA 4 SENAO-VA-PARA 1");

		List<String> entradas2 = new ArrayList<>();

		entradas2.add("FACA F VA-PARA 2");
		entradas2.add("SE T1 VA-PARA 3 SENAO-va-para 1");
		entradas2.add("FACA g VA-PARA 4");
		entradas2.add("SE T2 VA-PARA 1 SENAO-VA-PARA 5");
		entradas2.add("FACA h VA-PARA 6");
		entradas2.add("SE T3 VA-PARA 7 SENAO-VA-PARA 5");

		try {
			List<InstrucaoMonolitica> instrucoesMonoliticas1 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas1);
			List<InstrucaoMonolitica> instrucoesMonoliticas2 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas2);
			Programa programa = new Programa(instrucoesMonoliticas1, instrucoesMonoliticas2);

			assertEquals("(F,2)(G,4)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(G,4)(G,4)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(PARADA,&)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(PARADA,&)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(5, programa.getInstrucoesMonoliticasPrograma1()).toString());

			assertEquals("(F,6)(F,6)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(G,7)(F,6)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(H,8)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(PARADA,&)(H,8)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(5, programa.getInstrucoesMonoliticasPrograma2()).toString());
		} catch (Exception e) {
			String message = "";
			assertEquals(message, e.getMessage());
		}
	}

	@Test
	public void teste_geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida_2() {
		List<String> entradas1 = new ArrayList<>();
		entradas1.add("SE T1 VA-PARA 2 SENAO-va-para 5");
		entradas1.add("FACA F VA-PARA 3");
		entradas1.add("SE T2 VA-PARA 1 SENAO-VA-PARA 4");
		entradas1.add("FACA G VA-PARA 1");

		List<String> entradas2 = new ArrayList<>();

		entradas2.add("SE T1 VA-PARA 2 SENAO-va-para 6");
		entradas2.add("FACA F VA-PARA 3");
		entradas2.add("SE T2 VA-PARA 4 SENAO-VA-PARA 5");
		entradas2.add("FACA F VA-PARA 3");
		entradas2.add("FACA G VA-PARA 1");

		try {
			List<InstrucaoMonolitica> instrucoesMonoliticas1 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas1);
			List<InstrucaoMonolitica> instrucoesMonoliticas2 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas2);
			Programa programa = new Programa(instrucoesMonoliticas1, instrucoesMonoliticas2);

			assertEquals("(F,2)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,2)(G,3)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,2)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma1()).toString());

			assertEquals("(F,5)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(G,7)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(G,7)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,5)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(5, programa.getInstrucoesMonoliticasPrograma2()).toString());
		} catch (Exception e) {
			String message = "";
			assertEquals(message, e.getMessage());
		}
	}

	@Test
	public void teste_geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida_3() {
		List<String> entradas1 = new ArrayList<>();
		entradas1.add("Se T1 va-para 2 senao-va-para 6");
		entradas1.add("faca f va-para 3");
		entradas1.add("Se T2 va-para 1 senao-va-para 4");
		entradas1.add("Faca g va-para 1");

		List<String> entradas2 = new ArrayList<>();

		entradas2.add("SE T1 VA-PARA 2 SENAO-va-para 6");
		entradas2.add("FACA F VA-PARA 3");
		entradas2.add("SE T2 VA-PARA 4 SENAO-VA-PARA 5");
		entradas2.add("FACA F VA-PARA 3");
		entradas2.add("FACA G VA-PARA 1");

		try {
			List<InstrucaoMonolitica> instrucoesMonoliticas1 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas1);
			List<InstrucaoMonolitica> instrucoesMonoliticas2 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas2);
			Programa programa = new Programa(instrucoesMonoliticas1, instrucoesMonoliticas2);

			assertEquals("(F,2)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,2)(G,3)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,2)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma1()).toString());

			assertEquals("(F,5)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(G,7)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(G,7)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,5)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(5, programa.getInstrucoesMonoliticasPrograma2()).toString());
		} catch (Exception e) {
			String message = "";
			assertEquals(message, e.getMessage());
		}
	}

	@Test
	public void teste_geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida_4() {

		List<String> entradas1 = new ArrayList<>();
		entradas1.add("Se T1 va-para 2 senao-va-para 1");
		entradas1.add("Se T2 va-para 3 senao-va-para 8");
		entradas1.add("FACA F VA-PARA 4");
		entradas1.add("FACA G VA-PARA 5");
		entradas1.add("Se T3 va-para 6 senao-va-para 2");
		entradas1.add("FACA F VA-PARA 7");
		entradas1.add("Se T4 va-para 2 senao-va-para 7");

		List<String> entradas2 = new ArrayList<>();

		entradas2.add("SE T1 VA-PARA 2 SENAO-va-para 1");
		entradas2.add("FACA F VA-PARA 3");
		entradas2.add("FACA G VA-PARA 4");
		entradas2.add("SE T2 VA-PARA 5 SENAO-VA-PARA 6");
		entradas2.add("FACA F VA-PARA 1");

		try {
			List<InstrucaoMonolitica> instrucoesMonoliticas1 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas1);
			List<InstrucaoMonolitica> instrucoesMonoliticas2 = InstrucaoMonolitica.criaListaInstrucoesMonoliticasParaPrograma(entradas2);
			Programa programa = new Programa(instrucoesMonoliticas1, instrucoesMonoliticas2);

			assertEquals("(F,2)(CICLO,OO)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(G,3)(G,3)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(3, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,4)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma1()).toString());
			assertEquals("(F,2)(CICLO,OO)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(6, programa.getInstrucoesMonoliticasPrograma1()).toString());

			assertEquals("(F,6)(CICLO,OO)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(G,7)(G,7)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(2, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,8)(PARADA,&)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(4, programa.getInstrucoesMonoliticasPrograma2()).toString());
			assertEquals("(F,6)(CICLO,OO)", Programa.geraInstrucaoRotuladaCompostaAtravesOperacaoOuPartida(0, programa.getInstrucoesMonoliticasPrograma2()).toString());
		} catch (Exception e) {
			String message = "";
			assertEquals(message, e.getMessage());
		}
	}

}
