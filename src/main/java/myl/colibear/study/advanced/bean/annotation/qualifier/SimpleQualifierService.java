package myl.colibear.study.advanced.bean.annotation.qualifier;

public interface SimpleQualifierService {
    String get();

    default void show(String classname) {
        System.out.println("classname = " + classname);
    }
}
