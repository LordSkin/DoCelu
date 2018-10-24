package bartlomiej.kramnik.docelu.InterfaceTests

import android.os.SystemClock
import android.support.test.espresso.Espresso.onData
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.RootMatchers.withDecorView
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import bartlomiej.kramnik.docelu.Model.DataBase.LastPlaces
import bartlomiej.kramnik.docelu.Model.DataModels.MyPlace
import bartlomiej.kramnik.docelu.R
import bartlomiej.kramnik.docelu.Search.View.SearchActivityImpl
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matchers.`is`
import org.hamcrest.core.IsNot.not
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Tests of searching screen
 */
@RunWith(AndroidJUnit4::class)
class SearchScreenTests {

    @get:Rule
    val activity = ActivityTestRule<SearchActivityImpl>(SearchActivityImpl::class.java)

    lateinit var places: LastPlaces

    @Before
    fun setUp() {
        places = LastPlaces(activity.activity)
        var placesList = (1..100).map { MyPlace("desc" + it, "id" + it) }
        for (place in placesList) {
            places.add(place)
        }

        (activity.activity as SearchActivityImpl).let {
            it.presenter.setLastPlaces(places)
            it.runOnUiThread { it.reLoadList() }

        }

    }

    @After
    fun cleanUp() {
        places.clear()
    }

    @Test
    fun testViewLoadedPropetly() {
        onView(withId(R.id.fromTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.whereTextView)).check(matches(isDisplayed()))
        onView(withId(R.id.last_places_list)).check(matches(isDisplayed()))
        onView(withId(R.id.last_places_list)).check(matches(isDisplayed()))
        onView(withId(R.id.place_autocomplete_fragment)).check(matches(isDisplayed()))
        onView(withId(R.id.localisation)).check(matches(isDisplayed()))
        onView(withId(R.id.searchButton)).check(matches(isDisplayed()))

        onView(withId(R.id.fromTextView)).check(matches(withHint("Z...")))
        onView(withId(R.id.whereTextView)).check(matches(withHint("Do...")))
    }

    @Test
    fun testLastPlacesSelectingPropetly() {
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(1).perform(click())

        onView(withId(R.id.fromTextView)).check(matches(withText("desc100")))
        onView(withId(R.id.whereTextView)).check(matches(withText("desc99")))
    }

    @Test
    fun testLastPlacesReselectingPropetly() {
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(1).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(3).perform(click())

        onView(withId(R.id.fromTextView)).check(matches(withText("desc100")))
        onView(withId(R.id.whereTextView)).check(matches(withText("desc97")))
    }

    @Test
    fun testChangingSelectedField() {
        onView(withId(R.id.whereTextView)).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())

        onView(withId(R.id.fromTextView)).check(matches(withText("")))
        onView(withId(R.id.whereTextView)).check(matches(withText("desc100")))
    }

    @Test
    fun testChangingSelectedField2() {
        onView(withId(R.id.whereTextView)).perform(click())
        onView(withId(R.id.fromTextView)).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())

        onView(withId(R.id.whereTextView)).check(matches(withText("")))
        onView(withId(R.id.fromTextView)).check(matches(withText("desc100")))
    }

    @Test
    fun testToastWhenEmptyDestinations() {
        onView(withId(R.id.searchButton)).perform(click())
        onView(withText(R.string.emptyPlace)).inRoot(withDecorView(not(`is`(activity.activity.window.decorView)))).check(matches(isDisplayed()))

        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withText(R.string.emptyPlace)).inRoot(withDecorView(not(`is`(activity.activity.window.decorView)))).check(matches(isDisplayed()))
    }

    @Test
    fun testToastWhenEmptyDestinations2() {
        onView(withId(R.id.whereTextView)).perform(click())
        onData(anything()).inAdapterView(withId(R.id.last_places_list)).atPosition(0).perform(click())
        onView(withId(R.id.searchButton)).perform(click())
        onView(withText(R.string.emptyPlace)).inRoot(withDecorView(not(`is`(activity.activity.window.decorView)))).check(matches(isDisplayed()))
    }

    @Test
    fun locationTest() {
        onView(withId(R.id.localisation)).perform(click())
        SystemClock.sleep(3000)

        onView(withId(R.id.fromTextView)).check(matches(not(withText(""))))
    }
}