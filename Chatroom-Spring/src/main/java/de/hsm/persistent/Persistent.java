package de.hsm.persistent;

import java.util.ArrayList;
import java.util.List;

public class Persistent {

    private List<User> users;

    private static Persistent instance = new Persistent();

    public Persistent() {
        users = new ArrayList<User>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public <T> List<T> executeQuery(Class<T> type, QueryName queryName, Object arg) {
        List<T> result = new ArrayList<>();
        if (type.equals(User.class) && queryName == QueryName.searchUserName) {
            String name = (String) arg;
            for (User User : users) {
                if (User.getUserName().equals(name)) {
                    result.add((T) User);
                }
            }
        }
        return result;
    }

    public <T> T find(Class<T> type, Object key1, Object key2) {
        if (type.equals(User.class)) {
            String username = (String) key1;
            String password = (String) key2;
            for (User user : users) {
                if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                    return (T) user;
                }
            }
        }
        return null;
    }
    
    public Boolean findEmail(String email){
        Boolean result = true;
        
        for (User user : users) {
            if (user.getEmailID().equals(email) ) {
                return false;
            }
        }
        return result;
    }
    
    public static Persistent getInstance() {
        if (instance == null) {
            instance = new Persistent();
        }
        return instance;
    }

    public void persist(Object o) {
        
    }

}
