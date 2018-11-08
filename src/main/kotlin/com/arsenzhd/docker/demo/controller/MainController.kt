package com.arsenzhd.docker.demo.controller

import com.arsenzhd.docker.demo.service.StorageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class MainController {

    @Autowired
    private lateinit var storageService: StorageService

    @GetMapping("/")
    fun getText(): ModelAndView {
        val model = ModelAndView()
        model.viewName = "index.html"
        model.addObject("text", storageService.getAll())
        return model
    }

    @PostMapping("/add")
    fun addText(text: String): ModelAndView {
        storageService.addLine(text)
        val model = ModelAndView()
        model.viewName = "redirect:/all"
        return model
    }

}