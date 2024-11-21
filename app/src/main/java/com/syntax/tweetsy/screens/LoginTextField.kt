package com.syntax.tweetsy.screens


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.syntax.tweetsy.ui.theme.focusedTextFieldText
import com.syntax.tweetsy.ui.theme.textFieldContainer
import com.syntax.tweetsy.ui.theme.unFocusedTextFieldText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier=Modifier,
    lable:String,
    trailing:String
){

    val uiColor=if(isSystemInDarkTheme()) androidx.compose.ui.graphics.Color.White else androidx.compose.ui.graphics.Color.Black
    val state= remember { mutableStateOf("") }
    TextField(

        modifier = modifier,
        value = state.value,
        onValueChange = {
            state.value=it
        },
        label = {
            Text(text = lable, style = MaterialTheme.typography.labelMedium, color =uiColor)
        },
       colors = TextFieldDefaults.colors(
           unfocusedPlaceholderColor = MaterialTheme.colorScheme.unFocusedTextFieldText,
           focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
           unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
           focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer
       ),

        trailingIcon = {
            TextButton(onClick = {}) {
                Text(text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        }

    )

}