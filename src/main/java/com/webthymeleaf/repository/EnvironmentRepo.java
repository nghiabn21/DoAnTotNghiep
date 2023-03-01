package com.webthymeleaf.repository;

import com.webthymeleaf.entity.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnvironmentRepo extends JpaRepository< Environment, String> {

    @Query(value = "from Environment e where e.id = ?1")
    Environment getEnviromentByID(String id) ;

//    @Query(value = "SELECT e FROM environment AS e INNER join node AS n ON e.node_id = n.id \n" +
//            "INNER join user_node AS un ON n.id = un.node_id INNER join users AS u ON un.users_id = u.id WHERE \n" +
//            "u.id = ?1 ORDER BY e.time DESC LIMIT 1", nativeQuery = true)
//    List<Environment> findEnviromentByID(String id) ;

    @Query(value = "SELECT e FROM Environment AS e INNER join Node AS n ON e.node.id = n.id\n" +
            "INNER join UserNode AS un ON n.id = un.node.id INNER join User AS u ON un.users.id = u.id WHERE\n" +
            "u.id = ?1 ORDER BY e.time DESC ")
    List<Environment> findEnviromentByID(String id) ;
}
