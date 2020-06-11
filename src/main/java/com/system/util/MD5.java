package com.system.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * @author JGW
 * @version 1.0
 * @date 2020/6/7 13:18
 */
public class MD5 {
    public static String getMD5(String Resources,Object uid) {
        SimpleHash simpleHash = new SimpleHash("MD5", Resources,
                ByteSource.Util.bytes(String.valueOf(uid)), 1024);
        return simpleHash.toString();
    }

}
