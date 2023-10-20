package gov.rajasthan.roomdb_137

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gov.rajasthan.roomdb_137.databinding.NoteRowBinding

class RecyclerNoteAdapter(val context: Context, val arrNotes: ArrayList<NoteTable>)
    : RecyclerView.Adapter<RecyclerNoteAdapter.ViewHolder>(){
    class ViewHolder(val binding: NoteRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NoteRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrNotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.txtTitle.text = "${arrNotes[position].id} ${arrNotes[position].title}"
        holder.binding.txtDesc.text = arrNotes[position].desc
    }
}