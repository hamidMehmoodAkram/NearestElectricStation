package com.ahoy.livecoding.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

val View.inflater
    get() = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


//add divider line b/w list items
fun RecyclerView.addDivider(){
    val dividerItemDecoration = DividerItemDecoration(
        this.context,
        DividerItemDecoration.VERTICAL)
    addItemDecoration(dividerItemDecoration)
}