package com.alibaba.csp.sentinel.dashboard.rule.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sentinel.config.nacos")
public class NacosConfigProperties {

    /**
     * nacos服务器地址
     */
    private String serverAddr;

    /**
     * nacos命名空间
     */
    private String namespace;

    /**
     * 分组名
     */
    private String groupId = NacosConfigUtil.GROUP_ID;

    /**
     * 限流规则dataId后缀
     */
    private String flowRuleDataIdSuffix = NacosConfigUtil.FLOW_DATA_ID_POSTFIX;

    /**
     * 降级规则dataId后缀
     */
    private String degradeRuleDataIdSuffix = NacosConfigUtil.DEGRADE_DATA_ID_POSTFIX;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getFlowRuleDataIdSuffix() {
        return flowRuleDataIdSuffix;
    }

    public void setFlowRuleDataIdSuffix(String flowRuleDataIdSuffix) {
        this.flowRuleDataIdSuffix = flowRuleDataIdSuffix;
    }

    public String getDegradeRuleDataIdSuffix() {
        return degradeRuleDataIdSuffix;
    }

    public void setDegradeRuleDataIdSuffix(String degradeRuleDataIdSuffix) {
        this.degradeRuleDataIdSuffix = degradeRuleDataIdSuffix;
    }
}
