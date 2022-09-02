package com.toec.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CodeUtils {

    private String[] patch = {"00000","0000","000","00","0",""};

    public String generator(String telephoto){
        int hash = telephoto.hashCode();
        int encryption =new Random().nextInt();
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code =Math.abs(result % 1000000);
        String codeStr = String.valueOf(code);
        return patch[codeStr.length()-1] + codeStr;
    }

}
