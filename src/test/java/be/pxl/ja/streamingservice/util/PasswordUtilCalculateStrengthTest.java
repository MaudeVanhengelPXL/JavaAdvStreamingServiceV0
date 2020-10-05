package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordUtilCalculateStrengthTest {

    @Test
    public void PasswordWithLessThan6CharactersIsAlways0() {
        String password = "aaaa";
        assertEquals(0, PasswordUtil.calculateStrength(password));
    }

    @Test
    public void PasswordBetween6And10CharactersOnlyLowerCaseLetters() {
        String password = "abcdef";
        assertEquals(1 + 2, PasswordUtil.calculateStrength(password));
    }

    @Test
    public void PasswordBetween6And10CharactersOneUpperCase() {
        String password = "abcDefg";
        assertEquals(1 + 2 + 2, PasswordUtil.calculateStrength(password));
    }

    @Test
    public void PasswordBetween6And10CharactersSpecialCharacter() {
        String password = "abc%efg";
        assertEquals(1 + 2 + 2, PasswordUtil.calculateStrength(password));
    }

    @Test
    public void PasswordLowerCaseUpperCaseDigitsAndSpecialCharacters() {
        String password = "aBcd3f$g";
        assertEquals(1 + 2 + 2 + 2 + 2, PasswordUtil.calculateStrength(password));
    }

    @Test
    public void PasswordExactlyTenCharacters() {
        String password = "abcdefghij";
        assertEquals(2 + 2, PasswordUtil.calculateStrength(password));
    }
    @Test
    public void PasswordMoreThanTenLowerCaseUpperCaseDigitsAndSpecialCharacters() {
        String password = "abcdefhjS12$$$";
        assertEquals(2 + 2 + 2 + 2 + 2, PasswordUtil.calculateStrength(password));
    }

}
