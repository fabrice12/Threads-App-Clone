package com.orion.threads.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoreBottomSheet(onDismiss: () -> Unit) {
    val scope = rememberCoroutineScope()
    val modalState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        MoreBottomSheetContent()
    }

}


@Composable
fun MoreBottomSheetContent() {
    LazyColumn {
        item() {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(20.dp)
                        )

                        .padding(20.dp)


                ) {
                    Text(text = "Unfollow",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clickable { }
                            .fillMaxWidth())
                    Divider(
                        modifier = Modifier.padding(vertical = 2.dp),
                        color = Color.Gray.copy(alpha = 0.15f)
                    )
                    Text(text = "Mute",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .clickable { }
                            .fillMaxWidth())

                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Gray.copy(alpha = 0.1f), shape = RoundedCornerShape(20.dp)
                        )

                        .padding(20.dp)


                ) {
                    Text(text = "Hide",
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.clickable { })
                    Divider(
                        modifier = Modifier.padding(vertical = 2.dp),
                        color = Color.Gray.copy(alpha = 0.15f)
                    )
                    Text(
                        text = "Report",
                        color = Color.Red,
                        modifier = Modifier.clickable { },
                        fontWeight = FontWeight.SemiBold
                    )

                }
                Spacer(modifier = Modifier.height(30.dp))
            }


        }
//        items(countries) { (country, flag) ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable { Log.e("CLICKED", "CountryList: $country ", ) }
//                    .padding(vertical = 10.dp, horizontal = 20.dp)
//            ) {
//                Text(
//                    text = flag,
//                    modifier = Modifier.padding(end = 20.dp)
//                )
//                Text(text = country)
//            }
//        }
    }
}

@Preview
@Composable
fun BottomSheetPreview() {
    MoreBottomSheetContent()
}