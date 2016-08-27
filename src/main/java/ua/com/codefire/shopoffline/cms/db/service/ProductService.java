/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.repo.BrandRepo;
import ua.com.codefire.shopoffline.cms.db.repo.ProductRepo;

/**
 *
 * @author user
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private BrandRepo brandRepo;

    public List<Product> getProductList() {

        return (List<Product>) productRepo.findAll();
    }

    public List<Product> filterBrandList(String name) {
        return (List<Product>) productRepo.findByBrandName(name);
    }

    public void removeProduct(int id) {

        productRepo.delete(id);
    }

    public Product get(int id) {
        return productRepo.findOne(id);
    }
     
    public Product save(Product  product) {
        return productRepo.save(product);
    }
//    public List<Product> getProductsByCategory(int category_id){
//    
//    }

}
