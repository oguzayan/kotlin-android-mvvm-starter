package {{ cookiecutter.package_name }}

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import {{ cookiecutter.package_name }}.di.component.DaggerApplicationComponent
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = activityInjector 
        

    override fun onCreate() {
        super.onCreate()

        DaggerApplicationComponent.builder()
            .applicationBind(this)
            .build()
            .inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        } else {
            //TODO : Add crashlytics
        }
    }
}

