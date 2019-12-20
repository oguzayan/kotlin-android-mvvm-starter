package {{ cookiecutter.package_name }}.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import {{ cookiecutter.package_name }}.di.scope.ActivityScope
import {{ cookiecutter.package_name }}.ui.main.MainActivity
import dagger.android.ContributesAndroidInjector
import {{ cookiecutter.package_name }}.di.scope.ActivityScope
import {{ cookiecutter.package_name }}.ui.main.MainActivity

@Module
abstract class ActivityModule {

    @ActivityScope
    @ContributesAndroidInjector
    internal abstract fun mainActivity(): MainActivity
    
    }
