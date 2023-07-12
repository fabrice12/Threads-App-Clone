package com.orion.threads

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.orion.threads.components.MoreBottomSheet
import com.orion.threads.data.GenerateThreadData
import com.orion.threads.models.Thread
import com.orion.threads.ui.theme.ThreadsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThreadsTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ThreadsContent()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreadsContent() {
    val Threads = GenerateThreadData.generate()

    Scaffold(

//        modifier = Modifier.imePadding(),
        topBar = {

        }, bottomBar = {
            NavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .systemBarsPadding(),
                containerColor = MaterialTheme.colorScheme.onPrimary
            ) {
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Black
                        )

                    },

                    )
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray
                        )

                    },

                    )
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Rounded.Edit,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray
                        )

                    },

                    )
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray
                        )

                    },

                    )
                NavigationBarItem(
                    selected = false, onClick = { /*TODO*/ },
                    icon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Search",
                            modifier = Modifier.size(30.dp),
                            tint = Color.Gray
                        )

                    },

                    )

            }
        }

    ) {
        Log.d("Values", "ThreadsContent: $it")
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(horizontal = 16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.threadlogo),
                        contentDescription = "Logo",
                        modifier = Modifier.size(40.dp),
                        contentScale = ContentScale.Crop
                    )

                }
            }
            items(Threads) { thread ->
                ThreadCard(thread)
                Divider(color = Color.Gray.copy(alpha = 0.1f))
            }

        }
    }

}

@Composable
fun ThreadCard(thread: Thread) {
    var showSheet by remember {
        mutableStateOf(false)
    }
    if (showSheet) {
        MoreBottomSheet {
            showSheet = false
        }
    }
    val localDensity = LocalDensity.current
    var columnHeightPx by remember {
        mutableStateOf(0f)
    }

    // Create element height in dp state
    var columnHeightDp by remember {
        mutableStateOf(0.dp)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier.weight(2f), horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Image(
                painter = painterResource(id = thread.profileImage),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(50.dp),

                )
            Spacer(modifier = Modifier.height(8.dp))
            //make divider height match the height of row
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .background(Color.Gray.copy(alpha = 0.4F))
                    .height(columnHeightDp - 70.dp), contentAlignment = Alignment.BottomEnd
            ) {


            }
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

                PhotoBox()
            }


        }
        Column(modifier = Modifier
            .weight(8f)
            .onGloballyPositioned {
                columnHeightPx = it.size.height.toFloat()
                columnHeightDp = with(localDensity) {
                    columnHeightPx.toDp()
                }


            }) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = thread.name, fontSize = 16.sp, fontWeight = FontWeight.Bold
                    )
                    if (thread.isVerified) {
                        Image(
                            painter = painterResource(id = R.drawable.quality),
                            contentDescription = "Image",
                            modifier = Modifier.size(16.dp)
                        )
                    }

                }


                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = thread.time, fontSize = 12.sp, fontWeight = FontWeight.Light
                    )
                    IconButton(onClick = {
                        showSheet = true
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.more),
                            contentDescription = "more"
                        )
                    }
                }

            }
            Text(
                text = thread.message

            )
            Spacer(modifier = Modifier.height(8.dp))
            thread.messagePhoto?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it, modifier = Modifier
                            .clip(RoundedCornerShape(16.dp))
                            .border(
                                2.dp,
                                Color.Gray.copy(alpha = 0.4f),
                                shape = RoundedCornerShape(16.dp)
                            ), contentDescription = "desc"
                    )
                }

            //four icons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.favorite),
                        modifier = Modifier.size(25.dp),
                        contentDescription = "comment"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.comment),
                        modifier = Modifier
                            .size(25.dp)
                            .graphicsLayer {
                                scaleX = -1f
                            },
                        contentDescription = "comment"
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.retweet),
                        modifier = Modifier
                            .size(30.dp)
                            .graphicsLayer {
                                scaleX = -1f
                            },
                        contentDescription = "comment"
                    )
                }




                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.send),
                        modifier = Modifier
                            .size(25.dp)
                            .rotate(-45f),
                        contentDescription = "comment"
                    )
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(text = "164 replies", color = Color.Gray)
                Text(text = "99 likes", color = Color.Gray)


            }

        }
    }
}

@Composable
fun PhotoBox() {
    Box(
        modifier = Modifier.size(30.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.okkama),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(0.3f)
                .align(Alignment.TopStart),


            )
        Image(
            painter = painterResource(id = R.drawable.okkama),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(0.4f)
                .align(Alignment.TopEnd),

            )
        Image(
            painter = painterResource(id = R.drawable.bruce),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(0.3f)
                .align(Alignment.BottomCenter),


            )

    }
}

@Composable
@Preview(showBackground = true)
fun GreetingPreview() {
    ThreadsTheme {
        ThreadsContent()
    }
}