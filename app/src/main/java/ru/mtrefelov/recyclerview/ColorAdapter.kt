package ru.mtrefelov.recyclerview

import android.graphics.Color
import android.view.*
import android.widget.TextView

import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.RecyclerView

class ColorAdapter(
    private val colors: List<ColorData>, private val clickListener: ColorClickListener
) : RecyclerView.Adapter<ColorAdapter.ColorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rview_item, parent, false)
        return ColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val (colorName: CharSequence, colorHex: Int) = colors[position]
        holder.apply {
            colorView.background = Color.valueOf(colorHex).toDrawable()
            colorTextView.text = colorName
            itemView.setOnClickListener { clickListener.onClick(colorName) }
        }
    }

    override fun getItemCount() = colors.size

    class ColorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val colorView: View = view.findViewById(R.id.color_view)
        val colorTextView: TextView = view.findViewById(R.id.color_textView)
    }
}