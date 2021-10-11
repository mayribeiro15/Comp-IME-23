package br.eb.ime.agenda.aplicacao;

import br.eb.ime.agenda.dao.ContatoDAO;
import br.eb.ime.agenda.model.Contatos;

public class Main {
    public static void main(String[] args){
        ContatoDAO contatoDAO = new ContatoDAO(); //realiza o CRUD

        Contatos contato = new Contatos();
        contato.setNome("Amanda");
        contato.setIdade(21);
        contatoDAO.saveContato(contato);

        for(Contatos c: contatoDAO.getContatos()){
            System.out.println("Contato: "+  c.getId() + c.getNome());
        }

        System.out.println("Atualizando...");
            
        Contatos contato1 = new Contatos();
        contato1.setNome("Mayara Ribeiro");
        contato1.setIdade(22);
        contato1.setId(1);
        contatoDAO.updateContato(contato1);

        for(Contatos c: contatoDAO.getContatos()){
            System.out.println("Contato: "+  c.getId() + c.getNome());
        }
    }
}
