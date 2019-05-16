//package io.qkits.common.http;
//
//
//import io.hedwig.testing.base.core.data.ApiRequestData;
//import io.hedwig.testing.base.core.env.HostConstants;
//import io.restassured.RestAssured;
//import io.restassured.http.Method;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//
//public class WRestTemplateClient {
//
//    private RequestSpecification spec = RestAssured.given();
//
//
//    public WRestTemplateClient() {
//    }
//
//    public WRestTemplateClient(RequestSpecification spec) {
//        this.spec = spec;
//    }
//
//    public static WRestTemplateClient defaultInstance() {
//        return new WRestTemplateClient();
//    }
//
//    public static WRestTemplateClient defaultInstance(RequestSpecification spec) {
//        return new WRestTemplateClient(spec);
//    }
//
//    private Response request(ApiRequestData data) {
//
//        buildHeader(spec, data);
//        spec.params(data.getQueryParameters());
//        spec.pathParams(data.getPathParameters());
//        buildBody(spec, data);
//        System.out.println("request URI:"+data.getResourceURL());
//        System.out.println("query_parameters:"+data.getQueryParameters());
//        return spec.request(resolveMethod(data.getMethod()), data.getResourceURL());
//    }
//
//    public Response call(String host, int port, ApiRequestData data) {
//        spec.baseUri(host);
//        spec.port(port);
//        return request(data);
//    }
//
//    public Response call(String hostWithPort, ApiRequestData data) {
//        HostConstants.Host host = HostConstants.getHost(hostWithPort);
//        spec.baseUri(host.getHost());
//        if (host.getPort() != null) {
//            spec.port(Integer.parseInt(host.getPort()));
//        }
//
//        return request(data);
//    }
//
//
//    private Method resolveMethod(final String method) {
//        Method result = Method.GET;
//        for (Method definedMethod : Method.values()) {
//            if (definedMethod.name().equalsIgnoreCase(method)) {
//                result = definedMethod;
//                break;
//            }
//        }
//
//        return result;
//    }
//
//    private void buildHeader(RequestSpecification spec, ApiRequestData data) {
//        spec.header("content-type", "application/json");
//        spec.headers(data.getHeaders());
//    }
//
//    private void buildBody(RequestSpecification spec, ApiRequestData data) {
//        if (data.getRequestBody() != null) {
//            spec.body(data.getRequestBody());
//            return;
//        }
//    }
//
//    public RequestSpecification getSpec() {
//        return spec;
//    }
//
//    public void setSpec(RequestSpecification spec) {
//        this.spec = spec;
//    }
//
//    public WRestTemplateClient addHeader(String headerKey, String headerValue) {
//        this.spec.header(headerKey, headerValue);
//        return this;
//    }
//}
