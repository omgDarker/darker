package com.vip.darker.system.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.HttpPutFormContentFilter;

/**
 * @Auther: Darker
 * @Date: 2018/7/24 15:19
 * @Description: 开启put请求过滤
 */
@Component
public class PutFilter extends HttpPutFormContentFilter {
}
