package com.example.preubakotlin.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.preubakotlin.R
import com.example.preubakotlin.model.Platform

class PlatformRvAdapter(val platformList:List<Platform>): RecyclerView.Adapter<PlatformRvAdapter.PlatformViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatformViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.platform_item, parent, false )
        return PlatformViewHolder(view)
    }

    override fun getItemCount() = platformList.size


    override fun onBindViewHolder(holder: PlatformViewHolder, position: Int) {
        val name = holder.view.findViewById<TextView>(R.id.platform_name)
        val defaultLanguage = holder.view.findViewById<TextView>(R.id.platform_default_language)
        val homepage = holder.view.findViewById<TextView>(R.id.platform_homepage)
        val count = holder.view.findViewById<TextView>(R.id.platform_count)
        name.text =  platformList[position].name!!
        defaultLanguage.text = platformList[position].defaultLanguage
        homepage.text = platformList[position].homepage
        count.text = platformList[position].projectCount
    }

    class PlatformViewHolder(var view: View): RecyclerView.ViewHolder(view)
}