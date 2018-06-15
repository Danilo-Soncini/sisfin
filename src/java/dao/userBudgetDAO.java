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
import java.util.Collections;
import model.UseBudget;

/**
 *
 * @author dell-soncini
 */
public class userBudgetDAO {
     private String getAll = "SELECT * FROM userBudget WHERE idUser = ? AND year = ? AND month = ?";
     private String select = "SELECT * FROM userBudget WHERE idUser = ? AND year = ? AND month = ? AND idCategory = ?";
     private String insert = "INSERT INTO userBudget (idUser, year, month, idCategory, budget) VALUES (?,?,?,?,?) ";
     private String update = "UPDATE userBudget SET budget = ? WHERE id =  ?";
     
     public ArrayList<UseBudget> get(int idUser, int month, int year){
        ArrayList<UseBudget> Users = new ArrayList<UseBudget>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(getAll);
            stmt.setInt(1,idUser);
            stmt.setInt(3, month);
            stmt.setInt(2, year);
            
            rs = stmt.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                //int idUser = rs.getInt("idUser");
                int idCategory = rs.getInt("idCategory");
                double value = rs.getDouble("budget");
                //int month = rs.getInt("month");
                //int year = rs.getInt("year");
                UseBudget cli = new UseBudget( id,  idCategory,  idUser,  year,  month,  value);
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
    public UseBudget select(UseBudget user){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(select);
            stmt.setInt(1,user.getIdUser());
            stmt.setInt(4, user.getIdCategory());
            stmt.setInt(3, user.getMonth());
            stmt.setInt(2, user.getYear());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt("id"));
                //int idUser = rs.getInt("idUser");
                user.setIdCategory(rs.getInt("idCategory"));
                user.setBudget(rs.getDouble("budget"));
                //int month = rs.getInt("month");
                //int year = rs.getInt("year");
                return user;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return user;
    }
    public void update(UseBudget user){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(update);
            
            stmt.setDouble(1, user.getBudget());
            stmt.setInt(2, user.getId());
            //stmt.setInt(3, user.getId());
            stmt.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException("Erro Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
    }
    
    public UseBudget insert(UseBudget user){
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            
            stmt.setInt(1, user.getIdUser());
            stmt.setInt(2, user.getYear());
            stmt.setInt(3, user.getMonth());
            stmt.setInt(4, user.getIdCategory());
            stmt.setDouble(5, user.getBudget());
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
    
    public UseBudget upInsert(UseBudget user){
        double budget = user.getBudget();
        user = select(user);
        if(user.getId() > 0){
            user.setBudget(budget);
            update(user);
        }
        else{
            insert(user);
        }
        return user;        
    }
    
}
