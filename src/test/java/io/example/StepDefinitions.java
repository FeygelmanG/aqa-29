package io.example;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.AllureId;

public class StepDefinitions {

    @Когда("дверь закрыта")
    public void checkDoorIsClosed() {
        assert(true);
    }

    @Тогда("открыть дверь")
    public void openDoor() {
        System.out.println("The door is opened");
    }
}
