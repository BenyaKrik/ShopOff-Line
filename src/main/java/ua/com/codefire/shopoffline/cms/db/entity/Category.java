/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author user
 */
//@Entity
//@Table(name = "category", uniqueConstraints = {
//    @UniqueConstraint(columnNames = "url")
//})
//
//public class Category implements Serializable {
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    @Column(name = "url", unique = true)
//    private String url;
//    private String name;
//    private Integer parent_id;
//    @OneToMany(mappedBy = "category")
//    private List<Category> categoryList;
//
//    public List<Category> getCategoryList() {
//        return categoryList;
//    }
//
//    public void setCategoryList(List<Category> categoryList) {
//        this.categoryList = categoryList;
//    }
//
//    public Category() {
//    }
//
//    public Category(Integer id, String url, String name, Integer parent_id) {
//        this.id = id;
//        this.url = url;
//        this.name = name;
//        this.parent_id = parent_id;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getParent_id() {
//        return parent_id;
//    }
//
//    public void setParent_id(Integer parent_id) {
//        this.parent_id = parent_id;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 47 * hash + Objects.hashCode(this.id);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Category other = (Category) obj;
//        if (!Objects.equals(this.url, other.url)) {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name)) {
//            return false;
//        }
//        if (!Objects.equals(this.id, other.id)) {
//            return false;
//        }
//        if (!Objects.equals(this.parent_id, other.parent_id)) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "Category{" + "id=" + id + ", url=" + url + ", name=" + name + ", parent_id=" + parent_id + '}';
//    }
//
//}
