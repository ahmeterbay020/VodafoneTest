package com.qa.pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Test1 extends BasePage {

    @FindBy(xpath = "//*[@name='q']")
    public WebElement serachbutton;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailbox;

    @FindBy(xpath = "(//span[@class='VfPpkd-vQzf8d'])[2]")
    public WebElement nextbutton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordbox;

    @FindBy(xpath = "(//*[@class='Hl'])[1]")
    public WebElement createmailbutton;

    @FindBy(xpath = "//input[@id='composeto']")
    public WebElement alicibox;

    @FindBy(xpath = "//input[@id='cmcsubj']")
    public WebElement konubox;

    @FindBy(xpath = "//div[@id='cmcbody']")
    public WebElement mailbody;

    @FindBy(xpath = "//div/div[text()='Send' or text()='Gönder']")
    public WebElement sendButton;

    @FindBy(xpath = "(//div[@class='gk'])[1]")
    public WebElement account2inbox;

    @FindBy(xpath = "//*[@class='th']/div/div[1]")
    public WebElement account2content;

    @FindBy(xpath = "//*[@class='il d C ai']")
    public WebElement replyButton;

    @FindBy(xpath = "//div[@id='cmcbody']/br[1]")
    public WebElement replymailbody;

    @FindBy(xpath = "//*[@aria-label='Refresh' or @aria-label='Yenile']")
    public WebElement refreshButton;

    @FindBy(xpath = "(//*[text()='ben, ']/..)[1]")
    public WebElement account1inbox;

    @FindBy(xpath = "//div[@class='Gg Ig ']")
    public WebElement account1inboxcontent;


}
