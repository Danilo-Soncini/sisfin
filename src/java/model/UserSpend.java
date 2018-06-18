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
public class UserSpend {
    int id;
    Category category;
    User user;
    Date date;
    double amount;
    Date created_at;
    Date updated_at;

    public UserSpend(int id, Category category, User user, Date date, double amount, Date created_at, Date updated_at) {
        this.id = id;
        this.category = category;
        this.user = user;
        this.date = date;
        this.amount = amount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public UserSpend() {
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

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    
    
}
