package io.qkits.common.utils;

import lombok.Data;

/**
 * @author patrick
 * @date created on 2019-05-07
 **/
@Data
public class Triple<L,M,R> {
    private L left;
    private M middle;
    private R right;
}
