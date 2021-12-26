package com.project.library.dtos;

import com.project.library.models.Client;

public class ClientDTO {

    private Long id;
    private String username;
    private String password;
    private String role;

    //CONSTRUCTORES
    public ClientDTO() { }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.username = client.getUsername();
        this.password = client.getPassword();
        this.role = client.getRole();
    }

    //GETTER
    public Long getId() {return id;}
    public String getUsername() {return username;}
    public String getPassword() {return password;}
    public String getRole() {return role;}

    //SETTER
    public void setId(Long id) {this.id = id;}
    public void setUsername(String username) {this.username = username;}
    public void setPassword(String password) {this.password = password;}
    public void setRole(String role) {this.role = role;}
}
