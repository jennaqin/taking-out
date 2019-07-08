package com.keshe.luntan.utils.manager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SmsManager {

    private static ConcurrentHashMap<String, String> smsMap = new ConcurrentHashMap<>(1000);
    private static ScheduledThreadPoolExecutor removeExecutor = new ScheduledThreadPoolExecutor(3);

    private SmsManager() {}

    public static void addSms(String key, String code) {
        smsMap.put(key,code);
        removeExecutor.schedule(() -> smsMap.remove(key),1,TimeUnit.MINUTES);
    }

    public static boolean tryAddSms(String key) {

        return smsMap.get(key) == null ? false : true;
    }

    public static String getSms(String key) {
        return smsMap.get(key);
    }

    public static void deleteSms(String key) {
        smsMap.remove(key);
    }

    public static void clearLoginflag() {
        smsMap.clear();
    }
}
