package ua.example.test_3

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ua.example.test_3.databinding.FragSecretBinding

class SecretFragment : Fragment(R.layout.frag_secret) {

    private lateinit var binding: FragSecretBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragSecretBinding.bind(view)

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.goHomeButton.setOnClickListener {
            findNavController().popBackStack(R.id.rootFragment, false)
        }
    }

}