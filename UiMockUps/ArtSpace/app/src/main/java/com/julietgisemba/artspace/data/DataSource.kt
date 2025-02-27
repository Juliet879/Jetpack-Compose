package com.julietgisemba.artspace.data

import com.julietgisemba.artspace.model.ArtPiece

class DataSource {
    companion object {
        fun loadArts(): List<ArtPiece> {
            return listOf(
                ArtPiece(
                    "Starry Night Over the Rhône",
                    "Toa Heftiba",
                    1888,
                    "https://images.unsplash.com/photo-1740418953117-73dc083f23d2?q=80&w=2940&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                ),
                ArtPiece(
                    "The Great Wave off Kanagawa",
                    "Yevhenii Deshko",
                    1831,
                    "https://plus.unsplash.com/premium_photo-1671269941569-7841144ee4e0?q=80&w=3093&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                ),
                ArtPiece(
                    "Mona Lisa",
                    "Leonardo da Vinci",
                    1503,
                    "https://images.unsplash.com/photo-1734865266315-bfa6776eed4b?q=80&w=3087&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                ),
                ArtPiece(
                    "The Persistence of Memory",
                    "Victoria Prymak",
                    1931,
                    "https://upload.wikimedia.org/wikipedia/en/thumb/d/dd/The_Persistence_of_Memory.jpg/1280px-The_Persistence_of_Memory.jpg"
                ),
                ArtPiece(
                    "Girl with a Pearl Earring",
                    "Johannes Vermeer",
                    1665,
                    "https://images.unsplash.com/photo-1735845929472-da629a4cbac7?q=80&w=3164&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                )
            )
        }
    }
}