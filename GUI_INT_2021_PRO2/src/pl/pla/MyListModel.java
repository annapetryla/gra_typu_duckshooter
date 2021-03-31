package pl.pla;

import javax.swing.*;
import java.util.ArrayList;

public class MyListModel extends AbstractListModel {

    public ArrayList<User> users;
    public MyListModel(ArrayList<User> users) {

        this.users = users;
    }
    @Override
    public int getSize() {

        return users.size();
    }

    @Override
    public Object getElementAt(int index) {

        return users.get(index);
    }

}
