package com.example.scvmultitest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.scvmultitest.navigation.AppNavigation
import com.example.scvmultitest.ui.theme.SCVMultitestTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      SCVMultitestTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
          AppNavigation()
        }
      }
    }
  }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Select(
  options: Array<String>,
  label: String,
  selectedItem: String,
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
      label = { Text(label) },
      onValueChange = {},
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
            onValueChange(selectionOption)
            expanded = false
          }
        ) {
          Text(text = selectionOption)
        }
      }
    }
  }
}