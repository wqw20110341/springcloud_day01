package com.toec.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.toec.domain.SMSCode;
import com.toec.service.SMSCodeService;
import com.toec.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    // 自定义缓存对象
    @CreateCache(name = "jetCache_",expire = 100 ,timeUnit = TimeUnit.SECONDS,cacheType = CacheType.LOCAL)
//    @CreateCache(area = "sms",name = "jetCache_",expire = 10 ,timeUnit = TimeUnit.SECONDS)
    private Cache<String,String> jetCache;

    @Override
    public String sendCodeToSMS(String telephoto) {
        String code = codeUtils.generator(telephoto);
        jetCache.put(telephoto,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = jetCache.get(smsCode.getTelephoto());
        return code.equals(cacheCode);
    }

}
