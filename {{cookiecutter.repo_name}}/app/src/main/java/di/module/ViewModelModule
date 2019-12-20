package {{ cookiecutter.package_name }}.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import {{ cookiecutter.package_name }}.di.ViewModelFactory
import {{ cookiecutter.package_name }}.di.key.ViewModelKey
import {{ cookiecutter.package_name }}.ui.main.MainActivityViewModel


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun provideMainViewModel(mainActivityViewModel: MainActivityViewModel): ViewModel
    
    }
