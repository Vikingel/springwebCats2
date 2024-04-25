package Vikingel.springwebcats2.services;

import Vikingel.springwebcats2.entities.Cat;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@Service    //аннотация, которая говорит Спрингу, что этот класс является "сервисом" - частным случаем "компонента"
            //благодаря этому аннотация @ComponentScan на уровне конфигурации приложения автоматически
            //создает бин, помещает его в контекст и выполняет инициализацию
public class GetCatsService {
    ArrayList<Cat> cats= new ArrayList<>();


    @PostConstruct  //аннотация, которая говорит Спрингу, что данный метод нужно вызвать для иницализации
    //после создания бина
    public void fill(){
        try {
            cats.add(new Cat(1, "Мурзик", "черный",22));
            cats.add(new Cat(1, "Васька", "рыжий",2));
        }catch (Exception e){
            System.out.println("что-то не так с созданием продуктов");
        }
    }


    public ArrayList<Cat> getAllList() {
        return cats;
    }

    public static ArrayList<Cat> readCats(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(file));
        ArrayList<Cat> cats = new ArrayList<>();
        while (scanner.hasNext()) {
            int id = scanner.nextInt();
            String name = scanner.next();
            String color = scanner.next();
            double age = scanner.nextDouble();
            Cat c = new Cat(id, name, color, age);
            cats.add(c);
        }
        return cats;
    }

    public void addCat(Cat cat){
        cats.add(cat);
    }

    public Cat findByName(String s){
        for (Cat c: cats ) {
            if (c.getName().equals(s))
                return c;
        }
        return null;
    }

    @Override
    public String toString() {
        return "getCatsService{" +
                "cats=" + cats +
                '}';
    }
}
