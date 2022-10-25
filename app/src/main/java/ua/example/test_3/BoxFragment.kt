package ua.example.test_3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import ua.example.test_3.databinding.FragBoxBinding

class BoxFragment : Fragment(R.layout.frag_box) {

    private lateinit var binding: FragBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragBoxBinding.bind(view)

        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(color)
    }

    companion object {
        const val ARG_COLOR = "color"
    }
}