package com.example.demo.security;

import com.example.demo.entity.PreferencesColocation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Utilisateur")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String adresse; // prop
    private Double budget; // colo
    private String preferences; // colo

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PreferencesColocation> preferencesColocation;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retourne la liste des rôles ou autorités associées à l'utilisateur
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        // Retourne le mot de passe de l'utilisateur
        return password;
    }

    @Override
    public String getUsername() {
        // Retourne l'identifiant de l'utilisateur (dans ce cas, l'email)
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Retourne true si le compte de l'utilisateur n'a pas expiré
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Retourne true si le compte de l'utilisateur n'est pas verrouillé
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Retourne true si les informations d'identification de l'utilisateur n'ont pas expiré
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Retourne true si l'utilisateur est activé
        return true;
    }

}
