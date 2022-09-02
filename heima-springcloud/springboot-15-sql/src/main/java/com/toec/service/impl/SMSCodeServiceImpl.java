package com.toec.service.impl;

import com.toec.domain.SMSCode;
import com.toec.service.SMSCodeService;
import com.toec.utils.CodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;
    @Override
//    @Cacheable(value = "smsCode",key="#telephoto")
    @CachePut(value = "smsCode",key="#telephoto")
    public String sendCodeToSMS(String telephoto) {
        return codeUtils.generator(telephoto);
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        String cacheCode = codeUtils.get(smsCode.getTelephoto());
        return code.equals(cacheCode);
    }

}
