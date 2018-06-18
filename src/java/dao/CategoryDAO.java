/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author dell-soncini
 */
public class CategoryDAO {
    public Category getById(int idCategory){
       return new Category(); 
    }
    public List<Category> getAll(){
       return new ArrayList<Category>(); 
    }
    public boolean insert (Category category){
        return false;
    }
    public boolean update(Category category){
        return false;
    }
}
