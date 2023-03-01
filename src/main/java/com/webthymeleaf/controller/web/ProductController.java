package com.webthymeleaf.controller.web;

import com.webthymeleaf.entity.Environment;
import com.webthymeleaf.entity.Products;
import com.webthymeleaf.serviceimpl.ProductSerImpl;
import com.webthymeleaf.serviceimpl.service.IEnviromentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api")
public class ProductController extends MenuController {
    @Autowired
    ProductSerImpl products ;



    @RequestMapping(value = "/chi-tiet-san-pham/{id}", method = RequestMethod.GET)
    public ModelAndView chiTietSanPham(@PathVariable("id") int id) {
        _mvShare.addObject("product", products.getProductById(id));
        int idCategory = products.getProductById(id).getId_category();
        _mvShare.addObject("productByIdCategory", products.getProductByIdCategory(products.getProductById(id).getId_category(),1));

        _mvShare.setViewName("/web/sanpham");
        return _mvShare;
    }

//    @GetMapping("/trang-chu/envi")
//    public ModelAndView getEnviroment(){
//        String ids = "7252cb49-cfd0-4f17-b868-659ee910fe56" ;
//        Environment environment = iEnviromentSer.getEnviromentBy(ids);
//        return  ResponseEntity.ok(environment);
//    }


}
