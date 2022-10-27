package ua.example.test_3

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ua.example.test_3.databinding.FragRootBinding

class RootFragment : Fragment(R.layout.frag_root) {

    private lateinit var binding: FragRootBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragRootBinding.bind(view)

        binding.openYellowButton.setOnClickListener {
            openBox(Color.rgb(255,235,78))
        }

        binding.openGreenButton.setOnClickListener {
            openBox(Color.rgb(115,234,140))
        }

        parentFragmentManager.setFragmentResultListener(BoxFragment.REQUEST_CODE, viewLifecycleOwner){_, data ->
            val randNumber = data.getInt(BoxFragment.EXTRA_RANDOM_NUMBER)
            Toast.makeText(requireContext(), "Випадковий номер $randNumber", Toast.LENGTH_SHORT).show()
        }

    }

    private fun openBox(color: Int){
        findNavController().navigate(R.id.action_rootFragment_to_boxFragment, bundleOf(BoxFragment.ARG_COLOR to color))
    }

}