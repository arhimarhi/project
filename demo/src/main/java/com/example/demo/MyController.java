package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

@Controller
public class MyController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

//    @GetMapping("/check")
//    public String calculate(@RequestParam(name = "fileName") String fileName,
//                            Model model) {
//
//
//        String name = fileName;
//
//        model.addAttribute("fileName", name);
//
//
//        return "check";
//    }

    @Autowired
ProductService productService = new ProductService();

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        ArrayList<Product> spisok = productService.getAllList();
        model.addAttribute("spisok_productov", spisok);
        return "catalog";


    }

    @GetMapping("/check")
    public String findProduct(@RequestParam(name = "productName") String productName,Model model) {
        Product x = productService.findByName(productName);
        System.out.println(productService);
       if (x == null) { model.addAttribute("cost", "there is no product like this");}
       else
        model.addAttribute("cost", x.getCost());
        return "check";


    }
    @GetMapping("/check")
    public String readFile(@RequestParam(name = "fileName") String fileName, Model model) {
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNext()) {
                productService.products.add(new Product(scanner.nextInt(), scanner.next(), scanner.nextDouble()));
            }
            System.out.println(productService.products);
        }
        catch (Exception e){
            System.out.println("ERROR");}
        return "check";


    }
}