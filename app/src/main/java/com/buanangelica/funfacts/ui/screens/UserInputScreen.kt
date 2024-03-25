package com.buanangelica.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.buanangelica.funfacts.R
import com.buanangelica.funfacts.data.UserDataUiEvents
import com.buanangelica.funfacts.ui.AnimalCard
import com.buanangelica.funfacts.ui.ButtonComponent
import com.buanangelica.funfacts.ui.TextComponent
import com.buanangelica.funfacts.ui.TextFieldComponent
import com.buanangelica.funfacts.ui.TopBar
import com.buanangelica.funfacts.ui.UserInputViewModel


@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)

        ) {
            TopBar("Hi there")

            TextComponent(
                textValue = "Let's learn about you!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "This app will prepare a details page based on input provided by you!",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )

            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp)

            Row(
                modifier = Modifier.fillMaxWidth()
            ){
                AnimalCard(image = R.drawable.cat, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it) // will update the animalSelected in Screen State
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Cat") //will check and parse true if selected

                AnimalCard(image = R.drawable.dog, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="Dog")
            }

            Spacer(modifier = Modifier.weight(1f))

            if(userInputViewModel.isValidState()
                ){
                ButtonComponent (
                    goToDetailsScreen = {

                    }
                )
            }




        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview(){
    UserInputScreen(UserInputViewModel())
}