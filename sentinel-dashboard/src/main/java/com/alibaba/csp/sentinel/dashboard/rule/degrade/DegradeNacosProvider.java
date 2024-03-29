package com.alibaba.csp.sentinel.dashboard.rule.degrade;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.DegradeRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.AbstractNacosProvider;
import com.alibaba.csp.sentinel.dashboard.rule.config.NacosConfigProperties;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("degradeRuleNacosProvider")
public class DegradeNacosProvider extends AbstractNacosProvider<DegradeRuleEntity> {

    public DegradeNacosProvider(NacosConfigProperties nacosConfigProperties,
                                ConfigService configService,
                                Converter<String, List<DegradeRuleEntity>> converter
                                ) {
        super(nacosConfigProperties, configService, converter);
    }

    @Override
    protected String getDataIdSuffix() {
        return super.getNacosConfigProperties().getDegradeRuleDataIdSuffix();
    }
}
