package ContinueWithEmail;

import java.io.IOException;

public interface ContinueWithEmailInterface {

	void clickContinueWithEmailButton() throws InterruptedException;

    void validateEmailPageTexts() throws Exception;

    void validateEmailInputWithOutData();
    
  //  void validateEmailInputPosAndNeg();

	//void performEmailValidation(String emailInputValues) throws IOException;

	void validateEmailInputPosAndNeg(String emailInputValues);

	//void performEmailValidation(String emailInputValues) throws IOException;
}
