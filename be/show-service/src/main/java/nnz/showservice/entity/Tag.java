package nnz.showservice.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tags")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Tag {

    @Id
    private Long id;

    private String tag;

    @Builder.Default
    private Integer views = 0;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime updatedAt;

    public void updatePlusViews() {
        this.views += 1;
    }

    public void updateTag(String tag) {
        this.tag = tag;
    }

    public void updateViews(Integer views) {
        this.views = views;
    }

    public void updateUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
