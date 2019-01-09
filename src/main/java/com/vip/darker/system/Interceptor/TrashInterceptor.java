package com.vip.darker.system.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.vip.darker.entity.*;
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
     * @description:方法执行之前
     * @auther: WBA
     * @date: 2018/12/11 17:06
     * @param: [request, response, o]
     * @return: boolean
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
                    ResourceDo resourceDo = SpringBootService.getResourceService().selectById(dataId);
                    content = JSONObject.toJSONString(resourceDo);
                    break;
                case "classifys":
                    ClassifyDO classifyDO = SpringBootService.getClassifyService().selectById(dataId);
                    content = JSONObject.toJSONString(classifyDO);
                    break;
                case "columns":
                    ColumnDO columnDO = SpringBootService.getColumnService().selectById(dataId);
                    content = JSONObject.toJSONString(columnDO);
                    break;
                case "users":
                    UserDO userDO = SpringBootService.getUserService().selectById(dataId);
                    content = JSONObject.toJSONString(userDO);
                    break;
                case "roles":
                    RoleDO roleDO = SpringBootService.getRoleService().selectById(dataId);
                    content = JSONObject.toJSONString(roleDO);
                    break;
                case "permissions":
                    PermissionDO permissionDO = SpringBootService.getPermissionService().selectById(dataId);
                    content = JSONObject.toJSONString(permissionDO);
                    break;
                case "articles":
                    ArticleDO articleDO = SpringBootService.getArticleService().selectById(dataId);
                    content = JSONObject.toJSONString(articleDO);
                    break;
                case "images":
                    ImageDO imageDO = SpringBootService.getImageService().selectById(dataId);
                    content = JSONObject.toJSONString(imageDO);
                    break;
                case "links":
                    LinkDO linkDO = SpringBootService.getLinkService().selectById(dataId);
                    content = JSONObject.toJSONString(linkDO);
                    break;
                default:
                    logger.info("[删除的内容未增加到回收站]:" + requestURI);
                    break;
            }
            if (StringUtils.isNotBlank(content)) {
                TrashDO t = new TrashDO();
                t.setContent(content);
                t.setClassify(description);
                t.setDescription(description);
                SpringBootService.getTrashService().insert(t);
            }
        }
        return true;
    }

    /**
     * @description:方法执行之后,页面渲染前
     * @auther: WBA
     * @date: 2018/12/11 17:06
     * @param: [request, response, o, modelAndView]
     * @return: void
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) {
    }

    /**
     * @description:整个请求结束后,页面也渲染完毕,一般是资源清理操作
     * @auther: WBA
     * @date: 2018/12/11 17:07
     * @param: [request, response, o, e]
     * @return: void
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    }
}