package RunnerClass;

import org.testng.annotations.Test;

import ServerTestPackage.ServerTest;

public class RunnerMethod {

	ServerTest serverTest = new ServerTest();

	@Test
	public void serverRunner() {
		serverTest.test();
	}
}
