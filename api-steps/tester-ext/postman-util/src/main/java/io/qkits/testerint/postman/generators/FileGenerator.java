///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package io.qkits.testerint.postman.generators;
//
//
//
//
//
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public class FileGenerator {
//
//    public void createFile(Collection col) {
//        try {
//            PrintStream out = new PrintStream(new FileOutputStream("C:\\Your\\Path\\ForHome\\EXPORTED.md"));
//            out.println("# " + col.getInfo().getName());
//
//            out.println("## " + col.getInfo().getDescription());
//            out.println("----");
//            for (Item it : col.getItem()) {
//                out.println("### **`" + it.getRequest().getMethod() + "`** : `" + it.getItemName() + "`");
//                out.println("#### " + it.getRequest().getDescription());
//                out.println("* **URL Params**\n");
//                out.println("  * **Required**\n");
//                for (Query q : it.getRequest().getUrl().getQuery()) {
//                    if (!q.isDisabled()) {
//                        out.println("    * `" + q.getKey() + "`" + "\n");
//                    }
//                }
//                out.println("\n");
//                out.println("  * **Optional**\n");
//                for (Query q : it.getRequest().getUrl().getQuery()) {
//                    if (q.isDisabled()) {
//                        out.println("    * `" + q.getKey() + "`" + "\n");
//                    }
//                }
//                out.println("*Example:*\n");
//                out.println("```shell");
//                out.println(it.getRequest().getUrl().getRaw());
//                out.println("```");
//                out.println("----");
//
//            }
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(FileGenerator.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
