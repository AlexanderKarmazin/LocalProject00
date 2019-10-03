package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class DeletionTest extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        app.gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deletSelectedGroup();
        app.getGroupHelper().returnToGroupPage();
    }
}

