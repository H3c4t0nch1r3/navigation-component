package mousquetaires.com.navigation4techday.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.second_fragment.*
import mousquetaires.com.navigation4techday.R

class SecondFragment : Fragment(R.layout.second_fragment), View.OnClickListener {
    lateinit var originBundlevalue: String

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_button_second_to_sixth_fragment.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        originBundlevalue = arguments?.getString("origin").toString()
        origin.text = "chemin : ${originBundlevalue}"
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.nav_button_second_to_sixth_fragment -> {
                val bundle = bundleOf("origin" to "${originBundlevalue} second")
                view.findNavController()
                    .navigate(R.id.action_secondFragment_to_sixthFragment, bundle)
            }
        }
    }
}
