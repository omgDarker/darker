package com.vip.darker.service;

import com.github.pagehelper.PageInfo;
import com.vip.darker.model.ResourceModel;

public interface ResourceService {

    int addResource(ResourceModel resourceModel);

    int deleteResource(Integer resourceId);

    int updateResource(ResourceModel resourceModel);

    PageInfo<ResourceModel> queryAllResource(int pageNum, int pageSize);
}
