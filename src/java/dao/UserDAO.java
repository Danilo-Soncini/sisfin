/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dell-soncini
 */
public class UserDAO {
    private final String insertStm = "INSERT INTO user (name,password,email, created_at,updated_at) VALUES (?,md5(?),?, now(), now())";
    private final String updateStm = "UPDATE user SET  name = ? ,password = IF(? = password, password, md5(?)),email = ? , updated_at=now() WHERE id =  ?";
    private final String deleteStm = "DELETE FROM user WHERE id = ?";
    private final String getAll = "SELECT * FROM user ORDER BY id DESC";
    private final String getByEmailPass = "SELECT * FROM user WHERE email = ? AND password = md5(?) ORDER BY id DESC";
    private final String getById = "SELECT * FROM user WHERE id = ?";
    
    public User insert(User user){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertStm, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getEmail());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            user.setId(rs.getInt(1));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao inserir um user no banco de dados. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return user;
    }
    
    public void update(User user){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(updateStm);
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setInt(5, user.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public void delete(User user){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(deleteStm);
            stmt.setInt(1, user.getId());
            stmt.executeUpdate();
            //TODO deletear pedidos do cliente
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public ArrayList<User> getAll(){
        ArrayList<User> Users = new ArrayList<User>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getAll);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String nome = rs.getString("name");
                String password = rs.getString("password");
                String email = rs.getString("email");
                User cli = new User(id, nome, email, password);
                Users.add(cli);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return Users;
    }
    
    public User getByEmailPassword(String email, String password){
        User c = new User();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getByEmailPass);
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPassword(rs.getString("password"));
            }
            else{
                return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return c;
    }
    
    public User getById(int id){
        User c = new User();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getById);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setEmail(rs.getString("email"));
                c.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return c;
    }
}
