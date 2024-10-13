package com.example.fitbykit

import android.app.appsearch.SetSchemaResponse
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModelProvider
import com.example.fitbykit.ViewModels.VideoPlayerViewModel
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.coroutines.delay

class VideoPlayerActivity : ComponentActivity() {
    private lateinit var viewModel: VideoPlayerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the ViewModel
        viewModel = ViewModelProvider(this).get(VideoPlayerViewModel::class.java)

        // Get video URL from intent
        val videoUrl = intent.getStringExtra("VIDEO_URL") ?: return

        // Initialize the player in the ViewModel
        viewModel.initializePlayer(this, videoUrl) // Pass 'this' as context

        setContent {
            VideoPlayerScreen(viewModel)
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getPlayer().playWhenReady = true
    }

    override fun onStop() {
        super.onStop()
        viewModel.getPlayer().playWhenReady = false
    }
}

@Composable
fun VideoPlayerScreen(viewModel: VideoPlayerViewModel) {
    val context = LocalContext.current
    var isLoading by remember { mutableStateOf(true) }

    // Simulate a loading delay (e.g., for loading video)
    LaunchedEffect(Unit) {
        delay(2000) // Simulate a loading delay for the shimmer
        isLoading = false
    }

    val customFontRegular = FontFamily(
        Font(R.font.bold, FontWeight.Normal)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp), // Padding on both sides
        horizontalAlignment = Alignment.Start // Align items to the start (left)

    ) {
        // Add a text widget aligned to the left
        Text(
            text = "There You Go",
            fontSize = 28.sp,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = customFontRegular,
            textAlign = TextAlign.Start, // Align text to the start (left)
            modifier = Modifier
                .padding(top = 24.dp,bottom = 12.dp)
                .fillMaxWidth() // Make sure text takes full width for left alignment
        )

        // Show shimmer effect while loading
        if (isLoading) {
            ShimmerEffectBox()
        } else {
            // Use AndroidView to create the PlayerView with rounded corners
            AndroidView(
                factory = {
                    PlayerView(context).apply {
                        layoutParams = FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        this.player = viewModel.getPlayer() // Set the player for the view
                        this.resizeMode = AspectRatioFrameLayout.RESIZE_MODE_FILL
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()  // Take the full width of the screen
                    .fillMaxHeight()  // Fixed height for rectangle shape
                    .padding(horizontal = 4.dp , vertical = 4.dp)  // Padding on the sides
                    .padding(bottom = 32.dp)
                    .clip(RoundedCornerShape(8.dp)) // Rounded corners with 16.dp radius
            )
        }
    }
}

@Composable
fun ShimmerEffectBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth() // Fill the width just like the video player
            .fillMaxHeight() // Same height as the video player
            .padding(bottom = 32.dp)
            .clip(RoundedCornerShape(8.dp)) // Rounded corners for shimmer effect
            .background(color = Color.LightGray) // Placeholder shimmer effect
    ) {
        BasicText(
            text = "Loading...",
            modifier = Modifier.align(Alignment.Center),
            style = LocalTextStyle.current.copy(color = Color.DarkGray, fontSize = 16.sp)
        )
    }
}
