package com.perelandrax.dunkshot.root

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.perelandrax.dunkshot.R
import com.perelandrax.dunkshot.common.ScreenStack
import com.perelandrax.dunkshot.root.RootBuilder.ParentComponent
import com.perelandrax.dunkshot.root.RootInteractor.RootPresenter
import com.uber.rib.core.InteractorBaseComponent
import com.uber.rib.core.ViewBuilder
import dagger.Binds
import dagger.BindsInstance
import dagger.Provides
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.BINARY

/**
 * Builder for the {@link RootScope}.
 *
 * TODO describe this scope's responsibility as a whole.
 */
class RootBuilder(dependency: ParentComponent) :
  ViewBuilder<RootView, RootRouter, ParentComponent>(dependency) {

  /**
   * Builds a new [RootRouter].
   *
   * @param parentViewGroup parent view group that this router's view will be added to.
   * @return a new [RootRouter].
   */
  fun build(
    context: Context,
    parentViewGroup: ViewGroup
  ): RootRouter {
    val view = createView(parentViewGroup)
    val interactor = RootInteractor()
    val component = DaggerRootBuilder_Component.builder()
      .parentComponent(dependency)
      .view(view)
      .interactor(interactor)
      .provideContext(context)
      .build()
    return component.rootRouter()
  }

  override fun inflateView(
    inflater: LayoutInflater,
    parentViewGroup: ViewGroup
  ): RootView? =
    inflater.inflate(R.layout.root_rib, parentViewGroup, false) as RootView

  interface ParentComponent

  @dagger.Module
  abstract class Module {

    @RootScope
    @Binds
    internal abstract fun presenter(view: RootView): RootPresenter

    @dagger.Module
    companion object {

      @RootScope
      @Provides
      @JvmStatic
      internal fun router(
        component: Component,
        view: RootView,
        interactor: RootInteractor
      ): RootRouter {
        return RootRouter(view, interactor, component)
      }

      @RootScope
      @Provides
      @JvmStatic
      internal fun screenStack(rootView: RootView): ScreenStack {
        return ScreenStack(rootView.viewContent())
      }
    }
  }

  @RootScope
  @dagger.Component(
    modules = arrayOf(Module::class),
    dependencies = arrayOf(ParentComponent::class)
  )
  interface Component : InteractorBaseComponent<RootInteractor>,
    BuilderComponent {

    @dagger.Component.Builder
    interface Builder {

      @BindsInstance
      fun interactor(interactor: RootInteractor): Builder

      @BindsInstance
      fun view(view: RootView): Builder

      fun parentComponent(component: ParentComponent): Builder

      @BindsInstance
      fun provideContext(context: Context): Builder

      fun build(): Component
    }
  }

  interface BuilderComponent {
    fun rootRouter(): RootRouter
  }

  @Scope
  @Retention(BINARY)
  internal annotation class RootScope

  @Qualifier
  @Retention(BINARY)
  internal annotation class RootInternal
}
