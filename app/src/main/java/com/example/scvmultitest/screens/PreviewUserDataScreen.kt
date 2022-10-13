package com.example.scvmultitest.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.scvmultitest.R
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
    var selectedAge by rememberSaveable { mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("") }
    var selectedTime by rememberSaveable { mutableStateOf("") }
    val ageItems = stringArrayResource(id = R.array.age_array)
    val genderItems = stringArrayResource(id = R.array.gender_array)
    val timeItems = stringArrayResource(id = R.array.time_array)

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

          Select(
            ageItems,
            stringResource(id = R.string.age_category),
            selectedAge,
            onValueChange = { }
          )
          Select(
            genderItems,
            stringResource(id = R.string.gender),
            selectedGender,
            onValueChange = { }
          )
          Select(
            timeItems,
            stringResource(id = R.string.time_to_fill_out_the_test),
            selectedTime,
            onValueChange = { }
          )
          Button(onClick = {
            //navController.navigate(AppScreens...)
          }) {
            Text(stringResource(id = R.string.start_test))
          }
        }
      },
    )
  }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Select(
  options: Array<String>,
  selectedItem: String,
  label: String,
  onValueChange: (String) -> Unit
) {
  var expanded by remember { mutableStateOf(false) }

  ExposedDropdownMenuBox(
    expanded = expanded,
    onExpandedChange = {
      expanded = !expanded
    }
  ) {
    TextField(
      value = selectedItem,
      readOnly = true,
      onValueChange = {
        onValueChange(it)
      },
      label = { Text(label) },
      trailingIcon = {
        ExposedDropdownMenuDefaults.TrailingIcon(
          expanded = expanded
        )
      },
      colors = ExposedDropdownMenuDefaults.textFieldColors()
    )
    ExposedDropdownMenu(
      expanded = expanded,
      onDismissRequest = {
        expanded = false
      }
    ) {
      options.forEach { selectionOption ->
        DropdownMenuItem(
          onClick = {
            //selectedOptionText = selectionOption
            expanded = false
          }
        ) {
          Text(text = selectionOption)
        }
      }
    }
  }
}