package edu.javagroup.seabattle.service.impl;

import edu.javagroup.seabattle.model.HorizontalLine;
import edu.javagroup.seabattle.model.PointElement;
import edu.javagroup.seabattle.model.ShipPoint;
import edu.javagroup.seabattle.service.ShipService;
import edu.javagroup.seabattle.singleton.MinePanelSingleton;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShipServiceImpl implements ShipService{

     private List<ShipPoint> coordinateList;

    public boolean checkShipCount() {
        List<HorizontalLine> panel = MinePanelSingleton.instance(null).getPanel();
        return false;
    }

    public int checkShipCount(int numberDecks) {
        return 0;
    }

    public void getCoordinateList(List<HorizontalLine> panel) {

    }

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
}


