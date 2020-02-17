package vn.nlu.fit.utils;

public interface ObjectDAO {

    boolean addUser(Object obj);

    boolean editUser(Object obj);

    boolean removeUser(int id);

    boolean checkUser(String username, String password);

}
