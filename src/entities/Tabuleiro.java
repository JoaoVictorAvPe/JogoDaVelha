package entities;

import entities.enums.Tipo;

public class Tabuleiro {

	Piece[][] tab = new Piece[3][3];

	public Tabuleiro() {
	}

	public void getGame(){
		System.out.println();
		for (byte i = 0; i < tab.length; i++) {
			System.out.print(i + " -- ");
			for (byte j = 0; j < tab[i].length; j++) {
				if (tab[i][j] == null) {
					System.out.print(' ');
				} else {
					System.out.print(tab[i][j]);
				}
				if (j < tab[i].length - 1) {
					System.out.print(" | ");
				}
			}
			System.out.println();
			if (i < tab.length - 1) {
				System.out.println();
			}
		}
		System.out.print("\n     ");
		for (byte i = 0; i < 3; i++) {
			System.out.print(i + "   ");
		}
	}
	
	public void addPeca(Tipo tipo, String posicao) {
		int i = Integer.parseInt(posicao.substring(0, 1));
		int j = Integer.parseInt(posicao.substring(1));
		Piece piece = new Piece(tipo, i, j);
		if (tab[i][j] != null) {
			throw new GameException("Posicao " + i + j + " ja esta ocupada por " + tab[i][j].getTipo());
		} else {
		tab[i][j] = piece;
		}
	}
	
	public boolean vitoriaCheck() {
		for(int i=0; i<3; i++) {
			if (verificaLinha(i, 0)) {
				return true;
			}
		}	
		for(int j=0; j<3; j++) {
			if (verificaColuna(0, j)) {
				return true;
			}
		}
		if (verificaDiagonalPrincipal() || verificaDiagonalSecundaria()) {
			return true;
		}
		return false;
	}	
	
	private boolean verificaLinha(int i, int j) {
		Piece p1 = tab[i][j];
		Piece p2 = tab[i][j+1];
		Piece p3 = tab[i][j+2];
		if (p1 == null || p2 == null || p3 == null) {
			return false;
		} 
		else if(p1.getTipo() == p2.getTipo() && p2.getTipo() == p3.getTipo()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	private boolean verificaColuna(int i, int j) {
		Piece p1 = tab[i][j];
		Piece p2 = tab[i+1][j];
		Piece p3 = tab[i+2][j];
		if (p1 == null || p2 == null || p3 == null) {
			return false;
		} 
		else if(p1.getTipo() == p2.getTipo() && p2.getTipo() == p3.getTipo()) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	private boolean verificaDiagonalPrincipal() {
		Piece p1 = tab[0][0];
		Piece p2 = tab[1][1];
		Piece p3 = tab[2][2];
		if (p1 == null || p2 == null || p3 == null) {
			return false;
		}
		else if(p1.getTipo() == p2.getTipo() && p2.getTipo() == p3.getTipo()) {
			return true;
		} 
		return false;
	}
	
	private boolean verificaDiagonalSecundaria() {
		Piece p1 = tab[0][2];
		Piece p2 = tab[1][1];
		Piece p3 = tab[2][0];
		if (p1 == null || p2 == null || p3 == null) {
			return false;
		}
		else if(p1.getTipo() == p2.getTipo() && p2.getTipo() == p3.getTipo()) {
			return true;
		} 
		return false;
	}

}
