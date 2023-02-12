package com.search.csv

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping("/product")
    fun search(@RequestParam("name") name: String): List<Product> {
        return productService.findByName(name)
    }
}