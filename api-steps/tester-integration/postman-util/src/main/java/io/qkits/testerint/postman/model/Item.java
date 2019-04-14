
package io.qkits.testerint.postman.model;

import java.util.List;

/**
 *
 * @author jmone15
 */
public class Item {
    private String name;
    private Request request;
    private List<String> response;

    public Item(String name, Request request, List<String> response) {
        this.name = name;
        this.request = request;
        this.response = response;
    }

    public Item() {
    }

    public String getItemName() {
        return name;
    }

    public void setItemName(String itemName) {
        this.name = itemName;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public List<String> getResponse() {
        return response;
    }

    public void setResponse(List<String> response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Item{" + "itemName=" + name + ",\n request=" + request + ",\n response=" + response + '}';
    }    
}
