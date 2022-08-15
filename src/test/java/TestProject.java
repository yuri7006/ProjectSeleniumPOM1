
import Project.LoginCustomer;
import Project.Manager;
import org.junit.Assert;
import org.junit.Test;

public class TestProject {


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

                var expected = "1000";
                var actual = customer2.deposit();
                Assert.assertEquals(actual, expected);
                System.out.println("deposit account 1000- pass");

                var expexted1 = "750";
                var actual1 = customer2.withdrawl();
                Assert.assertEquals(actual1, expexted1);
                System.out.println("test balance account 750- pass");
                customer2.quit();
            }}











