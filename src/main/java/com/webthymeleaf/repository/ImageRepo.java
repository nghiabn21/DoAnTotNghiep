//package com.webthymeleaf.repository;
//
////import com.webthymeleaf.entity.Bills;
//import com.webthymeleaf.entity.Images;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface ImageRepo extends JpaRepository<Images, Integer> {
//    @Query(value = "from Images as  ima where ima.user.id=?1")
//    List<Images> findImageByUserId(int id);
//}
