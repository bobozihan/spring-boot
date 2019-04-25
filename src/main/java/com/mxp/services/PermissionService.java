package com.mxp.services;

import com.mxp.model.Permission;
import com.mxp.model.RolePermisssion;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:menxi
 * @DATE: 2019/3/5
 * @TIME: 15:28
 */
public interface PermissionService {
    List<RolePermisssion> selectPermissionByRoleId(Integer roleId);

    int insertPermission(Permission permission);
}
