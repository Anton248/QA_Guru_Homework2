package ru.nikolski.qa_guru_homeworks;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class Homework2 extends TestBase{

//testing all forms at https://demoqa.com/automation-practice-form
    @Test
    void homework2() {
        open("/automation-practice-form");

    }
}
