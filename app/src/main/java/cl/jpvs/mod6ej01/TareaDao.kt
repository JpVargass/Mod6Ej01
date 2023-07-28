package cl.jpvs.mod6ej01

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TareaDAO   {


    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    //Devolvemos una lista de tareas
    @Query ("Select * From tabla_tarea order by id asc" )
    fun obtenerTareas(): List<Tarea>

}