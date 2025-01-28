package ContinueWithEmail;

import java.io.IOException;

public interface ContinueWithEmailInterface {

	void clickContinueWithEmailButton() throws InterruptedException;

    void validateEmailPageTexts() throws Exception;

    void validateEmailInput();
}
