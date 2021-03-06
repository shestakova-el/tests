package org.nsu.fit.tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.nsu.fit.services.rest.data.AccountTokenPojo;
import org.nsu.fit.services.rest.data.CustomerPojo;
import org.testng.annotations.Test;

public class AuthTest implements TestInterface {
    private AccountTokenPojo adminToken;

    // Лабораторная 3: Разобраться с аннотациями, как они влияют на итоговый отчет.
    @Test(description = "Authenticate as admin.") //имя теста
    @Severity(SeverityLevel.BLOCKER) //приоритет теста
    @Feature("Authentication feature.") //тестируемая функция проекта
    public void authAsAdminTest() {
        adminToken = client.authenticate("admin", "setup");
    }

    @Test(description = "Authenticate as user.", dependsOnMethods = "authAsAdminTest")
    @Severity(SeverityLevel.BLOCKER)
    @Feature("Authentication feature.")
    public void authAsCustomerTest() {
        CustomerPojo customerPojo = client.createAutoGeneratedCustomer(adminToken);
        client.authenticate(customerPojo.login, customerPojo.pass);
    }
}
