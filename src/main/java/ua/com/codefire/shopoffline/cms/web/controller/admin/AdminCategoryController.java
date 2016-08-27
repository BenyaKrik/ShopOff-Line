/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller.admin;

 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping(value = "/admin/category")
public class AdminCategoryController {
@Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String getRoot(Model model) {
List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);
        List<Category> parentCategoryList = categoryService.parentCategoryList();
        model.addAttribute("categories", parentCategoryList);

        return "admin/category/index";
    }

}
