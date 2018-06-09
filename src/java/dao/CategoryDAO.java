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
import model.Category;
import model.User;

/**
 *
 * @author dell-soncini
 */
public class CategoryDAO {
    private final String insertStm = "INSERT INTO category (name,description,entrece, created_at,updated_at) VALUES (?,?,?, now(), now())";
    private final String updateStm = "UPDATE category SET  name = ? ,description = ?,entrece = ? , updated_at=now() WHERE id =  ?";
    private final String deleteStm = "DELETE FROM user WHERE id = ?";
    private final String getAll = "SELECT * FROM category ORDER BY id DESC";
    private final String getByEmailPass = "SELECT * FROM user WHERE email = ? AND password = md5(?) ORDER BY id DESC";
    private final String getById = "SELECT * FROM category WHERE id = ?";
    
    public Category getById(int idCategory){
        Category c = new Category();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getById);
            stmt.setInt(1, idCategory);
            rs = stmt.executeQuery();
            if(rs.next()){
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescription(rs.getString("description"));
                c.setEntrece(rs.getBoolean("entrece"));
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return c;
    }
    public ArrayList<Category> getAll(){
        ArrayList<Category> Categories = new ArrayList<Category>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getAll);
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean entrece = rs.getBoolean("entrece");
                Category category = new Category(id, name, description, entrece);
                Categories.add(category);
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return Categories;
    }
    public Category insert (Category category){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insertStm, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setBoolean(3, category.isEntrece());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            category.setId(rs.getInt(1));
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return category;
    }
    public void update(Category category){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(updateStm);
            
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
            stmt.setBoolean(3, category.isEntrece());
            stmt.setInt(4, category.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
}
