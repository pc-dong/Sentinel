package com.alibaba.csp.sentinel.dashboard.rule;

import com.alibaba.csp.sentinel.dashboard.rule.config.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;

public abstract class AbstractNacosProvider<T> implements DynamicRuleProvider<List<T>> {

    private static final long timeoutInMills = 3000;

    private final NacosConfigProperties nacosConfigProperties;

    private final ConfigService configService;

    private final Converter<String, List<T>> converter;

    protected AbstractNacosProvider(NacosConfigProperties nacosConfigProperties,
                                    ConfigService configService,
                                    Converter<String, List<T>> converter) {
        this.nacosConfigProperties = nacosConfigProperties;
        this.configService = configService;
        this.converter = converter;
    }

    @Override
    public List<T> getRules(String appName) throws Exception {
        String dataId = appName + getDataIdSuffix();
        String groupId = nacosConfigProperties.getGroupId();
        String rules = configService.getConfig(dataId, groupId, timeoutInMills);
        return StringUtil.isEmpty(rules) ? Collections.emptyList() : converter.convert(rules);
    }

    protected NacosConfigProperties getNacosConfigProperties() {
        return nacosConfigProperties;
    }

    protected abstract String getDataIdSuffix();
}
