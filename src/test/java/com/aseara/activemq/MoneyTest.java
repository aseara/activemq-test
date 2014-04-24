package com.aseara.activemq;

import org.junit.Test;
import org.nevec.rjm.BigDecimalMath;
import org.nevec.rjm.Rational;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: aseara
 * Date: 2014/3/24
 * Time: 18:35
 */
public class MoneyTest {


    @Test
    public void test() {
        BigDecimal initMoney = new BigDecimal("10000.00");
        BigDecimal yearRat = new BigDecimal("1.05000000");
        int periodNum = 24;
        BigDecimal creditRat = new BigDecimal("-0.09000000");

        Rational r = new Rational(30, 365);
        BigDecimal monthRat = BigDecimalMath.powRound(yearRat, r);

        //double rat2 = 0.045;
        BigDecimal result = initMoney;
        BigDecimal fee = BigDecimalMath.multiplyRound(initMoney, creditRat);
        BigDecimal part = BigDecimalMath.multiplyRound(initMoney, new Rational(-1, periodNum));
        //result = BigDecimalMath.addRound(initMoney, )
        for (int i = 0; i < periodNum; i++) {
            result = BigDecimalMath.multiplyRound(result, monthRat);
            result = BigDecimalMath.addRound(result, part);
            if (i == 0) {
                result = BigDecimalMath.addRound(result, fee);
            }
        }
        System.out.println(result);
    }


}
