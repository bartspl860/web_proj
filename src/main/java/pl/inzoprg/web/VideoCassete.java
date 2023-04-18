package pl.inzoprg.web;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class VideoCassete {
    private static Long instance_counter = 0L;
    @Id
    private Long id;
    private String title;
    private LocalDate productionYear;

    public VideoCassete(String title, LocalDate productionYear) {
        instance_counter++;
        this.id = instance_counter;
        this.title = title;
        this.productionYear = productionYear;
    }

    protected VideoCassete() {

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}