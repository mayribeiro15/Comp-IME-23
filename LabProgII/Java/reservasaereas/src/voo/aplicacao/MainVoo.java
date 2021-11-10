package voo.aplicacao;

import voo.dao.VooDAO;
import reservasaereas.Voo;

public class MainVoo {
	public static void main(String[] args) {
		Voo v1 = new Voo();
		v1.setAeroportoOrigem("Porto Seguro");
		v1.setAeroportoDestino("Galeão");
		v1.setNumeroVoo("W321");
		v1.setDistanciaKm(1345.8);
		v1.setModeloAviao("Boeing 767");
		v1.setTotalPoltronas(125);
		v1.setPoltronasVagas(125);
	    v1.setNumeroAutorizacaoAnac("ABC-123456");

		
		//Inserir os dados do voo v1 no banco
		VooDAO vooDao = new VooDAO();
		vooDao.save(v1);
		
		//Atualizar o voo
		Voo v2 = new Voo();
		v2.setNumeroVoo("Z432");
		v2.setTotalPoltronas(100);
		v2.setModeloAviao("Boeing 777");
		
		//ID do voo na tabela voo
		v2.setId(8);
		vooDao.update(v2);
		
		//Deletar o voo do banco
		vooDao.deleteByID(8);
		
		//Visualização dos voos do Banco de Dados
		for (Voo v: vooDao.getVoos()) {
			System.out.println("Voo de número: " + v.getNumeroVoo() + " de modelo " + v.getModeloAviao() + " que comporta " + v.getTotalPoltronas() + " passageiros");
		}
	}
}
