package com.webthymeleaf.serviceimpl.service;

import com.webthymeleaf.entity.Menus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMenuService {
    public List<Menus> GetDataMenus();
}
