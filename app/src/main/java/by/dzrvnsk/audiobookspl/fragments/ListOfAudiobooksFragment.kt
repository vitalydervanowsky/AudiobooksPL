package by.dzrvnsk.audiobookspl.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.audiobookspl.R
import by.dzrvnsk.audiobookspl.adapter.AudioBookAdapter
import by.dzrvnsk.audiobookspl.databinding.FragmentListOfAudiobooksBinding
import by.dzrvnsk.audiobookspl.model.AudioBookViewModel

class ListOfAudiobooksFragment : Fragment() {

    private var _binding: FragmentListOfAudiobooksBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AudioBookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListOfAudiobooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.audiobooksLiveData.observe(viewLifecycleOwner, {
            binding.rvListOfAudiobooks.adapter = AudioBookAdapter(it) { audiobook ->
                viewModel.setCurrentAudiobook(audiobook)
                parentFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.container, DetailsOfAudiobookFragment())
                    .commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}