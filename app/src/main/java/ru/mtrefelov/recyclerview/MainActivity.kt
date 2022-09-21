package ru.mtrefelov.recyclerview

import android.os.Bundle
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.*

class MainActivity : AppCompatActivity(), ColorClickListener {
    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast = Toast.makeText(this, "", Toast.LENGTH_LONG)

        findViewById<RecyclerView>(R.id.rView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ColorAdapter(getColors(), this@MainActivity)
        }
    }

    override fun onClick(colorName: CharSequence) {
        toast.apply {
            val toastText = getString(R.string.color_toast, colorName.toString().uppercase())
            setText(toastText)
            show()
        }
    }

    private fun getColors(): List<ColorData> = resources.getStringArray(R.array.color_names).map {
        val (colorHex: String, colorName: CharSequence) = it.split(" ")
        ColorData(colorName, colorHex.toColorInt())
    }
}