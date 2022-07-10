package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.model.ShipPoint;
import edu.javagroup.seabattle.service.ShipService;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import edu.javagroup.seabattle.constants.Constants.*;
import edu.javagroup.seabattle.singleton.ShipStorageSingleton;
import org.springframework.stereotype.Component;

import java.util.*;

import static edu.javagroup.seabattle.constants.Constants.DECK;

@Component
public class ShipServiceImpl implements ShipService {

    private List<ShipPoint> coordinateList;

    /**
     * метод: checkShipCount
     * входные параметры: нет
     * возвращает: boolean
     * реализация:
     * получить коллекцию из MinePanelSingleton
     * вызвать метод getCoordinateList куда отправить полученную коллекцию
     * создать карту и вложить в нее
     * ключ - "4deck", значение - результат выполнения метода findShipDeck с параметром 4
     * ключ - "3deck", значение - результат выполнения метода findShipDeck с параметром 3
     * ключ - "2deck", значение - результат выполнения метода findShipDeck с параметром 2
     * ключ - "1deck", значение - результат выполнения метода findShipDeck с параметром 1
     * вложить полученную карту в ShipStorageSingleton
     * вернуть
     * если в карте значение полученное по ключу "4deck" равно 1
     * и если в карте значение полученное по ключу "3deck" равно 2
     * и если в карте значение полученное по ключу "2deck" равно 3
     * и если в карте значение полученное по ключу "1deck" равно 4
     * примечание: ключ в любой момент может изменится, надо использовать константы
     *
     * @return
     */
    public boolean checkShipCount() {
        getCoordinateList(MinePanelSingleton.instance(null).getPanel());
        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put(("4" + DECK), findShipDeck(4));
        resultMap.put(("3" + DECK), findShipDeck(3));
        resultMap.put(("2" + DECK), findShipDeck(2));
        resultMap.put(("1" + DECK), findShipDeck(1));
        ShipStorageSingleton.instance(resultMap);
        return ShipStorageSingleton.instance(null).getShipMap().get("4" + DECK) == 1 &&
                ShipStorageSingleton.instance(null).getShipMap().get("3" + DECK) == 2 &&
                ShipStorageSingleton.instance(null).getShipMap().get("2" + DECK) == 3 &&
                ShipStorageSingleton.instance(null).getShipMap().get("1" + DECK) == 4;
    }

    /**
     * метод: checkShipCount
     * входные параметры: int (количество палуб)
     * возвращает: int
     * реализация:
     * используя метод getCoordinateList инициализируйте поле coordinateList
     * затем, надо понять сколько у вас кораблей указанной размерности (параметр метода)
     * при этом, метод должен
     * до начала игры, определять количество установленных кораблей согласно их размерности
     * определить начало игры можно по состоянию ImReadySingleton
     * примечание: реализация этого метода необязательна, см. task #16
     */
    public int checkShipCount(int numberDecks) {
        return 0;
    }


    /**
     * метод: getCoordinateList
     * входные параметры: List<HorizontalLine>
     * реализация:
     * инициализировать поле coordinateList (1) нужной размерности
     * в coordinateList добавить коллекцию полученную из метода getHorizontalCoordinateList
     * в coordinateList добавить коллекцию полученную из метода getVerticalCoordinateList
     * создать коллекцию (2) List<ShipPoint> нужной размерности
     * перебирая coordinateList вложить в предыдущую коллекцию элементы coordinateList
     * причем, вкладывать нужно только те элементы, у которых value == 0 и у соседнего (следующего) value == 0
     * в конце необходимо удалить из coordinateList (1) удалить все элементы коллекции (2)
     * и отсортировать коллекцию coordinateList по полю point
     */
    public void getCoordinateList(List<HorizontalLine> panel) {
        coordinateList = new ArrayList<>(220);
        coordinateList.addAll(getHorizontalCoordinateList(panel));
        coordinateList.addAll(getVerticalCoordinateList(panel));
        List<ShipPoint> shipPointList = new ArrayList<>();
        for (int i = 2; i < coordinateList.size() - 1; i++) {
            int increment = i + 1;

            if (coordinateList.get(i).getValue() == 0 && coordinateList.get(increment).getValue() == 0) {
                shipPointList.add(coordinateList.get(i));
                shipPointList.add(coordinateList.get(i + 1));
                //i = i + 2;
            }

        }
        coordinateList.removeAll(shipPointList);
        coordinateList.sort(Comparator.comparing(ShipPoint::getPoint));
    }


