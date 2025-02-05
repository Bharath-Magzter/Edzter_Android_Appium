package ContinueWithEmail;

import java.io.IOException;
import java.util.HashMap;

public interface ContinueWithEmailInterface {

	void clickContinueWithEmailButton() throws InterruptedException;

	void validateEmailPageTexts() throws Exception;

	void validateEmailInputWithOutData();

	void validateEmailInputPosAndNeg(HashMap<String, String> emailInputValues);

}
