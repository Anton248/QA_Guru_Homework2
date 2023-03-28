package ru.nikolski.qa_guru_homeworks;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

// Preparing browser for all tests
public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";  //site to test
        //Configuration.holdBrowserOpen = true; // testing the tests themselves
    }
}
