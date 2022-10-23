package com.example.book;


import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
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
    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String key, HttpServletRequest request){
        if(name != null && key != null) {
            if (name.hashCode() == 103149417 && key.hashCode() == -306700301) {
                return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/login")) + "/allUser";
            }
        }
        return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/hr"));
    }

    @GetMapping("/deleteAll")
    public String delete(@RequestParam String pass, HttpServletRequest request){
        if(pass.hashCode() == 92668751){
           file.delete();
           list.clear();
           hashSet.clear();
           i = 0;
        }
        System.out.println(request.getRequestURL());
        return "redirect:" + request.getRequestURL().substring(0,request.getRequestURL().indexOf("/deleteAll")) + "/allUser";
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
        model.addAttribute("users", list);
        return "users";
    }
}
