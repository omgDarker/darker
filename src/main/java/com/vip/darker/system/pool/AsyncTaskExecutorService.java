package com.vip.darker.system.pool;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.model.RPRelation;
import com.vip.darker.model.URRelation;
import com.vip.darker.service.base.SpringBootService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/10/27 10:33
 * @Description: 线程池异步任务service
 */
@Service(value = AsyncTaskExecutorService.BEAN_NAME)
public class AsyncTaskExecutorService {

    public static final String BEAN_NAME = "asyncTaskExecutorService";

    /**
     * 用户角色关系数据新增
     *
     * @param userId 用户ID
     * @param roleId 角色ID
     */
    @Async
    public void addURRelation(Integer userId, Integer roleId) {
        URRelation relation = new URRelation();
        relation.setUserId(userId);
        relation.setRoleId(roleId);
        SpringBootService.getURRelationService().insert(relation);
    }

    /**
     * 用户角色关系数据更新
     *
     * @param userId 用户ID
     * @param roleId 角色ID
     */
    public void editURRelation(Integer userId, Integer roleId) {
        URRelation relation = new URRelation();
        relation.setUserId(userId);
        relation.setRoleId(roleId);
        SpringBootService.getURRelationService().update(relation, new EntityWrapper<URRelation>().where("userId={0}", userId));
    }

    /**
     * 用户角色关系数据删除
     *
     * @param userId 用户ID
     */
    public void deleteURRelation(Integer userId) {
        SpringBootService.getURRelationService().delete(new EntityWrapper<URRelation>().where("userId={0}", userId));
    }

    /**
     * 角色权限关系数据新增
     *
     * @param roleId       角色ID
     * @param permissionId 权限ID
     */
    public void addRPRelation(Integer roleId, Integer permissionId) {
        RPRelation relation = new RPRelation();
        relation.setRoleId(roleId);
        relation.setPermissionId(permissionId);
        SpringBootService.getRPRelationService().insert(relation);
    }

    /**
     * 角色权限关系数据更新
     *
     * @param roleId       角色ID
     * @param permissionId 权限ID
     */
    public void editRPRelation(Integer roleId, Integer permissionId) {
        RPRelation relation = new RPRelation();
        relation.setRoleId(roleId);
        relation.setPermissionId(permissionId);
        SpringBootService.getRPRelationService().update(relation, new EntityWrapper<RPRelation>().where("roleId={0}", roleId));
    }

    /**
     * 角色权限关系数据删除
     *
     * @param roleId 角色ID
     */
    public void deleteRPRelation(Integer roleId) {
        SpringBootService.getRPRelationService().delete(new EntityWrapper<RPRelation>().where("roleId={0}", roleId));
    }
}