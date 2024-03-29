package com.vip.darker.controller;

import com.vip.darker.constant.CommonConstant;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Darker
 * @Date: 2018/9/17 10:44
 * @Description: DBMS控制器
 */
@RestController
@RequestMapping("dbms")
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DbmsController {

    /**
     * 数据库驱动
     */
    private String driverClassName;
    /**
     * 数据库连接
     */
    private String url;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * @description:获取数据库表信息
     * @auther: WBA
     * @date: 2018/12/11 16:41
     * @param: []
     * @return: java.util.Map<java.lang.String, java.lang.Object>
     */
    @RequestMapping(value = "/tables", method = RequestMethod.GET)
    public Map<String, Object> getTables() {
        // 数据库连接
        Connection conn = null;
        // 结果集
        Map<String, Object> result = new HashMap<>(CommonConstant.MAP_DEFAULT_INITIAL_CAPACITY);

        try {
            // 加载数据库驱动
            Class.forName(driverClassName).newInstance();
            // 获取数据库连接
            conn = DriverManager.getConnection(url, username, password);
            // 获取数据库信息
            DatabaseMetaData dbMetaData = conn.getMetaData();
            // 获取数据库表信息
            ResultSet tableSet = dbMetaData.getTables(null, null, null, new String[]{"TABLE"});
            while (tableSet.next()) {
                // 获取数据库表名
                String tableName = tableSet.getString("TABLE_NAME");

                PreparedStatement ps = conn.prepareStatement("SELECT * FROM" + tableName);
                // 获取查询表的字段信息
                ResultSet columnSet = ps.executeQuery();
                ResultSetMetaData meta = columnSet.getMetaData();
                Map<String, Object> column = new HashMap<>((int) (meta.getColumnCount() / 0.75 + 1));
                for (int i = 1; i < meta.getColumnCount() + 1; i++) {
                    column.put(meta.getColumnName(i), meta.getColumnType(i));
                }
                result.put(tableName, column);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}