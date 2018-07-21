package com.vip.darker.thread;

import com.vip.darker.model.URRelation;
import com.vip.darker.service.URRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Auther: Darker
 * @Date: 2018/7/21 10:06
 * @Description: 用户增加角色线程
 */
public class AddRoleThread extends Thread {


    private Integer userId;
    private Integer roleId;
    @Autowired
    @Qualifier(value = "urRelationService")
    private URRelationService urRelationService;

    public AddRoleThread(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    @Override
    public void run() {
        URRelation urRelation = new URRelation();
        urRelation.setUserId(userId);
        urRelation.setRoleId(roleId);
        try{
            urRelationService.insert(urRelation);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
