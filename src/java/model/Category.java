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
public class Category {
    int id;
    String name;
    String description;
    int Parent;
    boolean entrece;
    Date created_at;
    Date updated_at;
    public Category(){}
    public Category(int id, String name, String description, boolean entrece) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.entrece = entrece;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getParent() {
        return Parent;
    }

    public boolean isEntrece() {
        return entrece;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setParent(int Parent) {
        this.Parent = Parent;
    }

    public void setEntrece(boolean entrece) {
        this.entrece = entrece;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
