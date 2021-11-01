package Game;

public class Jogador {
	int id;
	char[][] campoJogador = new char[10][10]; //visao do jogador
	char[][] campoAdversario = new char[10][10]; //visao do adversario
	int totalAbatidos = 0;
	int totalRestante = 3;
	
	public Boolean atingirJogador(int linha, int coluna) {
		if(campoJogador[linha][coluna]=='1') {
			this.totalAbatidos++;
			this.totalRestante--;
			campoJogador[linha][coluna]='X';
			return true;
		} 
		campoJogador[linha][coluna]='~';
		return false;
	}
	
	public void atingirAdversario(int linha, int coluna, Boolean ans) {
		if(ans) {
			campoAdversario[linha][coluna]='X';
			return;
		} 
		campoAdversario[linha][coluna]='~';
	}
	
	public Boolean posicionarNavio(int linha, int coluna) {
		if (this.campoJogador[linha][coluna] == '1') {
			System.out.printf("--> Posição ocupada, tente novamente!\n");
			return false;
		}
		this.campoJogador[linha][coluna]='1';
		System.out.printf("--> Barco adicionado em (%d,%d)\n",linha,coluna);
		return true;		
	}
}