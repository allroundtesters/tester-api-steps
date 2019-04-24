package io.qkits.rule.common.util;

import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

public class WString extends StringUtils{


    public static String join(String joinSeparator, String... text) {

        return Joiner.on(joinSeparator).join(text);
    }
}