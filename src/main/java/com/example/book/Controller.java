package com.example.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.CharBuffer;
import java.util.*;

@org.springframework.stereotype.Controller
@RequestMapping("/hr")
public class Controller {
    static List<User> list = new ArrayList<>();
    private static File file = new File("file.txt");
    private int i = 0;
    private static HashSet<String> hashSet = new HashSet();


    public static void init(){
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                String[] temp = scanner.nextLine().split("\\|");
                if(hashSet.add(temp[0]))
                    list.add(new User(temp));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @GetMapping("/deleteAll")
    public void delete(@RequestParam String pass){
        if(pass.equals("123")){
            System.out.println(file.delete());
            list.clear();

        }

    }


    @GetMapping("/addUser")
    public void add(@RequestParam String pr1){
        addUser(pr1.split("\\|"));
    }


    public void addUser(String[] parameters){
        try {
            FileWriter fw = new FileWriter(file,true);
            if(!hashSet.add(parameters[0])){
                return;
            }
            for(int i = 0; i < parameters.length;i++){
                fw.write(parameters[i]+"|");
            }
            list.add(new User(parameters));
            fw.write("\n");
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @GetMapping("/allUser")
    public String show(Model model){
        model.addAttribute("users",list);
        return "users";
    }
}
