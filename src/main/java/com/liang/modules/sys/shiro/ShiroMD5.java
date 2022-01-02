package com.liang.modules.sys.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @ProjectName: test-blog-01
 * @Package: com.liang.modules.sys.shiro
 * @ClassName: ShiroMD5
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/1 23:15
 * @Version: 1.0
 */
public class ShiroMD5 {
    public static Object MD5(String phone, String password){
        // 与UserRealm中的认证方法一样，以手机号作为盐值进行MD5加盐
        ByteSource salt = ByteSource.Util.bytes(phone);

        // 参数分别是加密方式、待加密串(密码)、盐、加密次数
        // 这里的加密方式和次数要与ShiroConfig中我们写的hashedCredentialsMatcher一致
        return new SimpleHash("MD5", password, salt, 1024);
    }

    public static void main(String[] args) {
        // 保存密码到数据库的时候，可以将手机号、密码输入进来，这将生成一个加密后的字符串，
        // 将生成的加密字符串保存至数据库即可，下次登陆时将使用加密串进行核验
        System.out.println(MD5("12345678910", "123456"));
    }
}
