/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Category;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.CategoryService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private BrandService brandService;


    @RequestMapping("/")
    public String getRoot(Model model) {

        List<Category> parentCategoryList = categoryService.parentCategoryList();
        model.addAttribute("categories", parentCategoryList);

        return "admin/category/index";
    }

    @RequestMapping("/{url}")
    public String getByUrl(Model model, @PathVariable("url") String url) {

        Category category = categoryService.findBrandByUrl(url);
        model.addAttribute("products", category.getProductList());
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);
        model.addAttribute("category", category);
        

            return "showcase";
    }

    @RequestMapping("/{filter:(\\d+-?)+}") // 123-1223
    public String getByFilter(Model model, @PathVariable String filter) {
        List<String> filters = Arrays.asList(filter.split("-"));
        
        return "showcase";
    }
    
    @ExceptionHandler
    public void errorHandler(Throwable exception) {
        exception.printStackTrace();
    }

}
