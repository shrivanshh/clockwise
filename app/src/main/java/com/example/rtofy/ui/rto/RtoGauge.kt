package com.example.rtofy.ui.rto

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
val shortFmt = DateTimeFormatter.ofPattern("MMM d")

@Composable
fun RtoSummaryPanel(
    title: String,
    progress: Float,
    percentText: String,
    businessDays: Int,
    officeDays: Int,
    modifier: Modifier = Modifier.Companion
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 1.dp,
        color = MaterialTheme.colorScheme.surface
    ) {
        Column(
            modifier = Modifier.Companion.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            CompactRtoGauge(
                progress = progress,
                percentText = percentText
            )

            MiniStatRow(
                label = "Business Days",
                value = businessDays.toString()
            )

            HorizontalDivider(
                thickness = 0.8.dp,
                color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
            )

            MiniStatRow(
                label = "Office Days",
                value = officeDays.toString()
            )
        }
    }
}

@Composable
fun CompactRtoGauge(
    progress: Float,
    percentText: String
) {
    val safeProgress = progress.coerceIn(0f, 1f)
    val progressColor = gaugeColor(safeProgress)

    Box(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .height(105.dp),
        contentAlignment = Alignment.Companion.Center
    ) {
        Canvas(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .height(64.dp)
        ) {
            val strokeWidth = 8.dp.toPx()
            val gaugeDiameter = size.width * 0.7f
            val left = (size.width - gaugeDiameter) / 2f
            val top = (-6).dp.toPx()

            drawArc(
                color = Color(0xFFE8E8EC),
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = Offset(left, top),
                size = Size(gaugeDiameter, gaugeDiameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Companion.Round)
            )

            drawArc(
                color = progressColor,
                startAngle = 180f,
                sweepAngle = 180f * safeProgress,
                useCenter = false,
                topLeft = Offset(left, top),
                size = Size(gaugeDiameter, gaugeDiameter),
                style = Stroke(width = strokeWidth, cap = StrokeCap.Companion.Round)
            )
        }

        Column(
            modifier = Modifier.Companion.padding(top = 35.dp),
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Text(
                text = percentText,
                style = MaterialTheme.typography.titleMedium,
                color = progressColor
            )
            val status = rtoStatusLabel(safeProgress)
            Text(
                text = status.replace(" ", "\n"),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Companion.Center
            )
        }
    }
}

@Composable
fun MiniStatRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.Companion.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Companion.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

private fun rtoStatusLabel(progress: Float): String {
    return when {
        progress < 0.4f -> "Needs Attention"
        progress < 0.5f -> "Doing Okay"
        else -> "On Track"
    }
}

private fun gaugeColor(progress: Float): Color {
    return when {
        progress < 0.4f -> Color(0xFFD32F2F)
        progress < 0.5f -> Color(0xFFF9A825)
        else -> Color(0xFF3D8B40)
    }
}