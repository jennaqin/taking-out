package com.keshe.luntan.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import net.minidev.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {

    private static final byte[] secret = "mygirlfriendisxujingilovehervery".getBytes();

    //生成一个token
    private static String creatToken(Map<String,Object> payloadMap) throws JOSEException {

        //3.先建立一个头部Header,用hs256算法加密
        JWSHeader jwsHeader = new JWSHeader(JWSAlgorithm.HS256);

        //建立一个载荷Payload
        Payload payload = new Payload(new JSONObject(payloadMap));

        //将头部和载荷结合在一起
        JWSObject jwsObject = new JWSObject(jwsHeader, payload);

        //建立一个密匙
        JWSSigner jwsSigner = new MACSigner(secret);

        //签名
        jwsObject.sign(jwsSigner);

        //生成token
        return jwsObject.serialize();
    }

    public static String getToken(int user_id, Long time) throws JOSEException {
        //获取生成token
        Map<String, Object> map = new HashMap<>();
        map.put("userid", user_id);
        //生成时间
        map.put("sta", System.currentTimeMillis());
        //过期时间
        map.put("exp", System.currentTimeMillis()+time);
        String token = TokenUtils.creatToken(map);
        System.out.println("token="+token);
        return token;
    }

    public static Map<String,Object> valid(String token) throws ParseException, JOSEException {

//        解析token

        JWSObject jwsObject = JWSObject.parse(token);

        //获取到载荷
        Payload payload=jwsObject.getPayload();

        //建立一个解锁密匙
        JWSVerifier jwsVerifier = new MACVerifier(secret);

        Map<String, Object> resultMap = new HashMap<>();
        //判断token
        if (jwsObject.verify(jwsVerifier)) {
            resultMap.put("Result", 0);
            //载荷的数据解析成json对象。
            JSONObject jsonObject = payload.toJSONObject();
            resultMap.put("data", jsonObject);

            //判断token是否过期
            if (jsonObject.containsKey("exp")) {
                Long expTime = Long.valueOf(jsonObject.get("exp").toString());
                Long nowTime = System.currentTimeMillis();
                //判断是否过期
                if (nowTime > expTime) {
                    //已经过期
                    resultMap.put("Result", 1);

                }
            }
        }else {
            resultMap.put("Result", 2);
        }
        return resultMap;
    }
}
