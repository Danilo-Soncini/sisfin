/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author dell-soncini
 */
public class UseBudget {
    int id;
    Category category;
    User user;
    int Year;
    int month;
    double  budget;
    Date created_at;
    Date update_at;

    public UseBudget() {
    }

    public UseBudget(int id, Category category, User user, int Year, int month, double budget, Date created_at, Date update_at) {
        this.id = id;
        this.category = category;
        this.user = user;
        this.Year = Year;
        this.month = month;
        this.budget = budget;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public User getUser() {
        return user;
    }

    public int getYear() {
        return Year;
    }

    public int getMonth() {
        return month;
    }

    public double getBudget() {
        return budget;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
    
    
}
