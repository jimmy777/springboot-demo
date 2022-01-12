package io.abc.springboot.controllers;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PrometheusController {

    @GetMapping("/prometheus")
    public String getPrometheus() throws IOException {
        String query = "up";
        String url = "http://192.168.209.41:9090/api/v1/targets";
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.custom().build();
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //请求体内容
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            httpClient.close();
        }
        return "prometheus";
    }
}
