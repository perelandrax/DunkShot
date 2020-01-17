package com.perelandrax.dunkshot

import android.view.ViewGroup
import com.perelandrax.dunkshot.root.RootBuilder
import com.perelandrax.dunkshot.root.RootBuilder.ParentComponent
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class DunkShotActivity : RibActivity() {

  private val TAG = javaClass.simpleName

  override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
    val rootBuilder = RootBuilder(object :
      ParentComponent {})
    return rootBuilder.build(this, parentViewGroup)
  }
}
