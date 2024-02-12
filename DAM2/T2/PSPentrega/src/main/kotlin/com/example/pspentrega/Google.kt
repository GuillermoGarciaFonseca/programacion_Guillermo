package com.example.pspentrega

import java.awt.Desktop
import java.net.URI

fun main() {
    try {
        val url = "https://www.google.com"
        val uri = URI(url)

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(uri)
        } else {
            println("El escritorio no es compatible con la navegación web.")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
