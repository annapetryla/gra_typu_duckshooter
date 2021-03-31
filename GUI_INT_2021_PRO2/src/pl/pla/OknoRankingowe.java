package pl.pla;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class OknoRankingowe extends JFrame {

    public OknoRankingowe() throws IOException {
        generateFrame();
    }
    public void generateFrame() throws IOException {

        ArrayList<User> daneGraczy = new ArrayList<>();
        readFile("wyniki.txt",daneGraczy);
        Collections.sort(daneGraczy);
        MyListModel myListModel = new MyListModel(daneGraczy);
        JList jList = new JList(myListModel);
        jList.setModel(myListModel);

        JScrollPane jScrollPane = new JScrollPane(jList);
        JPanel jPanel = new JPanel(new GridLayout(1,2));

        setLayout(new BorderLayout());
        add(jScrollPane,BorderLayout.CENTER);
        add(jPanel,BorderLayout.PAGE_END);

        setSize(200,300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void readFile(String path,ArrayList<User> listaUsers) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String input =  reader.readLine();
        while(input != null){
            String imie = input.split(" ")[0];
            int wynik = Integer.parseInt(input.split(" ")[1]);
            listaUsers.add(new User(imie,wynik));
            input = reader.readLine();
        }
        reader.close();
    }
}

