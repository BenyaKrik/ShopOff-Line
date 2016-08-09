/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.repo;

import org.springframework.data.repository.CrudRepository;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;

/**
 *
 * @author user
 */
public interface BrandRepo extends CrudRepository<Brand, Integer>{
    
}
