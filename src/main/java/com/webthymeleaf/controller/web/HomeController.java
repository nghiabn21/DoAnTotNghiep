package com.webthymeleaf.controller.web;

import com.webthymeleaf.dto.ProductsDao;
import com.webthymeleaf.entity.Environment;
import com.webthymeleaf.entity.ThongSo;
import com.webthymeleaf.entity.User;
import com.webthymeleaf.repository.UserRepo;
import com.webthymeleaf.serviceimpl.*;
import com.webthymeleaf.serviceimpl.service.IEnviromentSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;


import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class HomeController extends MenuController {
    @Autowired
    SlidesSerImpl slidesSer;
//
//    @Autowired
//    ImageSerImpl imageSer ;

    @Autowired
    private MenusSerImpl menusSer;

    @Autowired
    private CategorysSerImpl categorysSer;

    @Autowired
    private ProductSerImpl dto;

    @Autowired
    private UserRepo userRepo ;

    @Autowired
    EnviromentSerImpl enviromentSer;

    @Autowired
    UserSerImpl userSer;

    @Autowired
    EnviromentSerImpl iEnviromentSer ;

    @RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
    public ModelAndView homePage() {
        _mvShare.addObject("slides", slidesSer.GetDataSlide());
        _mvShare.addObject("categorys", categorysSer.GetDataCategorys());
        _mvShare.addObject("products", dto.GetDataProduct(1));
        _mvShare.addObject("productsNoiBat", dto.GetDataProductNew(1));


        _mvShare.setViewName("/web/index");

        return _mvShare;
    }



    @GetMapping("/san-pham/{id}/{pageNumber}")
    public String getOnePage(Model model,@PathVariable("id") int id , @PathVariable("pageNumber") int currentPage){
        model.addAttribute("menus", menusSer.GetDataMenus());
        Page<ProductsDao> page = dto.getAllProductsByIdFindPage(id,currentPage); // lấy id sản phẩm rồi số trang
        int totalPages = page.getTotalPages();
        long totalItems = page.getTotalElements();
        List<ProductsDao> getAllProducts = page.getContent();

        model.addAttribute("id", id);
        model.addAttribute("currentPage", currentPage); // trang hiện tại
        model.addAttribute("totalPages", totalPages);  // tổng số trang
        model.addAttribute("totalItems", totalItems); // tổng số sản phẩm
        model.addAttribute("getAllProducts", getAllProducts);   // 1 trang bn sản phẩm

        return "/web/products";
    }

    @GetMapping("/san-pham/{id}")
    public String getAllPages(Model model,@PathVariable("id") int id){
        return getOnePage(model,id, 1);
    }

    @GetMapping(value = "/nhiet-do")
    public ModelAndView sanPham(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userRepo.findByDisplayName(currentPrincipalName);
//        String id = user.getId() ;
        String id = "3f108af4-d300-4a3e-9232-00894d458035";
        model.addAttribute("thongso", enviromentSer.getEnviromentBy(id));
        _mvShare.setViewName("/web/nhietdo");
        return _mvShare;
    }

    @GetMapping(value = "/do-am")
    public ModelAndView DoAm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
  //      User user = userRepo.findByDisplayName(currentPrincipalName);
//        int id = user.getId() ;
//        int id = 1 ;
//        model.addAttribute("images", imageSer.findAllImagesByChanelID(id));
        String id = "3f108af4-d300-4a3e-9232-00894d458035";
        model.addAttribute("thongso", enviromentSer.getEnviromentBy(id));
        _mvShare.setViewName("/web/doam");
        return _mvShare;
    }

    @GetMapping(value = "/do-am-cua-dat")
    public ModelAndView DoAmCuaDat(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
      //  User user = userRepo.findByDisplayName(currentPrincipalName);
//        int id = user.getId() ;
//        int id = 1 ;
//        model.addAttribute("images", imageSer.findAllImagesByChanelID(id));
        String id = "3f108af4-d300-4a3e-9232-00894d458035";
        model.addAttribute("thongso", enviromentSer.getEnviromentBy(id));
        _mvShare.setViewName("/web/doamdat");
        return _mvShare;
    }

    @GetMapping(value = "/cuong-do-anh-sang")
    public ModelAndView CuongDoAnhSang(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
      //  User user = userRepo.findByDisplayName(currentPrincipalName);
//        int id = user.getId() ;
//        int id = 1 ;
//        model.addAttribute("images", imageSer.findAllImagesByChanelID(id));
        String id = "3f108af4-d300-4a3e-9232-00894d458035";
        model.addAttribute("thongso", enviromentSer.getEnviromentBy(id));
        _mvShare.setViewName("/web/cuongdo");
        return _mvShare;
    }

    @RequestMapping(value = "/gioi-thieu", method = RequestMethod.GET)
    public ModelAndView aboutUs() {
        _mvShare.setViewName("/web/aboutUs");
        return _mvShare;
    }
}
