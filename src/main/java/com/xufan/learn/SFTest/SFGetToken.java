package com.xufan.learn.SFTest;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XuFan
 * @create 2023-09-14-11:02
 */
public class SFGetToken {
    public static void main(String[] args) throws IOException {
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://login.salesforce.com/services/oauth2/token");

        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("grant_type", "password"));
        parameters.add(new BasicNameValuePair("client_id",  "3MVG9fe4g9fhX0E4sIdbAOJh1dh7KbLRPHQF0Qn51_VngoGIavecdF1.HW44Tb6t6.Dj3juY32KVglhvCmz94"));
        parameters.add(new BasicNameValuePair("client_secret", "D23A034813002A2A1CB46FDA24C5823361FD947A12631A0615CFB10EF2650C70"));
        parameters.add(new BasicNameValuePair("username", "xufan-upe3@force.com"));
        parameters.add(new BasicNameValuePair("password", "XUFAN202411"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);

        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应体
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (response != null) {
                response.close();
            }
            // 关闭浏览器
            httpclient.close();
        }
    }
}
