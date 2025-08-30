package com.api.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListners implements ITestListener {

    private static final Logger logger = LogManager.getLogger(TestListners.class);


    public void onTestStart(ITestResult result) {
        logger.info("Started!!! "+result.getMethod().getMethodName());
        logger.info("Description!!! "+result.getMethod().getDescription());
    }

    public void onStart(ITestContext context) {
        logger.info("Test Suite Started!!!");
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
     * run and all their Configuration methods have been called.
     *
     * @param context The test context
     */
    public void onFinish(ITestContext context) {
        logger.info("Test Suite Completed!!!");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("Passed!!! "+result.getMethod().getMethodName());
    }

    /**
     * Invoked each time a test fails.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#FAILURE
     */
    public void onTestFailure(ITestResult result) {
        logger.error("Failed!!! "+result.getMethod().getMethodName());
    }

    /**
     * Invoked each time a test is skipped.
     *
     * @param result <code>ITestResult</code> containing information about the run test
     * @see ITestResult#SKIP
     */
    public void onTestSkipped(ITestResult result) {
        logger.info("Skipped!!! "+result.getMethod().getMethodName());
    }


}
