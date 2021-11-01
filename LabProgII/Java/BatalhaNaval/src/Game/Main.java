package Game;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		Jogador jogador1 = new Jogador();
		Jogador jogador2 = new Jogador();
		int x,y;
		Boolean acerto;
		
		System.out.println("Jogo de Batalha Naval");
		System.out.println("--> Para montar o tabuleiro escolha 3 posições \n    para os barcos da frota no formato \"x y\".");
		System.out.println("\nJogador 1: Monte seu tabuleiro!");
		for(int i=0;i<3;i++) {
			do {
				x = scanner.nextInt();
				y = scanner.nextInt();
			} while (jogador1.posicionarNavio(x, y)==false);
		}
		System.out.println("\nJogador 2: Monte seu tabuleiro!");
		for(int i=0;i<3;i++) {
			do {
				x = scanner.nextInt();
				y = scanner.nextInt();
			} while (jogador2.posicionarNavio(x, y)==false);
		}
		
		
		System.out.println("Vamos começar!");
		int rodada=1;
		while(jogador1.totalRestante>0 && jogador2.totalRestante>0) {
			System.out.printf("\n\nRODADA %d  (Digite s para sair)\n", rodada);
			System.out.println("Jogador 1: Qual area do campo 2 atacar? ");
			x = scanner.nextInt();
			y = scanner.nextInt();
			acerto = jogador2.atingirJogador(x,y);
			jogador1.atingirAdversario(x, y, acerto);
			System.out.println("Jogador 2: Qual area do campo 1 atacar? ");
			x = scanner.nextInt();
			y = scanner.nextInt();
			acerto = jogador1.atingirJogador(x,y);
			jogador2.atingirAdversario(x, y, acerto);
			System.out.printf("\nRESULTADO DA RODADA %d:\n", rodada);
			printarCampos(jogador1.campoJogador, jogador1.campoAdversario);
			rodada++;
		}	
		
		if(jogador1.totalRestante>jogador2.totalRestante) {
			System.out.println("\n\nVITÓRIA!!\nO Jogador 1 venceu!");
		} else {
			System.out.println("\n\nVITÓRIA!!\nO Jogador 2 venceu!");
		}
		scanner.close();
	}
	
	public static void printarCampos(char[][] campo, char[][] campoAdv) {
		System.out.println("Campo:                   Campo adversario:");
		System.out.println("  0 1 2 3 4 5 6 7 8 9      0 1 2 3 4 5 6 7 8 9");
		for(int i=0;i<10;i++) {
			System.out.printf("%d %c %c %c %c %c %c %c %c %c %c    ", i, campo[i][0],
					campo[i][1], campo[i][2], campo[i][3], campo[i][4], campo[i][5],
					campo[i][6], campo[i][7], campo[i][8], campo[i][9]);
			System.out.printf("%d %c %c %c %c %c %c %c %c %c %c\n", i, campoAdv[i][0],
					campoAdv[i][1], campoAdv[i][2], campoAdv[i][3], campoAdv[i][4], campoAdv[i][5],
					campoAdv[i][6], campoAdv[i][7], campoAdv[i][8], campoAdv[i][9]);
		}
	}

}
