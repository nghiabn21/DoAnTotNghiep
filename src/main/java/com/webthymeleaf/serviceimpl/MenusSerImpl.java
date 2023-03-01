package com.webthymeleaf.serviceimpl;

import com.webthymeleaf.entity.Menus;
import com.webthymeleaf.repository.MenuRepo;
import com.webthymeleaf.serviceimpl.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusSerImpl implements IMenuService {
    @Autowired
    private MenuRepo menuRepo ;
    @Override
    public List<Menus> GetDataMenus() {
        List<Menus> menuss = menuRepo.findAll();
        menuss.sort((o1, o2) -> o1.getId() - o2.getId());
        return menuss;
    }
}
