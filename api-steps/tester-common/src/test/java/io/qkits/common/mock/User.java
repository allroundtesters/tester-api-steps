package io.qkits.common.mock;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {

    private String id;
    @Excel(name = "user_name")
    private String userName;
    @Excel(name = "grade")
    private String test;

    public User() {
    }
}
