package app.service;

import app.dao.RoleDao;
//import app.dao.RoleDaoImpl;
import app.dao.UserDao;
import app.models.Role;
import app.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Transactional
    @Override
    public void createAndUpdate(User user) {
        Set<Role> set = new HashSet<>();
        if (user.isIsadmin()) {
            Role roleAdmin = roleDao.findByRole("ADMIN");
            set.add(roleAdmin);
        }
        if (user.isIsuser()){
            Role roleUser = roleDao.findByRole("USER");
            set.add(roleUser);
        }
        user.setRoles(set);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        List<User>list=userDao.findAll();
        Collections.sort(list);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) {
        userDao.deleteById(id);
    }

    @Transactional
    @Override
    public User findUserById(long id) {
        return userDao.findById(id).get();
    }

    @Transactional
    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }
}
