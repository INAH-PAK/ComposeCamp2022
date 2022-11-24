package com.codelabs.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    onCloseTask: (WellnessTask) -> Unit,
    list: List<WellnessTask> = remember { getWellnessTasks() }
) {
    LazyColumn(modifier = modifier) {
        items(items = list,
            key = {task->task.id}) { task ->
            WellnessTaskItem(task.label,onClose = { onCloseTask(task) })
        }
    }
}


private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task #${i}") }