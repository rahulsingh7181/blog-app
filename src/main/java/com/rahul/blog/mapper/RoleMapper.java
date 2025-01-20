package com.rahul.blog.mapper;

import com.rahul.blog.entity.Role;
import com.rahul.blog.request.RoleRequest;
import com.rahul.blog.response.RoleResponse;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper {

    public Role toRole(RoleRequest request){
        Role role = new Role();
        role.setRoleName(request.getRoleName());
        return role;
    }

    public RoleResponse toRoleResponse(Role role){
        RoleResponse roleResponse = new RoleResponse();
        roleResponse.setRoleId(role.getRoleId());
        roleResponse.setRoleName(role.getRoleName());
        return roleResponse;
    }
}
