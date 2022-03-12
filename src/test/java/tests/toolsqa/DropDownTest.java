package tests.toolsqa;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import toolsqa.SelectMenuPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;

public class DropDownTest extends BaseTest {

    @Test
    public void testOldStyleDropDown() {
        //arrange
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());
        List<String> options = selectMenuPage.getAllOptionsFromTheDropDown("single");
        System.out.println(options);
        Random random = new Random();
        int i = random.nextInt(options.size()-1);//0 1 2 3 4
        String expectedValue = options.get(i);
        System.out.println(expectedValue);
        //act
        selectMenuPage.selectFromOldStyleDropDown(expectedValue);
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        String actualValue = selectMenuPage.getSelectedValueFromTheOldStyleDropDown();
        //assert
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test
    public void multiSelectDropDown(){
        SelectMenuPage selectMenuPage = new SelectMenuPage(getDriver());

        List<String> options = selectMenuPage.getAllOptionsFromTheDropDown("multi");
        System.out.println(options);

        List<String> myoptions = new ArrayList<>();
        myoptions.add(options.get(1));
        myoptions.add(options.get(3));

        selectMenuPage.selectOptionsFromMultiSelect(myoptions);

        List<String> actualOptions = selectMenuPage.getSelectedOptionsFromMultiSelect();
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        Assert.assertEquals(actualOptions,myoptions);
    }
}