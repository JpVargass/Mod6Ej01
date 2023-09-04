package cl.jpvs.mod6ej01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.jpvs.mod6ej01.databinding.FragmentAgregarBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AgregarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AgregarFragment : Fragment() {

    lateinit var binding: FragmentAgregarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(layoutInflater, container, false)
        initListener()
        obtenerListaTareas()
        return binding.root
    }

    private fun initListener() {
        binding.btnAgregarTarea.setOnClickListener {
            val texto = binding.editTextTarea.text.toString()
            guardarTarea(texto)
        }
    }

    private fun guardarTarea(texto: String) {
        val dao = TareaBaseDatos.getDatabase(requireContext()).getTaskDao()
        val tarea = Tarea(texto)
        GlobalScope.launch { dao.insertarTarea(tarea) }

    }

    private fun obtenerListaTareas() {
        val dao = TareaBaseDatos.getDatabase(requireContext()).getTaskDao()
        GlobalScope.launch {
            val tareas = dao.obtenerTareas()
            val tasksAsText = tareas.joinToString("\n") { it.nombre }
            binding.tvLista.text = tasksAsText
        }


    }
}

