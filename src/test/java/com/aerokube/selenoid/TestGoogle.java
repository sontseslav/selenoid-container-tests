package com.aerokube.selenoid;

import com.aerokube.selenoid.misc.Page;
import com.aerokube.selenoid.misc.TestBase;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Features;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class TestGoogle extends TestBase {

    @Before
    public void before() throws Exception {
        openPage(Page.FIRST);
        waitUntilElementIsPresent(By.id("test-id"));
    }

    @Features("Finding element by ID")
    @Test
    public void testFindById() {
        WebDriver driver = getDriver();
        List<WebElement> elementsById = driver.findElements(By.id("test-id"));
        assertThat(elementsById, hasSize(1));
        assertThat(elementsById.get(0).getTagName(), equalToIgnoringCase("div"));
        assertThat(elementsById.get(0).getText(), equalTo("foo"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
