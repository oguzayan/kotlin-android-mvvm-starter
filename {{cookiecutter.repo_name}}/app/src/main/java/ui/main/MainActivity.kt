package {{ cookiecutter.package_name }}.ui.main

import {{ cookiecutter.package_name }}.R
import {{ cookiecutter.package_name }}.core.BaseActivity
import {{ cookiecutter.package_name }}.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainActivityViewModel>(
    R.layout.activity_main,
    MainActivityViewModel::class.java
)
