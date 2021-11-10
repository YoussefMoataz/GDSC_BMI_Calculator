package com.yquery.gdscbmicalculator.ui.input

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yquery.gdscbmicalculator.R
import com.yquery.gdscbmicalculator.databinding.FragmentInputBinding

class InputFragment : Fragment() {


    private var _binding: FragmentInputBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var result : String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentInputBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.calculateButton.setOnClickListener {

            getResult()

            if (result.isNotBlank()) {
                findNavController().navigate(InputFragmentDirections.actionNavigationInputToNavigationResult(result))
            }else{
                Toast.makeText(activity, getString(R.string.empty_inputs), Toast.LENGTH_SHORT).show()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getResult() {

        val heightInput = binding.heightInput.text.toString()
        val weightInput = binding.weightInput.text.toString()

        if (heightInput.isNotBlank() && weightInput.isNotBlank()) {
            val height = heightInput.toFloat()
            val weight = weightInput.toFloat()

            result = (weight / (height * height / 10000)).toString()
        }

    }

}