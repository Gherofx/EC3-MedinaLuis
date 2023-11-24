package pe.edu.idat.model.bd;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name= "nomusuario")
    private String nomusuario;
    @Column(name= "email")
    private String email;
    @Column(name= "password")
    private String password;
    @Column(name= "nombres")
    private String nombres;
    @Column(name= "apellidos")
    private String apellidos;
    @Column(name= "telefono")
    private String telefono;
    @Column(name= "activo")
    private Boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<rol> roles;

}
