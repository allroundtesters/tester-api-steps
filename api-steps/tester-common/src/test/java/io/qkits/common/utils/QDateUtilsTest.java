package io.qkits.common.utils;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;
@Epic("Date Utils")
public class QDateUtilsTest {

    @Test
    @Feature("Date to Triple: Year, Month, Date")
    public void testAsTriple() {
        Triple ymd = QDateUtils.asTriple("2019-12-07");
        Assertions.assertThat(ymd.getLeft()).isEqualTo(2019);
        Assertions.assertThat(ymd.getMiddle()).isEqualTo(12);
        Assertions.assertThat(ymd.getRight()).isEqualTo(7);
    }

    @Test
    @Feature("Date to Triple: Year, Month, Date")
    public void asTriple_forMilSeconds() {


        Triple ymd = QDateUtils.asTriple(1557196708218L);
        Assertions.assertThat(ymd.getLeft()).isEqualTo(2019);
        Assertions.assertThat(ymd.getMiddle()).isEqualTo(5);
        Assertions.assertThat(ymd.getRight()).isEqualTo(7);

    }

    @Test
    @Feature("Date Minus Month")
    public void asMinusMonth() {
        int result = QDateUtils.minusMonthsFromNow(3);
        Assertions.assertThat(result).isEqualTo(2);
    }
}