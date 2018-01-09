package homework;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "adminLoginTest")
    public Object[][] createData() {
        return new Object[][] {
                { "admin@phptravels.com","demoadmin"}
        };
    }

    @DataProvider(name = "adminNegativeLogin")
    public Object[][] createData2() {
        return new Object[][] {
                { "demo@phptravels.com", "demoadmin"},
                {"ad@phptravels.com", "admin"}
        };
    }


    @DataProvider(name = "bookJourney")
    public Object[][] createData3() {
        return new Object[][] {
                { "#collapse3 > div.hpadding20 > div:nth-child(27) > div > ins"},
                { "#collapse3 > div.hpadding20 > div:nth-child(3) > div > ins"},
                { "#collapse3 > div.hpadding20 > div:nth-child(11) > div > ins"},
                { "#collapse3 > div.hpadding20 > div:nth-child(7) > div > ins"},
                { "#collapse3 > div.hpadding20 > div:nth-child(29) > div > ins"}
        };
    }

    @DataProvider(name = "bookFlight")
    public Object[][] createData4() {
        return new Object[][] {
                { "Athenes,Greece","2018-1-23","2018-1-27"}
               // { "Athens, Greece","Wed, 17 February","Wed, 27 February"},
              //  { "Athens, Greece","Wed, 17 March","Wed, 27 March"},
              //  { "Athens, Greece","Wed, 17 April","Wed, 27 April"},
              //  { "Athens, Greece","Wed, 17 May","Wed, 27 May"},
        };
    }

    @DataProvider(name = "bookHotel")
    public Object[][] createData5() {
        return new Object[][] {
               // { "#\\31"},
               // { "#\\32"},
                { "#collapse1 > div.hpadding20 > div > div:nth-child(5) > div > ins"},
                { "#collapse1 > div.hpadding20 > div > div:nth-child(7) > div > ins"},
                { "#collapse1 > div.hpadding20 > div > div:nth-child(9) > div > ins"}
        };
    }

}
