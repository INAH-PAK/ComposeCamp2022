package com.codelabs.basicstatecodelab

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//
//@Preview
//@Composable
//fun WaterCounter(modifier: Modifier = Modifier) {
//    Column(modifier.padding(16.dp)) {
//        var counter by remember { mutableStateOf(0) }
//
//        if (counter > 0) {
//            var showTask by remember {
//                mutableStateOf(true)
//            }
//            if (showTask) {
//                WellnessTaskItem(taskName = "너 15분 이상 걸었음?", onClose = { showTask = false })
//            }
//            Text(text = "ㄴㅓ의 잔에 $counter 가 차있다.")
//        }
//
//        Row(Modifier.padding(top = 8.dp)) {
//            Button(onClick = { counter++ }, enabled = counter < 10) {
//                Text(text = "1 추가")
//            }
//            Button(onClick = { counter = 0 }, Modifier.padding(start = 8.dp)) {
//                Text(text = "물 잔 쏟기")
//            }
//        }
//
//
//    }
//
//
//}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text("ㄴㅓ의 잔에 $count 가 차있다.")
        }
        Button(onClick = { count++ }, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable // 기능만
fun StatelessCounter(counter: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (counter > 0) {
            Text("ㄴㅓ의 잔에 $counter 가 차있다.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = counter < 10) {
            Text("Add one")
        }
    }

}

@Composable // 상태소유 , 수정
fun StateFulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }

    StatelessCounter(counter = count, onIncrement = { count++ })
    StatelessCounter(counter = count, onIncrement = { count *= 2 })


}