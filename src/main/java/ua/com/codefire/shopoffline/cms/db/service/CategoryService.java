/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.service;

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

}
