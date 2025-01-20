package com.rahul.blog.controller;

import com.rahul.blog.request.RoleRequest;
import com.rahul.blog.response.RoleResponse;
import com.rahul.blog.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public ResponseEntity<RoleResponse> createRole(@RequestBody RoleRequest request){
        return new ResponseEntity<RoleResponse>(roleService.createRole(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getRoles(){
        return new ResponseEntity<List<RoleResponse>>(roleService.getRoles(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getRole(@PathVariable("id") Long roleId){
        return new ResponseEntity<RoleResponse>(roleService.getRole(roleId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> updateRole(@PathVariable("id") Long roleId, @RequestBody RoleRequest request){
        return new ResponseEntity<RoleResponse>(roleService.updateRole(roleId, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable("id") Long roleId){
        return new ResponseEntity<String>(roleService.deleteRole(roleId), HttpStatus.OK);
    }
}
