package utilities;

import org.testng.annotations.DataProvider;

public class DataSet {

    @DataProvider(name = "invalidCredentials")
    public static Object invalidCredentials(){
        Object[][] dataset = {{"alu@gmail","sdfsdfsdf","http://13.58.91.85/#/login"},
                {"admin@nq","fedsfasdf","http://13.58.91.85/#/login"},
                {"mahsdfsdf@gmail","admin","http://13.58.91.85/#/login"}};
//                {"","zxcvqwer","http://13.58.91.85/#/login"},
//                {"admin@nq","","http://13.58.91.85/#/login"}};
        return dataset;
    }

}
