package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {


    @Test
    public void shouldInitWithDefaultStationsCount() {
        Radio radio = new Radio();
        assertEquals(10, radio.getNumberOfStations());
    }

    @Test
    public void shouldInitWithCustomStationsCount() {
        Radio radio = new Radio(30);
        assertEquals(30, radio.getNumberOfStations());
    }

    @Test
    public void shouldNotInitWithNegativeStationsCount() {
        Radio radio = new Radio(-5);
        assertEquals(10, radio.getNumberOfStations());
    }


    @Test
    public void shouldSetValidStationCustom() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    public void shouldNotSetStationAboveMaxCustom() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(30);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToNextStationCustom() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(28);
        radio.next();
        assertEquals(29, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToZeroIfStationIsMaxCustom() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(29);
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToMaxIfStationIsZeroCustom() {
        Radio radio = new Radio(30);
        radio.setCurrentStation(0);
        radio.prev();
        assertEquals(29, radio.getCurrentStation());
    }

    // Прошлые тесты

    @Test
    public void shouldNotSetStationBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentStation(-1);
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void shouldSwitchToPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        radio.prev();
        assertEquals(4, radio.getCurrentStation());
    }

    @Test
    public void shouldIncreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.increaseVolume();
        assertEquals(51, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotIncreaseVolumeIfMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(100);
        radio.increaseVolume();
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {
        Radio radio = new Radio();
        radio.setCurrentVolume(50);
        radio.decreaseVolume();
        assertEquals(49, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotDecreaseVolumeIfMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeAboveMax() {
        Radio radio = new Radio();
        radio.setCurrentVolume(101);
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetVolumeBelowMin() {
        Radio radio = new Radio();
        radio.setCurrentVolume(-1);
        assertEquals(0, radio.getCurrentVolume());
    }
}
