/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [Item] from a given data source.
 */
interface ItemsRepository {

    // devuelve todos los items
    fun getAllItemsStream(): Flow<List<Item>>

    // devuelve un item de la db con el id específico
    fun getItemStream(id: Int): Flow<Item?>

    // inserta un item a la db
    suspend fun insertItem(item: Item)

    // elimina item de la db
    suspend fun deleteItem(item: Item)

    // update item de la db
    suspend fun updateItem(item: Item)

}
