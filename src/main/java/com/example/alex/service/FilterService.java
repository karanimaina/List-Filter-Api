package com.example.alex.service;

import com.example.alex.models.Selected;
import com.example.alex.repository.SelectedRepository;
import com.example.alex.wrappers.Total;
import com.example.alex.wrappers.UniversalResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilterService {
    private final SelectedRepository selectedRepository;
    @Scheduled(fixedDelay = 5000)
    void directoryProber() throws IOException {
        log.info(" Probing files...");
        Path path = Paths.get("input");
        try (Stream<Path> walk = Files.walk(path)) {
            walk.filter(Files::isRegularFile)
                    .forEach(f -> {
                        log.info(" Processing file with name {}", f.toFile().getName());
                        try {
                            File file=f.toFile();
                            InputStream is= new FileInputStream(file);
                            InputStreamReader in = new InputStreamReader(is);
                            String jsonData= FileCopyUtils.copyToString(in);
                            Total total = new ObjectMapper().readValue(jsonData,Total.class);
                            saveData(total);
                            in.close();
                            file.renameTo(new File("output/"+System.currentTimeMillis()+file.getName()));
                        } catch (Exception e) {
                            log.error("An exception occurred ======> {}",e.getMessage());
                        }
                    });
        }
    }
//    public void saveData(Total total) {
//        List<Selected> savedList = new ArrayList<>();
//        if (total != null) {
//            total.getResults().forEach(result -> {
//                Selected selected = Selected.builder()
//                        .timezone(result.getTz())
//                        .email(result.getProfile().getEmail())
//                        .tzLabel(result.getTzLabel())
//                        .realName(result.getRealName())
//                        .isOwner(result.getIsOwner())
//                        .isAdmin(result.getIsAdmin())
//                        .realNameNormalized(result.getProfile().realNameNormalized)
//                        .firstName(result.getProfile().firstName)
//                        .skype(result.getProfile().skype)
//                        .phone(result.getProfile().getPhone())
//                        .build();
//                savedList.add(selectedRepository.save(selected));
//            });
//        }
//    }
//    public ResponseEntity<UniversalResponse>getAllSelected(){
//        return ResponseEntity.ok().body(UniversalResponse.builder().status(200).message("Data list").data(selectedRepository.findAll()).build());
//    }
//    public ResponseEntity<Optional<Selected>>getSelectedItem(Long id){
//        return ResponseEntity.ok().body(selectedRepository.findById(id));
//    }
//    public void deleteSelected(Long id){
//       selectedRepository.deleteById(id);
//    }

}
