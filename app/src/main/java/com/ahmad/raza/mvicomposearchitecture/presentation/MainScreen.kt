package com.ahmad.raza.mvicomposearchitecture.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.ahmad.raza.mvicomposearchitecture.data.remote.AnimalService
import com.ahmad.raza.mvicomposearchitecture.model.Animal

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val vm: MainViewModel = viewModel(factory = ViewModelFactory(AnimalService.api))

    when (val state = vm.state.value) {
        is MainState.Idle -> IdleScreen(
            onButtonClick = {
                vm.onIntent(MainIntent.FetchAnimals)
            })

        is MainState.Loading -> LoadingScreen()
        is MainState.Animals -> AnimalsList(modifier = modifier, animals = state.animals)
        is MainState.Error -> {
            IdleScreen(
                onButtonClick = {
                    vm.onIntent(MainIntent.FetchAnimals)
                })
            Toast.makeText(LocalContext.current, state.error, Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun IdleScreen(onButtonClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Button(onClick = onButtonClick) {
            Text(text = "Fetch Animals")
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun AnimalsList(modifier: Modifier = Modifier, animals: List<Animal>) {
    LazyColumn(modifier = modifier
        .fillMaxSize()
        .imePadding()) {
        items(items = animals) {
            AnimalItem(animal = it)
            HorizontalDivider(
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                thickness = DividerDefaults.Thickness,
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun AnimalItem(animal: Animal) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        val url = AnimalService.BASE_URL + animal.image
        val painter = rememberAsyncImagePainter(model = url)
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.FillHeight
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 4.dp)
        ) {
            Text(text = animal.name, fontWeight = FontWeight.Bold)
            Text(text = animal.location)
        }
    }
}