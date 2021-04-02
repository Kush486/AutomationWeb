package Shopping.Agosh;
import java.io.IOException;

import org.testng.annotations.*;

public class Testsuit {

    BasePage basePage;

    @BeforeClass
    public void onBefore() {
        basePage = new BasePage();
    }

    @AfterClass
    public void tearDown() throws Exception {
        basePage.close();
    }

//  Test Case 01 ::
    @Test
    public void Verify_Login_Details_of_buyer() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.verify_loing_details_of_buyer();
    }
    
//  Test Case 02 ::
    @Test
    public void Verify_Login_Details_of_seller() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.Verify_Login_Details_of_seller();
    }
    
//  Test Case 03 ::
    @Test
    public void Verify_to_Register_New_Account_for_Buyer() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.Verify_to_Register_New_Account_for_Buyer();
    }
    
//  Test Case 04 ::
    @Test
    public void Verify_to_Register_New_Account_for_Seller() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.Verify_to_Register_New_Account_for_Seller();
    }
    
//  Test Case 05 ::
    @Test
    public void Verify_to_Logout_of_Buyer() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.Verify_to_Logout_of_Buyer();
    }
    
//  Test Case 06 ::
    @Test
    public void Verify_to_Logout_of_Seller() throws InterruptedException, IOException{
        basePage.enterURL();
        basePage.Verify_to_Logout_of_Seller();
    }
    
    
}
