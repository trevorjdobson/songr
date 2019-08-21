package com.trevorjdobson.songr;

import com.trevorjdobson.songr.controllers.HomeController;
import org.junit.Test;

import static org.junit.Assert.*;

public class HomeControllerTest {
    HomeController testHomeController = new HomeController();
    @Test
    public void testReverseString() {
        String toBeReversed = "This is reversed";
        String expected = "reversed is This";
        String reversed = testHomeController.reverseString(toBeReversed);
        assertEquals(expected,reversed);
    }
    @Test
    public void testReverseString_OneWord() {
        String toBeReversed = "reversed";
        String expected = "reversed";
        String reversed = testHomeController.reverseString(toBeReversed);
        assertEquals(expected,reversed);
    }
    @Test
    public void testReverseString_Empty() {
        String toBeReversed = "";
        String expected = "";
        String reversed = testHomeController.reverseString(toBeReversed);
        assertEquals(expected,reversed);
    }
}