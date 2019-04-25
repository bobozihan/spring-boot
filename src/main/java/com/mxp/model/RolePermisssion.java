package com.mxp.model;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:menxi
 * @DATE: 2019/3/5
 * @TIME: 15:03
 */
public class RolePermisssion {
    private Integer roleId;
    private Integer permissionId;
    private Permission permission;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "RolePermisssion{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", permission=" + permission +
                '}';
    }
}
