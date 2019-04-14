
package io.qkits.testerint.postman.model;

import java.util.List;

/**
 *
 * @author jmone15
 */
public class Collection {
    
    private Info info;
    private List<Item> item;

    public Collection(Info info, List<Item> item) {
        this.info = info;
        this.item = item;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Item> getItems() {
        return item;
    }

    public void setItems(List<Item> item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Collection{" + "info=" + info + ",\n items=" + item + '}';
    }
    
}
