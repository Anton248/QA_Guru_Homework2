package ru.nikolski.qa_guru_homeworks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import java.nio.file.Path;
import java.nio.file.Paths;

// Preparing browser for all tests
public class TestBase {
    String pathToPictures = "pictures/1.jpg"; //path to pictures which used in tests
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";  //site to test
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true; // show browser to test the tests themselves
    }
}
