package com.mxp.controller;

import com.mxp.model.Permission;
import com.mxp.model.RolePermisssion;
import com.mxp.services.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by mxp on 2017/7/4.
 */
@Controller
public class EmpController {


    @Autowired
    private PermissionService permissionService;


    @RequestMapping("/socket")
    @ResponseBody
    public void socket(){
        //SocketServer
        //socketServer.startServer();
    }



    @RequestMapping("/getPer/aa/bbb/ccc")
    @ResponseBody
    public List<Object> perssion(@RequestBody Permission permissions){
        System.out.println(permissions.getIcon());
        Map<List, Object> mapP = new HashMap<>();
        Map<List, Object> mapS = new HashMap<>();
        Map<List, Object> mapButton = new HashMap<>();
        List<Object> list = new ArrayList<>();

        List<RolePermisssion> permission = permissionService.selectPermissionByRoleId(1);
        permission.forEach(System.out::println);


        permission.forEach((x) -> {
            String parent = x.getPermission().getParentId();
            String title = x.getPermission().getTitle();
            Integer ids = x.getPermission().getId();
            String id = String.valueOf(ids);
            String url = x.getPermission().getPath();
            String name = x.getPermission().getName();
            String icon = x.getPermission().getIcon();
            String component = x.getPermission().getComponent();
            String hideInMenu = x.getPermission().getHideInMenu();
            String notCache = x.getPermission().getNotCache();
            String showAlways = x.getPermission().getShowAlways();
            if (parent == null){
                Map<String,Object> map = new HashMap<>();
                map.put("icon",icon);
                map.put("title",title);
                map.put("hideInMenu",Boolean.valueOf(hideInMenu));
                map.put("notCache",Boolean.valueOf(notCache));
                map.put("showAlways",Boolean.valueOf(showAlways));
                List<Object> listP = new ArrayList<>();
                listP.add(url);
                listP.add(name);
                listP.add(map);
                listP.add(component);
                //mapP.put(pre_name,id);
                mapP.put(listP,id);
            }
            if (parent != null & !"button".equals(component)){
                Map<String,Object> map = new HashMap<>();
                map.put("icon",icon);
                map.put("title",title);
                map.put("hideInMenu",Boolean.valueOf(hideInMenu));
                map.put("notCache",Boolean.valueOf(notCache));
                List<Object> listS = new ArrayList<>();
                listS.add(url);
                listS.add(name);
                listS.add(map);
                listS.add(component);
                listS.add(id);
                mapS.put(listS,parent);
            }
            if (parent != null & "button".equals(component)){
                Map<String,Object> map = new HashMap<>();
                map.put("icon",icon);
                map.put("title",title);
                map.put("hideInMenu",Boolean.valueOf(hideInMenu));
                map.put("notCache",Boolean.valueOf(notCache));
                List<Object> listButton = new ArrayList<>();
                //listButton.add(url);
                listButton.add(name);
                //listButton.add(map);
                //listButton.add(component);
                mapButton.put(listButton,parent);
            }

        });


        mapP.forEach((k,v) ->{
            Map<String, Object> map = new TreeMap<>(Comparator.reverseOrder());
            List<Object> list1 = new ArrayList<>();

            map.put("path",k.get(0));
            map.put("name",k.get(1));
            map.put("meta",k.get(2));
            map.put("component",k.get(3));


            mapS.forEach((x,y)->{
                if (v.equals(y)){
                    List<Object> list2 = new ArrayList<>();
                    Map<String, Object> map1 = new TreeMap<>(Comparator.reverseOrder());
                    map1.put("path",x.get(0));
                    map1.put("name",x.get(1));
                    map1.put("meta",x.get(2));
                    map1.put("component",x.get(3));

                    mapButton.forEach((j,p) -> {
                        if (p.equals(x.get(4))){
                            list2.add(j.get(0));
                            System.out.println();
                        }
                        map1.put("button",list2);
                    });

                    list1.add(map1);
                }
            });
            map.put("children",list1);
            list.add(map);
        });
        Collections.reverse(list);
        return list;

    }


    @RequestMapping("/insertPer/")
    @ResponseBody
    public List<Object> insertPermission(){

        Permission permission = new Permission();

        permission.setTitle("1");
        permission.setPath("2");
        permission.setName("3");
        permission.setIcon("4");
        permission.setParentId("5");
        permission.setComponent("6");
        permission.setHideInMenu("7");
        permission.setNotCache("8");
        permission.setShowAlways("9");

        Integer status = permissionService.insertPermission(permission);

        List list = new ArrayList();
        list.add(status);
        return list;
    }

}
