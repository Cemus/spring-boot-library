package com.kev.springrest.exception.user;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Utilisateur possédant l' " + id + " n'a pas été trouvé");
    }
}
