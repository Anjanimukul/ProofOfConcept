package com.example.proofofconcept.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.proofofconcept.R
import com.example.proofofconcept.databinding.HomeItemBinding
import com.example.proofofconcept.ui.home.HomeContract
import com.squareup.picasso.Picasso
import javax.inject.Inject


class HomeAdapter @Inject
constructor(private val presenter: HomeContract.Presenter<HomeContract.View>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.home_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return presenter.getHomeResponse().rows?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.data = presenter.getHomeResponse().rows?.get(position)
        if (presenter.getHomeResponse().rows?.get(position)?.imageHref != null) {
            val url: String =
                presenter.getHomeResponse().rows?.get(position)?.imageHref!!.replace(
                    "http",
                    "https"
                )
            Picasso.get().load(url).into(holder.binding.ivPhoto)
        }
    }

    inner class ViewHolder(val binding: HomeItemBinding) : RecyclerView.ViewHolder(binding.root)
}