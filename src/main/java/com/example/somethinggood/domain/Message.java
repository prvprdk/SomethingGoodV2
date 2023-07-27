package com.example.somethinggood.domain;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @JsonView(Views.Id.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @JsonView(Views.Id.class)
    private String text;
    @ManyToOne
    @JsonView(Views.Id.class)
    @JoinColumn(name = "user_id")
    private User author;
}
