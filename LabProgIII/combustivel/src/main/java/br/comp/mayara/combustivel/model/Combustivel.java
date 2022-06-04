package br.comp.mayara.combustivel.model;

public class Combustivel {
    public int calculo(int n){
        if(n<2) return n;
        return calculo(n-1) + calculo(n-2);
    }
}
