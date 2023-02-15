package entities;

public class Piece {
	
	private String name;
	private int linha;
	private int coluna;
	
	public Piece(String name, int linha, int coluna) {
		this.name = name;
		this.linha = linha;
		this.coluna = coluna;
	}

	public String getName() {
		return name;
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
		return name;
	}
	
}
