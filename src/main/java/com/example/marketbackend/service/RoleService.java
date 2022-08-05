package com.example.marketbackend.service;

import com.example.marketbackend.entity.Role;
import com.example.marketbackend.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role create(Role role){
        return roleRepository.save(role);
    }
}
