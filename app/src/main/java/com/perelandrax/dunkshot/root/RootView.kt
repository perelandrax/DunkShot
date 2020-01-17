package com.perelandrax.dunkshot.root

import android.content.Context
import android.util.AttributeSet
import android.view.ViewGroup
import android.widget.FrameLayout
import com.perelandrax.dunkshot.root.RootInteractor.RootPresenter
import kotlinx.android.synthetic.main.root_rib.view.content

/**
 * Top level view for {@link RootBuilder.RootScope}.
 */
class RootView @JvmOverloads constructor(
  context: Context,
  attrs: AttributeSet? = null,
  defStyle: Int = 0
) : FrameLayout(context, attrs, defStyle),
  RootPresenter {

  fun viewContent(): ViewGroup {
    return content
  }
}
