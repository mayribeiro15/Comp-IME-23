package passageiro.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import reservasaereas.Passageiro;
import voo.dao.VooDAO;

public class PassageiroDAO {
	/*
	 * CRUD
	 * c: CREATE
	 * r: READ
	 * u: UPDATE
	 * d: DELETE
	 */

	//INSERT
	public void save(Passageiro passageiro) {
		String sql = "INSERT INTO passageiro(numeroFidelidade, categoriaFidelidade, nome, email, cpf, sexo, passaporte, dataNascimento, idVoo) VALUES (?,?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setInt(1,  passageiro.getNumeroFidelidade());
			pstm.setString(2,  passageiro.getCategoriaFidelidade());
			pstm.setString(3,  passageiro.getNome());
			pstm.setString(4,  passageiro.getEmail());
			pstm.setString(5,  passageiro.getCpf());
			pstm.setString(6,  passageiro.getSexo());
			pstm.setString(7,  passageiro.getPassaporte());
			pstm.setString(8,  passageiro.getDataNascimento());
			pstm.setInt(9, passageiro.getIdVoo());
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		sql = "UPDATE voo SET poltronasVagas = poltronasVagas-1 WHERE id=?";		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setInt(1, passageiro.getIdVoo());
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//SELECT
	public List<Passageiro> getPassageiros() {
		String sql = "SELECT * FROM PASSAGEIRO";
		List<Passageiro> passageiros = new ArrayList<Passageiro>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Passageiro passageiro = new Passageiro();
				// Recuperar o id
				passageiro.setId(rset.getInt("id"));
				// Recuperar o numeroFidelidade
				passageiro.setNumeroFidelidade(rset.getInt("numeroFidelidade"));
				// Recuperar a categoriaFidelidade
				passageiro.setCategoriaFidelidade(rset.getString("categoriaFidelidade"));
				// Recuperar o nome
				passageiro.setNome(rset.getString("nome"));
				// Recuperar o email
				passageiro.setEmail(rset.getString("email"));
				// Recuperar o cpf
				passageiro.setCpf(rset.getString("cpf"));
				// Recuperar o sexo
				passageiro.setSexo(rset.getString("sexo"));
				// Recuperar o passaporte
				passageiro.setPassaporte(rset.getString("passaporte"));
				// Recuperar o dataNascimento
				passageiro.setDataNascimento(rset.getString("dataNascimento"));
				// Recuperar o id do Voo
				passageiro.setIdVoo(rset.getInt("idVoo"));
				passageiros.add(passageiro);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return passageiros;
	}
	
	//UPDATE
	public void update(Passageiro passageiro) {
		String sql = "SELECT * FROM passageiro WHERE id = ?";
		int idVoo = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, passageiro.getId());
			rset = pstm.executeQuery();
			while (rset.next()) {
				idVoo = rset.getInt("idVoo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		sql = "UPDATE voo SET poltronasVagas = poltronasVagas+1 WHERE id=?";		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setInt(1, idVoo);
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sql = "UPDATE passageiro SET numeroFidelidade = ?, categoriaFidelidade = ?, nome = ?, email = ?, cpf = ?, sexo = ?, passaporte = ?, dataNascimento = ? , idVoo = ? WHERE id = ?";
		try {
			// Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			// Adiciocnar os valores para atualizar
			pstm.setInt(1,  passageiro.getNumeroFidelidade());
			pstm.setString(2,  passageiro.getCategoriaFidelidade());
			pstm.setString(3,  passageiro.getNome());
			pstm.setString(4,  passageiro.getEmail());
			pstm.setString(5,  passageiro.getCpf());
			pstm.setString(6,  passageiro.getSexo());
			pstm.setString(7,  passageiro.getPassaporte());
			pstm.setString(8,  passageiro.getDataNascimento());
			pstm.setInt(9,  passageiro.getIdVoo());
			pstm.setInt(10,  passageiro.getId());
			// Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sql = "UPDATE voo SET poltronasVagas = poltronasVagas-1 WHERE id=?";		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setInt(1, passageiro.getIdVoo());
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//DELETE
	public void deleteByID(int id) {	
		String sql = "SELECT * FROM passageiro WHERE id = ?";
		int idVoo = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();
			while (rset.next()) {
				idVoo = rset.getInt("idVoo");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		sql = "UPDATE voo SET poltronasVagas = poltronasVagas+1 WHERE id=?";		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setInt(1, idVoo);
			//Executar a query
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sql = "DELETE FROM passageiro WHERE id = ?";	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
