package com.perelandrax.ribshot.ribs.root

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_root.view.*

/**
 * Top level view for {@link RootBuilder.RootScope}.
 */
class RootView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle), RootInteractor.RootPresenter {

    fun viewContent(): ViewGroup {
        return content
    }
}
