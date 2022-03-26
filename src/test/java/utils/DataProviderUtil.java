package utils;

import org.testng.annotations.DataProvider;

import java.util.List;
import java.util.Map;

public class DataProviderUtil {
    @DataProvider(name = "credentials")
    public Object[][] dataPump() {

        Map<String, List<String>> credentials = ExcelUtil.getCredentials();
        List<String> usernames = credentials.get("usernames");
        List<String> passwords = credentials.get("passwords");
        String[][] data = new String[usernames.size()][credentials.size()];
        for (int i = 0; i < usernames.size(); i++) {
            data[i][0] = usernames.get(i);
            data[i][1] = passwords.get(i);
        }
        return data;

//        return new String[][]{
//                {"standard_user", "secret_sauce"},
//                {"problem_user", "secret_sauce"},
//                {"performance_glitch_user", "secret_sauce"}
//        };
    }
}
