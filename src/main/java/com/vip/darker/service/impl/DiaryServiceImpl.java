package com.vip.darker.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.vip.darker.dao.DiaryMapper;
import com.vip.darker.model.DiaryModel;
import com.vip.darker.service.DiaryService;
import org.springframework.stereotype.Service;

@Service(value = "diaryService")
public class DiaryServiceImpl extends ServiceImpl<DiaryMapper,DiaryModel> implements DiaryService {
}
