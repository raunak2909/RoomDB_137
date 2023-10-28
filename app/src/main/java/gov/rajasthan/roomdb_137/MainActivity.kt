package gov.rajasthan.roomdb_137

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import gov.rajasthan.roomdb_137.databinding.ActivityMainBinding
import gov.rajasthan.roomdb_137.databinding.AddDialogBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var maViewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //init DB
        val db = MyRoomDatabase.getInstance(this)

        //init repo
        val noteRepository = NoteRepository(db)

        //initializing
        maViewModel = ViewModelProvider(
            this,
            MainActivityViewModelFactory(noteRepository)
        )[MainActivityViewModel::class.java]

        binding.recyclerNotes.layoutManager = LinearLayoutManager(this)

        //fetch all data
        maViewModel.getAllNotes().observe(this){data->
            binding.recyclerNotes.adapter = RecyclerNoteAdapter(this, data as ArrayList<NoteTable>)
        }







        binding.floatingActionButton.setOnClickListener {

            val dialogAdd = Dialog(this)
            val dialogBinding = AddDialogBinding.inflate(layoutInflater)
            dialogAdd.setContentView(dialogBinding.root)

            dialogBinding.btnAdd.setOnClickListener {

                val mTitle = dialogBinding.edtTitle.text.toString()
                val mDesc = dialogBinding.edtDesc.text.toString()

                maViewModel.addNewNote(NoteTable(0, mTitle, mDesc))
                dialogAdd.dismiss()

            }

            dialogBinding.btnCancel.setOnClickListener {
                dialogAdd.dismiss()
            }

            dialogAdd.show()
        }
    }

    fun deleteNote(noteTable: NoteTable){
        maViewModel.deleteNote(noteTable)
    }
}