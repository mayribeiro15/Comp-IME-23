package voo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import factory.ConnectionFactory;
import reservasaereas.Voo;

public class VooDAO {
	/*
	 * CRUD
	 * c: CREATE
	 * r: READ
	 * u: UPDATE
	 * d: DELETE
	 */

	//INSERT
	public void save(Voo voo) {
		String sql = "INSERT INTO voo(numeroVoo, aeroportoOrigem, aeroportoDestino, distanciaKm, modeloAviao, totalPoltronas, poltronasVagas, numeroAutorizacaoAnac) VALUES (?,?,?,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			//Criar uma PreparedStatement para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			//Adicionar os valores esperados pela query
			pstm.setString(1,  voo.getNumeroVoo());
			pstm.setString(2,  voo.getAeroportoOrigem());
			pstm.setString(3,  voo.getAeroportoDestino());
			pstm.setDouble(4,  voo.getDistanciaKm());
			pstm.setString(5,  voo.getModeloAviao());
			pstm.setInt(6,  voo.getTotalPoltronas());
			pstm.setInt(7,  voo.getTotalPoltronas());
			pstm.setString(8,  voo.getNumeroAutorizacaoAnac());
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
	public List<Voo> getVoos() {
		String sql = "SELECT * FROM VOO";
		List<Voo> voos = new ArrayList<Voo>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//Classe que recupera os dados do banco
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Voo voo = new Voo();
				// Recuperar o id
				voo.setId(rset.getInt("id"));
				// Recuperar o numeroVoo
				voo.setNumeroVoo(rset.getString("numeroVoo"));
				// Recuperar o aeroportoOrigem
				voo.setAeroportoOrigem(rset.getString("aeroportoOrigem"));
				// Recuperar o aeroportoDestino
				voo.setAeroportoDestino(rset.getString("aeroportoDestino"));
				// Recuperar a distanciaKm
				voo.setDistanciaKm(rset.getDouble("distanciaKm"));
				// Recuperar o modeloAviao
				voo.setModeloAviao(rset.getString("modeloAviao"));
				// Recuperar o totalPoltronas
				voo.setTotalPoltronas(rset.getInt("totalPoltronas"));
				// Recuperar o poltronasVagas
				voo.setPoltronasVagas(rset.getInt("poltronasVagas"));
				// Recuperar o numeroAutorizacaoAnac
				voo.setNumeroAutorizacaoAnac(rset.getString("numeroAutorizacaoAnac"));
				voos.add(voo);
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
		return voos;	
	}
	
	//UPDATE
	public void update(Voo voo) {
		String sql = "UPDATE voo SET numeroVoo = ?, aeroportoOrigem = ?, aeroportoDestino = ?, distanciaKm = ?, modeloAviao = ?, totalPoltronas = ?, numeroAutorizacaoAnac = ? WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			// Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			// Adiciocnar os valores para atualizar
			pstm.setString(1,  voo.getNumeroVoo());
			pstm.setString(2,  voo.getAeroportoOrigem());
			pstm.setString(3,  voo.getAeroportoDestino());
			pstm.setDouble(4,  voo.getDistanciaKm());
			pstm.setString(5,  voo.getModeloAviao());
			pstm.setInt(6,  voo.getTotalPoltronas());
			pstm.setString(7,  voo.getNumeroAutorizacaoAnac());
			pstm.setInt(10,  voo.getId());
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
	}
	
	//DELETE
	public void deleteByID(int id) {
		String sql = "DELETE FROM voo WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
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
