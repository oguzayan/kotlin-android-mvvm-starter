package {{ cookiecutter.package_name }}.core

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup
import {{ cookiecutter.package_name }}.R

abstract class BaseAdapter<T>(callback: DiffUtil.ItemCallback<T>) : ListAdapter<T, BaseViewHolder<ViewDataBinding>>(callback) {

   override fun onBindViewHolder(holder: BaseViewHolder<ViewDataBinding>, position: Int) {
        bind(holder.binding, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ViewDataBinding> {
        return getViewHolder(parent, viewType)
    }

    open fun getViewHolder(parent: ViewGroup, viewType: Int) = BaseViewHolder(createBinding(parent, viewType))

    abstract fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding
    protected abstract fun bind(binding: ViewDataBinding, position: Int)
}
