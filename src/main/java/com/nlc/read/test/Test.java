package com.nlc.read.test;

/**  
 * @Title: Test.java
 * @Package com.nlc.read.test
 * @Description: 
 * @author 王金龙  
 * @date 2016年8月17日 下午2:39:02
 * @version V1.0  
 */

import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.nlc.read.common.constant.Constants;
import com.nlc.read.common.dto.ReqValue;
import com.nlc.read.common.dto.server.message.QryMessageListJson;
import com.nlc.read.common.util.DESUtil;
import com.nlc.read.test.util.HttpUtil;
import com.nlc.read.test.util.MD5Util;

/**
 * @ClassName: Test
 * @Description:
 * @author 王金龙
 * @date 2016年8月17日 下午2:39:02
 *
 */
public class Test {
public static void main(String[] args) {
	String t = "eyG3QKRQ3rQch4qg4FP40uLb2h1zmj53+zlUscOB58k=";
	System.out.println(DESUtil.decrypt(t, Constants.PUBLIC_DES_KEY));
}
}
