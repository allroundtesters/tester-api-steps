
package io.qkits.testerint.postman.model;

import java.util.List;

/**
 *
 * @author editor
 */
public class Url {
    
    private String raw;
    private String protocol;
    private List<String> host;
    private List<String> path;
    private List<Query> query;

    public Url(String raw, String protocol, List<String> host, List<String> path, List<Query> query) {
        this.raw = raw;
        this.protocol = protocol;
        this.host = host;
        this.path = path;
        this.query = query;
    }

    public Url() {
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public List<String> getHosts() {
        return host;
    }

    public void setHosts(List<String> host) {
        this.host = host;
    }

    public List<String> getPaths() {
        return path;
    }

    public void setPaths(List<String> path) {
        this.path = path;
    }

    public List<Query> getQuery() {
        return query;
    }

    public void setQuery(List<Query> query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Url{" + "raw=" + raw + ", protocol=" + protocol + ", hosts=" + host + ", paths=" + path + ", query=" + query + '}';
    } 
}
