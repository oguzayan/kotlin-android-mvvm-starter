package {{ cookiecutter.package_name }}.ui.main

import android.app.Application
import {{ cookiecutter.package_name }}.core.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val context: Context) : BaseViewModel() {
    
}
