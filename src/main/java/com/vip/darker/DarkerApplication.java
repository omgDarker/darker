package com.vip.darker;

import com.vip.darker.system.SpringBootApplicationContent;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 *                             _ooOoo_
 *                            o8888888o
 *                            88" . "88
 *                            (| -_- |)
 *                             O\ = /O
 *                         ____/`---'\____
 *                       .   ' \\| |// `.
 *                        / \\||| : |||// \
 *                      / _||||| -:- |||||- \
 *                        | | \\\ - /// | |
 *                      | \_| ''\---/'' | |
 *                       \ .-\__ `-` ___/-. /
 *                    ___`. .' /--.--\ `. . __
 *                 ."" '< `.___\_<|>_/___.' >'"".
 *                | | : `- \`.;`\ _ /`;.`/ - ` : | |
 *                  \ \ `-. \_ __\ /__ _/ .-` / /
 *          ======`-.____`-.___\_____/___.-`____.-'======
 *                             `=---='
 *
 *          .............................................
 *                   [佛祖镇楼]       [BUG辟易]
 *           佛曰:
 *                   写字楼里写字间，写字间里程序员；
 *                   程序人员写程序，又拿程序换酒钱。
 *                   酒醒只在网上坐，酒醉还来网下眠；
 *                   酒醉酒醒日复日，网上网下年复年。
 *                   但愿老死电脑间，不愿鞠躬老板前；
 *                   奔驰宝马贵者趣，公交自行程序员。
 *                   别人笑我忒疯癫，我笑自己命太贱；
 *                   不见满街漂亮妹，哪个归得程序员？
 */
@SpringBootApplication // 启动类注释
@MapperScan("com.vip.darker.dao")
public class DarkerApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(DarkerApplication.class, args);
        // 获取容器上下文
        SpringBootApplicationContent.setApplicationContext(applicationContext);
    }
}
