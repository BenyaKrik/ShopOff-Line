/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.repo.BrandRepo;

/**
 *
 * @author user
 */
@Service
@Transactional(readOnly = true)
public class BrandService {

    @Autowired
    private BrandRepo brandRepo;

    public List<Brand> getBrandList() {
        return (List<Brand>) brandRepo.findAll();
    }

    @Transactional(readOnly = false)
    public void removeBrand(int id) {
        brandRepo.delete(id);
    }

    public Brand getBrand(int id) {
        return (Brand) brandRepo.findOne(id);
    }

    @Transactional(readOnly = false)
    public Brand save(Brand brand) {
        return brandRepo.save(brand);
    }

    
}
