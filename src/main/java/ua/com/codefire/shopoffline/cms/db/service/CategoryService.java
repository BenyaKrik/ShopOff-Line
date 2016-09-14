/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codefire.shopoffline.cms.db.entity.Category;
import ua.com.codefire.shopoffline.cms.db.repo.CategoryRepo;

/**
 *
 * @author user
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> parentCategoryList() {

        return (List<Category>) categoryRepo.findByParentIsNull();

    }

    public static List<Category> getCategoryChild(List<Category> categoryList) {
        List<Category> flatList = new ArrayList<>();
        
        for (Category category : categoryList) {
            flatList.add(category);
            
            List<Category> categoryChild = getCategoryChild(category.getCategoryList());
            
            flatList.addAll(categoryChild);
        }
 
        return flatList;
    }

    public void removeCategory(int id) {
        categoryRepo.delete(id);
    }

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category getCategory(int id) {
        return categoryRepo.findOne(id);
    }

    public Category findBrandByUrl(String url) {
        return categoryRepo.findByUrl(url);
    }

}
