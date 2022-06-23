package edu.javagroup.seabattle.service;

/**
 * создать интерфейс PanelService
 * с методами:
 * boolean isPanelEmpty()
 * boolean isFullMinePanel()
 * int howMuchIsLeft(String side)
 * boolean checkEndGame(String side)
 */
public interface PanelService {
    boolean  isPanelEmpty();
    boolean  isFullMinePanel();
    int howMuchIsLeft(String side);
    boolean checkEndGame(String side);


}
