package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.DiaryMapper;
import com.vip.darker.model.DiaryModel;
import com.vip.darker.service.DiaryService;
import org.springframework.stereotype.Service;

@Service(value = DiaryServiceImpl.BEAN_NAME)
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper, DiaryModel> implements DiaryService {
    public static final String BEAN_NAME = "diaryService";
}
