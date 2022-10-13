package com.example.scvmultitest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.scvmultitest.navigation.AppScreens
import com.example.scvmultitest.ui.theme.Purple200

@Composable
fun PreviewUserDataScreen(navController: NavHostController) {
  ShowPreviewUserDataScreen(navController)
}

@Composable
fun ShowPreviewUserDataScreen(navController: NavHostController){
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
      scaffoldState = scaffoldState,
      topBar = {
        TopAppBar(
          title = {Text("Fill basic info")},
          backgroundColor = Purple200,
          navigationIcon = {
            IconButton(onClick = {
              navController.navigate(AppScreens.HomeScreen.route)
            }) {
              Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
              )
            }
          }
        )
      },
      content = {
        Column(
          modifier = Modifier.fillMaxSize(),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.Center
        ){
          val ageItems = listOf("Under 20", "21-40 years old", "40-65 years old", "65+ years old")
          val genderItems = listOf("Male", "Female", "Others")
          val timeItems = listOf("Short test (5 minutes)", "Standard (10 minutes)", "Recommended (+20 minutes)")
          Select(ageItems)
          Select(genderItems)
          Select(timeItems)
          Button(onClick = {
            //navController.navigate(AppScreens...)
          }) {
            Text(text = "Start anonymous test")
          }
        }
      },
    )
  }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Select(options: List<String>) {
  var expanded by remember { mutableStateOf(false) }
  var selectedOptionText by remember { mutableStateOf("") }
  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = {
      expanded = !expanded
    }
  ) {
    TextField(
      value = selectedOptionText,
      onValueChange = { selectedOptionText = it },
      label = { Text("Label") },
      trailingIcon = {
        ExposedDropdownMenuDefaults.TrailingIcon(
          expanded = expanded
        )
      },
      colors = ExposedDropdownMenuDefaults.textFieldColors()
    )
    // filter options based on text field value
    val filteringOptions =
      options.filter { it.contains(selectedOptionText, ignoreCase = true) }
    if (filteringOptions.isNotEmpty()) {
      ExposedDropdownMenu(
        expanded = expanded,
        onDismissRequest = {
          expanded = false
        }
      ) {
        filteringOptions.forEach { selectionOption ->
          DropdownMenuItem(
            onClick = {
              selectedOptionText = selectionOption
              expanded = false
            }
          ) {
            Text(text = selectionOption)
          }
        }
      }
    }
  }
}