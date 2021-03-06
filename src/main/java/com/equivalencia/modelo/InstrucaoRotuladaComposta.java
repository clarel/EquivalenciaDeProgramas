package com.equivalencia.modelo;

public class InstrucaoRotuladaComposta {
	private String rotulo;

	private TipoInstrucao tipo1;
	private String identificador1;
	private String rotulo1;

	private TipoInstrucao tipo2;
	private String identificador2;
	private String rotulo2;

	public InstrucaoRotuladaComposta() {

	}

	public InstrucaoRotuladaComposta(InstrucaoRotuladaComposta instrucao) {
		this.rotulo = instrucao.getRotulo();

		this.tipo1 = instrucao.getTipo1();
		this.identificador1 = instrucao.getIdentificador1();
		this.rotulo1 = instrucao.getRotulo1();

		this.tipo2 = instrucao.getTipo2();
		this.identificador2 = instrucao.getIdentificador2();
		this.rotulo2 = instrucao.getRotulo2();
	}

	public void setInstrucaoRotulada(String identificador, String rotulo, TipoInstrucao tipo) {
		if (this.tipo1 == null) {
			this.tipo1 = tipo;
			this.identificador1 = identificador;
			this.rotulo1 = rotulo;
		} else {
			this.tipo2 = tipo;
			this.identificador2 = identificador;
			this.rotulo2 = rotulo;
		}
	}

	@Override
	public String toString() {
		StringBuffer primeiroConjunto = new StringBuffer("");
		primeiroConjunto.append("(" + identificador1 + "," + rotulo1 + ")");

		StringBuffer segundoConjunto = new StringBuffer("");
		segundoConjunto.append("(" + identificador2 + "," + rotulo2 + ")");

		return primeiroConjunto.toString() + segundoConjunto.toString();
	}

	public String toStringComRotulo() {
		StringBuffer primeiroConjunto = new StringBuffer(this.rotulo + ":");
		primeiroConjunto.append("(" + identificador1 + "," + rotulo1 + ")");

		StringBuffer segundoConjunto = new StringBuffer("");
		segundoConjunto.append("(" + identificador2 + "," + rotulo2 + ")");

		return primeiroConjunto.toString() + segundoConjunto.toString();
	}

	public TipoInstrucao getTipo1() {
		return tipo1;
	}

	public TipoInstrucao getTipo2() {
		return tipo2;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getRotulo() {
		return rotulo;
	}

	public String getIdentificador1() {
		return identificador1;
	}

	public void setIdentificador1(String identificador1) {
		this.identificador1 = identificador1;
	}

	public String getRotulo1() {
		return rotulo1;
	}

	public void setRotulo1(String rotulo1) {
		this.rotulo1 = rotulo1;
	}

	public String getIdentificador2() {
		return identificador2;
	}

	public void setIdentificador2(String identificador2) {
		this.identificador2 = identificador2;
	}

	public String getRotulo2() {
		return rotulo2;
	}

	public void setRotulo2(String rotulo2) {
		this.rotulo2 = rotulo2;
	}

	public void setTipo1(TipoInstrucao tipo1) {
		this.tipo1 = tipo1;
	}

	public void setTipo2(TipoInstrucao tipo2) {
		this.tipo2 = tipo2;
	}

}
