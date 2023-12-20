import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Icon
import androidx.compose.material3.icons.Default

@Composable
fun HorizontalList() {
    // Data untuk diisi dalam list
    val dataList = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

    // Membuat state untuk mengatur posisi scroll
    val listState = rememberLazyListState()

    // Menggunakan LazyRow untuk membuat daftar horizontal
    LazyRow(state = listState) {
        items(dataList) { item ->
            // Komponen di dalam setiap item
            ListItem(text = item)
        }
    }
}

@Composable
fun ListItem(text: String) {
    // Komponen untuk setiap item dalam list
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Gray)
            .size(120.dp)
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = null, tint = Color.White)
        Text(text = text, color = Color.White, modifier = Modifier.align(Alignment.BottomCenter))
    }
}
