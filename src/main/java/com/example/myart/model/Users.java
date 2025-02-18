package com.example.myart.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Введите имя, это обязательное поле")
    @Size(min = 2, max = 15, message = "Корретное имя - длиною от 2 до 30 символов")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы")
    private String name;

    @Column(name = "last_name")
    @NotEmpty(message = "Введите фамилию, это обязательное поле")
    @Size(min = 2, max = 25, message = "Корретная фамилия - длиною от 2 до 30 символов")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы")
    private String lastName;

    public @NotNull(message = "Вы не указали электронную почту") @Email @Size(min = 4, max = 40, message = "Введите корректный почтовый адрес") String getMail() {
        return mail;
    }

    public void setMail(@NotNull(message = "Вы не указали электронную почту") @Email @Size(min = 4, max = 40, message = "Введите корректный почтовый адрес") String mail) {
        this.mail = mail;
    }

    @NotNull(message = "Вы не указали возраст")
    @Min(value = 0, message = "Возраст должен быть положительным числом")
    @Max(value = 150, message = "Возраст должен быть реальным")
    public int getAge() {
        return age;
    }

    public void setAge(@NotNull(message = "Вы не указали возраст") @Min(value = 0, message = "Возраст должен быть положительным числом") @Max(value = 150, message = "Возраст должен быть реальным") int age) {
        this.age = age;
    }

    public @NotEmpty(message = "Введите фамилию, это обязательное поле") @Size(min = 2, max = 25, message = "Корретная фамилия - длиною от 2 до 30 символов") @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы") String getLastName() {
        return lastName;
    }

    public void setLastName(@NotEmpty(message = "Введите фамилию, это обязательное поле") @Size(min = 2, max = 25, message = "Корретная фамилия - длиною от 2 до 30 символов") @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы") String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty(message = "Введите имя, это обязательное поле") @Size(min = 2, max = 15, message = "Корретное имя - длиною от 2 до 30 символов") @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы") String getName() {
        return name;
    }

    public void setName(@NotEmpty(message = "Введите имя, это обязательное поле") @Size(min = 2, max = 15, message = "Корретное имя - длиною от 2 до 30 символов") @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Используйте кирриллицу или латинские буквы") String name) {
        this.name = name;
    }

    @Column(name = "age")
    @NotNull(message = "Вы не указали возраст")
    @Min(value = 0, message = "Возраст должен быть положительным числом")
    @Max(value = 150, message = "Возраст должен быть реальным")
    private int age;

    @Column(name = "mail")
    @NotNull(message = "Вы не указали электронную почту")
    @Email
    @Size(min = 4, max = 40, message = "Введите корректный почтовый адрес")
    private String mail;

    public Users(String name, String lastName, int age, String mail) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.mail = mail;
    }

    public Users() {

    }


    @Override
    public String toString() {
        return "Users{" + "id=" + id + ", name='" + name + '\'' + ", last_name='" + lastName + '\'' + ", age=" + age + ", mail='" + mail + '\'' + '}';
    }
}