package com.vip.darker.system.pool;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vip.darker.entity.RelationRpDO;
import com.vip.darker.entity.RelationUrDO;
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
     * @description:用户角色关系数据新增
     * @auther: WBA
     * @date: 2018/12/11 17:22
     * @param: [userId, roleId]
     * @return: void
     */
    @Async
    public void addURRelation(Integer userId, Integer roleId) {
        RelationUrDO relation = new RelationUrDO();
        relation.setUserId(userId);
        relation.setRoleId(roleId);
        SpringBootService.getURRelationService().insert(relation);
    }

    /**
     * @description:用户角色关系数据更新
     * @auther: WBA
     * @date: 2018/12/11 17:22
     * @param: [userId, roleId]
     * @return: void
     */
    @Async
    public void editURRelation(Integer userId, Integer roleId) {
        RelationUrDO relation = new RelationUrDO();
        relation.setUserId(userId);
        relation.setRoleId(roleId);
        SpringBootService.getURRelationService().update(relation, new EntityWrapper<RelationUrDO>().where("userId={0}", userId));
    }

    /**
     * @description:用户角色关系数据删除
     * @auther: WBA
     * @date: 2018/12/11 17:23
     * @param: [userId]
     * @return: void
     */
    @Async
    public void deleteURRelation(Integer userId) {
        SpringBootService.getURRelationService().delete(new EntityWrapper<RelationUrDO>().where("userId={0}", userId));
    }

    /**
     * @description:角色权限关系数据新增
     * @auther: WBA
     * @date: 2018/12/11 17:23
     * @param: [roleId, permissionId]
     * @return: void
     */
    @Async
    public void addRPRelation(Integer roleId, Integer permissionId) {
        RelationRpDO relation = new RelationRpDO();
        relation.setRoleId(roleId);
        relation.setPermissionId(permissionId);
        SpringBootService.getRPRelationService().insert(relation);
    }

    /**
     * @description:角色权限关系数据更新
     * @auther: WBA
     * @date: 2018/12/11 17:23
     * @param: [roleId, permissionId]
     * @return: void
     */
    @Async
    public void editRPRelation(Integer roleId, Integer permissionId) {
        RelationRpDO relation = new RelationRpDO();
        relation.setRoleId(roleId);
        relation.setPermissionId(permissionId);
        SpringBootService.getRPRelationService().update(relation, new EntityWrapper<RelationRpDO>().where("roleId={0}", roleId));
    }

    /**
     * @description:角色权限关系数据删除
     * @auther: WBA
     * @date: 2018/12/11 17:23
     * @param: [roleId]
     * @return: void
     */
    @Async
    public void deleteRPRelation(Integer roleId) {
        SpringBootService.getRPRelationService().delete(new EntityWrapper<RelationRpDO>().where("roleId={0}", roleId));
    }
}