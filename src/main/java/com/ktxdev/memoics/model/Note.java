package com.ktxdev.memoics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "Note title should be provided")
    private String title;
    @Lob
    @Column(nullable = false)
    @NotBlank(message = "Note content should be provided")
    private String content;
    @ManyToOne
    private User user;
}
