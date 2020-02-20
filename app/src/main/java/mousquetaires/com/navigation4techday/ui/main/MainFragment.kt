package mousquetaires.com.navigation4techday.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.main_fragment.*
import mousquetaires.com.navigation4techday.R

class MainFragment : Fragment(R.layout.main_fragment), View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav_button_first_to_second_fragment.setOnClickListener(this)
        nav_button_first_to_third_fragment.setOnClickListener(this)
        nav_button_first_to_fourth_fragment.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.nav_button_first_to_second_fragment -> {
                val bundle = bundleOf("origin" to "main")
                view.findNavController()
                    .navigate(R.id.action_mainFragment_to_secondFragment, bundle)
            }
            R.id.nav_button_first_to_third_fragment -> {
                val bundle = bundleOf("origin" to "main")
                view.findNavController().navigate(R.id.action_mainFragment_to_thirdFragment, bundle)
            }
            R.id.nav_button_first_to_fourth_fragment -> {
                val bundle = bundleOf("origin" to "main")
                view.findNavController()
                    .navigate(R.id.action_mainFragment_to_fourthFragment, bundle)
            }
        }
    }
}
