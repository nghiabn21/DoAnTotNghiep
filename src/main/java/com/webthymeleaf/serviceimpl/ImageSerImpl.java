//package com.webthymeleaf.serviceimpl;
//
//import com.webthymeleaf.entity.Images;
//import com.webthymeleaf.repository.ImageRepo;
//import com.webthymeleaf.serviceimpl.service.ImageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ImageSerImpl implements ImageService {
//
//    @Autowired
//    ImageRepo imageRepo ;
//
//    @Override
//    public List<Images> findAllImagesByChanelID(int id) {
//        int a = id ;
//        List<Images> imagesList = imageRepo.findImageByUserId(a);
//        if( imagesList == null) {
//            List<Images> images = new ArrayList<>();
//
//            return images;
//        }
//
//        return imagesList;
//    }
//}
