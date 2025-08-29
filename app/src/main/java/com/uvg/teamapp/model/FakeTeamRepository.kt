package com.uvg.teamapp.model

object FakeTeamRepository {

    fun getTeamMembers(): List<TeamMember> {
        return listOf(
            TeamMember(
                name = "Ángel Sanabria",
                description = "Estudiante de Ingeniería en Ciencias de la Computación, apasionado por la IA y el desarrollo de software."
            ),
            TeamMember(
                name = "Juan Montenegro",
                description = "Especialista en desarrollo móvil con Kotlin y Jetpack Compose."
            ),
            TeamMember(
                name = "Vernel Hernández",
                description = "Intereasado en diseño de interfaces y experiencia de usuario."
            )
        )
    }
}
