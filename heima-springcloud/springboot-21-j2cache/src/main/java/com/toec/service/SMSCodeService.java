package com.toec.service;

import com.toec.domain.SMSCode;

public interface SMSCodeService {
    String sendCodeToSMS(String telephoto);
    boolean checkCode(SMSCode smsCode);
}
