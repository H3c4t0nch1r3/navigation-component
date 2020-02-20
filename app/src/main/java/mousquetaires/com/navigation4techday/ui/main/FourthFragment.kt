package mousquetaires.com.navigation4techday.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fourth_fragment.*
import mousquetaires.com.navigation4techday.R

class FourthFragment : Fragment(R.layout.fourth_fragment), View.OnClickListener {

    lateinit var originBundlevalue: String

    companion object {
        fun newInstance() = FourthFragment()
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
            R.id.nav_button_fourth_to_fifth_fragment -> {
                val bundle = bundleOf("origin" to "${originBundlevalue} fourth")
                view.findNavController()
                    .navigate(R.id.action_fourthFragment_to_fifthFragment, bundle)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_button_fourth_to_fifth_fragment.setOnClickListener(this)
    }
}
