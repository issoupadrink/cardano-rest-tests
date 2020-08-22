package com.cardano.rest.tests.functional;

import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected String host;

    @BeforeTest
    public void setupTests() {
        this.host = "https://explorer.cardano-testnet.iohkdev.io/api/";

        if (System.getProperty("HOST") != null){
            this.host = System.getProperty("HOST");
        }
    }
}
