package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.convert.ConvertObject;
import com.vip.darker.entity.PermissionDO;
import com.vip.darker.entity.RoleDO;
import com.vip.darker.entity.URRelationDO;
import com.vip.darker.entity.UserDO;
import com.vip.darker.service.base.SpringBootService;
import com.vip.darker.constant.ConfigConstant;
import com.vip.darker.util.WebSiteUtil;
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
 * @DateUpdate: 2018/10/27
 * @Description: 用户管理控制器
 * @Remark:restful API
 */
@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //****************************************用户模块****************************************//

    /**
     * @description:用户新增
     * @auther: WBA
     * @date: 2018/12/11 17:00
     * @param: [roleId, userModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestParam(value = "roleId", required = false, defaultValue = "1") Integer roleId, UserDO userDO) {

        boolean flag = SpringBootService.getUserService().insert(userDO);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().addURRelation(userDO.getId(), roleId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }


    /**
     * @description:用户更新
     * @auther: WBA
     * @date: 2018/12/11 17:00
     * @param: [userId, roleId, userModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public Map<String, Object> editUser(@PathVariable(value = "id") Integer userId, Integer roleId, UserDO userDO) {

        boolean flag = SpringBootService.getUserService().updateById(userDO);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().editURRelation(userDO.getId(), roleId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * @description:用户删除
     * @auther: WBA
     * @date: 2018/12/11 17:00
     * @param: [userId]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteUser(@PathVariable(value = "id") Integer userId) {

        boolean flag = SpringBootService.getUserService().deleteById(userId);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().deleteURRelation(userId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * @description:用户对象查询
     * @auther: WBA
     * @date: 2018/12/11 17:00
     * @param: [userId]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/users/{id}")
    public Map<String, Object> findUserById(@PathVariable(value = "id") Integer userId) {

        UserDO userDO = SpringBootService.getUserService().selectById(userId);

        if (userDO != null) {
            try {
                return ConvertObject.convertBeanToMap(userDO);
            } catch (Exception e) {
                logger.info("{}:bean转map失败!", "[" + Thread.currentThread().getStackTrace()[1].getMethodName() + "]");
            }
        }
        return null;
    }

    /**
     * @description:用户列表查询
     * @auther: WBA
     * @date: 2018/12/11 17:00
     * @param: [pageNum, pageSize]
     * @return: java.util.List<java.util.Map>
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<Map<String, Object>> findListUser(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                  @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        try {
            List<UserDO> beanList = SpringBootService.getUserService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
            List<Map<String, Object>> resultList = ConvertObject.convertListBeanToListMap(beanList, UserDO.class);
            resultList.forEach(opt -> {
                int userId = Integer.valueOf(opt.get("id") + "");
                // 根据用户ID查找角色ID
                Map<String, Object> relationMap = SpringBootService.getURRelationService().selectMap(new EntityWrapper<URRelationDO>().where("userId={0}", userId));
                if (relationMap != null && relationMap.size() > 0) {
                    int roleId = Integer.valueOf(relationMap.get("roleId") + "");
                    // 根据角色ID查找角色
                    RoleDO role = SpringBootService.getRoleService().selectById(roleId);
                    opt.put("roleName", StringUtils.isNotBlank(role.getName()) ? role.getName() : "游客");
                } else {
                    opt.put("roleName", "游客");
                }
                // 用户名
                if (StringUtils.isBlank(opt.get("name").toString())) {
                    opt.put("name", "陌生人");
                }
                // 邮箱
                if (StringUtils.isBlank(opt.get("email").toString())) {
                    opt.put("email", "stranger@qq.vip.com");
                }
                // 地区
                if (StringUtils.isBlank(opt.get("area").toString())) {
                    opt.put("area", WebSiteUtil.getCountryNameByIp(opt.get("ip").toString()));
                }
            });
            return resultList;
        } catch (Exception e) {
            logger.info("{}:用户分页查询异常!", Thread.currentThread().getStackTrace()[1].getMethodName());
        }
        return null;
    }

    /**
     * @description:用户列表页数
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/users/page", method = RequestMethod.GET)
    public Map<String, Object> countUserPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getUserService().selectCount(new EntityWrapper<>());

        map.put("userMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }

    //****************************************角色模块****************************************//

    /**
     * @description:角色新增
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: [permissionId, roleModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/roles", method = RequestMethod.POST)
    public Map<String, Object> addRole(@RequestParam(value = "permissionId") Integer permissionId, RoleDO roleDO) {

        boolean flag = SpringBootService.getRoleService().insert(roleDO);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().addRPRelation(roleDO.getId(), permissionId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }


    /**
     * @description:角色更新
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: [roleId, permissionId, roleModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
    public Map<String, Object> editRole(@PathVariable(value = "id") Integer roleId, Integer permissionId, RoleDO roleDO) {

        boolean flag = SpringBootService.getRoleService().updateById(roleDO);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().editRPRelation(roleDO.getId(), permissionId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * @description:角色删除
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: [roleId]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deleteRole(@PathVariable(value = "id") Integer roleId) {

        boolean flag = SpringBootService.getRoleService().deleteById(roleId);

        if (flag) {
            SpringBootService.getAsyncTaskExecutorService().deleteRPRelation(roleId);
        }

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * @description:角色对象查询
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: [roleId]
     * @return: com.vip.darker.model.RoleModel
     */
    @RequestMapping(value = "/roles/{id}")
    public RoleDO findRoleById(@PathVariable(value = "id") Integer roleId) {
        return SpringBootService.getRoleService().selectById(roleId);
    }

    /**
     * @description:角色列表查询
     * @auther: WBA
     * @date: 2018/12/11 17:01
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.RoleModel>
     */
    @RequestMapping(value = "/roles", method = RequestMethod.GET)
    public List<RoleDO> findListRole(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getRoleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:角色列表页数
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/roles/page", method = RequestMethod.GET)
    public Map<String, Object> countRolePage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getRoleService().selectCount(new EntityWrapper<>());

        map.put("roleMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }

    //****************************************权限模块****************************************//

    /**
     * @description:权限新增
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: [permissionModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/permissions", method = RequestMethod.POST)
    public Map<String, Object> addPermission(PermissionDO permissionDO) {

        boolean flag = SpringBootService.getPermissionService().insert(permissionDO);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "新增成功!" : "新增失败!");

        return map;
    }

    /**
     * @description:权限更新
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: [permissionId, permissionModel]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.PUT)
    public Map<String, Object> editPermission(@PathVariable(value = "id") Integer permissionId, PermissionDO permissionDO) {

        boolean flag = SpringBootService.getPermissionService().updateById(permissionDO);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "更新成功!" : "更新失败!");

        return map;
    }

    /**
     * @description:权限删除
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: [permissionId]
     * @return: java.util.Map
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> deletePermission(@PathVariable(value = "id") Integer permissionId) {

        boolean flag = SpringBootService.getPermissionService().deleteById(permissionId);

        Map<String, Object> map = new HashMap<>();

        map.put("msg", flag ? "删除成功!" : "删除失败!");

        return map;
    }

    /**
     * @description:权限对象查询
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: [permissionId]
     * @return: com.vip.darker.model.PermissionModel
     */
    @RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET)
    public PermissionDO findPermissionById(@PathVariable(value = "id") Integer permissionId) {
        return SpringBootService.getPermissionService().selectById(permissionId);
    }

    /**
     * @description:权限列表查询
     * @auther: WBA
     * @date: 2018/12/11 17:02
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.PermissionModel>
     */
    @RequestMapping(value = "/permissions", method = RequestMethod.GET)
    public List<PermissionDO> findListPermission(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        return SpringBootService.getPermissionService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * @description:权限列表页数
     * @auther: WBA
     * @date: 2018/12/11 17:03
     * @param: []
     * @return: java.util.Map
     */
    @RequestMapping(value = "/permissions/page", method = RequestMethod.GET)
    public Map<String, Object> countPermissionPage() {

        Map<String, Object> map = new HashMap<>();

        int count = SpringBootService.getPermissionService().selectCount(new EntityWrapper<>());

        map.put("permissionMaxPage", (count - 1) / ConfigConstant.PAGE_SIZE + 1);

        return map;
    }
}