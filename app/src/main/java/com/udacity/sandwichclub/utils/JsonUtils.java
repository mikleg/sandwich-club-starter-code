package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class JsonUtils {

    public static Sandwich parseSandwichJson2(String json)
    {
        //some fake data
        List<String> alsoKnownAs = Arrays.asList("name1", "name2", "name3");
        String image = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Shawarmafood.jpg/800px-Shawarmafood.jpg";
        List<String> ingredients = Arrays.asList("ing1", "ing2");
        String description ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eu lectus posuere, facilisis lectus vitae, viverra mi. Ut lacinia nec ligula et varius. Ut sed nunc et lacus vestibulum finibus. Duis vitae posuere elit. Curabitur consequat erat non nibh volutpat, eu consectetur augue gravida. Curabitur at accumsan dolor, eu ultricies lorem. Maecenas varius varius odio nec interdum. Vivamus nibh tellus, varius vel neque quis, mollis tristique velit. Maecenas sit amet nisi id augue pulvinar imperdiet et non nibh. Curabitur fermentum, dui ac pretium maximus, sapien urna fringilla nulla, sit amet laoreet mauris orci eu velit. Aliquam gravida lacus in turpis pretium malesuada. Curabitur ligula est, suscipit aliquam metus vitae, lacinia interdum neque. Integer augue velit, lacinia non rhoncus in, iaculis accumsan lorem. Donec massa enim, rhoncus convallis suscipit quis, pretium sit amet arcu.\n" +
                "\n" +
                "Vivamus accumsan facilisis libero. Vivamus blandit malesuada tellus, id porttitor eros ultrices in. Praesent non varius felis. Ut orci nunc, sollicitudin non elit id, eleifend lobortis ligula. Quisque vel gravida metus, sit amet mollis sem. Maecenas ultrices euismod volutpat. Sed vitae sem dolor. Morbi cursus placerat pulvinar.\n" +
                "\n" +
                "Aenean ut orci aliquet, varius urna nec, lacinia arcu. Integer hendrerit, neque eget volutpat tincidunt, ante justo faucibus justo, non feugiat diam nulla pellentesque libero. Nunc fermentum turpis sed quam interdum, at molestie lorem vulputate. Nunc euismod tincidunt ullamcorper. Cras interdum tristique pharetra. Nulla scelerisque odio a gravida placerat. Ut luctus dui non tortor malesuada rhoncus. Maecenas venenatis ipsum a elit iaculis, eget scelerisque nunc blandit.\n" +
                "\n" +
                "Quisque ut diam eget orci venenatis ullamcorper iaculis nec eros. Cras at varius quam, eu commodo sapien. Proin id imperdiet ipsum, ornare elementum tellus. Quisque fringilla erat a laoreet tempor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras posuere imperdiet neque eget gravida. Nunc placerat nulla eu nisi ultrices, a malesuada mauris consectetur. Aliquam ac nulla maximus, commodo justo eget, finibus neque. Quisque vehicula efficitur facilisis. Praesent faucibus rutrum massa ac molestie. Mauris dictum ut enim semper tempor. Mauris vitae turpis tempor, volutpat nisi at, malesuada augue. Duis vel laoreet metus. Proin et metus ac justo elementum vestibulum sollicitudin at felis.\n" +
                "\n" +
                "Vestibulum tempus porta dignissim. Donec eget quam turpis. Curabitur nec blandit massa, vitae placerat libero. Aliquam ut dolor nec libero lacinia porttitor. Nunc pulvinar suscipit nulla, sit amet mattis lacus porttitor id. Praesent a pretium tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla ut semper lacus. Duis posuere tempus augue. Sed hendrerit erat nec urna egestas, eu iaculis leo dignissim. Suspendisse id ligula sit amet lectus pulvinar placerat ac a elit. Integer leo est, faucibus et maximus id, tincidunt vel mauris. Nunc euismod gravida justo quis scelerisque. Curabitur sapien nulla, tincidunt sit amet mattis id, vulputate vitae sapien.";
        Sandwich sandwich = new Sandwich("test snwch", alsoKnownAs, "USA", description, image, ingredients);

        return sandwich;
    }
    //it returns value of given property
    private static String getValue(String json, String name)
    {
        int descriptIx = json.indexOf(name)+name.length()+3;
        int comma1 = json.substring(descriptIx).indexOf("\",\"") + descriptIx;
        return json.substring(descriptIx, comma1);
    }
    //it returns a list of values of given property
    private static List<String> getValueList(String json, String name)
    {
        int descriptIx = json.indexOf(name)+name.length()+3;
        int comma1 = json.substring(descriptIx).indexOf("]") + descriptIx;
        List<String> result = Arrays.asList(json.substring(descriptIx, comma1).replaceAll("\"","").split(","));
        return result;
    }


    public static Sandwich parseSandwichJson(String json)
    {
        String description = getValue(json, "description");
        String place = getValue(json, "placeOfOrigin");
        String mainName = getValue(json, "mainName");
        String image = getValue(json, "image");
        List<String> otherName = getValueList(json, "alsoKnownAs");
        List<String> ingredient = getValueList(json, "ingredients");

        /*String description ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis eu lectus posuere, facilisis lectus vitae, viverra mi. Ut lacinia nec ligula et varius. Ut sed nunc et lacus vestibulum finibus. Duis vitae posuere elit. Curabitur consequat erat non nibh volutpat, eu consectetur augue gravida. Curabitur at accumsan dolor, eu ultricies lorem. Maecenas varius varius odio nec interdum. Vivamus nibh tellus, varius vel neque quis, mollis tristique velit. Maecenas sit amet nisi id augue pulvinar imperdiet et non nibh. Curabitur fermentum, dui ac pretium maximus, sapien urna fringilla nulla, sit amet laoreet mauris orci eu velit. Aliquam gravida lacus in turpis pretium malesuada. Curabitur ligula est, suscipit aliquam metus vitae, lacinia interdum neque. Integer augue velit, lacinia non rhoncus in, iaculis accumsan lorem. Donec massa enim, rhoncus convallis suscipit quis, pretium sit amet arcu.\n" +
                "\n" +
                "Vivamus accumsan facilisis libero. Vivamus blandit malesuada tellus, id porttitor eros ultrices in. Praesent non varius felis. Ut orci nunc, sollicitudin non elit id, eleifend lobortis ligula. Quisque vel gravida metus, sit amet mollis sem. Maecenas ultrices euismod volutpat. Sed vitae sem dolor. Morbi cursus placerat pulvinar.\n" +
                "\n" +
                "Aenean ut orci aliquet, varius urna nec, lacinia arcu. Integer hendrerit, neque eget volutpat tincidunt, ante justo faucibus justo, non feugiat diam nulla pellentesque libero. Nunc fermentum turpis sed quam interdum, at molestie lorem vulputate. Nunc euismod tincidunt ullamcorper. Cras interdum tristique pharetra. Nulla scelerisque odio a gravida placerat. Ut luctus dui non tortor malesuada rhoncus. Maecenas venenatis ipsum a elit iaculis, eget scelerisque nunc blandit.\n" +
                "\n" +
                "Quisque ut diam eget orci venenatis ullamcorper iaculis nec eros. Cras at varius quam, eu commodo sapien. Proin id imperdiet ipsum, ornare elementum tellus. Quisque fringilla erat a laoreet tempor. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Cras posuere imperdiet neque eget gravida. Nunc placerat nulla eu nisi ultrices, a malesuada mauris consectetur. Aliquam ac nulla maximus, commodo justo eget, finibus neque. Quisque vehicula efficitur facilisis. Praesent faucibus rutrum massa ac molestie. Mauris dictum ut enim semper tempor. Mauris vitae turpis tempor, volutpat nisi at, malesuada augue. Duis vel laoreet metus. Proin et metus ac justo elementum vestibulum sollicitudin at felis.\n" +
                "\n" +
                "Vestibulum tempus porta dignissim. Donec eget quam turpis. Curabitur nec blandit massa, vitae placerat libero. Aliquam ut dolor nec libero lacinia porttitor. Nunc pulvinar suscipit nulla, sit amet mattis lacus porttitor id. Praesent a pretium tortor. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Nulla ut semper lacus. Duis posuere tempus augue. Sed hendrerit erat nec urna egestas, eu iaculis leo dignissim. Suspendisse id ligula sit amet lectus pulvinar placerat ac a elit. Integer leo est, faucibus et maximus id, tincidunt vel mauris. Nunc euismod gravida justo quis scelerisque. Curabitur sapien nulla, tincidunt sit amet mattis id, vulputate vitae sapien.";
*/        Sandwich sandwich = new Sandwich(mainName,  otherName, place, description, image, ingredient);

        return sandwich;
    }
}
