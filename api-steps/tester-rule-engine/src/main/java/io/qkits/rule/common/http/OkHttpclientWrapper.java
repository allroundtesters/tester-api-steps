package io.qkits.rule.common.http;

import io.qkits.pilotrunner.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;

/**
 * OKWrapper for API Client
 *
 * @param <Req>
 * @param <Res>
 */
@Slf4j
public class OkHttpclientWrapper<Req, Res> {
    private static String APPLICATION_JSON = "application/json";
    private static String CONTENT_TYPE = "Content-Type";

    public Res postForObject(String domainUrl, String routerUrl, Req req, Class returnClazz) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse(APPLICATION_JSON);
        RequestBody body = RequestBody.create(mediaType, JsonUtils.toJsonString(req));
        Request request = new Request.Builder()
                .url(domainUrl + routerUrl)
                .post(body)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            if(response.body()!=null){
                return JsonUtils.toBean(response.body().string(), returnClazz);
            }
        } catch (IOException e) {
           log.error("invoke {} failed,error={}",routerUrl,e);
        }

        try {
            return (Res) returnClazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            log.error("init class {} failed,error={}",returnClazz.getSimpleName(),e);
            throw new RuntimeException(e);
        }
    }
}
