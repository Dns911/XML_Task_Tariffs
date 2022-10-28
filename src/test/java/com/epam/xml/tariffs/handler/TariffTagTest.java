package com.epam.xml.tariffs.handler;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TariffTagTest {

    @Test
    public void testGetTag() {
        TariffTag expected = TariffTag.TARIFF;
        TariffTag actual = TariffTag.getTag(TariffTag.TARIFF.getValue());
        Assert.assertEquals(actual, expected);
    }

}