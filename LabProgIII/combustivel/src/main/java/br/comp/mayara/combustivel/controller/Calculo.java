package br.comp.mayara.combustivel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.comp.mayara.combustivel.model.Combustivel;

@RestController
@RequestMapping(value="/calculo")
public class Calculo {

    @GetMapping(value="/{n}")
    public String calculoFibonacci(@PathVariable String n){
        int valorCalculado = (new Combustivel()).calculo(Integer.parseInt(n));
        String resposta = "O valor do termo de ordem ";
        resposta += n;
        resposta += " da série de Fibonacci vale ";
        resposta += String.valueOf(valorCalculado);
        return resposta;
    }
}