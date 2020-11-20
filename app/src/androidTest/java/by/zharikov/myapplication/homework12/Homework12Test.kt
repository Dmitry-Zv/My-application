package by.zharikov.myapplication.homework12

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import by.zharikov.myapplication.R
import by.zharikov.myapplication.homework12.utils.FibonacciNumbers
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class Homework12Test{
    private lateinit var activityScenario: ActivityScenario<Homework12>

    @Before
    fun setUp(){
        activityScenario = ActivityScenario.launch(Homework12::class.java)
    }
    @Test
    fun fibonacciNumbersIsVisible(){
        onView(withId(R.id.input_number_edit_text)).perform(typeText("484941654894"))
            .check(matches(withText((R.string.number_484941654894))))
        onView(withId(R.id.fibonacci_number_text)).check(matches(isDisplayed()))
    }

    @Test
    fun inputTextAndFibonacciAreSimilar(){
        onView(withId(R.id.input_number_edit_text)).perform(typeText("23"))
        androidx.test.espresso.Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_start_fibonacci)).perform(click())
        val fibonacciNumber = FibonacciNumbers.validate(23)
        onView(withId(R.id.fibonacci_number_text)).check(matches(withText(fibonacciNumber.toString())))
    }

    @Test
    fun inputInCorrectNumber(){
        onView(withId(R.id.input_number_edit_text)).perform(typeText("ght"))
        androidx.test.espresso.Espresso.closeSoftKeyboard()
        onView(withId(R.id.button_start_fibonacci)).perform(click())
    }
}