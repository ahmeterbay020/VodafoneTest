package com.qa.stepdef;

import com.qa.pages.Test1;
import com.qa.utils.DriverManager;
import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class mailstepdefs extends Test1{
    DriverManager dm = new DriverManager();
    WebDriverWait wait=new WebDriverWait(dm.getDriver(),20);

    @Given("User goes to the website for Emulator Test1")
    public void userGoesToTheWebsiteForEmulatorTest1() {
        dm.getDriver().get("https://accounts.google.com/v3/signin/identifier?dsh=S553792958%3A1663081145297274&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWqwQ5MTVQUv3X-9ikXKo4Lrk02X7o0QkIESfeLd-w9DvI7srJjAnVVuc1IQjncAzi4qbPB6Wg");
    }
    @Given("User enters valid email1 for account1 in email box")
    public void userEntersValidEmail1ForAccount1InEmailBox() throws InterruptedException {
        emailbox.sendKeys("senderdevice@gmail.com");
        nextbutton.click();
        Thread.sleep(3000);


    }
    @Given("User enters valid password for account1 in password box")
    public void userEntersValidPasswordForAccount1InPasswordBox() throws InterruptedException {
        passwordbox.sendKeys("Test123*_");
        nextbutton.click();
        Thread.sleep(3000);
    }
    @Given("User clicks on create an email button")
    public void userClicksOnCreateAnEmailButton() {

        createmailbutton.click();

    }
    @Given("User prepare mail content and receiverdevice information to account2")
    public void userPrepareMailContentAndReceiverdeviceInformationToAccount2() throws InterruptedException {
        alicibox.sendKeys("receiverdevice1@gmail.com");
        konubox.sendKeys("Test");
        mailbody.sendKeys("Test1Account");
        Thread.sleep(2000);


    }
    @Given("User clicks on send button1")
    public void userClicksOnSendButton1() throws InterruptedException {
        sendButton.click();
        Thread.sleep(40000);
    }
    @Then("verify that user can reply email from receiverdevice to senderdevice successfully")
    public void verifyThatUserCanReplyEmailFromReceiverdeviceToSenderdeviceSuccessfully() throws InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();

        refreshButton.click();

        wait.until(ExpectedConditions.visibilityOf(account1inbox));
        Thread.sleep(1000);
        account2inbox.click();
        Thread.sleep(5000);
        String [] actualcontentsplit=account1inboxcontent.getText().split(dtf.format(now));
        String actualcontent1=String.valueOf(actualcontentsplit[0]);
        System.out.println(actualcontent1);
        Assert.assertEquals("Alındi",actualcontent1.trim());


    }
    @Given("User goes to website for Emulator Test2")

    public void userGoesToWebsiteForEmulatorTest2() throws InterruptedException {
        Thread.sleep(20000);
       new DriverManager().getDriver().get("https://accounts.google.com/v3/signin/identifier?dsh=S553792958%3A1663081145297274&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AQDHYWqwQ5MTVQUv3X-9ikXKo4Lrk02X7o0QkIESfeLd-w9DvI7srJjAnVVuc1IQjncAzi4qbPB6Wg");
    }
    @Given("User enters valid email2 for account2 in email box2")
    public void userEntersValidEmail2ForAccount2InEmailBox2() throws InterruptedException {
        emailbox.sendKeys("receiverdevice1@gmail.com");
        nextbutton.click();
        Thread.sleep(3000);
    }
    @Given("User enters valid password2 for account2 in password box2")
    public void userEntersValidPassword2ForAccount2InPasswordBox2() throws InterruptedException {
        passwordbox.sendKeys("Test123*-");
        nextbutton.click();
        Thread.sleep(3000);
    }
    @Given("User checks the inbox for account2")
    public void userChecksTheInboxForAccount2() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(account2inbox));
account2inbox.click();
       Thread.sleep(5000);

    }
    @Then("verify that user can send email from senderdevice to receiverdevice successfully")
    public void verifyThatUserCanSendEmailFromSenderdeviceToReceiverdeviceSuccessfully() throws InterruptedException {
       String actualcontent=account2content.getText();
        Assert.assertEquals("Test1Account",actualcontent);
        Thread.sleep(2000);
    }
    @Then("User clicks on reply button for account2")
    public void userClicksOnReplyButtonForAccount2() {
        replyButton.click();
    }
    @Then("User prepare reply message content to senderdevice")
    public void userPrepareReplyMessageContentToSenderdevice() {
        replymailbody.sendKeys("Alındi");

    }
    @Then("User clicks on send button2")
    public void userClicksOnSendButton2() {
       sendButton.click();
    }


}
