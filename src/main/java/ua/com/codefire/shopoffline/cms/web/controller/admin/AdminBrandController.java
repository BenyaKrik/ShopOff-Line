/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/admin/brand/")
public class AdminBrandController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping(path = "remove/{id}")
    public String removeBrands(@PathVariable int id) {
        brandService.removeBrand(id);
        return "redirect:/admin/brands";
    }

    @RequestMapping("add")
    public String addBrands() {

        return "admin/brand.edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", params = {"name", "country"})
    public String addBrands(Model model, @RequestParam String name,
            @RequestParam String country) {

        Brand brand = new Brand(name, country);
        brand = brandService.save(brand);

        return "redirect:/admin/brand/edit/" + brand.getId();
    }

    @RequestMapping(path = "edit/{id}", method = RequestMethod.POST, params = {"name", "country"})
    public String editBrands(@PathVariable Integer id, @RequestParam String name, @RequestParam String country) {
        Brand brand = brandService.getBrand(id);
        brand.setName(name);
        brand.setCountry(country);
        brand = brandService.save(brand);
        return "redirect:/admin/brand/edit/" + brand.getId();

    }

    @RequestMapping("edit/{id}")
    public String editBrands(Model model, @PathVariable Integer id) {
        Brand brand = brandService.getBrand(id);
        model.addAttribute("foundBrand", brand);
        return "admin/brand.edit";

    }

}
