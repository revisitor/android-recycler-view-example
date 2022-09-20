package ru.mtrefelov.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.rView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ColorAdapter(getColors())
        }
    }

    private fun getColors(): List<ColorData> {
        val colorNames = resources.getStringArray(R.array.colors)
        val colors = listOf(
            R.color.white, R.color.black, R.color.blue, R.color.red, R.color.magenta
        ).map { resources.getColor(it, null) }

        return colorNames.mapIndexed { i, colorName -> ColorData(colorName, colors[i]) }
    }
}