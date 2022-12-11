package com.example.hesabyapp

import android.graphics.drawable.VectorDrawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.hesabyapp.ui.theme.HesabyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HesabyAppTheme {

                var bottomState by remember {
                    mutableStateOf("الرئيسية")
                }

                Scaffold(
                    modifier = Modifier.padding(10.dp),

                    content = {
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                            Column(Modifier.fillMaxWidth()) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row() {
                                        Text(
                                            text = "مرحباً",
                                            fontSize = MaterialTheme.typography.h6.fontSize,
                                            fontStyle = FontStyle.Normal,
                                            fontFamily = FontFamily(
                                                Font(R.font.frutiger_lt_arabic_65_bold)
                                            )
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(
                                            text = "تركي الشهراني",
                                            fontSize = MaterialTheme.typography.h6.fontSize,
                                            fontStyle = FontStyle.Normal,
                                            fontFamily = FontFamily(
                                                Font(R.font.frutiger_lt_arabic_65_bold)
                                            ),
//                                                modifier = Modifier.graphicsLayer(alpha = 0.99f)
//                                            .drawWithCache {
//                                                val brush = Brush.horizontalGradient(RainbowColors)
//                                                onDrawWithContent {
//                                                    drawContent()
//                                                    drawRect(brush, blendMode = BlendMode.SrcAtop)
//                                                }
//                                            }
                                        )
                                    } // parent Row

                                    Row() {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(15.dp))
                                                .background(color = Color(0Xff00afa9))
                                                .width(70.dp)
                                                .padding(5.dp)

                                        ) {
                                            Text(
                                                text = "حضور",
                                                textAlign = TextAlign.Center,
                                                color = Color.White,
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                        }
                                    }


                                }

                                Spacer(modifier = Modifier.height(20.dp))

                                Box(modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(shape = RoundedCornerShape(15))
                                    .background(color = Color(0xfff2a456))
                                    .height(80.dp)
                                    .padding(
                                        start = 20.dp, top = 20.dp
                                    )
                                ){
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight(),
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        Image(painterResource(id = R.drawable.logo),
                                            contentDescription = " hbjhv" ,
                                            modifier = Modifier.fillMaxHeight() )

                                        Column(verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally) {
                                            Text(text = "تم تغيير روابط الوزارة إلى " , color = Color.White)
                                            Text(text = "https://MC.gov.sa" , color = Color.White)
                                        }
                                    }
                                }
                            }

                            var  list : ArrayList<MyData> = ArrayList()

                            list.add(MyData("jkhbdkjbd" , painterResource(id = R.drawable.logo)))
                            list.add(MyData("jkhbdkjbd" , painterResource(id = R.drawable.logo)))
                            list.add(MyData("jkhbdkjbd" , painterResource(id = R.drawable.logo)))


                            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                                LazyRow(state = rememberLazyListState()) {
                                    items(list.size){

                                    }
                                }
                            }
                        }
                    },
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = Color(0xFFECE8E8),
                            contentColor = Color(0xfff999999),
                            modifier = Modifier.clip(
                                shape = RoundedCornerShape(
                                    bottomStart = 30.dp, bottomEnd = 30.dp,
                                    topStart = 30.dp, topEnd = 30.dp
                                )
                            )
                        ) {

                            BottomNavigationItem(selected = bottomState == "بياناتي", onClick = {
                                bottomState == "بياناتي"
                            },
                                label = { Text(text = "بياناتي") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Person,
                                        contentDescription = null
                                    )
                                }
                            )

                            BottomNavigationItem(selected = bottomState == "دردشة", onClick = {
                                bottomState == "دردشة"
                            },
                                label = { Text(text = "دردشة") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Email,
                                        contentDescription = null
                                    )
                                }
                            )

                            BottomNavigationItem(selected = bottomState == "اخبار", onClick = {
                                bottomState == "اخبار"
                            },
                                label = { Text(text = "اخبار") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Send,
                                        contentDescription = null
                                    )
                                }
                            )


                            BottomNavigationItem(selected = bottomState == "الدليل", onClick = {
                                bottomState == "الدليل"
                            },
                                label = { Text(text = "الدليل") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.LocationOn,
                                        contentDescription = null
                                    )
                                }
                            )
                            BottomNavigationItem(selected = bottomState == "الرئيسية", onClick = {
                                bottomState == "الرئيسية"
                            },
                                label = { Text(text = "الرئيسية") },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Home,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}

