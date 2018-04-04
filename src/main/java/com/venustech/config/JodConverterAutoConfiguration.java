package com.venustech.config;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jodconverter.DocumentConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

/**
 * @author robin(贾永伟)
 * @PackgeName: com.venustech.config
 * @Description: 请添加描述...
 * @date 18-4-2 13:21
 */
@Configuration
@ConditionalOnClass({DocumentConverter.class})
@ConditionalOnProperty(
        prefix = "jodconverter",
        name = {"enabled"},
        havingValue = "true",
        matchIfMissing = false
)
@EnableConfigurationProperties({JodConverterProperties.class})
public class JodConverterAutoConfiguration {
    private final JodConverterProperties properties;

    public JodConverterAutoConfiguration(JodConverterProperties properties) {
        this.properties = properties;
    }

    private OfficeManager createOfficeManager() {
        LocalOfficeManager.Builder builder = LocalOfficeManager.builder();
        if (!StringUtils.isBlank(this.properties.getPortNumbers())) {
            Set<Integer> iports = new HashSet();
            String[] var3 = StringUtils.split(this.properties.getPortNumbers(), ", ");
            int var4 = var3.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String portNumber = var3[var5];
                iports.add(NumberUtils.toInt(portNumber, 2002));
            }

            builder.portNumbers(ArrayUtils.toPrimitive((Integer[])iports.toArray(new Integer[iports.size()])));
        }

        builder.officeHome(this.properties.getOfficeHome());
        builder.workingDir(this.properties.getWorkingDir());
        builder.templateProfileDir(this.properties.getTemplateProfileDir());
        builder.killExistingProcess(this.properties.isKillExistingProcess());
        builder.processTimeout(this.properties.getProcessTimeout());
        builder.processRetryInterval(this.properties.getProcessRetryInterval());
        builder.taskExecutionTimeout(this.properties.getTaskExecutionTimeout());
        builder.maxTasksPerProcess(this.properties.getMaxTasksPerProcess());
        builder.taskQueueTimeout(this.properties.getTaskQueueTimeout());
        return builder.build();
    }

    @Bean(
            initMethod = "start",
            destroyMethod = "stop"
    )
    @ConditionalOnMissingBean
    public OfficeManager officeManager() {
        return this.createOfficeManager();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean({OfficeManager.class})
    public DocumentConverter jodConverter(OfficeManager officeManager) {
        return LocalConverter.make(officeManager);
    }
}
