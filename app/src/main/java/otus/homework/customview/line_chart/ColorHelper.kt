package otus.homework.customview.line_chart

import kotlin.random.Random

object ColorHelper {

    fun getRandomColor(colorScheme: Int = 16) = generateRandomColors(colorScheme).shuffled().first()

    private fun generateRandomColors(size: Int) = buildList<Int> {
        for (i in 0 until size) {
            add(generateRandomColor())
        }
    }

    private fun generateRandomColor(): Int {
        val red = randomColor()
        val green = randomColor()
        val blue = randomColor()
        return -((red shl HEX_BITE) or (green shl OCT_BITE) or blue)
    }

    private fun randomColor() = Random.nextInt(MIN_COLOR, MAX_COLOR)

    private const val MAX_COLOR = 256
    private const val MIN_COLOR = 0
    private const val HEX_BITE = 16
    private const val OCT_BITE = 8
}