package test.testng.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class OkHttpUtils {

    private final static Logger logger = LoggerFactory.getLogger(OkHttpUtils.class);
    private OkHttpClient okHttpClient;
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
    private static OkHttpUtils mInstance;

    // 设置连接超时时间，单位毫秒。
    private static final int CONNECT_TIMEOUT = 20000;

    // 设置获取数据超时时间，单位毫秒。
    private static final int SOCKET_TIMEOUT = 20000;

    //设置超时时间
    public OkHttpUtils() {
        okHttpClient = new OkHttpClient.Builder()
                .cookieJar(new CookieJar() {
                    Map<String, List<Cookie>> cookies = new HashMap<>();
                    @Override
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        cookies.put(httpUrl.host(), list);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        return cookies.getOrDefault(httpUrl.host(), Collections.emptyList());
                    }
                })
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(SOCKET_TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
    }

    //单例模式
    public static OkHttpUtils instance() {
        if (mInstance == null) {
            synchronized (OkHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpUtils();
                }
            }
        }
        return mInstance;
    }

    //设置Cookie
    public void setCookieStore(String url, String cookie) {
        List<Cookie> cookieList = okHttpClient.cookieJar().loadForRequest(HttpUrl.get(url));
        List arrList = new ArrayList(cookieList);
        Cookie ck = new Cookie.Builder().name("access-token").value(cookie).domain(HttpUrl.get(url).host()).build();
        arrList.add(ck);
        okHttpClient.cookieJar().saveFromResponse(HttpUrl.get(url), arrList);
    }

    //设置header
    private Headers setHeader(String url, Map<String, String> header) {

        Headers.Builder headerBuilder = new Headers.Builder();
        for (Map.Entry<String, String> e : header.entrySet()) {
            headerBuilder.add(e.getKey(), e.getValue());
        }
        return headerBuilder.build();
    }

    //拼链接
    private String setParams(String url, Map<String, String> params) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        for (Map.Entry<String, String> e : params.entrySet()) {
            try {
                urlBuilder.addQueryParameter(e.getKey(), URLEncoder.encode(e.getValue(), "UTF-8"));
            } catch (UnsupportedEncodingException e1) {
                urlBuilder.addQueryParameter(e.getKey(), e.getValue());
            }
        }
        return urlBuilder.build().toString();
    }

    //request
    private JSONObject conRequest(Request request){
        String result = "";
        JSONObject json = new JSONObject();
        try {
            Call call = okHttpClient.newCall(request);
            Response response = call.execute();
            if (response.isSuccessful()) {
                result = response.body().string();
                json = JSONObject.parseObject(result);
//                logger.info("request url:{}; request response:{}", request.url().toString(), response.toString());
            } else {
                logger.info("request failure url:{}; message:{}", request.url().toString(), response.toString());
            }
        } catch (IOException e) {
            logger.info("error message:{}", e.getMessage());
        }
        return json;
    }

    public JSONObject get(Map<String, String> headers, String url, Map<String, String> params) {

        StringBuilder urlBuilder = new StringBuilder();
        //拼链接
        if (params != null) {
            urlBuilder.append(setParams(url, params));
        }else {
            urlBuilder.append(url);
        }

        //设置headers
        Request request;
        if (headers != null) {
            Headers head = setHeader(urlBuilder.toString(), headers);
            request = new Request.Builder()
                    .url(urlBuilder.toString())
                    .headers(head)
                    .build();
        }else {
            request = new Request.Builder()
                    .url(urlBuilder.toString())
                    .build();
        }
        return conRequest(request);
    }

    public JSONObject get(String url) {
        return get(null, url, null);
    }

    public JSONObject get(Map<String, String> headers, String url) {
        return get(headers, url, null);
    }

    public JSONObject post(Map<String, String> headers, String url, Map<String, Object> requestBody) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, JSON.toJSONBytes(requestBody, SerializerFeature.WriteMapNullValue));
        Request request;
        if (headers != null) {
            Headers head = setHeader(url, headers);
            request = new Request.Builder()
                    .url(url)
                    .headers(head)
                    .post(body)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        }
        return conRequest(request);
    }

    public JSONObject post(String url, Map<String, Object> requetBody) {
        return post(null, url, requetBody);
    }

    public JSONObject put(Map<String, String> headers, String url, Map<String, Object> requestBody) {
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, JSON.toJSONBytes(requestBody, SerializerFeature.WriteMapNullValue));
        Request request;
        if (headers != null) {
            Headers head = setHeader(url, headers);
            request = new Request.Builder()
                    .url(url)
                    .headers(head)
                    .put(body)
                    .build();
        } else {
            request = new Request.Builder()
                    .url(url)
                    .put(body)
                    .build();
        }

        return conRequest(request);
    }


}
