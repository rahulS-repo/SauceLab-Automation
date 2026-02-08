package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "login_dp")
    public String[][] loginDataProvider(){
        String[][] data = {
                {"standard_user","secret_sauce","valid"},
                {"locked_out_user","secret_sauce","invalid"}
        };
        return data;
    }
}
