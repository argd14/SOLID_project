package com.kodigo.solid.views.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MenuTest {

  Menu menu;

  @BeforeEach
  public void setup() {
    menu = new Menu("Test Menu", menuOptionsList());
  }

  @Test
  @DisplayName("Method showMenu - Should print all options from the array")
  public void showMenu() {
    assertFalse(menuOptionsList().isEmpty());
    assertEquals(3, menuOptionsList().size());
  }

  @Test
  @DisplayName("Method getTitle - Should print menu title")
  void getTitle() {
      assertEquals("Test Menu", menu.getTitle());
  }

  @Test
  @DisplayName("Method getOptions - Should get menu options")
  void getOptions() {
      assertEquals(menuOptionsList(), menu.getOptions());
  }

  private static List<String> menuOptionsList() {
    return Arrays.asList("Option 1", "Option 2", "Option 3");
  }
}
