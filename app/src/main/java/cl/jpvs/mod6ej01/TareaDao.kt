package cl.jpvs.mod6ej01

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDao  {


    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    //Devolvemos una lista de tareas
    @Query("SELECT * FROM tabla_tarea order by id ASC")
    fun obtenerTareas(): LiveData<List<Tarea>> //livedata permite obtener actualizacion

}