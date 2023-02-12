package com.search.csv

import com.opencsv.CSVReader

class ProductService(reader: CSVReader) {

    private val lines = reader.readAll()

    private val products: List<Product> = lines.map {
        Product(it[0], it[1].toInt())
    }

    fun findByName(name: String): List<Product> {
        return products.filter { it.name.lowercase().contains(name.lowercase()) }
    }
}