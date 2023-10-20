package gov.rajasthan.roomdb_137

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import gov.rajasthan.roomdb_137.databinding.ActivityMainBinding
import gov.rajasthan.roomdb_137.databinding.AddDialogBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db = MyRoomDatabase.getInstance(this)



        val arrNotes = db.NoteDao().getAllNotes()


        binding.recyclerNotes.layoutManager = LinearLayoutManager(this)
        binding.recyclerNotes.adapter = RecyclerNoteAdapter(this, arrNotes as ArrayList<NoteTable>)

        binding.floatingActionButton.setOnClickListener{

            val dialogAdd = Dialog(this)
            val dialogBinding = AddDialogBinding.inflate(layoutInflater)
            dialogAdd.setContentView(dialogBinding.root)

            dialogBinding.btnAdd.setOnClickListener {

                val mTitle = dialogBinding.edtTitle.text.toString()
                val mDesc =  dialogBinding.edtDesc.text.toString()

                db.NoteDao().addNote(NoteTable(0, mTitle, mDesc))

                //to get the updated notes
                val arrNotes = db.NoteDao().getAllNotes()
                binding.recyclerNotes.adapter = RecyclerNoteAdapter(this, arrNotes as ArrayList<NoteTable>)
                dialogAdd.dismiss()

            }

            dialogBinding.btnCancel.setOnClickListener {
                dialogAdd.dismiss()
            }

            dialogAdd.show()
        }
    }
}