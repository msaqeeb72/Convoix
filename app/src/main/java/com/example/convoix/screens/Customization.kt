package com.example.convoix.screens

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.convoix.AppState
import com.example.convoix.ChatViewModel
import com.example.convoix.Pref
import com.example.convoix.R

@Composable
fun Customization(viewModel: ChatViewModel, state: AppState, isDark: Boolean) {
    val pref = state.userData?.pref
    var sliderPosition by remember { mutableFloatStateOf(pref?.fontSize.toString().toFloat()) }
    var bsliderPosition by remember { mutableFloatStateOf(pref?.back.toString().toFloat()) }
    var theme by remember { mutableStateOf(pref?.themes) }
    val size = sliderPosition.sp
    val brush = Brush.linearGradient(listOf(
        Color(0xFF238CDD),
        Color(0xFF1952C4)
    ))
    val brush2 = Brush.linearGradient(listOf(
        Color(0xFF2A4783),
        Color(0xFF2F6086)
    ))
    val brush3 = Brush.linearGradient(listOf(
        Color(0xFF9465FF),
        Color(0xFF6723D1)
    ))
    val brush4 = Brush.linearGradient(listOf(
        Color(0xFF54308D),
        Color(0xFF5E449B)
    ))
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 50.dp)
        .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Customization",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp,)
        )
        Box(modifier = Modifier
            .border(
                1.dp,
                MaterialTheme.colorScheme.inversePrimary,
                RoundedCornerShape(16.dp)
            )
            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(16.dp))
            .height(200.dp),
            contentAlignment = Alignment.BottomCenter ) {
            Image(
                modifier = Modifier
                    .alpha(bsliderPosition)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop,
                painter = painterResource(R.drawable.hd_wallpaper_whatsapp_black_abstract_abstract_digital_abstraction_abstracts_background_digital_pattern_texture),
                contentDescription = null,
                colorFilter = if (isDark) ColorFilter.tint(
                    MaterialTheme.colorScheme.primaryContainer,
                    blendMode = BlendMode.Softlight
                )
                else ColorFilter.tint(
                    MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.6f),
                    blendMode = BlendMode.Color
                )
            )

            Column (modifier = Modifier.padding(bottom = 10.dp)){
                MessageItem("This is a Sample Text", alignment = Alignment.CenterStart, if(theme==2) brush4 else brush2, size)
                MessageItem("This is a sample Text 2", alignment = Alignment.CenterEnd, if(theme==2) brush3 else brush,size)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .shadow(5.dp, RoundedCornerShape(12.dp))
            .background(
                if (isDark) Color.DarkGray else Color.LightGray,
                RoundedCornerShape(12.dp)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Font size",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
                    ),
                    steps = 4,
                    valueRange = 14f..24f
                )
            }
        }
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .shadow(5.dp, RoundedCornerShape(12.dp))
            .background(
                if (isDark) Color.DarkGray else Color.LightGray,
                RoundedCornerShape(12.dp)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "background",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Slider(
                    value = bsliderPosition,
                    onValueChange = { bsliderPosition = it },
                    colors = SliderDefaults.colors(
                        thumbColor = MaterialTheme.colorScheme.secondary,
                        activeTrackColor = MaterialTheme.colorScheme.secondary,
                        inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer
                    ),
                )
            }
        }
        Row(modifier = Modifier
            .padding(top = 20.dp)
            .shadow(5.dp, RoundedCornerShape(12.dp))
            .background(
                if (isDark) Color.DarkGray else Color.LightGray,
                RoundedCornerShape(12.dp)
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            ) {
                Text(
                    text = "Accent color",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 10.dp)
                )
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),horizontalArrangement = Arrangement.SpaceEvenly) {
                    Box(modifier = Modifier
                        .shadow(2.dp, CircleShape)
                        .clickable { theme = 1 }
                        .size(60.dp)
                        .background(brush, CircleShape)
                        .border(2.dp, if(theme==1) Color.LightGray else Color.Transparent, CircleShape)) {

                    }
                    Box(modifier = Modifier
                        .shadow(2.dp, CircleShape)
                        .clickable { theme=2 }
                        .size(60.dp)
                        .background(brush3, CircleShape)
                        .border( 2.dp, if(theme==2) Color.LightGray else Color.Transparent, CircleShape)) {
                    }
                }

            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { viewModel.updatePref(state.userData!!, Pref(fontSize = sliderPosition, isDark = isDark, back = bsliderPosition, themes = theme!!))
                Toast.makeText(context, "Preferences saved", Toast.LENGTH_SHORT).show()},
            modifier = Modifier
                .padding(bottom = 50.dp)
                .background(brush, CircleShape)
                .fillMaxWidth(0.7f)
                .height(50.dp), colors = ButtonDefaults.buttonColors(Color.Transparent), shape = CircleShape
        ) {
            Text(
                text = "Save preferences",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}
@Composable
fun MessageItem(
    text: String,
    alignment: Alignment,
    brush: Brush,
    size: TextUnit,
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 3.dp,
                bottom = 3.dp,
                start = 10.dp,
                end = 10.dp
            ),
        contentAlignment = alignment
    ) {
        Column(verticalArrangement = Arrangement.Bottom) {
            Column(
                modifier = Modifier
                    .shadow(2.dp, RoundedCornerShape(16.dp))
                    .widthIn(max = 270.dp)
                    .background(brush, RoundedCornerShape(16.dp)),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp),
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = size),
                    color = Color.White
                )
                Text(
                    text = "12:30 pm",
                    modifier = Modifier.padding(
                        end = 8.dp,
                        bottom = 5.dp,
                        start = 8.dp,
                        top = 2.dp
                    ),
                    style = MaterialTheme.typography.labelSmall,
                    color = Color.White,
                )
            }
        }
    }
}