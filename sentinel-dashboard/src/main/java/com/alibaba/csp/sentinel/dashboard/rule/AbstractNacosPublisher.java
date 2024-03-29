package com.alibaba.csp.sentinel.dashboard.rule;

import com.alibaba.csp.sentinel.dashboard.rule.config.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.common.utils.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.alibaba.nacos.api.config.ConfigType.JSON;

public abstract class AbstractNacosPublisher<T> implements DynamicRulePublisher<List<T>> {

        protected final NacosConfigProperties nacosConfigProperties;


    protected final ConfigService configService;


    protected final Converter<List<T>, String> converter;

    protected AbstractNacosPublisher(NacosConfigProperties nacosConfigProperties, ConfigService configService, Converter<List<T>, String> converter) {
        this.nacosConfigProperties = nacosConfigProperties;
        this.configService = configService;
        this.converter = converter;
    }

    @Override
    public void publish(String app, List<T> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (CollectionUtils.isEmpty(rules)) {
            return;
        }

        String dataId = app + getDataIdSuffix();
        String groupId = nacosConfigProperties.getGroupId();
        configService.publishConfig(dataId, groupId, converter.convert(rules), JSON.getType());
    }

    protected NacosConfigProperties getNacosConfigProperties() {
        return nacosConfigProperties;
    }

    protected abstract String getDataIdSuffix();
}
