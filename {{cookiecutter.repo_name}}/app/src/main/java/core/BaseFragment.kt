package {{ cookiecutter.package_name }}.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import {{ cookiecutter.package_name }}.BR

abstract class BaseFragment<B : ViewDataBinding, V : BaseViewModel>(
    @LayoutRes val layout: Int, viewModelClass: Class<V>
) : Fragment() {

    lateinit var binding: B

    private val viewModel by lazy {
        ViewModelProvider(this, (activity as? BaseActivity<*, *>)?.viewModelProviderFactory as ViewModelProvider.Factory)
            .get(viewModelClass)
    }

    private fun init(inflater: LayoutInflater, container: ViewGroup?) {
        binding = DataBindingUtil.inflate(inflater, layout, container, false)
        binding.setVariable(BR.viewModel, viewModel)
    }

    abstract fun init()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        init(inflater, container)
        super.onCreateView(inflater, container, savedInstanceState)
        init()
        return binding.root
    }
}
