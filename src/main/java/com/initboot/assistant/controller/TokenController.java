package com.initboot.assistant.controller;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.initboot.assistant.dto.UserInfo;
import com.initboot.assistant.enums.ExceptionEnum;
import com.initboot.assistant.exception.BusinessException;
import com.initboot.assistant.thread.UserContext;
import com.initboot.assistant.util.GaiaI18nInternational;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Description: 获取accessToken
 * Author:   Jack.Li
 * Time:     2021/5/6 11:11
 * Version:  1.0.0
 */
@Slf4j
@RestController
@Api(description = "获取accessToken")
public class TokenController {

//    @Value("${keycloak.resource}")
//    private String masterClientId;
//
//    @Value("${keycloak.credentials.secret}")
//    private String masterClientSecret;
//
    @Autowired
    private GaiaI18nInternational hvisionsI18nInternational;
//
//    @ApiOperation(value = "获取accessToken")
//    @GetMapping(value = "/getAccessToken/{realm}/{username}/{password}")
//    public Object getAccessToken(@ApiParam(name = "realm", value = "租户", required = true) @PathVariable String realm,
//                                 @ApiParam(name = "username", value = "用户名", required = true) @PathVariable String username,
//                                 @ApiParam(name = "password", value = "密码", required = true) @PathVariable String password,
//                                 @RequestParam(value = "clientId", required = false) String clientId, @RequestParam(value = "clientSecret", required = false) String clientSecret) {
//        Map<String, Object> bodyParams = Maps.newHashMap();
//        bodyParams.put("client_id", StringUtils.isBlank(clientId) ? masterClientId : clientId);
//        bodyParams.put("client_secret", StringUtils.isBlank(clientSecret) ? masterClientSecret : clientSecret);
//        bodyParams.put("grant_type", "password");
//        bodyParams.put("username", username);
//        bodyParams.put("password", password);
//        try {
//            String responseBody = HttpUtil.post("https://identity-dev.XXXXX.com/auth/realms/" + realm + "/protocol/openid-connect/token", bodyParams);
//            return JSONUtil.toBean(responseBody, Map.class);
//        } catch (Exception e) {
//            log.error("请求sso获取token失败", e);
//            return ResultData.error(500, e.getMessage());
//        }
//    }

//    @ApiResultIgnore
    @ApiOperation(value = "testException")
    @GetMapping(value = "/testException")
    public Object testException() {
        String content = "test中文";

//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

//构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

//加密
        byte[] encrypt = aes.encrypt(content);
//解密
        byte[] decrypt = aes.decrypt(encrypt);

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
//解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

        UserInfo userInfo = UserContext.get();
        System.out.println(userInfo);

//        return "123123";
        throw new BusinessException(ExceptionEnum.DEMO_EXCEPTION.getCode(), hvisionsI18nInternational.getInterNationalMsg(ExceptionEnum.DEMO_EXCEPTION.getMessage()));
    }

    @ApiOperation(value = "读取classpath下的文件转成文件流")
    @GetMapping(value = "/testFileRead")
    public String testFileRead() throws Exception {
        InputStream is = ResourceUtil.getStream("sql/init-db.sql");
        FileOutputStream fos = new FileOutputStream("d:/temp/lfs.txt");
        byte[] b = new byte[1024];
        while ((is.read(b)) != -1) {
            fos.write(b);// 写入数据
        }
        is.close();
        fos.close();// 保存数据
        return "true";
    }
}
