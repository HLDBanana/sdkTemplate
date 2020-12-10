package com.yss.datamiddle.util;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.HttpURLConnection;
import java.util.*;

/**
 * @description: httpclient工具类
 * @author: Han LiDong
 * @create: 2020-07-20 14:00:00
 * @update: 2020-07-20 14:00:00
 */
public class HttpClient {

    /**
     * post请求传输map数据
     *
     * @param url url地址
     * @param body 请求体参数
     * @param header 请求头参数
     * @return
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static String sendPostRequest(String url, Map<String,Object> body,Map<String,String> header) throws IOException {
        String result = "";
        // 创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);
        // 装填参数
        List nameValuePairs = new ArrayList();
        if (body != null) {
            for (Map.Entry entry : body.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair((String) entry.getKey(), String.valueOf(entry.getValue())));
            }
        }
        // 设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "utf-8"));
        // 设置header信息
        // 指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        for (String key : header.keySet()) {
            httpPost.setHeader(key, header.get(key));
        }
        // 执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = httpClient.execute(httpPost);
        // 获取结果实体
        // 判断网络连接状态码是否正常(0--200都是正常)
//        if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
//            result = EntityUtils.toString(response.getEntity(), "utf-8");
//        }
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        // 释放连接
        response.close();
        return result;
    }

    /**
     * 向目的URL发送get请求
     *
     * @param url          目的url
     * @param body   请求体参数
     * @param header 请求头参数
     * @return String
     */
    public static String sendGetRequest(String url,Map<String, Object> body, Map<String, String> header) {
        RestTemplate client = new RestTemplate();
        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        //给请求头设置参数
        for (String key : header.keySet()) {
            headers.add(key, header.get(key));
        }
        //headers.add("Content-Type","application/json");
        //设置请求方式 get/post
        HttpMethod method = HttpMethod.GET;
        // 设置提交方式这里设置成application/json格式
        //headers.setContentType(MediaType.APPLICATION_JSON);
        //将请求头部和参数合成一个请求
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(body, headers);
        url = appendUrl(url,body);
        //执行HTTP请求，将返回的结构使用String 类格式化
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);
        return response.getBody();
    }

    /**
     * get请求地址拼接
     * @param url
     * @param bodyParams
     * @return
     */
    public static String appendUrl(String url, Map<String, Object> bodyParams){
        boolean flag = true;
        for (String key : bodyParams.keySet()){
            if (flag){
                url = url + "?" + key + "=" + bodyParams.get(key);
                flag = false;
            } else {
                url = url + "&" + key + "=" + bodyParams.get(key);
            }
        }
        return url;
    }

    /**
     * 向目的URL发送delect请求
     *
     * @param url          目的url
     * @param headerParams 请求头参数
     * @param bodyParams   请求体参数
     * @return AdToutiaoJsonTokenData
     */
    public static String sendDelectRequest(String url, Map<String, String> headerParams,
                                           Map<String, String> bodyParams) {
        RestTemplate client = new RestTemplate();
        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        //给请求头设置参数
        for (String key : headerParams.keySet()) {
            headers.add(key, headerParams.get(key));
        }
        //设置请求发送方式
        HttpMethod method = HttpMethod.DELETE;
        // 设置提交方式这里设置成application/json格式
        headers.setContentType(MediaType.APPLICATION_JSON);
        //将请求头部和参数合成一个请求
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(bodyParams, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);

        return response.getBody();
    }

    /**
     * 向目的URL发送patch请求
     * 由于httpclient不支持patch请求，所以需要反射方式获取连接对象，增加patch方式
     * @param url          目的url
     * @param headerParams 请求头参数
     * @param bodyParams   请求体参数
     * @return AdToutiaoJsonTokenData
     */
    public static String sendPatchRequest(String url, Map<String, String> headerParams,
                                          Map<String, String> bodyParams) {

        //httpclient不支持patch请求，反射方式获取连接对象，增加patch方式
        allowMethods("PATCH");
        RestTemplate client = new RestTemplate();
        //新建Http头，add方法可以添加参数
        HttpHeaders headers = new HttpHeaders();
        //给请求头设置参数
        for (String key : headerParams.keySet()) {
            headers.add(key, headerParams.get(key));
        }
        //headers.add("X-HTTP-Method-Override", "PATCH");
        //设置请求发送方式
        HttpMethod method = HttpMethod.PATCH;
        // 设置提交方式这里设置成application/json格式
        headers.setContentType(MediaType.APPLICATION_JSON);
        //将请求头部和参数合成一个请求
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(bodyParams, headers);
        //执行HTTP请求，将返回的结构使用String 类格式化（可设置为对应返回值格式的类）
        ResponseEntity<String> response = client.exchange(url, method, requestEntity, String.class);

        return response.getBody();
    }
    //增加支持patch请求方式
    private static void allowMethods(String... methods) {
        try {
            Field methodsField = HttpURLConnection.class.getDeclaredField("methods");

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(methodsField, methodsField.getModifiers() & ~Modifier.FINAL);

            methodsField.setAccessible(true);

            String[] oldMethods = (String[]) methodsField.get(null);
            Set<String> methodsSet = new LinkedHashSet<>(Arrays.asList(oldMethods));
            methodsSet.addAll(Arrays.asList(methods));
            String[] newMethods = methodsSet.toArray(new String[0]);

            methodsField.set(null/*static field*/, newMethods);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalStateException(e);
        }
    }

}
