package com.vip.darker.service.base;

import com.vip.darker.service.*;
import com.vip.darker.service.impl.*;
import com.vip.darker.system.SpringBootApplicationContent;
import com.vip.darker.system.load.SpringBootPropertiesLoad;
import com.vip.darker.system.redis.RedisService;

/**
 * @Auther: Darker
 * @Date: 2018/7/26 16:34
 * @Description: 基础服务serviceBean
 */
public class SpringBootService {

    /**
     * 功能描述: 资源service
     *
     * @param: []
     * @return: com.vip.darker.service.ResourceService
     * @auther: darker
     * @date: 2018/7/26 17:43
     */
    public static ResourceService getResourceService() {
        return (ResourceService) SpringBootApplicationContent.getBean(ResourceServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 回收service
     *
     * @param: []
     * @return: com.vip.darker.service.TrashService
     * @auther: darker
     * @date: 2018/7/26 17:44
     */
    public static TrashService getTrashService() {
        return (TrashService) SpringBootApplicationContent.getBean(TrashServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 用户service
     *
     * @param: []
     * @return: com.vip.darker.service.UserService
     * @auther: darker
     * @date: 2018/7/26 18:00
     */
    public static UserService getUserService() {
        return (UserService) SpringBootApplicationContent.getBean(UserServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 角色service
     *
     * @param: []
     * @return: com.vip.darker.service.RoleService
     * @auther: darker
     * @date: 2018/7/26 18:01
     */
    public static RoleService getRoleService() {
        return (RoleService) SpringBootApplicationContent.getBean(RoleServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 权限service
     *
     * @param: []
     * @return: com.vip.darker.service.PermissionService
     * @auther: darker
     * @date: 2018/7/26 18:03
     */
    public static PermissionService getPermissionService() {
        return (PermissionService) SpringBootApplicationContent.getBean(PermissionServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 用户角色service
     *
     * @param: []
     * @return: com.vip.darker.service.URRelationService
     * @auther: darker
     * @date: 2018/7/26 18:15
     */
    public static URRelationService getURRelationService() {
        return (URRelationService) SpringBootApplicationContent.getBean(URRelationServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 角色权限service
     *
     * @param: []
     * @return: com.vip.darker.service.RPRelationService
     * @auther: darker
     * @date: 2018/7/26 18:16
     */
    public static RPRelationService getRPRelationService() {
        return (RPRelationService) SpringBootApplicationContent.getBean(RPRelationServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 文章service
     *
     * @param: []
     * @return: com.vip.darker.service.ArticleService
     * @auther: darker
     * @date: 2018/7/26 18:05
     */
    public static ArticleService getArticleService() {
        return (ArticleService) SpringBootApplicationContent.getBean(ArticleServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 图片service
     *
     * @param: []
     * @return: com.vip.darker.service.PhotoService
     * @auther: darker
     * @date: 2018/7/26 18:06
     */
    public static PhotoService getPhotoService() {
        return (PhotoService) SpringBootApplicationContent.getBean(PhotoServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 留言板service
     *
     * @param: []
     * @return: com.vip.darker.service.MessageService
     * @auther: darker
     * @date: 2018/7/26 18:07
     */
    public static MessageService getMessageService() {
        return (MessageService) SpringBootApplicationContent.getBean(MessageServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 统计service
     *
     * @param: []
     * @return: com.vip.darker.service.StatisticsService
     * @auther: darker
     * @date: 2018/7/26 18:09
     */
    public static StatisticsService getStatisticsService() {
        return (StatisticsService) SpringBootApplicationContent.getBean(StatisticsServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 监控service
     *
     * @param: []
     * @return: com.vip.darker.service.MonitorService
     * @auther: darker
     * @date: 2018/7/26 18:10
     */
    public static MonitorService getMonitorService() {
        return (MonitorService) SpringBootApplicationContent.getBean(MonitorServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 分类service
     *
     * @param: []
     * @return: com.vip.darker.service.ClassifyService
     * @auther: darker
     * @date: 2018/8/14 16:33
     */
    public static ClassifyService getClassifyService() {
        return (ClassifyService) SpringBootApplicationContent.getBean(ClassifyServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 栏目service
     *
     * @param: []
     * @return: com.vip.darker.service.ColumnService
     * @auther: darker
     * @date: 2018/8/14 16:34
     */
    public static ColumnService getColumnService() {
        return (ColumnService) SpringBootApplicationContent.getBean(ColumnServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 友情链接service
     *
     * @param: []
     * @return: com.vip.darker.service.LinkService
     * @auther: darker
     * @date: 2018/8/17 14:13
     */
    public static LinkService getLinkService() {
        return (LinkService) SpringBootApplicationContent.getBean(LinkServiceImpl.BEAN_NAME);
    }

    /**
     * 功能描述: 初始化加载YML文件属性bean
     *
     * @param: []
     * @return: SpringBootPropertiesLoad
     * @auther: darker
     * @date: 2018/8/28 14:13
     */
    public static SpringBootPropertiesLoad getSpringBootPropertiesLoad(){
        return (SpringBootPropertiesLoad) SpringBootApplicationContent.getBean(SpringBootPropertiesLoad.BEAN_NAME);
    }

    /**
     * 功能描述: 初始化加载YML文件属性bean
     *
     * @param: []
     * @return: SpringBootPropertiesLoad
     * @auther: darker
     * @date: 2018/8/28 14:13
     */
    public static RedisService getRedisService(){
        return (RedisService) SpringBootApplicationContent.getBean("redisService");

    }


}
