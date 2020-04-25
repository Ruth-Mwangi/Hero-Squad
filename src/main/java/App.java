import models.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");
        Hero hero1 =new Hero("Absorbing Man",30,"Absorbing ","Can Absorb evil thought",20,60);
        Hero hero2 =new Hero("A-Bomb",30,"Throw bombs for long distances ","Water ",20,60);
        Hero hero3 =new Hero("Mike",30,"can talk with animals ","pretty girls",20,60);
        Hero hero4 =new Hero("Stretch",30,"Stretching ","Temparature above 40 degrees",20,60);
        Hero hero5 =new Hero("Poison Ivy",30,"Vast knowledge in plants ","Emotional",20,60);
        //start session
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("username", request.session().attribute("username"));

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/welcome", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String inputtedUsername = request.queryParams("username");
            request.session().attribute("username", inputtedUsername);
            model.put("username", inputtedUsername);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //hero form
        get("/create/hero",(request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "hero-form.hbs");

        },new HandlebarsTemplateEngine());

        post("/heroes/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();

            String name = request.queryParams("name");
            int age=Integer.parseInt(request.queryParams("age"));
            String powers=request.queryParams("powers");
            String weakness=request.queryParams("weakness");
            int defence=Integer.parseInt(request.queryParams("defence"));
            int attack = Integer.parseInt(request.queryParams("attack"));
            Hero newHero = new Hero(name,age,powers,weakness,defence,attack);
            model.put("heroes", newHero);
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/hero", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes", heroes);

            return new ModelAndView(model, "hero-view.hbs");
        }, new HandlebarsTemplateEngine());


        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfHeroToFind = Integer.parseInt(request.params(":id")); //pull id - must match route segment
             Hero foundHero = Hero.findById(idOfHeroToFind); //use it to find post
            model.put("hero", foundHero); //add it to model for template to display
            ArrayList<Hero> heroes = Hero.getHeroes();
            model.put("heroes", heroes);
            return new ModelAndView(model, "hero-view.hbs"); //individual post page.
        }, new HandlebarsTemplateEngine());






    }
}
