
package io.qkits.testerint.postman.model;

import java.util.List;

/**
 *
 * @author jmone15
 */
public class Request {
    
    private String method;
    private List<String> header;
    private Body body;
    private Url url;
    private String description;

    public Request(String method, List<String> header, Body body, Url url, String description) {
        this.method = method;
        this.header = header;
        this.body = body;
        this.url = url;
        this.description = description;
    }

    public Request() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }
  

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Url getUrl() {
        return url;
    }

    public void setUrl(Url url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Request{" + "method=" + method + ", header=" + header.toString() + ", body=" + body + ", url=" + url + ", description=" + description + '}';
    }
    
}
