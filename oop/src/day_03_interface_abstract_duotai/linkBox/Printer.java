package day_03_interface_abstract_duotai.linkBox;

public class Printer {

    public void print(linkBox linkBox,Paper paper){
        System.out.println("使用"+linkBox.getColor()+"墨盒在"+paper.getSize()+"纸张上打印。");
    }

}
