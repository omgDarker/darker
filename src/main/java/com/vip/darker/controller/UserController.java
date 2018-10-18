package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.*;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.util.BeanToMapUtil;
import com.vip.darker.util.ConstantUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 22:27
 * @DateUpdate: 2018/10/18
 * @Description: 用户管理控制器
 * @Remark:restful API
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //****************************************用户模块****************************************//

    /**
     * 功能描述: 用户新增
     *
     * @param: [roleId, userModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:38
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestParam(value = "roleId", required = false, defaultValue = "1") Integer roleId, UserModel userModel) {
        // 用户新增
        boolean flag = SpringBootService.getUserService().insert(userModel);

        if (flag) {
            // 用户角色关系数据新增
            URRelation relation = new URRelation();
            relation.setUserId(userModel.getId());
            relation.setRoleId(roleId);
            flag = SpringBootService.getURRelationService().insert(relation);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }

    /**
     * 功能描述: 用户更新
     *
     * @param: [id, roleId, userModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:40
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public Map<String, Object> updateUser(@PathVariable(value = "id") Integer id, Integer roleId, UserModel userModel) {
        // 用户更新
        boolean flag = SpringBootService.getUserService().updateById(userModel);

        if (flag) {
            // 用户角色关系数据更新
            URRelation relation = new URRelation();
            relation.setUserId(userModel.getId());
            relation.setRoleId(roleId);
            flag = SpringBootService.getURRelationService().update(relation, new EntityWrapper<URRelation>().where("userId={0}", userModel.getId()));
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * 功能描述: 用户删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:43
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteUser(@PathVariable(value = "id") Integer id) {
        // 用户删除
        boolean flag = SpringBootService.getUserService().deleteById(id);

        if (flag) {
            // 用户角色关系数据删除
            flag = SpringBootService.getURRelationService().delete(new EntityWrapper<URRelation>().where("userId={0}", id));
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 用户实体查询
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 14:17
     */
    @RequestMapping(value = "/users/{id}")
    public Map<String, Object> queryUserById(@PathVariable(value = "id") Integer id) {
        // 查询用户实体
        UserModel userModel = SpringBootService.getUserService().selectById(id);

        if (userModel != null) {
            try {
                return BeanToMapUtil.convertBeanToMap(userModel);
            } catch (Exception e) {
                logger.info("bean转map失败!");
            }
        }
        return null;
    }

    /**
     * 功能描述: 用户分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.UserModel>
     * @auther: darker
     * @date: 2018/7/19 22:47
     * @updateDate: 2018/7/30
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Map<String, Object>> queryAllUser(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        try {
            List<UserModel> list = SpringBootService.getUserService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
            List<Map<String, Object>> resultList = BeanToMapUtil.convertListBeanToListMap(list, UserModel.class);
            for (Map<String, Object> map : resultList) {
                int userId = Integer.valueOf(map.get("id") + "");
                // 根据用户ID查找角色ID
                Map<String, Object> relationMap = SpringBootService.getURRelationService().selectMap(new EntityWrapper<URRelation>().where("userId={0}", userId));
                if (relationMap != null && relationMap.size() > 0) {
                    int roleId = Integer.valueOf(relationMap.get("roleId") + "");
                    // 根据角色ID查找角色
                    RoleModel role = SpringBootService.getRoleService().selectById(roleId);
                    map.put("roleName", StringUtils.isNotBlank(role.getName()) ? role.getName() : "游客");
                } else {
                    map.put("roleName", "游客");
                }
            }
            return resultList;
        } catch (Exception e) {
            logger.info("用户分页查询异常!");
        }
        return null;
    }

    /**
     * 功能描述: 用户分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/users/page", method = RequestMethod.GET)
    public Map<String, Object> getUserMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getUserService().selectCount(new EntityWrapper<>());

        map.put("userMaxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

        return map;
    }

    //****************************************角色模块****************************************//

    /**
     * 功能描述: 角色新增
     *
     * @param: [permissionId, roleModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/19 22:50
     */
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public Map<String, Object> addRole(@RequestParam(value = "permissionId") Integer permissionId, RoleModel roleModel) {
        // 角色新增
        boolean flag = SpringBootService.getRoleService().insert(roleModel);

        if (flag) {
            // 角色权限关系数据新增
            RPRelation relation = new RPRelation();
            relation.setRoleId(roleModel.getId());
            relation.setPermissionId(permissionId);
            SpringBootService.getRPRelationService().insert(relation);
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }

    /**
     * 功能描述: 角色更新
     *
     * @param: [id, permissionId, roleModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:26
     */
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    public Map<String, Object> updateRole(@PathVariable(value = "id") Integer id, Integer permissionId, RoleModel roleModel) {
        // 角色更新
        boolean flag = SpringBootService.getRoleService().updateById(roleModel);

        if (flag) {
            // 角色权限关系数据更新
            RPRelation relation = new RPRelation();
            relation.setRoleId(roleModel.getId());
            relation.setPermissionId(permissionId);
            flag = SpringBootService.getRPRelationService().update(relation, new EntityWrapper<RPRelation>().where("roleId={0}", roleModel.getId()));
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * 功能描述: 角色删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:30
     */
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteRole(@PathVariable(value = "id") Integer id) {
        // 角色删除
        boolean flag = SpringBootService.getRoleService().deleteById(id);

        if (flag) {
            // 角色权限关系数据删除
            flag = SpringBootService.getRPRelationService().delete(new EntityWrapper<RPRelation>().where("roleId={0}", id));
        }
        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 角色实体查询
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 15:31
     */
    @RequestMapping(value = "/roles/{id}")
    public Map<String, Object> queryRoleById(@PathVariable(value = "id") Integer id) {

        RoleModel roleModel = SpringBootService.getRoleService().selectById(id);

        if (roleModel != null) {
            try {
                return BeanToMapUtil.convertBeanToMap(roleModel);
            } catch (Exception e) {
                logger.info("bean转map失败!");
            }
        }
        return null;
    }

    /**
     * 功能描述: 角色分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.RoleModel>
     * @auther: darker
     * @date: 2018/7/20 11:34
     */
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<RoleModel> queryAllRole(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getRoleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 角色分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/roles/page", method = RequestMethod.GET)
    public Map<String, Object> getRoleMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getRoleService().selectCount(new EntityWrapper<>());

        map.put("roleMaxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

        return map;
    }

    //****************************************权限模块****************************************//

    /**
     * 功能描述: 权限新增
     *
     * @param: [permissionModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/19 23:04
     */
    @RequestMapping(value = "/permissions", method = RequestMethod.POST)
    public Map<String, Object> addPermission(PermissionModel permissionModel) {

        boolean flag = SpringBootService.getPermissionService().insert(permissionModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }

    /**
     * 功能描述: 权限更新
     *
     * @param: [id, permissionModel]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:37
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT)
    public Map<String, Object> updatePermission(@PathVariable(value = "id") Integer id, PermissionModel permissionModel) {

        boolean flag = SpringBootService.getPermissionService().updateById(permissionModel);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * 功能描述: 权限删除
     *
     * @param: [id]
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/20 11:39
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deletePermission(@PathVariable(value = "id") Integer id) {

        boolean flag = SpringBootService.getPermissionService().deleteById(id);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * 功能描述: 权限实体查询
     *
     * @param: [id]
     * @return: com.vip.darker.model.PermissionModel
     * @auther: darker
     * @date: 2018/7/30 15:31
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET)
    public PermissionModel queryPermissionById(@PathVariable(value = "id") Integer id) {
        return SpringBootService.getPermissionService().selectById(id);
    }

    /**
     * 功能描述: 权限分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.PermissionModel>
     * @auther: darker
     * @date: 2018/7/20 11:42
     */
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public List<PermissionModel> queryAllPermission(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getPermissionService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 权限分页查询,最大页数
     *
     * @param: []
     * @return: java.util.Map<>
     * @auther: darker
     * @date: 2018/7/30 10:48
     */
    @RequestMapping(value = "/permissions/page", method = RequestMethod.GET)
    public Map<String, Object> getPermissionMaxPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getPermissionService().selectCount(new EntityWrapper<>());

        map.put("permissionMaxPage", (count - 1) / ConstantUtil.PAGE_SIZE + 1);

        return map;
    }
}