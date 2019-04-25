package com.mxp.model;

/**
 * @EMAIL menxipeng@gmail.com
 * @AUTHOR:menxi
 * @DATE: 2019/3/5
 * @TIME: 14:33
 */
public class Permission {

    private Integer id;
    private String title;
    private String path;
    private String name;
    private String icon;
    private String component;
    private String notCache;
    private String hideInMenu;
    private String showAlways;
    private String parentId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getNotCache() {
        return notCache;
    }

    public void setNotCache(String notCache) {
        this.notCache = notCache;
    }

    public String getHideInMenu() {
        return hideInMenu;
    }

    public void setHideInMenu(String hideInMenu) {
        this.hideInMenu = hideInMenu;
    }

    public String getShowAlways() {
        return showAlways;
    }

    public void setShowAlways(String showAlways) {
        this.showAlways = showAlways;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", component='" + component + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}
