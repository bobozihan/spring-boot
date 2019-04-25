package com.mxp.serviceImpl;

import com.mxp.mapper.PermissionMapper;
import com.mxp.model.Permission;
import com.mxp.model.RolePermisssion;
import com.mxp.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:menxi
 * @DATE: 2019/3/5
 * @TIME: 15:29
 */
@Service
public class PerssionServiceImpl implements PermissionService {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public List<RolePermisssion> selectPermissionByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionByRoleId(roleId);
    }

    @Override
    public int insertPermission(Permission permission) {
        return permissionMapper.insertPermission(permission);
    }
}
