package com.yquery.gdscbmicalculator.ui.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yquery.gdscbmicalculator.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.otherAppsButton.setOnClickListener {
            val openMyPlayStoreIntent = Intent(Intent.ACTION_VIEW)
            openMyPlayStoreIntent.data = Uri.parse("https://play.google.com/store/apps/dev?id=6245006738668751785")
            startActivity(openMyPlayStoreIntent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}