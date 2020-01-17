package com.perelandrax.dunkshot.root

import com.perelandrax.dunkshot.root.RootBuilder.Component
import com.uber.rib.core.ViewRouter

/**
 * Adds and removes children of {@link RootBuilder.RootScope}.
 *
 * TODO describe the possible child configurations of this scope.
 */
class RootRouter(
  view: RootView,
  interactor: RootInteractor,
  component: Component
) :
  ViewRouter<RootView, RootInteractor, Component>(view, interactor, component)
