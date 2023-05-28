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
        @GeneratedValue
        public Integer id;

        @Column(unique = true)
        public String token;


        @Column
        public boolean expired;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "appuser_id")
        public AppUser user;



}
