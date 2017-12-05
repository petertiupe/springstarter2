package de.tiupe.business;

public interface UserRepository {

    public User findByUsername(String username);
    public void save(User aUser);

}
