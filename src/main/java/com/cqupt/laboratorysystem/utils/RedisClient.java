package com.cqupt.laboratorysystem.utils;

import org.springframework.stereotype.Component;

/**
 * @create 2023/5/2 22:03
 */
@Component
public class RedisClient {

    /**
     * 限流脚本
     */
    public String buildLuaScript() {
        return "local c" +
                "\nc = redis.call('get',KEYS[1])" +
                "\nif c and tonumber(c) > tonumber(ARGV[1]) then" +
                "\nreturn c;" +
                "\nend" +
                "\nc = redis.call('incr',KEYS[1])" +
                "\nif tonumber(c) == 1 then" +
                "\nredis.call('expire',KEYS[1],ARGV[2])" +
                "\nend" +
                "\nreturn c;";
    }
}
