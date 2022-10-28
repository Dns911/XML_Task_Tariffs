package com.epam.xml.tariffs.handler;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TariffTagTest {
    @DataProvider(name = "getTagCheck")
    public Object[][] testData() {
        return new TariffTag[][]{{TariffTag.TARIFFICATION, TariffTag.TARIFFICATION}, {TariffTag.SMS_PRICE, TariffTag.SMS_PRICE}};
    }

    @Test(dataProvider = "getTagCheck")
    public void testGetTag(TariffTag actual, TariffTag expected) {
        actual = TariffTag.getTag(actual.getValue());
        Assert.assertEquals(actual, expected);
    }

}