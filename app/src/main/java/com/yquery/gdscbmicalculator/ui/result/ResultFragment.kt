package com.yquery.gdscbmicalculator.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yquery.gdscbmicalculator.Extensions.Companion.shorten
import com.yquery.gdscbmicalculator.R
import com.yquery.gdscbmicalculator.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    val args: ResultFragmentArgs by navArgs()

    private var _binding: FragmentResultBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val result = args.result

        if (result.isBlank()) {
            binding.resultTextview.text = getString(R.string.enter_data_first)
        } else {
            val resultValue = result.toFloat().shorten(1)

            if (resultValue < 18.5) {
                resultTextview(resultValue, "Underweight")
            }else if(resultValue >= 18.5 && resultValue < 24.9){
                resultTextview(resultValue, "Normal weight")
            }else if (resultValue >= 24.9 && resultValue < 29.9){
                resultTextview(resultValue, "Overweight")
            }else if (resultValue >= 29.9){
                resultTextview(resultValue, "Obese")
            }

        }

        binding.newButton.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_result_to_navigation_input)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun resultTextview(value: Float, state : String){
        binding.resultTextview.text = "Your BMI is : ${value}\n\n${state}"
    }

}