Feature: Mail
  @device1
  Scenario:Checking the mail contents

  Given User goes to the website for Emulator Test1
  And User enters valid email1 for account1 in email box
  And User enters valid password for account1 in password box
  And User clicks on create an email button
  And User prepare mail content and receiverdevice information to account2
  And User clicks on send button1
    Then verify that user can reply email from receiverdevice to senderdevice successfully
    @device2
    Scenario:Check 2
  Given User goes to website for Emulator Test2
  And User enters valid email2 for account2 in email box2
  And User enters valid password2 for account2 in password box2
  And User checks the inbox for account2
  Then verify that user can send email from senderdevice to receiverdevice successfully
  And  User clicks on reply button for account2
  And User prepare reply message content to senderdevice
  And User clicks on send button2
