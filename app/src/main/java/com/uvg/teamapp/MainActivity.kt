package com.uvg.teamapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.uvg.teamapp.ui.detail.TeamDetailScreen
import com.uvg.teamapp.ui.list.TeamListScreen
import com.uvg.teamapp.ui.theme.TeamAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            TeamAppTheme {
                val nav = rememberNavController()

                MaterialTheme {
                    NavHost(navController = nav, startDestination = "list") {

                        composable("list") {
                            TeamListScreen(
                                onMemberClick = { member ->
                                    val n = Uri.encode(member.name)
                                    val d = Uri.encode(member.description)
                                    nav.navigate("detail/$n/$d")
                                }
                            )
                        }

                        composable(
                            route = "detail/{name}/{desc}",
                            arguments = listOf(
                                navArgument("name") { type = NavType.StringType },
                                navArgument("desc") { type = NavType.StringType }
                            )
                        ) { backStack ->
                            val name = backStack.arguments?.getString("name") ?: ""
                            val desc = backStack.arguments?.getString("desc") ?: ""
                            TeamDetailScreen(
                                name = name,
                                description = desc,
                                onBack = { nav.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) { Text("Hola $name!") }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() { TeamAppTheme { Greeting("Equipo") } }
