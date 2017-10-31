package com.comup.personal.site.service.impl;

import com.comup.personal.site.service.GitHubService;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Comup
 */
@Service
public class GitHubServiceImpl implements GitHubService {

    private static final Logger logger = LoggerFactory.getLogger(GitHubServiceImpl.class);

    @Override
    public String getToken(HttpServletRequest request, String code, String state) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://github.com/login/oauth/access_token");
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("client_id","78801b95845d1f192c38"));
        nvps.add(new BasicNameValuePair("client_secret","f10bd1cbf606655c94903cb2aacace494476b2cd"));
        nvps.add(new BasicNameValuePair("code", code));
        nvps.add(new BasicNameValuePair("state", state));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//        Enumeration<String> headerNames = request.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            httpPost.setHeader(headerName, request.getHeader(headerName));
//        }
        String content = "";
        try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            if (entity2 != null && entity2.isStreaming()) {
                byte[] bytes = new byte[entity2.getContent().available()];
                entity2.getContent().read(bytes);

                logger.info("");
                content = new String(bytes, Charset.forName(entity2.getContentEncoding().getValue()));

                entity2.getContent().close();
                EntityUtils.consume(entity2);

                return content;
            }
        }
        return content;
    }
}
