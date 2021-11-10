package passageiro.aplicacao;

import passageiro.dao.PassageiroDAO;
import reservasaereas.*;

public class MainPassageiro {
	public static void main(String[] args) {
		Passageiro p1 = new Passageiro();
		p1.setNome("Mayara");	
		p1.setNumeroFidelidade(12345);
		p1.setCategoriaFidelidade("Diamante");
		p1.setEmail("mayara.ribeiro@ime.eb.br");
		p1.setSexo("F");
		p1.setPassaporte("32086539568");
		
		//Inserir os dados do passageiro p1 no banco
		PassageiroDAO passageiroDao = new PassageiroDAO();
		passageiroDao.save(p1);
		
		//Atualizar o passageiro
		Passageiro p2 = new Passageiro();
		p2.setNome("Mayara Ribeiro");
		p2.setCategoriaFidelidade("Platina");
		
		//ID do passageiro na tabela passageiro
		p2.setId(8);
		passageiroDao.update(p2);
		
		//Deletar o passageiro do banco
		passageiroDao.deleteByID(8);
		
		//Visualização dos registros do Banco de Dados
		for (Passageiro p: passageiroDao.getPassageiros()) {
			System.out.println("Passageiro: " + p.getNome() + " da categoria " + p.getCategoriaFidelidade());
		}
	}
}
