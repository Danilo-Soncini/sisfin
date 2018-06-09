/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buisness;

import dao.CategoryDAO;
import java.util.ArrayList;
import model.Category;

/**
 *
 * @author dell-soncini
 */
public class CategoryBusiness {
     public static ArrayList<Category> getAll()
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        return categoryDAO.getAll();
    }
    public static Category getById(int idCategory)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        return categoryDAO.getById(idCategory);
    }
    
    public static void update(Category category)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        categoryDAO.update(category);
    }
    public static Category  insert(Category category)
    {
        CategoryDAO categoryDAO = new CategoryDAO();
        return categoryDAO.insert(category);
    }
}
