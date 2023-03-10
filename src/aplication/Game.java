package aplication;

import java.util.Scanner;

import entities.GameException;
import entities.Tabuleiro;
import entities.enums.Tipo;

public class Game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Tabuleiro tab = new Tabuleiro();
		
		Tipo peca = null;
		int jogadas = 1;
		
		while(jogadas <= 9 && !tab.vitoriaCheck()) {
			try {
				clearScreen();
				tab.getGame();
				if (jogadas%2 != 0) {
					System.out.println("\n\nJogador: X");
					peca = Tipo.X;
				} else {
					System.out.println("\n\nJogador: O");
					peca = Tipo.O;
				}
				System.out.print("\nPosicao: ");
				String posicao = sc.next();
				tab.addPeca(peca, posicao);
				jogadas++;
			}
			catch(GameException e) {
				System.out.println("\n" + e.getMessage() + "\nAperte ENTER para continuar");
				sc.nextLine();
				sc.nextLine();
			}
			catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\nCoordenada digitada invalida\nAperte ENTER para continuar");
				sc.nextLine();
				sc.nextLine();
			}
			catch (NumberFormatException e) {
				System.out.println("\nDigite dois numeros juntos no formato: yx\nAperte ENTER para continuar");
				sc.nextLine();
				sc.nextLine();
			}
		}
		
		if (jogadas >= 9 && !tab.vitoriaCheck()) {
			clearScreen();
			tab.getGame();
			System.out.println("\n\nVELHA");
		} 
		else {
			clearScreen();
			tab.getGame();
			if (jogadas%2 == 0) {
			System.out.println("\n\nVencedor: X");
			} else {
				System.out.println("\n\nVencedor: O");
			}
		}
		
		sc.close();
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}
