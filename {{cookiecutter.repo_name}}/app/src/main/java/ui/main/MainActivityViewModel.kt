package {{ cookiecutter.package_name }}.ui.main

import android.content.Context
import {{ cookiecutter.package_name }}.core.BaseViewModel
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val context: Context) : BaseViewModel() {
    
    fun appVersion():String?{
        return BuildConfig.VERSION_NAME
    }
    
}
