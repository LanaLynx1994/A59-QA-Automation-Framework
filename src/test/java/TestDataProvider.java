import org.testng.annotations.DataProvider;

public class TestDataProvider extends BaseTest{
    @DataProvider(name="IncorrectLoginData")
    public Object[][] getDataFromDataProviders() {
        return new Object[][]{
                {"invalid@testpro.io", "invalidPassword"},
                {"sviatlana.rysiavets@testpro.io", "invalidPassword"},
                {"invalid@testpro.io", "nTtAZKUq"},
                {"sviatlana.rysiavets@testpro.io", ""},
                {"", "nTtAZKUq"}
        };
    }
}
