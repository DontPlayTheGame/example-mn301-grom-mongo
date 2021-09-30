package org.example.user

import grails.gorm.annotation.Entity
import org.bson.types.ObjectId

@Entity
class User {
    ObjectId id
    String firstname
    String lastname
    String email
    String role
    String password
    Date dateCreated
    Date lastUpdated

    static constraints = {
        firstname nullable: false
        lastname nullable: false
        email email: true
        role nullable: true
        password nullable: false
    }
}
