package com.vip.darker.service.impl;


import com.github.pagehelper.PageInfo;
import com.vip.darker.dao.ResourceDao;
import com.vip.darker.model.ResourceModel;
import com.vip.darker.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "resourceService")
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDao resourceDao;

    @Override
    public int addResource(ResourceModel resourceModel) {
        return 0;
    }

    @Override
    public int deleteResource(Integer resourceId) {
        return 0;
    }

    @Override
    public int updateResource(ResourceModel resourceModel) {
        return 0;
    }

    @Override
    public PageInfo<ResourceModel> queryAllResource(int pageNum, int pageSize) {
        return null;
    }
}
