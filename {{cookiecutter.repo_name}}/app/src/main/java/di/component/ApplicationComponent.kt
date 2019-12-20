package {{ cookiecutter.package_name }}.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import {{ cookiecutter.package_name }}.App
import {{ cookiecutter.package_name }}.di.module.*
{% endif %}
import javax.inject.Singleton


@Singleton
{% if cookiecutter.retrofit == "y" %}
@Component(modules = [ApplicationModule::class,
                      AndroidInjectionModule::class,
                      NetModule::class,
                      DatabaseModule::class,
                      ActivityModule::class,
                      ViewModelModule::class]
{% endif %}
{% if cookiecutter.retrofit == "n" %}
@Component(modules = [ApplicationModule::class,
                      AndroidInjectionModule::class,
                      DatabaseModule::class,
                      ActivityModule::class,
                      ViewModelModule::class]
{% endif %}
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationBind(application: Application): Builder

        fun build(): ApplicationComponent
    }

}
