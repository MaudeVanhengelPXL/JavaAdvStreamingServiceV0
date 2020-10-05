package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountConstructorTest {

    @Test
    public void AccountProfileListIsNotEmpty() {
        Account account = new Account("testemail@pxl.be", "password");
        assertEquals("Profile1", account.getFirstProfile().getName());

    }
}
