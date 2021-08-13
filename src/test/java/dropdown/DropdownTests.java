package dropdown;

import base.BaseTest;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTest {

    @Test
    public void testSelectOption() {
        var dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected");

    }

    @Test
    public void testJavaScriptSelect() {
        var dropdownPage = homePage.clickDropdown();
        dropdownPage.selectMultipleDropdowns();

        var optionsToSelect = List.of("Option 1", "Option 2");
        optionsToSelect.forEach(dropdownPage::selectFromDropdown);

        var selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions, optionsToSelect, "incorrect option(s) selected");
        assertTrue(selectedOptions.containsAll(optionsToSelect), "All options were not selected");
    }
}
