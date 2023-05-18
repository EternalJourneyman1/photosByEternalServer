package dev.robinsond.photosbyeternal.photos.images

import com.cloudinary.Cloudinary
import com.cloudinary.api.ApiResponse
import org.springframework.http.CacheControl
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.servlet.view.RedirectView
import java.util.concurrent.TimeUnit

@RestController
@RequestMapping("/images")
class ImageController(private val cloudinary: Cloudinary) {

    @GetMapping("/{id}")
    @CrossOrigin(origins = ["*"])
    fun getImage(@PathVariable id: String): ResponseEntity<ApiResponse> {
        val params: Map<String, Any> = mapOf("public_id" to id)
        val result = cloudinary.api().resource(id, params)
        return ResponseEntity
            .ok()
            .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS)) // Set appropriate cache duration
            .body(result)
    }

    @GetMapping
    @CrossOrigin(origins = ["*"])
    fun getImages(): ResponseEntity<Any> {
        val params: Map<String, Any> = mapOf("max_results" to 500)
        val result = cloudinary.api().resources(params)
        return ResponseEntity
            .ok()
            .cacheControl(CacheControl.maxAge(1, TimeUnit.HOURS))
            .body(result["resources"])
    }

//    @PostMapping("/upload")
    fun upload(
        @RequestParam("file") file: MultipartFile,
        @RequestParam("description") description: String,
        @RequestParam("tags") tags: String
    ): RedirectView {

        println("description: $description")
        println("tags: $tags")
        println("file: ${file.originalFilename}")

        cloudinary.uploader().upload(
            file.bytes, mapOf(
                "description" to description,
                "tags" to tags
            )
        )
        return RedirectView("/index.html")    }
}