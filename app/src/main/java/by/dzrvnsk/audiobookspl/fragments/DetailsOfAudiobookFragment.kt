package by.dzrvnsk.audiobookspl.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import by.dzrvnsk.audiobookspl.databinding.FragmentDetailsOfAudiobookBinding
import by.dzrvnsk.audiobookspl.model.AudioBookViewModel
import com.bumptech.glide.Glide

class DetailsOfAudiobookFragment : Fragment() {

    private var _binding: FragmentDetailsOfAudiobookBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AudioBookViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsOfAudiobookBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            viewModel.currentAudioBook.observe(viewLifecycleOwner, {
                val coverUrl = "https://wolnelektury.pl/media/" + it.cover
                Glide.with(requireContext())
                    .load(coverUrl)
                    .into(ivBookCover)
                tvBookAuthor.text = it.author
                tvBookTitle.text = it.title
                tvBookKind.text = it.kind
                tvBookGenre.text = it.genre
            })
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}