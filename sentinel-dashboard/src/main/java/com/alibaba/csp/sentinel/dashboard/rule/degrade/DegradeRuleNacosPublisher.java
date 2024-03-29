package com.alibaba.csp.sentinel.dashboard.rule.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.AbstractNacosPublisher;
import com.alibaba.csp.sentinel.dashboard.rule.config.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("degradeRuleNacosPublisher")
public class DegradeRuleNacosPublisher extends AbstractNacosPublisher<DegradeRuleEntity> {

    protected DegradeRuleNacosPublisher(NacosConfigProperties nacosConfigProperties, ConfigService configService, Converter<List<DegradeRuleEntity>, String> converter) {
        super(nacosConfigProperties, configService, converter);
    }

    @Override
    protected String getDataIdSuffix() {
        return super.getNacosConfigProperties().getDegradeRuleDataIdSuffix();
    }
}
