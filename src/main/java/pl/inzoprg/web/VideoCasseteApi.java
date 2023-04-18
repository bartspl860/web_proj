package pl.inzoprg.web;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/videocassetes")
public class VideoCasseteApi {
    private VideoCassetteRepo casseteRepo;
    @Autowired
    public VideoCasseteApi(VideoCassetteRepo videoCassetteRepo) {
        this.casseteRepo = videoCassetteRepo;

        VideoCassete casette1 = new VideoCassete("The Matrix", LocalDate.of(1999, 3, 31));
        VideoCassete casette2 = new VideoCassete("Titanic", LocalDate.of(1997, 12, 19));
        VideoCassete casette3 = new VideoCassete("Jurassic Park", LocalDate.of(1993, 6, 9));
        casseteRepo.saveAll(Arrays.asList(casette1, casette2, casette3));
    }

    @GetMapping
    public Iterable<VideoCassete> getAllCassettes() {
        return casseteRepo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VideoCassete> getCassetteById(@PathVariable Long id) {
        return casseteRepo.findById(id);
    }

    @PostMapping("/add")
    public VideoCassete addCassette(@RequestBody VideoCassete cassette) {
        casseteRepo.save(cassette);
        return cassette;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideoCassete(@PathVariable long id) {
        casseteRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoCassete> editVideoCassete(@PathVariable Long id, @RequestBody VideoCassete updatedVideoCassete) {
        VideoCassete cassetteToUpdate = casseteRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cassette not found with id: " + id));
        cassetteToUpdate.setTitle(updatedVideoCassete.getTitle());
        cassetteToUpdate.setTitle(updatedVideoCassete.getTitle());
        cassetteToUpdate.setProductionYear(updatedVideoCassete.getProductionYear());
        casseteRepo.save(cassetteToUpdate);

        return ResponseEntity.ok().build();
    }


}

