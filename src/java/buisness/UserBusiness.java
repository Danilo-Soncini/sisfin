/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buisness;

import dao.UserDAO;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author dell-soncini
 */
public class UserBusiness {
    public static User getByEmailPassword(String email, String password)
    {
        UserDAO userDAO = new UserDAO();
        return userDAO.getByEmailPassword(email, password);
    }
    public static User getById(int id)
    {//
        UserDAO userDAO = new UserDAO();
        return userDAO.getById(id);
    }
    public static void update(User user)
    {//
        UserDAO userDAO = new UserDAO();
        userDAO.update(user);
    }
    public static void insert(User user)
    {//
        UserDAO userDAO = new UserDAO();
        userDAO.insert(user);
    }
    public static ArrayList<User> getAll()
    {
        UserDAO userDAO = new UserDAO();
        return userDAO.getAll();
    }
}
