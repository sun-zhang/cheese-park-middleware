package com.hangwei.wanke.middleware.enums;

/**
 * 提供HTTP服务的各类服务名称枚举
 *
 * Created by Sam on 8/30/17.
 */
public enum ServiceNameEnum {
    CREATE("CreateApprovement","创建审批流程"),
    AUDIT("AuditApprovement","审批"),
    CLOSE("CloseApprovement","关闭审批流程")
    ;

    private String name;

    private String description;

    private ServiceNameEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
