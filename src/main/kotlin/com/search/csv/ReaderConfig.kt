package com.search.csv

import com.opencsv.CSVParserBuilder
import com.opencsv.CSVReader
import com.opencsv.CSVReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.StringReader

@Configuration
class ReaderConfig {

    @Bean
    fun reader(): CSVReader {
        val parser = CSVParserBuilder().withSeparator(';').withQuoteChar('"').build()
        val contents = ReaderConfig::class.java.getResource("/products.csv").readText()
        val reader = CSVReaderBuilder(StringReader(contents)).withSkipLines(1).withCSVParser(parser).build()
        return reader
    }

    @Bean
    fun productService(reader: CSVReader): ProductService {
        return ProductService(reader)
    }
}