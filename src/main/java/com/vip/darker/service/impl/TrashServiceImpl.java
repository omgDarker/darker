package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.TrashMapper;
import com.vip.darker.model.TrashModel;
import com.vip.darker.service.TrashService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Darker
 * @Date: 2018/7/19 23:00
 * @Description: 回收service
 */
@Service(value = "trashService")
public class TrashServiceImpl extends ServiceImpl<TrashMapper, TrashModel> implements TrashService {
}
