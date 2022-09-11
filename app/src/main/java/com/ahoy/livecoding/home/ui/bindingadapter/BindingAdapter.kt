package com.ahoy.livecoding.home.ui.bindingadapter

import android.app.ProgressDialog.show
import android.util.Log
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahoy.livecoding.home.models.ElectricStation
import com.ahoy.livecoding.home.models.UIState
import com.ahoy.livecoding.home.ui.HomeAdapter

@BindingAdapter("adapter")
fun <T : RecyclerView.ViewHolder> RecyclerView.bindAdapter(adapter: RecyclerView.Adapter<T>) {
    this.adapter = adapter
}

@BindingAdapter(value = ["set_home_data"])
fun RecyclerView.submitDataHome(data: List<ElectricStation>?) {
    data?.let {
        (adapter as? HomeAdapter)?.listItems = data.orEmpty()
    }
}


@BindingAdapter(value = ["toggle_visibility"])
fun View.toggleVisibility(viewState: UIState<Any>?) {
    updateViewVisibility(viewState is UIState.Loading)
}

fun View.updateViewVisibility(visible: Boolean) {
    visibility = when {
        visible -> View.VISIBLE
        else -> View.GONE
    }
}
