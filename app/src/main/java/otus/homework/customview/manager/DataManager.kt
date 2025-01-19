package otus.homework.customview.manager

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import otus.homework.customview.R
import otus.homework.customview.line_chart.PayloadEntity

class DataManager(private val context: Context) {
    private val gson = Gson()

    fun readAndParse(): List<PayloadEntity> =
        parsePayloadJson(readPayloadFromRawFiles().orEmpty())

    private fun parsePayloadJson(json: String): List<PayloadEntity> {
        return try {
            gson.fromJson(
                json,
                object : TypeToken<List<PayloadEntity>>() {}.type
            )
        } catch (e: Exception) {
            emptyList()
        }
    }

    private fun readPayloadFromRawFiles(): String? {
        return try {
            val inputStream = context.resources.openRawResource(R.raw.payload)
            inputStream.bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            null
        }
    }
}