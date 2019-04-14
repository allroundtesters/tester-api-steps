
package io.qkits.testerint.postman.model;

/**
 *
 * @author jmone15
 */
public class Query {
    
    private String key;
    private String value;
    private boolean disabled;

    public Query() {
    }

    public Query(String key, String value, boolean disabled) {
        this.key = key;
        this.value = value;
        this.disabled = disabled;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "Query{" + "key=" + key + ", value=" + value + ", disabled=" + disabled + '}';
    }
   
}
