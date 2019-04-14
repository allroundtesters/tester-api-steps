
package io.qkits.testerint.postman.model;

/**
 *
 * @author jmone15
 */
public class Info {

    private String _postman_id;
    private String name;
    private String description;
    private String schema;

    public Info(String _postman_id, String name, String description, String schema) {
        this._postman_id = _postman_id;
        this.name = name;
        this.description = description;
        this.schema = schema;
    }

    public Info() {
    }

    public String getPostman_id() {
        return _postman_id;
    }

    public void setPostman_id(String _postman_id) {
        this._postman_id = _postman_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    @Override
    public String toString() {
        return "Info{" + "postman_id=" + _postman_id + ", name=" + name + ", description=" + description + ", schema=" + schema + '}';
    }

}
