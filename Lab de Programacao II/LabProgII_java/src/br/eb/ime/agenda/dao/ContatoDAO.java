package br.eb.ime.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.eb.ime.agenda.factory.ConnectionFactory;
import br.eb.ime.agenda.model.Contatos;

public class ContatoDAO {
    //CRUD - create, read, update, delete
    public void saveContato(Contatos contato){
        String sql = "INSERT INTO contatos(nome, idade) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstn = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, contato.getNome());
            pstn.setInt(2, contato.getIdade());

            pstn.execute();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(pstn!=null){
                    pstn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Contatos> getContatos() {
        String sql = "SELECT * FROM contatos";

        List<Contatos> contatos = new ArrayList<Contatos>();

        Connection conn = null;
        PreparedStatement pstn = null;

        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstn = conn.prepareStatement(sql);
            rset = pstn.executeQuery();

            while(rset.next()) {
                Contatos contato = new Contatos();
                contato.setId(rset.getInt("id"));
                contato.setNome(rset.getString("nome"));
                contato.setIdade(rset.getInt("idade"));
                contatos.add(contato);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstn!=null){
                    pstn.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        return contatos;
    } 

    public void updateContato(Contatos contato){
        String sql = "UPDATE contatos SET nome = ?, idade = ? " + "WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstn = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstn = conn.prepareStatement(sql);
            pstn.setString(1, contato.getNome());
            pstn.setInt(2, contato.getIdade());
            pstn.setInt(3, contato.getId());

            pstn.execute();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(pstn!=null){
                    pstn.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void deleteContato(int id){
        String sql = "DELETE FROM contatos WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstn = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstn = conn.prepareStatement(sql);
            pstn.setInt(1, id);

            pstn.execute();
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(pstn!=null){
                    pstn.close();
                }
                if(conn!=null){
                    conn.close();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
