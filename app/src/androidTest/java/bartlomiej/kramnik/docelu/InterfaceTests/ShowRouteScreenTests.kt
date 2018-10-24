package bartlomiej.kramnik.docelu.InterfaceTests

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import bartlomiej.kramnik.docelu.Model.DataModels.Route
import bartlomiej.kramnik.docelu.Model.DataModels.Transport.Line
import bartlomiej.kramnik.docelu.ShowRoute.View.ShowRouteActivityImpl
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.espresso.matcher.ViewMatchers.*


@RunWith(AndroidJUnit4::class)
class ShowRouteScreenTests {

    val from = "fromplace"
    val where = "whereplace"


    @get:Rule
    val activity = object :  ActivityTestRule<ShowRouteActivityImpl>(ShowRouteActivityImpl::class.java){
        override fun getActivityIntent(): Intent {

            val l1 = Line("name1,","from1","where1",3,"type1","arTime1","depTime1")
            val l2 = Line("name2,","from2","where2",5,"type2","arTime2","depTime2")

            val r = Route(listOf(l1,l2))

            val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
            val result = Intent(targetContext, ShowRouteActivityImpl::class.java)

            result.let {
                it.putExtra("route", r)
                it.putExtra("from", from)
                it.putExtra("where",where)
            }
            return result
        }
    }

    @Test
    fun testViewLoadedPropetly(){
        onView(withText(from)).check(matches(isDisplayed()))
        onView(withText(where)).check(matches(isDisplayed()))

        onView(withText("name1,")).check(matches(isDisplayed()))
        onView(withText("from1")).check(matches(isDisplayed()))
        onView(withText("where1")).check(matches(isDisplayed()))
        onView(withText("arTime1")).check(matches(isDisplayed()))
        onView(withText("depTime1")).check(matches(isDisplayed()))

        onView(withText("name2,")).check(matches(isDisplayed()))
        onView(withText("from2")).check(matches(isDisplayed()))
        onView(withText("where2")).check(matches(isDisplayed()))
        onView(withText("arTime2")).check(matches(isDisplayed()))
        onView(withText("depTime2")).check(matches(isDisplayed()))
    }

}