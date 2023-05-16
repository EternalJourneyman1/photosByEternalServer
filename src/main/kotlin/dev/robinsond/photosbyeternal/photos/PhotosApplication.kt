package dev.robinsond.photosbyeternal.photos

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PhotosApplication

fun main(args: Array<String>) {

	runApplication<PhotosApplication>(*args)
}
