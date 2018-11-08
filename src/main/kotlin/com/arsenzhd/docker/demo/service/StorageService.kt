package com.arsenzhd.docker.demo.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.util.stream.Collectors

@Service
class StorageService {

    @Value("\${demo.path}")
    var path: String = ""

    fun getAll(): List<String> = Files.lines(Path.of(path)).collect(Collectors.toList())

    fun addLine(l: String) {
        File(path).appendText(l + "\n")
    }

}