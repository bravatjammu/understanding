
package logic;

import de.hsm.persistent.Persistent;
import de.hsm.persistent.User;
import de.hsm.persistent.QueryName;
import java.util.List;

public class UserManager {
    private final Persistent persistent;
    
    public UserManager() {
        persistent = Persistent.getInstance();
    }

    public void registerUser(User user)
    {
        persistent.addUser(user);
        
    }    
    public List<User> searchUser(String username) {
        return persistent.executeQuery(User.class, QueryName.searchUserName, username);
    }
   
    public User loginUser(String userName, String password){
        return persistent.find(User.class, userName, password);
    } 
    
    public Boolean checkEmail(String email){
        return persistent.findEmail(email);
    } 
    
    
    
}
