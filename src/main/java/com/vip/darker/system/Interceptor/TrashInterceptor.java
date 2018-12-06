package com.vip.darker.system.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.vip.darker.model.*;
import com.vip.darker.service.base.SpringBootService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrashInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(TrashInterceptor.class);

    /**
     * 功能描述: 方法执行之前
     *
     * @return: [boolean]
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) {
        if ("DELETE".equals(request.getMethod())) {
            // 接收删除内容
            String content = "";
            // 获取请求URL
            String requestURI = request.getRequestURI();
            // 回收类型
            String description = requestURI.split("/")[1];
            // 回收数据ID
            Integer dataId = Integer.valueOf(requestURI.split("/")[2]);

            switch (description) {
                case "resources":
                    ResourceModel resourceModel = SpringBootService.getResourceService().selectById(dataId);
                    content = JSONObject.toJSONString(resourceModel);
                    break;
                case "classifys":
                    ClassifyModel classifyModel = SpringBootService.getClassifyService().selectById(dataId);
                    content = JSONObject.toJSONString(classifyModel);
                    break;
                case "columns":
                    ColumnModel columnModel = SpringBootService.getColumnService().selectById(dataId);
                    content = JSONObject.toJSONString(columnModel);
                    break;
                case "users":
                    UserModel userModel = SpringBootService.getUserService().selectById(dataId);
                    content = JSONObject.toJSONString(userModel);
                    break;
                case "roles":
                    RoleModel roleModel = SpringBootService.getRoleService().selectById(dataId);
                    content = JSONObject.toJSONString(roleModel);
                    break;
                case "permissions":
                    PermissionModel permissionModel = SpringBootService.getPermissionService().selectById(dataId);
                    content = JSONObject.toJSONString(permissionModel);
                    break;
                case "articles":
                    ArticleModel articleModel = SpringBootService.getArticleService().selectById(dataId);
                    content = JSONObject.toJSONString(articleModel);
                    break;
                case "images":
                    ImageModel imageModel = SpringBootService.getImageService().selectById(dataId);
                    content = JSONObject.toJSONString(imageModel);
                    break;
                case "links":
                    LinkModel linkModel = SpringBootService.getLinkService().selectById(dataId);
                    content = JSONObject.toJSONString(linkModel);
                    break;
                default:
                    logger.info("[删除的内容未增加到回收站]:" + requestURI);
                    break;
            }
            if (StringUtils.isNotBlank(content)) {
                TrashModel t = new TrashModel();
                t.setContent(content);
                t.setClassify(description);
                t.setDescription(description);
                SpringBootService.getTrashService().insert(t);
            }
        }
        return true;
    }

    /**
     * 功能描述: 方法执行之后,页面渲染前
     *
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {
    }

    /**
     * 功能描述: 整个请求结束后,页面也渲染完毕,一般是资源清理操作
     *
     * @auther: darker
     * @date: 2018/9/16 13:29
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }
}
