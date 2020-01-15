package com.perelandrax.ribshot

import android.view.ViewGroup
import com.perelandrax.ribshot.ribs.root.RootBuilder
import com.uber.rib.core.RibActivity
import com.uber.rib.core.ViewRouter

class RibShotActivity : RibActivity() {

  private val TAG = javaClass.simpleName

  override fun createRouter(parentViewGroup: ViewGroup): ViewRouter<*, *, *> {
    val rootBuilder = RootBuilder(object : RootBuilder.ParentComponent {})
    return rootBuilder.build(this, parentViewGroup)
  }
}
