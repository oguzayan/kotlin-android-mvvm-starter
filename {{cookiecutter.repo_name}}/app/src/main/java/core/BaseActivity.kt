package {{ cookiecutter.package_name }}.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import {{ cookiecutter.package_name }}.BR
import javax.inject.Inject

abstract class BaseActivity<B : ViewDataBinding, V : BaseViewModel>(
    @LayoutRes val layout: Int, viewModelClass: Class<V>
) : AppCompatActivity() {

    @Inject
    internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    val binding: B by lazy {
        DataBindingUtil.setContentView(this, layout) as B
    }

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelProviderFactory).get(viewModelClass)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, viewModel)
    }
}
