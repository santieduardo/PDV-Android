package eduardosanti.com.br.pdv.dao;

import java.util.ArrayList;

import eduardosanti.com.br.pdv.model.User;

public interface UserDAO {
    public void create(User user);
    public void delete(User user);
    public void update(User user);
    public ArrayList<User> findAll();
    public User findById(int id);

}
