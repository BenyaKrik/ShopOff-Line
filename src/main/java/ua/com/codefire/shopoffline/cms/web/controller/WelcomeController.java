/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
public class WelcomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    private JSONParser jsonParser = new JSONParser();
    private double usd;

    @PostConstruct
    private void init() {
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11");
            String json = IOUtils.toString(url, "utf-8");
            JSONArray currencies = (JSONArray) jsonParser.parse(json);
            System.out.println(currencies);

            for (int i = 0; i < currencies.size(); i++) {
                JSONObject curr = (JSONObject) currencies.get(i);

                if ("USD".equals(curr.get("ccy"))) {
                    usd = Double.valueOf(curr.get("sale").toString());
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping("/")
    public String getRoot(Model model) {
        List<Product> phoneList = productService.getProductList();
        model.addAttribute("products", phoneList);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);
        model.addAttribute("usd", usd);

        return "showcase";
    }

//    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @RequestMapping("/showcase")
    public String getIndex() {
        return "redirect:/";
    }

    @RequestMapping("/s/{name}")

    public String filterBrand(Model model, @PathVariable("name") String name) {
        List<Product> productList = productService.filterBrandList(name);
        System.out.println(productList);
        model.addAttribute("products", productList);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);
        model.addAttribute("usd", usd);

        return "showcase";
    }
}
