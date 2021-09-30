package org.example.user

import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import java.text.MessageFormat

@CompileStatic
@Transactional
@Controller("/users")
class UserController {
    @Get("/")
    def index() {
        User.list()
    }
    @Post("/")
    def save(String firstname, String lastname, String email, String role, String password) {
        def user = new User(firstname: firstname, lastname: lastname, email: email, role: role, password: password)
        if (user.save()) {
            return user
        } else {
            return user.errors.allErrors.collect { MessageFormat.format(it.defaultMessage, it.arguments) }.join(", ")
        }
    }
}
