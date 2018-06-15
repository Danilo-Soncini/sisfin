/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dell-soncini
 */
public class dadosDAO {
   private String getAll ="SELECT name, sum(budget) gastos FROM userBudget " +
                "INNER JOIN category on idCategory = category.id " +
                "WHERE Year = 2018 and entrece = 0 " +
                "GROUP BY idCategory; "; 
   private String getAll2 ="SELECT month, avg(IF(idCategory =20,budget, null)) salario, avg(IF(idCategory =19,budget, null) ) hh FROM userBudget 	" +
"INNER JOIN category on idCategory = category.id " +
"WHERE Year = 2018 and entrece = 1 " +
"GROUP BY month " +
"order by month; "; 
   public String getAll(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String response = "{ \"gastos\" : [";
        String virgula= "";
        try {
            con = ConnectionFactory.getConnection();
           
            stmt = con.prepareStatement(getAll);
            rs = stmt.executeQuery();
            while(rs.next()){
               response = response + virgula + "[\""+ rs.getString("name") + "\"," + String.valueOf(rs.getDouble("gastos")) + "]";
               virgula = ",";
            }
            response = response + "] , \"ganhos\" :  [" ;
            virgula= "";
            con = ConnectionFactory.getConnection();
            
            stmt = con.prepareStatement(getAll2);
            rs = stmt.executeQuery();
            while(rs.next()){
               response = response + virgula + "[\""+ mesToString(rs.getInt("month")) + "\"," + String.valueOf(rs.getDouble("salario")) + "," + String.valueOf(rs.getDouble("hh"))+"]";
               virgula = ",";
            }
            response = response + "] }";
        } catch (Exception ex) {
            throw new RuntimeException("Erro. Origem="+ex.getMessage());
        } finally{
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};
        }
        return response;
    }
    public static String mesToString (int mes){
       switch (mes) {
           case 1:
               return "Janeiro";
           case 2:
               return "Fevereiro";
           case 3:
               return "Marco";
           case 4:
               return "Abril";
           case 5:
               return "Maio";
           case 6:
               return "Junho";
           case 7:
               return "Julho";
           case 8:
               return "Agosto";
           case 9:
               return "Setembro";
           case 10:
               return "Outubro";
           case 11:
               return "Novembro";
           case 12:
               return "Dezembro";
           default:
               return "";
       }
    }
}
