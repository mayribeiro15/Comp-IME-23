package app;

import java.util.Scanner;

public class Unidade {
	 public float main(Scanner sc) {
		 float pDesc = 0.1f; 
		 float totalPagar = 0.0f; 
		 float frete = 5.0f; 
		 int preco = 0;
		 
		 System.out.print("entre com o pre?o de um produto (valor inteiro): ");
		 preco = sc.nextInt();
		 System.out.print(preco+"\n");
		 
		 while (preco != -1) {
			 totalPagar = totalPagar + preco;
			 System.out.print("entre com o pre?o de um produto (valor inteiro): ");
			 preco = sc.nextInt();
			 System.out.print(preco+"\n");
		 }
			 
		 if (totalPagar>15.0 && totalPagar<= 70.0) 
			 pDesc = pDesc + 0.1f;
		 float valorDesconto = totalPagar * pDesc;
			 
		 if (totalPagar > 50.0) 
			 frete = 0.0f;
			
		totalPagar = totalPagar - valorDesconto + frete;
		sc.close();
		
		return totalPagar;
	 }
}
