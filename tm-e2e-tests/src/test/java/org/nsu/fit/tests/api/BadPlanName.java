package org.nsu.fit.tests.api;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.nsu.fit.services.rest.data.PlanPojo;
import org.testng.annotations.Test;

public class BadPlanName implements TestInterface{

    @Test(description = "Create plan with short name.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create plan feature.")
    public void shortNameTest(){
        PlanPojo plan = new PlanPojo();
        plan.name = "u";
        plan.details = "Revenge for the dog";
        plan.fee = 100;
        client.createUnValidPlan(adminToken,plan);
    }

    @Test(description = "Create plan with long name.")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Create plan feature.")
    public void longNameTest(){
        PlanPojo plan = new PlanPojo();
        plan.name = "I would like to start my intervention with a question: who among you would like to see his brother, his sister, a relative whom he likes very much";
        plan.details = "Revenge for the dog";
        plan.fee = 100;
        client.createUnValidPlan(adminToken,plan);
    }
}
