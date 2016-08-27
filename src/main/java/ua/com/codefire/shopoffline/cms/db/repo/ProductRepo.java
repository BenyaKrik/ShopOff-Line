/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import ua.com.codefire.shopoffline.cms.db.entity.Product;

/**
 *
 * @author user
 */
public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findByBrandName(String name);
    
//    List<Product> findByCategory_IdOrCategory_Parent_Id(int category_id);
    
}
