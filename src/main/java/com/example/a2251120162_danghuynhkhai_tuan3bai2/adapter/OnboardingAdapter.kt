package com.example.a2251120162_danghuynhkhai_tuan3bai2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a2251120162_danghuynhkhai_tuan3bai2.R
import com.example.a2251120162_danghuynhkhai_tuan3bai2.model.OnboardingItem

class OnboardingAdapter(private val items: List<OnboardingItem>) :
    RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {

    class OnboardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageView: ImageView = view.findViewById(R.id.image)
        private val titleView: TextView = view.findViewById(R.id.title)
        private val descView: TextView = view.findViewById(R.id.description)

        fun bind(item: OnboardingItem) {
            imageView.setImageResource(item.image)
            titleView.text = item.title
            descView.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(view)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}