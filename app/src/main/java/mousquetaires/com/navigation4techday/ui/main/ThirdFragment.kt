package mousquetaires.com.navigation4techday.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.third_fragment.*
import mousquetaires.com.navigation4techday.R

class ThirdFragment : Fragment(R.layout.third_fragment), View.OnClickListener {

    lateinit var originBundlevalue: String

    companion object {
        fun newInstance() = ThirdFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        originBundlevalue = arguments?.getString("origin").toString()
        origin.text = "chemin : ${originBundlevalue}"
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.nav_button_third_to_sixth_fragment -> {
                val bundle = bundleOf("origin" to "${originBundlevalue} third")
                view.findNavController()
                    .navigate(R.id.action_thirdFragment_to_sixthFragment, bundle)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_button_third_to_sixth_fragment.setOnClickListener(this)
    }

}
