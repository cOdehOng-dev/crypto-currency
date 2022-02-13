package com.c0de_h0ng.cryptocurrency.common.databinding

import android.view.View
import android.view.View.*
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.c0de_h0ng.cryptocurrency.R
import com.c0de_h0ng.domain.model.CoinRank

/**
 * Created by c0de_h0ng on 2022/02/13.
 */

@BindingAdapter("visible")
fun View?.setVisible(visible: Boolean?) {
    this?.visibility = if (visible == true) VISIBLE else GONE
}

@BindingAdapter("visible")
fun View?.setVisible(visible: Int?) {
    this?.visibility = if (visible == VISIBLE) VISIBLE else if (visible == INVISIBLE) INVISIBLE else GONE
}

@BindingAdapter(value = ["tabItem", "tabBg"], requireAll = false)
fun ConstraintLayout.setRankTabBg(
    item: CoinRank?,
    selectedTab: CoinRank?
) {
    if (item != null && selectedTab != null) {
        isEnabled = (item != selectedTab)
    }
}

@BindingAdapter(value = ["tabItem", "selectedTab"], requireAll = false)
fun TextView.setRankTabSelected(
    item: CoinRank?,
    selectedTab: CoinRank?
) {
    if (item != null && selectedTab != null) {
        var color = ContextCompat.getColor(context, R.color.gray_848489)
        if (item == selectedTab) {
            color = ContextCompat.getColor(context, R.color.gray_efedef)
        }
        setTextColor(color)
    }
}