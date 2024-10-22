package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// [Item::class] -> Item como la única clase con la lista de entities
@Database(entities = [Item::class], version = 1, exportSchema = false)
abstract class InventoryDatabase : RoomDatabase() {

    // función que muestra el ItemDao
    // para que la db sepa acerca del DAO
    abstract fun itemDao(): ItemDao

    companion object {

        // la variable Instance conserva una referencia a la db cuando se crea una
        @Volatile
        private var Instance: InventoryDatabase? = null

        fun getDatabase(context: Context): InventoryDatabase {
            return Instance ?: synchronized(this) {
                // Obtengo la db
                // Si la instancia no es null, devuelve esto, sino crea una nueva db
                Room.databaseBuilder(
                    context,
                    InventoryDatabase::class.java,
                    "item_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }

}