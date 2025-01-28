package LoginPagePackage;

import java.io.IOException;

public interface LoginPageInterface {

    // Method to click the "Let's Start" button
    void clickLetStartButton();

    // Method to validate the login page banner
    boolean validateLoginPageBanner();

    // Method to validate login options
    void validateLoginOptions() throws IOException;
    
   
}
