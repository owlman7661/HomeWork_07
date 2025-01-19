package otus.homework.customview.pie_chart

import android.os.Parcelable
import android.view.View

class PieChartState(
    private val superSavedState: Parcelable?,
    val dataList: List<PieChartData>
) : View.BaseSavedState(superSavedState), Parcelable