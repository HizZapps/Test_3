package ua.example.test_3

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ua.example.test_3.databinding.FragBoxBinding
import kotlin.random.Random

class BoxFragment : Fragment(R.layout.frag_box) {

    private lateinit var binding: FragBoxBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragBoxBinding.bind(view)

        val color = requireArguments().getInt(ARG_COLOR)
        binding.root.setBackgroundColor(color)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.generateNumberButton.setOnClickListener {
            val number = Random.nextInt(100)
            parentFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(EXTRA_RANDOM_NUMBER to number))
            findNavController().popBackStack()
        }
        binding.openSecretButton.setOnClickListener {
            findNavController().navigate(R.id.action_boxFragment_to_secretFragment)
        }
    }

    companion object {
        const val ARG_COLOR = "color"
        const val REQUEST_CODE = "RANDOM_NUMBER_CODE"
        const val EXTRA_RANDOM_NUMBER = "EXTRA_RANDOM_NUMBER"
    }
}