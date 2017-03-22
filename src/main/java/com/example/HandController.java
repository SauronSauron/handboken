package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-03-21.
 */

@Controller
public class HandController {

//    @Autowired
//    private dbconnect dbconnecthand;

//    @PostMapping("/")
//    public ModelAndView login2(@RequestParam (required=false) String userid, @RequestParam (required=false) String password, HttpSession session) {
//
//        if(userid.equals("test") && password.equals("pass")) {
//
//            session.setAttribute("user", userid);
//            return new ModelAndView("secret");
//
//        }
//
//        return new ModelAndView("login");
//
//    }
//
//
//
//    @GetMapping("/secret")
//    public ModelAndView secret(HttpSession session) {
//
//        if(session.getAttribute("user") != null) {
//
//            return new ModelAndView("secret");
//
//        }
//
//        else {
//
//            return new ModelAndView("login");
//
//        }
//
//    }

    @GetMapping("/")
    public ModelAndView index(){



        ModelAndView modelmodel = new ModelAndView("index");
        return modelmodel;
    }

    @GetMapping("/larare")
    public ModelAndView larare() throws Exception {
        String w = "Remove";
        ModelAndView modelmodel = new ModelAndView("index");
        return modelmodel.addObject("knappen", w);
    }

    @GetMapping("/test")
    public ModelAndView index2() throws Exception {
        ModelAndView modelmodel = new ModelAndView("index");
        return modelmodel;
    }

    Hand handObject = new Hand();
    int counter = 0;
    @MessageMapping("/hello")
    @SendTo("/topic/message/room")
    public Hand hand(HandMessage message) throws Exception {
        //dbconnecthand.addHand(message);
        if (message.getName().equals("hej")){
            counter++;
            String snothing = "";
            handObject.addContent(snothing);
            return handObject;
        } else {
        String s = message.getName();
        s = s + "<button class=\"removeBtn\" id=\"btn" + counter + "\" onclick=\"getParent(this)\">Remove</button></td></tr>'";
        counter++;
        handObject.addContent(s);


        return handObject;}
    }

    @MessageMapping("/delete")
    @SendTo("/topic/message/room")
    public Hand handDelete(HandMessage message) throws Exception {
        int away = Integer.parseInt(message.getName().substring(3));
        System.out.println("värde " + handObject.getContent().get(away));
        System.out.println("tabort " + away);

        handObject.getContent().set(away, "");



        return handObject;
    }

}
