package otus.homework.customview.pie_chart

import android.graphics.Color
import android.graphics.CornerPathEffect
import android.graphics.Paint


data class PieChartModel(
    var percentOfCircle: Float = 100F,
    var percentToStartAt: Float = 0F,
    var colorOfLine: Int = Color.BLACK,
    var stroke: Float = 10F,
    var paintRound: Boolean = false
) {
    var paint: Paint = Paint().apply {
        color = colorOfLine
        isAntiAlias = true
        style = Paint.Style.STROKE
        strokeWidth = stroke
        isDither = true

        if (paintRound) {
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            pathEffect = CornerPathEffect(8F)
        }
    }

    init {
        // Ensuring percent values are in a valid range and converting to degrees
        percentOfCircle = (percentOfCircle.coerceIn(0F, 100F) * 360) / 100
        percentToStartAt = (percentToStartAt.coerceIn(0F, 100F) * 360) / 100
    }
}