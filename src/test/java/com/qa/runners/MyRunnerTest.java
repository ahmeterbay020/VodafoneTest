package com.qa.runners;

import com.qa.utils.*;
import io.cucumber.junit.Cucumber;

import io.cucumber.testng.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@CucumberOptions(
        plugin = {"json:target/report.json"
                , "html:target/device/report.html"
                , "summary"
                , "me.jvt.cucumber.report.PrettyReports:target/device/cucumber-html-reports"}
        ,features = {"src/test/resources"}
        ,glue = {"com.qa.stepdef"}
        ,dryRun=false
        ,monochrome=true
        ,tags = "@device1"


)

public class MyRunnerTest extends RunnerBase {


}
