package com.lee.springboot.dynamic.datasource;

/**增加多数据源,在此配置
 * @author lee
 * @date 2019/12/23 15:26
 */
public enum DataSourceNames {
    FIRST("first"), SECOND("second");
    private String name;

    DataSourceNames(String name) {
        this.name = name;
    }
}
