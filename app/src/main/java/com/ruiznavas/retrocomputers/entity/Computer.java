package com.ruiznavas.retrocomputers.entity;

import java.io.Serializable;

/**
 * Created by zhanos on 10/02/2017.
 */

public class Computer implements Serializable{
    public static int NO_IMAGE_PROVIDED = -1;
    private String title;
    private String description;
    private String name;
    private String manufacturer;
    private String type;
    private String origin;
    private Long year;
    private String builtInLanguage;
    private String keyboard;
    private String cpu;
    private String speed;
    private String coProcessor;
    private String ram;
    private String colors;
    private String sound;
    private String os;
    private String powerSupply;
    private String peripherals;
    private String price;
    private String image;

    public Computer() { }

    public Computer(String title){
        this.title = title;
    }

    public Computer(String title, int image){
        this.title = title;
    }

    public boolean hasImage(){
        return !image.isEmpty();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getBuiltInLanguage() {
        return builtInLanguage;
    }

    public void setBuiltInLanguage(String builtInLanguage) {
        this.builtInLanguage = builtInLanguage;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getCoProcessor() {
        return coProcessor;
    }

    public void setCoProcessor(String coProcessor) {
        this.coProcessor = coProcessor;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public String getPeripherals() {
        return peripherals;
    }

    public void setPeripherals(String peripherals) {
        this.peripherals = peripherals;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
