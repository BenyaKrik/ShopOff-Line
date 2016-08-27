/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ua.com.codefire.shopoffline.cms.db.entity.Category;

/**
 *
 * @author user
 */
public interface CategoryRepo extends CrudRepository<Category, Integer> {

    public List<Category> findByParentIsNull();
    
    public Category findByUrl(String url);
    
}
