package com.devdynasty.CrowdCritic.model;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Token {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(unique = true)
        private String token;

        @Column(name="refreshtoken")
        private String refreshToken;


        @Column
        private boolean expired;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appuser_id")
        private AppUser user;



}
