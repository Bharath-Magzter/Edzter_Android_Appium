package ServerTestPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import ServerPackage.ServerClass;

public class ServerTest extends ServerClass {
	ServerClass sc = new ServerClass();

//	@BeforeClass
	public void serverStartTest() {

		sc.serverStart();

	}

	//@AfterClass
	public void serverStopTest() {

		sc.serverStop();
	}

}
