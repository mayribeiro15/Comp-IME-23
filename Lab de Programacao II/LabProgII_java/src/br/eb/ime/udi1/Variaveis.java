package br.eb.ime.udi1;

public class Variaveis {
    public static void vars(String[] args) {
        byte idade01=20;
        short idade02=21;
        int idade03=22;
        long idade04 = 23;

        System.out.println("Valor de idade01="+idade01);
        System.out.println("Valor de idade02="+idade02);
        System.out.println("Valor de idade03="+idade03);
        System.out.println("Valor de idade04="+idade04);

        double valorLivro = 7.9;
        float valorCurso = 3.4F;
        System.out.println("Valor do Livro = " + valorLivro);
        System.out.println("Valor do Curso = " + valorCurso);


        char o = 111;
        char i = 105;
        char interrogacao = 63; // valor '?'

        System.out.println(o+i); // Desta forma ele soma os valores da variável
        System.out.println(""+o+i); // Desta forma ele imprime 'oi'
        System.out.println(""+o+i+interrogacao); // Desta forma ele imprime no final interrogação

        boolean verdadeiro = true;
        boolean falso = false;

        System.out.println("O valor de verdadeiro é " + verdadeiro);
        System.out.println("O valor de falso é " + falso);

        int var1 = 2147483647;
        int var2 = 1;

        System.out.println(var1 + var2); //Overflow
    }
}