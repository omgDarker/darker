package com.vip.darker.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.vip.darker.model.*;
import com.vip.darker.system.locator.SystemServiceLocator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 22:27
 * @Description: 用户管理controller
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    /**
     * 功能描述: 用户新增
     *
     * @param: [roleId, userModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:38
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestParam(value = "roleId") Integer roleId, UserModel userModel) {

        try {
            // 用户新增
            SystemServiceLocator.getUserService().insert(userModel);
            // 用户角色关系数据新增
            URRelation relation = new URRelation();
            relation.setUserId(userModel.getId());
            relation.setRoleId(roleId);
            SystemServiceLocator.getURRelationService().insert(relation);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 用户更新
     *
     * @param: [roleId, userModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:40
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public boolean updateUser(@RequestBody Integer roleId, @RequestBody UserModel userModel) {

        try {
            // 用户更新
            SystemServiceLocator.getUserService().updateById(userModel);
            // 用户角色关系数据更新
            URRelation relation = new URRelation();
            relation.setUserId(userModel.getId());
            relation.setRoleId(roleId);
            SystemServiceLocator.getURRelationService().update(relation, new EntityWrapper<URRelation>().where("userId={0}", userModel.getId()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 用户删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:43
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public boolean deleteUser(@PathVariable(value = "id") Integer id) {

        try {
            // 用户删除
            SystemServiceLocator.getUserService().deleteById(id);
            // 用户角色关系数据删除
            SystemServiceLocator.getURRelationService().delete(new EntityWrapper<URRelation>().where("userId={0}", id));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 用户分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.UserModel>
     * @auther: darker
     * @date: 2018/7/19 22:47
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserModel> queryAllUser(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return SystemServiceLocator.getUserService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 角色新增
     *
     * @param: [permissionId, roleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 22:50
     */
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public boolean addRole(@RequestParam(value = "permissionId") Integer permissionId, RoleModel roleModel) {

        try {
            // 角色新增
            SystemServiceLocator.getRoleService().insert(roleModel);
            // 角色权限关系数据新增
            RPRelation relation = new RPRelation();
            relation.setRoleId(roleModel.getId());
            relation.setPermissionId(permissionId);
            SystemServiceLocator.getRPRelationService().insert(relation);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 角色更新
     *
     * @param: [permissionId, roleModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 11:26
     */
    @RequestMapping(value = "/updateRole", method = RequestMethod.PUT)
    public boolean updateRole(@RequestBody Integer permissionId, @RequestBody RoleModel roleModel) {

        try {
            // 角色更新
            SystemServiceLocator.getRoleService().updateById(roleModel);
            // 角色权限关系数据更新
            RPRelation relation = new RPRelation();
            relation.setRoleId(roleModel.getId());
            relation.setPermissionId(permissionId);
            SystemServiceLocator.getRPRelationService().update(relation, new EntityWrapper<RPRelation>().where("roleId={0}", roleModel.getId()));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 角色删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 11:30
     */
    @RequestMapping(value = "/deleteRole/{id}", method = RequestMethod.DELETE)
    public boolean deleteRole(@PathVariable(value = "id") Integer id) {

        try {
            // 角色删除
            SystemServiceLocator.getRoleService().deleteById(id);
            // 角色权限关系数据删除
            SystemServiceLocator.getRPRelationService().delete(new EntityWrapper<RPRelation>().where("roleId={0}", id));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * 功能描述: 角色分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.RoleModel>
     * @auther: darker
     * @date: 2018/7/20 11:34
     */
    @RequestMapping(value = "/allRole", method = RequestMethod.GET)
    public List<RoleModel> queryAllRole(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return SystemServiceLocator.getRoleService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }

    /**
     * 功能描述: 权限新增
     *
     * @param: [permissionModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/19 23:04
     */
    @RequestMapping(value = "/addPermission", method = RequestMethod.POST)
    public boolean addPermission(PermissionModel permissionModel) {
        return SystemServiceLocator.getPermissionService().insert(permissionModel);
    }

    /**
     * 功能描述: 权限更新
     *
     * @param: [permissionModel]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 11:37
     */
    @RequestMapping(value = "/updatePermission", method = RequestMethod.PUT)
    public boolean updatePermission(@RequestBody PermissionModel permissionModel) {
        return SystemServiceLocator.getPermissionService().updateById(permissionModel);
    }

    /**
     * 功能描述: 权限删除
     *
     * @param: [id]
     * @return: boolean
     * @auther: darker
     * @date: 2018/7/20 11:39
     */
    @RequestMapping(value = "/deletePermission/{id}", method = RequestMethod.DELETE)
    public boolean deletePermission(@PathVariable(value = "id") Integer id) {
        return SystemServiceLocator.getPermissionService().deleteById(id);
    }

    /**
     * 功能描述: 权限分页查询
     *
     * @param: [pageNum, pageSize]
     * @return: java.util.List<com.vip.darker.model.PermissionModel>
     * @auther: darker
     * @date: 2018/7/20 11:42
     */
    @RequestMapping(value = "/allPermission", method = RequestMethod.GET)
    public List<PermissionModel> queryAllPermission(
            @RequestParam(value = "pageNum", required = false, defaultValue = "1")
                    Integer pageNum,
            @RequestParam(value = "pageSize", required = false, defaultValue = "10")
                    Integer pageSize) {
        return SystemServiceLocator.getPermissionService().selectPage(new Page<>(pageNum, pageSize)).getRecords();
    }
}
