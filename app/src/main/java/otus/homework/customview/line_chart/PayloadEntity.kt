package otus.homework.customview.line_chart

data class PayloadEntity(
    val id: Int,
    val name: String,
    val amount: Int,
    val category: String,
    val time: Long
)