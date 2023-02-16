package entities;

import entities.enums.Tipo;

public class Piece {
	
	private Tipo tipo;
	private int linha;
	private int coluna;
	
	public Piece(Tipo tipo, int linha, int coluna) {
		this.tipo = tipo;
		this.linha = linha;
		this.coluna = coluna;
	}

	public Tipo getTipo() {
		return tipo;
	}	
	
	
	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public String toString() {
		return tipo.toString();
	}
	
}
