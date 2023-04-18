package pl.inzoprg.web;

import java.time.LocalDate;

public class VideoCassete {
    private static Long instance_counter = 0L;
    private Long id;
    private String title;
    private LocalDate productionYear;

    public VideoCassete(String title, LocalDate productionYear) {
        instance_counter++;
        this.id = instance_counter;
        this.title = title;
        this.productionYear = productionYear;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(LocalDate productionYear) {
        this.productionYear = productionYear;
    }
}