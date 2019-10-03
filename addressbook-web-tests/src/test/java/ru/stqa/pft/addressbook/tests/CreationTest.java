package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.modul.GroupData;

public class CreationTest extends TestBase {

    @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupPage(new GroupData("TestTest1", "Tester2", "Tester3"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
    app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupPage(new GroupData("Bernie", "Sanders", "Is good"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }

}
