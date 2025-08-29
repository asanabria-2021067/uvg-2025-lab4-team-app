package com.uvg.teamapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.model.FakeTeamRepository
import com.uvg.teamapp.model.TeamMember
import com.uvg.teamapp.ui.detail.TeamDetailScreen
import com.uvg.teamapp.ui.theme.TeamAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TeamAppTheme {
                TeamApp()
            }
        }
    }
}

@Composable
fun TeamApp() {
    var selectedMember by remember { mutableStateOf<TeamMember?>(null) }
    val teamMembers = remember { FakeTeamRepository.getTeamMembers() }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        if (selectedMember == null) {
            TeamListScreen(
                teamMembers = teamMembers,
                onMemberClick = { member ->
                    selectedMember = member
                },
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            TeamDetailScreen(
                name = selectedMember!!.name,
                description = selectedMember!!.description,
                onBack = {
                    selectedMember = null
                }
            )
        }
    }
}

@Composable
fun TeamListScreen(
    teamMembers: List<TeamMember>,
    onMemberClick: (TeamMember) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Miembros del Equipo",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(teamMembers) { member ->
                TeamMemberItem(
                    teamMember = member,
                    onClick = { onMemberClick(member) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun TeamMemberItem(
    teamMember: TeamMember,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Filled.Person,
                contentDescription = "Member icon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(40.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = teamMember.name,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hola $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TeamListScreenPreview() {
    TeamAppTheme {
        TeamListScreen(
            teamMembers = FakeTeamRepository.getTeamMembers(),
            onMemberClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TeamMemberItemPreview() {
    TeamAppTheme {
        TeamMemberItem(
            teamMember = TeamMember(
                name = "Vernel Gonzalez",
                description = "Desarrollador especializado en UI/UX"
            ),
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TeamAppTheme {
        Greeting("Equipo")
    }
}