package com.uvg.teamapp.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.teamapp.model.TeamMember

@Composable
fun TeamListScreen(
    onMemberClick: (TeamMember) -> Unit
) {
    val members = listOf(
        TeamMember("Vernel", "Android / Compose"),
        TeamMember("Sanabria", "UI/UX"),
        TeamMember("Francisco", "Repos & PRs")
    )

    LazyColumn {
        items(members) { m ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onMemberClick(m) }
            ) {
                ListItem(
                    headlineContent = { Text(m.name, style = MaterialTheme.typography.titleMedium) },
                    supportingContent = { Text(m.description) }
                )
            }
        }
    }
}
