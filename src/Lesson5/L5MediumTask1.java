package Lesson5;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L5MediumTask1 {
    private static java.util.stream.Collectors Collectors;

    public static void main(String[] args) throws URISyntaxException {

        URI filesPath = L5MediumTask1.class.getClassLoader().getResource("").toURI();
        File fileDir = new File(filesPath);
        File[] filesList = fileDir.listFiles();
        HashMap<String, Shop> hArrayShops = new HashMap<String, Shop>();
        for (File currentFile : filesList) {
            String fileName = currentFile.getName();
            Pattern pFileName = Pattern.compile("[.]+txt");
            Matcher resFileName = pFileName.matcher(fileName);//.toString();
            if (!resFileName.find()) {
                continue;
            }
            String[] elementsDate = fileName.split("_");
            Months currentMonth = Months.getNameByCode(Integer.valueOf(elementsDate[1]));
            try {
                Object[] arrayResult = Files.lines(Paths.get(currentFile.toURI()), StandardCharsets.UTF_8).skip(1).toArray();//.map(x -> Arrays.stream(x.split(";"))).toArray(); массив массивов не вариант

                for (int i = 0; i < arrayResult.length; i++) {

                    String[] stringShop = arrayResult[i].toString().split(";");
                    Shop resultShop = hArrayShops.get(stringShop[0]);
                    if (resultShop == null) {
                        Shop a = new Shop(stringShop[0], Double.valueOf(stringShop[1]), Double.valueOf(stringShop[2]), currentMonth, 2012);
                        hArrayShops.put(stringShop[0], a);
                    } else {
                        resultShop.addCreditForMonth(Double.valueOf(stringShop[2]), currentMonth);
                        resultShop.addDebitForMonth(Double.valueOf(stringShop[1]), currentMonth);
                    }

                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        hArrayShops.forEach((key, value) -> value.getResultCredit());
        hArrayShops.get("pyterochka").resultByMonth();

    }

    //public Shop

}
