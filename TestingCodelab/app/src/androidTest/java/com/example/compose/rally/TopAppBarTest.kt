package com.example.compose.rally

import androidx.compose.material.Text
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
        val allScreens = RallyScreen.values().toList()
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
        val allScreens = RallyScreen.values().toList()
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
}

