
import Project.LoginCustomer;
import Project.Manager;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TestProject {
    @Test
    public void testuUrl(){
        var statusaCode =given().
                when().
                get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login").
                getStatusCode();

        int code= statusaCode/100;
        System.out.println(code);
        switch (code) {
            case 2 -> System.out.println("pass");
            case 3 -> System.out.println("redirection");
            case 4 -> System.out.println("user error");
            case 5 -> System.out.println("api error");}
            Assert.assertEquals(code,2);
        }

       @Test
              public void TestManager() throws InterruptedException {
           Manager customer1 = new Manager();
           customer1.openSite("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

           var expected = "Bruce";
           var actual = customer1.loginManager();
           Assert.assertEquals(expected,actual);
           System.out.println("test customer in system - pass");

        customer1.quit();
       }
          @Test
            public void testCustomer() throws InterruptedException {
                LoginCustomer customer2 = new LoginCustomer();
                customer2.openSite("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
                customer2.customerLogin();
                customer2.userSelect();

                var expected = 1000;
                var actual = Integer.parseInt(customer2.deposit());
                Assert.assertEquals(actual, expected);
                System.out.println("deposit account 1000- pass");

                var expexted1= 750;
                var actual1 = Integer.parseInt(customer2.withdrawl());
                Assert.assertEquals(actual1, expexted1);
                System.out.println("test balance account 750- pass");
                customer2.quit();
            }
    }











