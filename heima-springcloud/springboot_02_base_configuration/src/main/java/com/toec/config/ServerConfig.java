package com.toec.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

//@Component
// 2.开启对当前bean 的属性注入校验
@Validated
@Data
@ConfigurationProperties(prefix = "servers")
public class ServerConfig {
    private String ipAddress;
    // 3.设置具体的规则
    @Max(value=8888 , message = "最大值不得超过8888")
    @Min(value = -888, message = "最小值不得超过-888")
//    @NotEmpty
    private int port;

    private long timeout;

    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;

    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
