package com.example.rtofy.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = AppPrimaryLight,
    onPrimary = AppSurfaceLight,
    primaryContainer = AppPrimaryContainerLight,
    onPrimaryContainer = AppTextPrimaryLight,

    background = AppBackgroundLight,
    onBackground = AppTextPrimaryLight,

    surface = AppSurfaceLight,
    onSurface = AppTextPrimaryLight,
    surfaceVariant = AppSurfaceVariantLight,
    onSurfaceVariant = AppTextSecondaryLight,

    outline = AppOutlineLight
)

private val DarkColors = darkColorScheme(
    primary = AppPrimaryDark,
    onPrimary = AppTextPrimaryLight,
    primaryContainer = AppPrimaryContainerDark,
    onPrimaryContainer = AppTextPrimaryDark,

    background = AppBackgroundDark,
    onBackground = AppTextPrimaryDark,

    surface = AppSurfaceDark,
    onSurface = AppTextPrimaryDark,
    surfaceVariant = AppSurfaceVariantDark,
    onSurfaceVariant = AppTextSecondaryDark,

    outline = AppOutlineDark
)

@Composable
fun RtofyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}