package com.qa.runners;

import com.qa.utils.DriverManager;
import com.qa.utils.GlobalParams;
import com.qa.utils.ServerManager;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apache.logging.log4j.ThreadContext;

import org.testng.annotations.*;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunnerBase {

    private static final ThreadLocal<TestNGCucumberRunner> testNGCucumberRunner = new ThreadLocal<>();

    public static TestNGCucumberRunner getRunner() {
        return testNGCucumberRunner.get();
    }
    private static void setRunner(TestNGCucumberRunner testNGCucumberRunner1) {
        testNGCucumberRunner.set(testNGCucumberRunner1);
    }

    @Parameters({"systemPort","ChromeDrıverPort","devıceName","ud"})
    @BeforeClass(alwaysRun = true)
    public void initialize(String systemPort,String  ChromeDrıverPort,String devıceName,String ud) throws Exception {
        GlobalParams params = new GlobalParams();
        params.initializeGlobalParams();
        new GlobalParams().setChromeDriverPort(ChromeDrıverPort);
        new GlobalParams().setSystemPort(systemPort);
        new GlobalParams().setDeviceName(devıceName);
        new GlobalParams().setUDID(ud);


        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());

        new ServerManager().startServer();
        new DriverManager().initializeDriver();

        setRunner(new TestNGCucumberRunner(this.getClass()));
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickleEvent, FeatureWrapper cucumberFeature) throws Throwable {
        getRunner().runScenario(pickleEvent.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return getRunner().provideScenarios();
    }



    @AfterClass(alwaysRun = true)
    public static void quit(){
        DriverManager driverManager = new DriverManager();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        ServerManager serverManager = new ServerManager();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }

    }

}
