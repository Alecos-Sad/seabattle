package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.constants.Constants;
import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.model.ShipPoint;
import edu.javagroup.seabattle.service.ShipService;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ShipServiceImpl implements ShipService {

    private List<ShipPoint> coordinateList;

    public boolean checkShipCount() {
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();
        return false;
    }

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
        List<ShipPoint> coordinateList = new ArrayList<>();
        coordinateList.addAll(getHorizontalCoordinateList(panel));
        coordinateList.addAll(getVerticalCoordinateList(panel));
        List<ShipPoint> shipPointList = new ArrayList<>();
        for (int i = 0; i < coordinateList.size(); i++) {
            if (coordinateList.get(i).getValue() == 0 && coordinateList.get(i + 1).getValue() == 0) {
                shipPointList.add(coordinateList.get(i));
                shipPointList.add(coordinateList.get(i + 1));
                i = i + 2;
            }
        }
        coordinateList.removeAll(shipPointList);
        coordinateList.sort(Comparator.comparing(ShipPoint::getPoint));
    }

    /**
     * метод: getHorizontalCoordinateList
     * входные параметры: List<HorizontalLine>
     * возвращает: List<ShipPoint>
     * реализация:
     * создать коллекцию (1) List<ShipPoint> нужной размерности
     * создать числовую переменную (чп) со значением 1
     * начало цикла по List<HorizontalLine>
     * получить List<PointElement> (2)
     * начало цикла по List<PointElement> (2)
     * положить в коллекцию List<ShipPoint> (1) один ShipPoint где в качестве параметров: (чп) и value PointElement
     * прирастить (чп)
     * конец цикла по (2)
     * вложить в коллекцию (1) ShipPoint с параметрами: (чп) и 0
     * прирастить (чп)
     * конец цикла по panel
     * вернуть коллекцию (1)
     * <p>
     * пояснение: в данной ситуации мы просто перебираем List<HorizontalLine> по горизонтали
     */
    public List<ShipPoint> getHorizontalCoordinateList(List<HorizontalLine> panel) {
        List<ShipPoint> shipPointList = new ArrayList<>(110);
        int count = 1;
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
        int count = 1;
        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            for (int j = 0; j < 10; j++) {
                int value = panel.get(i).getPointElementList().get(j).getValue();
                shipPointList.add(new ShipPoint(count, value));
                count++;
            }
            shipPointList.add(new ShipPoint(count, 0));
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
        StringBuilder stringBuilder = new StringBuilder();
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();

        for (int i = 0; i < Constants.VERTICAL_COORDINATE.length(); i++) {
            for (int j = 0; j < 10; j++) {
                stringBuilder.append(panel.get(i).getPointElementList().get(j).getValue());
            }
        }

        for (HorizontalLine horizontalLine : panel) {
            for (PointElement pointElement : horizontalLine.getPointElementList()) {
                stringBuilder.append(pointElement.getValue());
            }
        }
        String[] split = stringBuilder.toString().split("0");
//        for (String str : split) {
//            if (str.length() == numberDeck){
//                count++;
//            }
//        }
        return 1;
    }
}



