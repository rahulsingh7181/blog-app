package com.rahul.blog.service;

import com.rahul.blog.entity.Role;
import com.rahul.blog.exception.RoleNotFoundException;
import com.rahul.blog.mapper.RoleMapper;
import com.rahul.blog.repository.RoleRepository;
import com.rahul.blog.request.RoleRequest;
import com.rahul.blog.response.RoleResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public RoleResponse createRole(RoleRequest request) {
        Role savedRole = roleRepository.save(roleMapper.toRole(request));
        return roleMapper.toRoleResponse(savedRole);
    }

    public List<RoleResponse> getRoles() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(roleMapper::toRoleResponse).toList();
    }

    public RoleResponse getRole(Long roleId) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException("ROLE NOT FOUNT BY GIVEN ID :: "+roleId));
        return roleMapper.toRoleResponse(role);
    }

    public RoleResponse updateRole(Long roleId, RoleRequest request) {
        Role role = roleRepository.findById(roleId).orElseThrow(() -> new RoleNotFoundException("ROLE NOT FOUNT BY GIVEN ID :: "+roleId));
        role.setRoleName(request.getRoleName());
        return roleMapper.toRoleResponse(roleRepository.save(role));
    }

    public String deleteRole(Long roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        if (role.isPresent()){
            roleRepository.deleteById(roleId);
            return "ROLE DELETE SUCCESSFULLY";
        } else {
            return "THIS ROLE NOT FOUND BY GIVEN ID ::"+roleId;
        }
    }
}
