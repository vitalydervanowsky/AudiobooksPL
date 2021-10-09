package by.dzrvnsk.audiobookspl.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.dzrvnsk.audiobookspl.data.Audiobook
import by.dzrvnsk.audiobookspl.databinding.ItemAudiobookBinding
import com.bumptech.glide.Glide

class AudioBookAdapter(
    private val data: List<Audiobook>,
    private val delegate: (Audiobook) -> Unit
) : RecyclerView.Adapter<AudioBookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioBookViewHolder {
        val binding =
            ItemAudiobookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AudioBookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AudioBookViewHolder, position: Int) {
        holder.bind(data[position], delegate)
    }

    override fun getItemCount(): Int = data.size
}

class AudioBookViewHolder(private val binding: ItemAudiobookBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(audiobook: Audiobook, delegate: (Audiobook) -> Unit) {
        binding.apply {
            val coverUrl = "https://wolnelektury.pl/media/" + audiobook.cover_thumb
            Glide.with(itemView)
                .load(coverUrl)
                .into(ivBookCover)
            tvBookTitle.text = audiobook.title
            tvBookAuthor.text = audiobook.author
        }
        itemView.setOnClickListener {
            delegate(audiobook)
        }
    }
}