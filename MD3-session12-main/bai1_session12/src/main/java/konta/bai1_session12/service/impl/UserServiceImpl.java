package konta.bai1_session12.service.impl;

import konta.bai1_session12.dao.impl.UserDAOImpl;
import konta.bai1_session12.entity.User;
import konta.bai1_session12.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        return new UserDAOImpl().findAll();
    }

    @Override
    public User findById(Integer id) {
        return new UserDAOImpl().findById(id);
    }

    @Override
    public boolean add(User user) {
        return new UserDAOImpl().add(user);
    }

    @Override
    public boolean edit(User user) {
        return new UserDAOImpl().edit(user);
    }

    @Override
    public boolean delete(Integer id) {
        return new UserDAOImpl().delete(id);
    }

    @Override
    public List<User> findByName(String name) {
        return new UserDAOImpl().findByName(name);
    }
}
