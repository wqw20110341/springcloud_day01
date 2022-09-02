package com.toec.service.impl;

import com.toec.domain.SMSCode;
import com.toec.service.SMSCodeService;
import com.toec.utils.CodeUtils;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    @Autowired
    private CacheChannel cacheChannel;

    @Override
    public String sendCodeToSMS(String telephoto) {
        String code = codeUtils.generator(telephoto);
        cacheChannel.set("sms",telephoto,code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String smsCacheCode = cacheChannel.get("sms", smsCode.getTelephoto()).asString();
        return code.equals(smsCacheCode);
    }

}
