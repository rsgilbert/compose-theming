package com.example.compose.rally

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import kotlinx.coroutines.delay
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import java.lang.Thread.sleep

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val allScreens = RallyScreen.values().toList()

    @Test
    fun myTest() {
        composeTestRule.setContent {
            Text("Hey there")
        }
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("myTest")
        composeTestRule
            .onNode(hasText("Hey there"))
            .assertExists()
    }

    @Test
    fun rallyTopAppBarTest_currentTabSelected() {
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens =allScreens,
                onTabSelected = {},
                currentScreen =RallyScreen.Accounts
            )
        }
        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()

    }

    @Test
    fun rallyTopAppBarTest_currentLabelExists() {
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens=allScreens,
                onTabSelected={},
                currentScreen=RallyScreen.Bills
            )
        }
        composeTestRule.onRoot(useUnmergedTree = true).printToLog("currentLabelExists")
        composeTestRule
            .onNode(hasText(RallyScreen.Bills.name.uppercase()), useUnmergedTree = true)
            .assertExists()

        composeTestRule
            .onNode(hasText(RallyScreen.Bills.name.uppercase()), useUnmergedTree = true)
            .assert(hasParent(hasContentDescription(RallyScreen.Bills.name)))

        sleep(4000)
    }

    @Test
    fun rallyTopAppBarTest_tabClickChangesSelection() {
        // test that clicking on a different tab changes the currently selected tab

        composeTestRule.setContent {
            RallyApp()
        }
        composeTestRule.onRoot().printToLog("tabClick_before")

        composeTestRule
            .onNode(hasContentDescription("Overview"))
            .assertIsSelected()

        composeTestRule
            .onNode(hasContentDescription("Bills"))
            .performClick()

        composeTestRule.onRoot().printToLog("tabClick_after_click")

        composeTestRule
            .onNode(hasContentDescription("Bills"))
            .assertIsSelected()

        composeTestRule
            .onNode(hasContentDescription("Overview"))
            .assertIsNotSelected()
    }
}

