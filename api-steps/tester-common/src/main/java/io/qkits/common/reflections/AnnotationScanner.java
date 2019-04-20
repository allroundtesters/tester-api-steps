//package io.qkits.common.reflections;
//
//import dorkbox.annotation.AnnotationDetector;
//
//public class AnnotationScanner {
//
//    public static void main(String[] args) {
////        try {
////            // Get a list of all classes annotated with @Module, inside the "dorkbox.client" and "dorkbox.common" packages.
////            List<Module> classModules = AnnotationDetector.scanClassPath("dorkbox.client", "dorkbox.common")
////                    .forAnnotations(Module.class)  // one or more annotations
////                    .on(ElementType.METHOD) // optional, default ElementType.TYPE. One ore more element types
////                    .filter((File dir, String name) -> !name.endsWith("Client.class")) // optional, default all *.class files
////                    .collect(AnnotationDefaults.getType);
////        } catch (IOException e) {
////            throw new IllegalArgumentException("Unable to start the client", e);
////        }
//    }
//}
