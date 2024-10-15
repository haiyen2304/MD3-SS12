package konta.tt.service.impl;

import konta.tt.dao.impl.UserDAOImplement;
import konta.tt.entity.User;
import konta.tt.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return new UserDAOImplement().findAll();
    }

    @Override
    public User findById(Integer id) {
        return new UserDAOImplement().findById(id);
    }

    @Override
    public boolean add(User user) {
        return new UserDAOImplement().add(user);
    }

    @Override
    public boolean edit(User user) {
        return new UserDAOImplement().edit(user);
    }

    @Override
    public boolean delete(Integer id) {
        return new UserDAOImplement().delete(id);
    }

    @Override
    public List<User> findByName(String name) {
        return new UserDAOImplement().findByName(name);
    }
}
