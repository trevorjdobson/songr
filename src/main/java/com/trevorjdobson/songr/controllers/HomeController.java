package com.trevorjdobson.songr.controllers;


import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    @GetMapping("/")
    public String getRoot(){

        return "helloworld";
    }
    @GetMapping("/capitalize/{word}")
    public String capitalize(@PathVariable String word, Model m){
        String capWord = word.toUpperCase();
        m.addAttribute("word",capWord);

        return "capitalize";
    }
    @GetMapping("/reverse")
    public String reverse(@RequestParam(required=true) String sentence, Model m){
        String reversedSentence = reverseString(sentence);

        m.addAttribute("reversedSentance",reversedSentence);

        return "reversed";
    }
    public String reverseString(String stringToBeReversed){
        String words[]=stringToBeReversed.split("\\s");
        String reversedSentence = "";
        for(int i = words.length-1;i>=0;i--){
            reversedSentence+= words[i] + " ";
        }
        reversedSentence = reversedSentence.substring(0, reversedSentence.length() - 1);
        return reversedSentence;
    }

}
