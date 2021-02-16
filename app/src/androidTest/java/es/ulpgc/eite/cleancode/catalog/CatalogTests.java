package es.ulpgc.eite.cleancode.catalog;


import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.catalog.categories.CategoryListActivity;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;

@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class CatalogTests {

  @Rule
  public ActivityTestRule<CategoryListActivity> testRule =
      new ActivityTestRule<>(CategoryListActivity.class);

  @Test
  public void catalogTests() {

    ViewInteraction textView = onView(allOf(
        withParent(allOf(
            withId(R.id.toolbar),
            withParent(withId(R.id.app_bar))
        )),
        isDisplayed()
    ));
    textView.check(matches(withText("Catalog")));


    onData(anything())
        .inAdapterView(withId(R.id.category_list))
        .atPosition(0)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Category 1")));


    DataInteraction linearLayout = onData(anything())
        .inAdapterView(allOf(withId(R.id.category_list)))
        .atPosition(2);
    linearLayout.perform(click());


    onData(anything())
        .inAdapterView(withId(R.id.product_list))
        .atPosition(4)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Product 3.5")));

    DataInteraction linearLayout2 = onData(anything())
        .inAdapterView(allOf(withId(R.id.product_list)))
        .atPosition(6);
    linearLayout2.perform(click());


    ViewInteraction textView6 = onView(allOf(
        withId(R.id.product_detail),  isDisplayed()));
    textView6.check(matches(withText(
        "Details about Product:  3.7\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.\n" +
        "More details information here.")
    ));

    ViewInteraction appCompatImageButton = onView(allOf(
        withContentDescription("Navigate up"),
        isDisplayed()
    ));
    appCompatImageButton.perform(click());


    onData(anything())
        .inAdapterView(withId(R.id.product_list))
        .atPosition(0)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Product 3.1")));


    ViewInteraction appCompatImageButton1 = onView(allOf(
        withContentDescription("Navigate up"),
        isDisplayed()
    ));
    appCompatImageButton1.perform(click());


    onData(anything())
        .inAdapterView(withId(R.id.category_list))
        .atPosition(0)
        .onChildView(withId(R.id.content))
        .check(matches(withText("Category 1")));
  }


}
