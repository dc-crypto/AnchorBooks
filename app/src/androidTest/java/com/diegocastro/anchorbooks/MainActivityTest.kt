package com.diegocastro.anchorbooks

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.diegocastro.anchorbooks.adapter.LibroAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val mainActivity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @LargeTest
    fun prueba_click_recycler_muestra_detalle() {
        // hace click sobre el 2do elemento del RecyclerView
        onView(withId(R.id.recyclerView))
            .perform(
                scrollToPosition<LibroAdapter.ViewHolder>(4)
            )
            .perform(
                actionOnItemAtPosition<LibroAdapter.ViewHolder>(
                    2,
                    click()
                )
            )

        // revisar que se cargue el titulo
        onView(withId(R.id.tvDetalleTitulo))
            .check(
                matches(
                    withText("The Divine Comedy")
                )
            )
    }
}

