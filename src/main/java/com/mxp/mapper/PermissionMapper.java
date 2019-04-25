package com.mxp.mapper;

import com.mxp.model.Permission;
import com.mxp.model.RolePermisssion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:menxi
 * @DATE: 2019/3/5
 * @TIME: 14:38
 */
@Mapper
public interface PermissionMapper {
    List<RolePermisssion> selectPermissionByRoleId(Integer roleId);

    int insertPermission(Permission permission);



}