    public List<ShipPoint> getHorizontalCoordinateList(List<HorizontalLine> panel) {
        List<ShipPoint> shipPointList = new ArrayList<>(110);
        int count = 0;
        for (HorizontalLine horizontalLine : panel) {
            List<PointElement> pointElementList = horizontalLine.getPointElementList();
            for (PointElement pointElement : pointElementList) {
                shipPointList.add(new ShipPoint(count, pointElement.getValue()));
                count++;
            }
            shipPointList.add(new ShipPoint(count, 0));
            count++;
        }
        return shipPointList;
    }

    /**
     * имплементация интерфейса
     * метод: getVerticalCoordinateList
     * входные параметры: List<HorizontalLine>
     * возвращает: List<ShipPoint>
     * реализация:
     * похожа на предыдущий вариант, но тут мы идем по вертикали
     * первый проход A01 B01 C01 ... J01
     * второй проход A02 B02 C02 ... J02
     * третий проход A03 B03 C03 ... J03
     * ...
     * десятый проход проход A10 B10 C10 ... J10
     * т.е. просто выясняем какие ячейки у нас заняты палубами кораблей (по одиночке)
     * собирая все вертикальные линии в одну
     * вполне возможно, что в циклах придется опираться на константы определяющие список букв координат
     */
    public List<ShipPoint> getVerticalCoordinateList(List<HorizontalLine> panel) {
        List<ShipPoint> shipPointList = new ArrayList<>(110);
        int count = 111;
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            for (int j = 0; j < 10; j++) {
                int value = panel.get(i).getPointElementList().get(j).getValue();
                shipPointList.add(new ShipPoint(count, value));
                count++;
            }
            shipPointList.add(new ShipPoint(count, 0));
            count++;
        }
        return shipPointList;
    }

    /**
     * метод: findShipDeck
     * входные параметры: int
     * возвращает: int
     * реализация:
     * все предыдущие методы нужны были только для того, чтобы подготовить coordinateList
     * итак, когда мы прошлись по List<HorizontalLine>
     * мы выяснили сколько ячеек идет подряд по горизонтали, так мы нашли все 4х 3х 2х палубные корабли
     * их ячейки заняты последовательно
     * потом мы прошлись по вертикали и опять нашли все 4х 3х 2х палубные корабли
     * их ячейки опять же заняты последовательно
     * но я ни разу не упомянул однопалубные корабли, и вот почему
     * допустим наш корабль состоит из четырех палуб и занимает ячейки A01 B01 C01 D01
     * а строка A02-A10 пуста от остальных кораблей
     * выходит, что если пройти по List<HorizontalLine> по горизонтали, мы получим один однопалубный корабль
     * хотя его и нет там, потом мы пройдем по следующей строке и опять получим однопалубный, хотя его нет там
     * выходит, надо понять, где у нас однопалубные корабли, а где остальные
     * <p>
     * можно сложить строку из всех value (там может быть только 0 или 1)
     * затем превратить ее в массив, разделив по "0"
     * затем просто делать приращение некоей числовой переменной если длина элемента массива равна пришедшей в качестве параметра переменной
     * теперь нам нужно вернуть количество кораблей с указанным количеством палуб
     */
    public int findShipDeck(int numberDeck) {
        int count = 0;
        StringBuilder stringCollection = new StringBuilder();
        getCoordinateList(MinePanelSingleton.instance(null).getPanel());
        for (ShipPoint shipPoint : coordinateList) {
            stringCollection.append(shipPoint.getValue());
        }

        String[] split = stringCollection.toString().split("0");

        for (String str : split) {
            if (str.length() == numberDeck) {
                count++;
            }
        }
        return (numberDeck == 1) ? count / 4 : count;
    }
}



