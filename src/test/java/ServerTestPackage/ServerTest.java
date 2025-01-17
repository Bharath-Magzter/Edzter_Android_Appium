package ServerTestPackage;

import ServerPackage.ServerClass;

public class ServerTest extends ServerClass {

	public void test() {

		ServerClass sc = new ServerClass();
		sc.serverStart();
		sc.serverStop();
	}

}
